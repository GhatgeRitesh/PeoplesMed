package com.BackEnd.Features.Feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("WEB-INTERFACE")
public interface WebInterFaces {
    // in this class all the required methods from the other service are
    // interfaces are stored here and then the object is injected to required method
    // using the autowire and method from this classes are called
    // used into the computation

    /*
    *  To run the application and communicate with the services
    *  we have to use the server port number for which service we are running on
    *  then the keep the link relative make sure complete link is written
    *  http://localhost:8081/login/getuser this is the example
    *  web interface do not have any access to the database
    *  hence after we have login complete through spring security we can manage the user session
    * */
}
