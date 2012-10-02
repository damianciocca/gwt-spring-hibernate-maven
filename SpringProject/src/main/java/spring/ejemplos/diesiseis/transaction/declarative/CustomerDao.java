package spring.ejemplos.diesiseis.transaction.declarative;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao implements IDao{

	// Esta propiedad la va a inyectar automaticamente ya que esta definida en el XML.
	// No importa que tenga otro nombre en el XML ya q la inyeccion la hace por tipo y no por nombre
	@Autowired
	private DataSource ds;

	public List<Customer> findAll() {
		
		 JdbcTemplate select = new JdbcTemplate(ds);
		 List<Customer> result = select.query("select first_name from customer", new CustomerRowMapper());
		 return result;
	}
	
	/**
	 * Mapea cada row del resultSet mediante un RowMapper
	 */
	class CustomerRowMapper implements RowMapper<Customer>{

		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			CustomerResultSetExtractor resultSetExtractor = new CustomerResultSetExtractor();
			return resultSetExtractor.extractData(rs);
		}

		
	}
	
	class CustomerResultSetExtractor implements ResultSetExtractor<Customer>{

		public Customer extractData(ResultSet rs) throws SQLException,DataAccessException {
			
			Customer C = new Customer();
			C.setName(rs.getString(1));
			return C;
		}

	}

	
}
