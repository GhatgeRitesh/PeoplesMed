package com.PeoplesMed.PaymentService.controllers;

import com.PeoplesMed.PaymentService.DTO.PaymentInfo;
import com.PeoplesMed.PaymentService.DTO.StripeResponse;
import com.PeoplesMed.PaymentService.Service.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/PaymentService")
public class PaymentController {

    @Autowired
    private StripeService service;

    @PostMapping("/checkout")
    public ResponseEntity<StripeResponse> getCheckoutLink(@RequestBody PaymentInfo info){
        System.out.println("Payment Service Activated");

        StripeResponse response = service.checkoutPayment(info);
        System.out.println(response.toString());
        System.out.println("Payment Service Successfully created Link Redirecting to Web Interface");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
