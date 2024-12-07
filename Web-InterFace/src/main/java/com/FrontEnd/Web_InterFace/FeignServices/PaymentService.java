package com.FrontEnd.Web_InterFace.FeignServices;

import com.FrontEnd.Web_InterFace.EntityManager.PaymentEntity.PaymentInfo;
import com.FrontEnd.Web_InterFace.EntityManager.PaymentEntity.StripeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENTSERVICE")
public interface PaymentService {

    @PostMapping("/PaymentService/checkout")
    public ResponseEntity<StripeResponse> getCheckoutLink(@RequestBody PaymentInfo info);
}
