package com.EmergencyServcice.Model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("Prototype")
public class E_ID {
   private  Long emergencyRequestId;
}
