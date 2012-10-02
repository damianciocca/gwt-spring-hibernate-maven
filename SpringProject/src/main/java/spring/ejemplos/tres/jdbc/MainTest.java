package spring.ejemplos.tres.jdbc;

import java.util.List;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * http://www.vogella.com/articles/SpringJDBC/article.html
 * http://www.inmensia.com/articulos/spring/jdbc_jdbctemplate.html
 * 
 * La clase JdbcTemplate es la pieza central del paquete de facilidades que ofrece Spring a la hora 
 * de trabajar con JDBC. Encapsula todos los detalles de conexión y gestión de recursos, permitiendo 
 * a los desarrolladores centrarse en la ejecución de sentencias.
 * 
 * NamedParameterJdbcTemplate
 * 		La clase NamedParameterJdbcTemplate es un wrapper sobre la clase JdbcTemplate que se instancia 
 * 		pasándole como argumento el DataSource en el constructor:
 * 		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
 * 		Lo que pretende es resolver los problemas de tener que trabajar con caracteres marcadores de posición ("?") 
 * 		dentro de las sentencias SQL, permitiendo en su lugar utilizar nombres para los parámetros.
 * 
 * 		Los nombres de los parámetros se distinguen del resto de la sentencia antecediéndolos con un carácter de 
 * 		dos puntos (":"):
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
	    dataSource.setUsername("hibernate_tutorial");
	    dataSource.setPassword("hibernate_tutorial");
	    // Inject the datasource into the dao
	    dao.setDatasource(dataSource);
	    List<Person> persons = dao.findAll();
	    for (Person person : persons) {
	    	System.out.println(person);
		}
	}

}
