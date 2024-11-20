package com.BackEnd.Features.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Getter @Setter
public class Patient {

    private String email;
    private Long p_id;
}
