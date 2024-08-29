package com.FrontEnd.Web_InterFace.TestController1;

import com.FrontEnd.Web_InterFace.EntityManager.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Entity")
public class TestingEntity {

    @Autowired
    @Qualifier("testEntity1")
    TestEntity testEntity;
    @PostMapping("/Save")
    public ResponseEntity<TestEntity> save(@RequestBody TestEntity newtestEntity){
        System.out.println(newtestEntity.getName());
        testEntity.setName(newtestEntity.getName());
        testEntity.setRole(newtestEntity.getRole());
        testEntity.setId(newtestEntity.getId());
      return new ResponseEntity<>(testEntity, HttpStatus.OK);
    }
    @GetMapping("/Get")
    public ResponseEntity<TestEntity> send(){
        System.out.println(testEntity.getId()+" "+testEntity.getName()+" "+testEntity.getRole());
        return new ResponseEntity(testEntity, HttpStatus.OK);
    }
}
