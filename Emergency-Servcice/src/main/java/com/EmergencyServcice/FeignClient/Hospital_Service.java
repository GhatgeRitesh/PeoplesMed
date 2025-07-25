package com.EmergencyServcice.FeignClient;

import com.EmergencyServcice.Model.Emergency_Requests;
import com.EmergencyServcice.Model.HospitalStatusDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("HospitalService")
public interface Hospital_Service {

    @PostMapping("/Hospital/getCityHospitals")
    public ResponseEntity<List<HospitalStatusDTO>> getHospitals(@RequestBody Emergency_Requests emergencyRequests);

    @PostMapping("/Hospital/saveEmergencyRequest")
    public ResponseEntity<?> saveEmergencyRequest(@RequestBody Emergency_Requests emergencyRequests);

    @PostMapping("/Hospital/getAcceptanceStatus")
    public ResponseEntity<?> getAcceptanceStatus(@RequestBody  Long RequestID);
}
