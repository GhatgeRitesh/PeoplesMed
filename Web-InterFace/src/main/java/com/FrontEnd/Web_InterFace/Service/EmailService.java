package com.FrontEnd.Web_InterFace.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/Mail")
public class EmailService {
      @GetMapping("/loginMail")
      public ResponseEntity<HttpStatus> MailSender(){

          return new ResponseEntity<>(HttpStatus.OK);
      }
}
