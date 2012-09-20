package spring.ejemplos.tres.jdbc;

import java.util.List;

import javax.sql.DataSource;

public interface IDao {
	
	void setDatasource(DataSource ds);
	
	List<Person> findAll();

}
