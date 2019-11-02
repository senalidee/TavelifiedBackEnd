package com.cyntex.TourismApp.Util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Component
public class DataSourceManager {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost/tourism_app";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "toor";
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        DataSource source = getDataSource();
        setJdbcTemplate(new JdbcTemplate(source));
    }

    /**
     * Returns a DataSource object for connection to the database.
     *
     * @return a DataSource.
     */
    private static DataSource getDataSource() {
        // Creates a new instance of DriverManagerDataSource and sets
        // the required parameters such as the Jdbc Driver class,
        // Jdbc URL, database user name and password.
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
