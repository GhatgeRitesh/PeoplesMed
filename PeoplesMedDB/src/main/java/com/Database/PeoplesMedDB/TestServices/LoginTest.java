package com.Database.PeoplesMedDB.TestServices;

import com.Database.PeoplesMedDB.EntityManager.TestEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/PeoplesMed")
public class LoginTest {
    @PostMapping("/Check")
    public Boolean checkUser(@RequestBody TestEntity newTestEntity){
        return newTestEntity.getId() == 1 && newTestEntity.getName() == "Ritesh" && newTestEntity.getRole() == "Admin";
    }
}
