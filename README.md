## clustered-ware-housing
- The project uses Spring MVC with purely Java based configuration for bean definition.  
- The project uses JPA as a persistence layer and hibernate as a persistence provider.
- The project uses maven as a building tool.
- The project contains (dump**.sql) scripts to be ran against the database
- The project uses Log4j as a logger.
- The project implements the search.
- Sample csv files(small and large) are attached. (check resources folder)


*The dataset of 100K records was uploaded in less than 5 seconds by streaming data as bytes*.

###### Manual

The source file contains default controller  that handles the request. There is a service layer backed by data access layer. The CsvParser parses the file, takes care of the invalid and valid records. For the time being, only amount is validated against. These data gets updated to their respective tables. EntityWrapper is just the util class to wrap entities to provide to persistence layer.

###### Test cases
 Testing Note: 
- Please adjust Confiuration settings (AppConfig.java) for db connection as required. 
- Please check the logger file in resources to adust settings.

As i believed *record validation* is the most important component to be tested, its is provided as sample in the test case. Other cases are most of runtime exceptions(errors).

Thank you for giving me this opportunity to face this challenge. I apologize i couldnot complete some features due to time constraints and schedules.But i believe my project won't dissappoint you. I will be waiting for your response.

**Thank you**
