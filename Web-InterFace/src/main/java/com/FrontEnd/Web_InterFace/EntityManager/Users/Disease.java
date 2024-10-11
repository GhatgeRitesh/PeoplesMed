package com.FrontEnd.Web_InterFace.EntityManager.Users;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("session")
@Getter @Setter
public class Disease {
    private Long diseaseId;
    private String name;
    private String category;
    private List<MedicalHistory> medicalHistories;
}
