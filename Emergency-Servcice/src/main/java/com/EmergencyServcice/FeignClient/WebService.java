package com.EmergencyServcice.FeignClient;

import com.EmergencyServcice.Model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("WEB-INTERFACE")
public interface WebService {
    @GetMapping("/home/GetUserDetails")
    public ResponseEntity<Patient> getDetails();
}
