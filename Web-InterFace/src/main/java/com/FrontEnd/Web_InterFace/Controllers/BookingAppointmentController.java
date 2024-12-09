package com.FrontEnd.Web_InterFace.Controllers;

import com.FrontEnd.Web_InterFace.EntityManager.PaymentEntity.PaymentInfo;
import com.FrontEnd.Web_InterFace.EntityManager.PaymentEntity.StripeResponse;
import com.FrontEnd.Web_InterFace.EntityManager.Users.BookedSchedules;
import com.FrontEnd.Web_InterFace.FeignServices.PaymentService;
import com.FrontEnd.Web_InterFace.Configurations.currDoctor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log
@RequestMapping("/P")
public class BookingAppointmentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private BookedSchedules bookedSchedules;

    @Autowired
    private PaymentInfo paymentInfo;

    @Autowired
    private currDoctor currDoctor;


    @PostMapping("/BookSchedule/{d_id}")
    public String PaymentCheckOut(@ModelAttribute BookedSchedules schedules, @PathVariable Long d_id ){
        // 1 . save the BookSchedule Object
        // 2 . ask the payment to be completed
        // 3 . then save the  schedule from the success method

        log.info("Booking Appointment Started Redirecting to payments Service");
        bookedSchedules = schedules;
        PaymentInfo payinfo= paymentInfo.builder().name(currDoctor.getDoctorName()).amount(10000L).quantity(1L).currency("inr").build();
        ResponseEntity<StripeResponse> response=  paymentService.getCheckoutLink(payinfo);


        return "redirect:"+ response.getBody().getSessionUrl();

    }

    @GetMapping("/paymentSuccess")
    public String paymentSuccess(){
//
//        Test Card Number	Scenario
//        4000 0000 0000 0002	Card declined (generic).
//        4000 0000 0000 9995	Insufficient funds.
//        4000 0000 0000 9987	Lost card.
//        4000 0000 0000 9979	Stolen card.
//        4000 0000 0000 0069	Card expired.
//        4000 0000 0000 0119	CVC check fails.
//        4000 0000 0000 5126	Fraudulent card.

        // save the payment Info.
        log.info("Payment Success Test Schedule presence " + bookedSchedules.toString());
        log.info("Payment Completed Redirecting to ZoomApi Service");
        return "PaymentSuccessful";
    }
    @GetMapping("/paymentFailed")
    public String paymentFailed(){
        return "PaymentFailed";
    }

    @GetMapping("/bookingConfirm")
    public String confirm(){
        log.info("Redirecting to Confirmation Page");
        return "BookingConfirm";
    }

    @GetMapping("/linkGenerated")
    public String linkGenerated(){
        log.info("zoom Authorize page revisited by user redirecting to LinkGenerated Page");
        return "LinkGenerated";
    }
}
