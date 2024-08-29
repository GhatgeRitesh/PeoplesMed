package com.Database.PeoplesMedDB.TestServices;

import com.Database.PeoplesMedDB.EntityManager.TestEntity;
import com.Database.PeoplesMedDB.FeignInterfaces.TestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DB")
public class EntityTest {
    @Autowired
    TestInterface testInterface;
    @Autowired
    TestEntity testEntity;
    @GetMapping("/test2")
    public ResponseEntity<TestEntity> test2(){
       testEntity= testInterface.send().getBody();
        System.out.println(testEntity.getId()+" "+testEntity.getName()+" "+testEntity.getRole());
        if(testEntity.getId()==1 && testEntity.getName()=="Ritesh" && testEntity.getRole()=="User"){return new ResponseEntity<>(testEntity, HttpStatus.OK);}
        return new ResponseEntity<>(testEntity,HttpStatus.EXPECTATION_FAILED);
    }
}
