package com.PeoplesMed.PaymentService.Service;

import com.PeoplesMed.PaymentService.DTO.PaymentInfo;
import com.PeoplesMed.PaymentService.DTO.StripeResponse;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripeService {


    @Value("${stripe.api.publishableKey}")
    private String publishabableKey;

    @Value("${stripe.api.secretKey}")
    private String secretKey;

    @Autowired
    private StripeResponse stripeResponse;

    public StripeResponse checkoutPayment(PaymentInfo Info){
        Stripe.apiKey=secretKey;
        SessionCreateParams.LineItem.PriceData.ProductData productData = SessionCreateParams.LineItem.PriceData.ProductData.builder()
                .setName(Info.getName())
                .build();

        SessionCreateParams.LineItem.PriceData priceData = SessionCreateParams.LineItem.PriceData.builder()
                .setCurrency(Info.getCurrency() == null ? "USD" : Info.getCurrency())
                .setUnitAmount(Info.getAmount())
                .setProductData(productData)
                .build();

        SessionCreateParams.LineItem lineItem =SessionCreateParams.LineItem.builder()
                .setQuantity((long) 1)
                .setPriceData(priceData)
                .build();

        SessionCreateParams params =SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://localhost:8083/P/paymentSuccess")
                .setCancelUrl("http://localhost:8083/P/paymentFailed")
                .addLineItem(lineItem)
                .build();

        Session session = null;

        try{
            session = Session.create(params);
                stripeResponse.setMessage("Success");
                stripeResponse.setStatus(session.getStatus());
                stripeResponse.setSessionId(session.getId());
                stripeResponse.setSessionUrl(session.getUrl());
                return stripeResponse;
        }catch (StripeException e){
            System.out.println("Payment Failed :" +e);
            stripeResponse.setSessionUrl("/paymentFailed");
            stripeResponse.setStatus("failed");
            stripeResponse.setSessionId(session.getId());
            stripeResponse.setMessage("failed");
            return stripeResponse;
        }
    }

}
