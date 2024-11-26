package org.example.ex1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfiguration {
    @Bean
    public JdbcTemplate getJdbcTemplate() {
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource("jdbc:mysql://localhost:3306/web2024","root","root");
        return new JdbcTemplate(dataSource);
    }

}
