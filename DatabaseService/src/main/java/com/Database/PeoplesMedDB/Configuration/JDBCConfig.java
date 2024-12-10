//package com.Database.PeoplesMedDB.Configuration;
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class JDBCConfig {
//    @Bean
//    public DataSource dataSource()throws Exception{
//        DataSource dataSource= DataSourceBuilder.create()
//                .driverClassName("com.mysql.cj.jdbc.Driver")
//                .url("jdbc:mysql://peoplesmed-test1-trialproject1.h.aivencloud.com:26564/peoplesMed_test?createDatabaseIfNotExist=TRUE")
//                .username("avnadmin")
//                .password("avien password")
//                .build();
//        return dataSource;
//    }
//}
