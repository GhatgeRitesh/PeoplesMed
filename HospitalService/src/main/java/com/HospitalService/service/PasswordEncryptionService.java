package com.HospitalService.service;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
@Log
public class PasswordEncryptionService {

    public String hashPassword(String password){
        try{
            if(password.isEmpty()){log.info("Password received empty");return null;}
            log.info("Password Encryption Started");
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashed = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for(byte b:hashed){
                sb.append(String.format("%02x",b));
            }
            log.info("Password Encrypted Successfully");
            return sb.toString();
        }catch(Exception e){
            log.info("Exception occurred while Encrypting the password");
            log.info("Exception:- "+ e);
            return null;
        }
    }
}
