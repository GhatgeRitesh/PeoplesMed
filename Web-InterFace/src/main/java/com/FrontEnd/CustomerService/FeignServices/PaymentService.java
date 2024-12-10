package com.FrontEnd.CustomerService.FeignServices;

import com.FrontEnd.CustomerService.EntityManager.PaymentEntity.PaymentInfo;
import com.FrontEnd.CustomerService.EntityManager.PaymentEntity.StripeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENTSERVICE")
public interface PaymentService {

    @PostMapping("/PaymentService/checkout")
    public ResponseEntity<StripeResponse> getCheckoutLink(@RequestBody PaymentInfo info);
}
