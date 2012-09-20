package spring.ejemplos.tres.jdbc;

import java.util.List;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * http://www.vogella.com/articles/SpringJDBC/article.html
 * 
 * @author dciocca
 */
public class MainTest {
	
	public static void main(String[] args){
		
		PersonDao dao = new PersonDao();
		// Initialize the datasource, could /should be done of Spring
	    // configuration
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	    dataSource.setUsername("prueba");
	    dataSource.setPassword("prueba");
	    // Inject the datasource into the dao
	    dao.setDatasource(dataSource);
	    List<Person> persons = dao.findAll();
	    for (Person person : persons) {
	    	System.out.println(person);
		}
	}

}
