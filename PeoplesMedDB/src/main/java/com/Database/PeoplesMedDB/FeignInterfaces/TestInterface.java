package com.Database.PeoplesMedDB.FeignInterfaces;

import com.Database.PeoplesMedDB.EntityManager.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("WEB-INTERFACE")
public interface TestInterface {

    // here register the interfaces those needed to be used to get the data from web interfaces
    // example if you want to have the user Entities complete from web interfaces
    @GetMapping("/Entity/Get")
    public ResponseEntity<TestEntity> send();
}
