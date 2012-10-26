package com.gemalto.latansoft.ws;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class PlanetaJDBCResolver {

	protected String queryPlanetByName;
	protected JdbcTemplate jdbcTemplate;

	public List<Planeta> retrievePlanetByName(String name) {

		List<Planeta> result = jdbcTemplate.query(
													queryPlanetByName,
													new Object[]{name},
													new RowMapper<Planeta>() {
														public Planeta mapRow(ResultSet result, int rowNum) throws SQLException {
															Planeta p = new Planeta();
															p.setCodigo(result.getInt(1));
															p.setNombre(result.getString(2));
															p.setDiametro(result.getInt(3));
															return p;
														}
													});
		
		return result;
	}

	public String getQueryPlanetByName() {
		return queryPlanetByName;
	}

	public void setQueryPlanetByName(String queryPlanetByName) {
		this.queryPlanetByName = queryPlanetByName;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
