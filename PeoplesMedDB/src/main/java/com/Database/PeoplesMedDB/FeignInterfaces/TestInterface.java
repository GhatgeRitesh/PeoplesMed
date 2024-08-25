package com.Database.PeoplesMedDB.FeignInterfaces;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("Web-InterFace")
public interface TestInterface {
    // here register the interfaces those needed to be used to get the data from web interfaces
    // example if you want to have the user Entities complete from web interfaces

}
