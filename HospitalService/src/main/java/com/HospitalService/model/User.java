package com.HospitalService.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private Long id;

    private String userName;
    private String userContact;
    private String userCity;
}
