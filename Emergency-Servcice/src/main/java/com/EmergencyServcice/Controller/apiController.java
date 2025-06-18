package com.EmergencyServcice.Controller;

import com.EmergencyServcice.Model.Emergency_Requests;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Log
public class apiController {

    // logic to get the status
    // required is Emergency Request Id
    // only thats it .
    @GetMapping("/getStatus")
    public ResponseEntity<?> getStatus(Emergency_Requests emergencyRequests){
        log.info("Emergency Request ID: "+ emergencyRequests.getId());
        log.info("Emergency Request Status :" + emergencyRequests.getAcceptanceStatus());
        return new ResponseEntity<>(emergencyRequests.getAcceptanceStatus(), HttpStatus.OK);
    }
}
