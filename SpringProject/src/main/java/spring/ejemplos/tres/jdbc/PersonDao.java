package spring.ejemplos.tres.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class PersonDao implements IDao{

	private DataSource ds;

	public void setDatasource(DataSource ds) {
		this.ds = ds;
	}

	public List<Person> findAll() {
		
		 JdbcTemplate select = new JdbcTemplate(ds);
		 List<Person> result = select.query("select supplier_name, contact_name from supplier", new PersonRowMapper());
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
			p.setSurname(rs.getString(2));
			return p;
		}

	}
	

}
