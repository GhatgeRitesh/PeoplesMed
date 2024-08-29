package com.Database.PeoplesMedDB.TestServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;


@RestController
@RequestMapping("/DB")
public class DBtest {

    @Autowired
    DataSource dataSource;

    @GetMapping("/DBtest")
    public String healthcheck(){
        try {
            JdbcTemplate template = new JdbcTemplate(dataSource);
            // Perform a simple query to test the database connection
//            String query="Insert into Names(?)values(\"Chetan\")";
//            template.execute(query);

            template.execute("SELECT 1");
            return "DB is healthy";
        } catch (Exception e) {
            // Handle the error and return an appropriate message
            return "Error in DB: " + e.getMessage();
        }
    }
}
