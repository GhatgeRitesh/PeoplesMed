package com.BackEnd.Features.TestRESTAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/Features")
public class TestService {
    @GetMapping("/Test1")
    public @ResponseBody ArrayList<Integer> test1(){
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        return list;
    }
}
