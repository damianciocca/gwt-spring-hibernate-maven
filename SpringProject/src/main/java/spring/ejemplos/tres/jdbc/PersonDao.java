package spring.ejemplos.tres.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class PersonDao implements IDao{

	private DataSource ds;

	public void setDatasource(DataSource ds) {
		this.ds = ds;
	}

	public List<Person> findAll() {
		
		/**
		 * Otra forma de declarar elJdbcTemplate es de forma declarativa mediante el bean de tipo 
		 * JdbcTemplate e inyectarlo en la clase que uno desee:
		 * <bean name="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
		 *   <constructor-arg><ref bean="dataSource"/></constructor-arg>
		 * </bean>
		 * JdbcTemplate es segura en entornos multihilos, y no debería representar ningún problema 
		 * utilizar una única instancia.
		 * 
		 * Adicionalmente se puede heredar de la clase JdbcDaoSupport, que implementa directamente 
		 * una propiedad de tipo JdbcTemplate, aunque requiere de igual forma que se 
		 * le inyecte un DataSource.
		 */
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		 
		 // - Consulta sin parámetros que retorna un valor entero:
		 int count = jdbcTemplate.queryForInt("SELECT COUNT(1) FROM customer");
		 System.out.println("COUNT = " +  count);
		 
		 // - Consulta con parámetros que retorna un valor entero:
		 int count2 = jdbcTemplate.queryForInt("SELECT COUNT(1) FROM customer WHERE first_name = ?", "Juan");
		 System.out.println("COUNT2 = " +  count2);
		 
		 // - Consulta con varios parámetros e indica el tipo de valor esperado mediante String.class:
		 String name = jdbcTemplate.queryForObject("SELECT first_name FROM customer WHERE first_name = ?",new Object[]{"Juan"}, String.class);
		 System.out.println("NAME = " +  name);
		 
		 // - Consulta con parámetros de una entidad:
		 Person person = jdbcTemplate.queryForObject(
				    "SELECT first_name FROM customer WHERE first_name = ?",
				    new Object[]{"Juan"},
				    new RowMapper<Person>() {
				        public Person mapRow(ResultSet result, int rowNum) throws SQLException {
				        	Person p = new Person();
							p.setName(result.getString(1));
				            return p;
				        }
				});
		 System.out.println("PERSON NAME = " +  person.getName());
		 
		 // - Consulta sin parámetros de un listado de entidades:
		 List<Person> empresas = jdbcTemplate.query(
				 	"SELECT first_name FROM customer",
				    new RowMapper<Person>() {
				    public Person mapRow(ResultSet result, int rowNum) throws SQLException {
				    	Person p = new Person();
						p.setName(result.getString(1));
			            return p;
				    }
				});
		 for (Person person2 : empresas) {
			 System.out.println("PERSON2 NAME = " +  person2.getName());
			
		 }
		 
		 // wrapper sobre la clase JdbcTemplate
		 // pretende es resolver los problemas de tener que trabajar con caracteres marcadores de posición ("?") 
		 // dentro de las sentencias SQL, permitiendo en su lugar utilizar nombres para los parámetros.
		 NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
		 Map<String, String> parameters = new HashMap<String, String>();
		 parameters.put("nombre", "Juan");
		 String name2 = namedParameterJdbcTemplate.queryForObject(
				 	"SELECT first_name FROM customer WHERE first_name = :nombre",
				    parameters, 
				    String.class);
		 
		 System.out.println("NAME2 = " +  name2);
		 
		 // O bien, otra alternativa es en lugar de utilizar un mapa para pasar los parametros, se pueden utilizar la clase SqlParameterSource 
		 SqlParameterSource parameters2 = new MapSqlParameterSource("nombre", "Juan");
		 String name3 = namedParameterJdbcTemplate.queryForObject(
				 	"SELECT first_name FROM customer WHERE first_name = :nombre",
				 	parameters2, 
				    String.class);
		 
		 System.out.println("NAME3 = " +  name3);
		 
		// O bien, la 3era alternativa es utilizar la clase BeanPropertySqlParameterSource (construye automáticamente un Map con los 
		// nombres de las propiedades y sus correspondientes valores
		 Person p = new Person();
		 p.setName("Juan");
		 SqlParameterSource parameters3 = new BeanPropertySqlParameterSource(p);
		 String name4 = namedParameterJdbcTemplate.queryForObject(
				 	"SELECT first_name FROM customer WHERE first_name = :name",
				 	parameters3, 
				    String.class);
		 
		 System.out.println("NAME4 = " +  name4);
		 
		 // SimpleJdbcTemplate: 
		 // La clase SimpleJdbcTemplate es otro wrapper sobre JdbcTemplate, aunque las diferencias entre una y 
		 // otra son un poco sutíles. Básicamente está mejor adaptada para usar algunas de las características 
		 // concretas de Java que se incorporaron en la versión 5, como los genéricos y los argumentos variables.
		 
		 // MappingSqlQuery:
		 // Utilizando esta clase se puede mapear cada columna de un registro en su correspondiente 
		 // propiedad dentro de un objeto.
		 // Las clases que hereden de MappingSqlQuery deben definir en su constructor la sentencia SQL 
		 // de la que se obtendrán los registros, así como el número y tipos de parámetros que necesitan, 
		 // y además, deben de implementar el método mapRow que convierta los registros en objetos
		 
		 PersonQuery personQuery = new PersonQuery(ds);
		 Person personFounded = personQuery.findObject("Juan");
		 System.out.println("PERSON " + personFounded.getName());
		 
		 
		 // Otra forma de hacer la consulta mediante un custom RowMapper
		 List<Person> result = jdbcTemplate.query("select first_name from customer", new PersonRowMapper());
		 return result;
	}
	
	/**
	 * Mapea cada row del resultSet mediante un RowMapper
	 */
	class PersonRowMapper implements RowMapper<Person>{

		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			PersonResultSetExtractor resultSetExtractor = new PersonResultSetExtractor();
			return resultSetExtractor.extractData(rs);
		}

		
	}
	
	class PersonResultSetExtractor implements ResultSetExtractor<Person>{

		public Person extractData(ResultSet rs) throws SQLException,DataAccessException {
			
			Person p = new Person();
			p.setName(rs.getString(1));
			return p;
		}

	}
	

}
