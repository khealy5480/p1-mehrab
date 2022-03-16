package com.revature.music;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDataConfig {
    // @Bean
    // public DataSource dataSource() {
    //     PGSimpleDataSource dataSource = new PGSimpleDataSource();
    //     dataSource.setUrl("jdbc:postgresql://db:5432/postgres");
    //     dataSource.setUser("postgres");
    //     dataSource.setPassword("postgres");
    //     return dataSource;
    // }
}
