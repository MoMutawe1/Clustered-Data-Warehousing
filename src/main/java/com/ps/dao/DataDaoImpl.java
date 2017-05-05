package com.ps.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ps.entity.CountDeal;
import com.ps.entity.CsvFile;
import com.ps.util.EntityWrapper;

@Component
public class DataDaoImpl implements DataDao {

	final static Logger logger = Logger.getLogger(DataDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public boolean save(EntityWrapper wrapper) {

		logger.info("Entering the Save method..");

		try {
			Session session = sessionFactory.getCurrentSession();

			// save the file object
			session.persist(wrapper.getFile());

			// get our hashtable for manipulation

			Hashtable<String, Integer> hash = wrapper.getDeals();

			// get from CountDeal table
			System.out.println("---------------");
			List<CountDeal> deals = session.createCriteria(CountDeal.class).list();

			// System.out.println(deals.size());
			// if this is not the first time we are updating the accumulating
			Iterator<CountDeal> iterator = deals.iterator();

			// check for the first time if record exist because if not we cannot
			// persist.
			boolean isRecordExist = false;
			while (iterator.hasNext()) {
				isRecordExist = true;
				System.out.println("NOt empty fucker ----");

				CountDeal cd = (CountDeal) iterator.next();

				// update the deals now;
				cd.setCountOfDeals(cd.getCountOfDeals() + hash.get(cd.getCode()));
				session.persist(cd);
			}

			// if this is first time
			if (!isRecordExist) {
				System.out.println(" empty fucker ----");

				deals = new ArrayList<CountDeal>();
				for (Map.Entry<String, Integer> entry : hash.entrySet()) {
					CountDeal cd = new CountDeal(entry.getKey(), entry.getValue());
					session.persist(cd);
				}
			}

			logger.info("Congratulation: Data saving is  successful..");

		} catch (Exception e) {
			logger.error("Error while saving file information. Message: " + e.getMessage());
		}
		return true;
	}

	@Override
	public CsvFile getCsvFile(String name) {
		// TODO Auto-generated method stub
		Criteria c = sessionFactory.getCurrentSession().createCriteria(CsvFile.class)
				.add(Restrictions.eq("name", name).ignoreCase());

		CsvFile csv = (CsvFile) c.uniqueResult();
		return csv;
	}

}
