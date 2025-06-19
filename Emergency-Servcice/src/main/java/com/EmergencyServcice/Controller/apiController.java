package com.EmergencyServcice.Controller;

import com.EmergencyServcice.FeignClient.Hospital_Service;
import com.EmergencyServcice.Model.DataHolder;
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

    @Autowired
    private DataHolder dataHolder;

    @Autowired
    private Hospital_Service hospitalService;

    // logic to get the status
    // required is Emergency Request Id
    // only thats it .
    @GetMapping("/getStatus")
    public ResponseEntity<?> getStatus(){
        log.info("");
        log.info("Emergency Request ID: "+ dataHolder.getEmergencyRequestId());
        ResponseEntity<?> response= hospitalService.getAcceptanceStatus(dataHolder.getEmergencyRequestId());


        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }
}
