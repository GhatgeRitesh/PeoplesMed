package com.FrontEnd.Web_InterFace.Controllers;


import com.FrontEnd.Web_InterFace.EntityManager.Users.Doctor;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/D/dash")
@Log4j2
public class EntityRetriveController {
   @Autowired
   private UserClient userClient;
    @GetMapping("/retrive")
    public ResponseEntity<Doctor> getDocCred(@RequestBody Doctor doc){
        log.info("Doctor Cred Retrival");
        userClient.getDoc(doc);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
