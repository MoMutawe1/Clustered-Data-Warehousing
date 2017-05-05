package com.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ps.entity.CsvFile;
import com.ps.service.DataService;
import com.ps.util.EntityWrapper;

import org.apache.log4j.Logger;

@Controller
public class DefaultController {

	final static Logger logger = Logger.getLogger(DefaultController.class);

	@Autowired
	private DataService dataService;

	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {

		ModelAndView model = new ModelAndView("index");

		return model;
	}

	@RequestMapping(name = "/search", method = RequestMethod.GET)
	public ModelAndView search() {
		return new ModelAndView("search");
	}

	@RequestMapping("/search/result")
	public ModelAndView getSearchResult(@RequestParam("name") String name) {

		ModelAndView mv = new ModelAndView("search");
		mv.addObject("csvFile", dataService.getCsvFile(name));
		return mv;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView handleFileUpload(@RequestParam("filedata") MultipartFile file) {

		ModelAndView model = new ModelAndView();

		if (!file.isEmpty()) {

			EntityWrapper wrapper;

			try {
				wrapper = dataService.parseFile(file);

			} catch (Exception ex) {
				// TODO Auto-generated catch block
				model.setViewName("error");
				model.addObject("parsingError", "There was an error parsing the file");
				logger.error(ex.getMessage());
				return model;
				// throw e;
			}

			try {
				boolean result = dataService.save(wrapper);

			} catch (Exception ex) {
				logger.error(ex.getMessage());
				model.setViewName("error");
				model.addObject("databaseError", "There was an error parsing the file");

			}
		} else {

			model.setViewName("index");
			model.addObject("empty", "This file is empty !!");
			return model;
		}
		model.setViewName("success");
		model.addObject("success", "File was uploaded and data updated in database successfully");
		logger.info("Success: Data updated to database");
		return model;
	}

}
