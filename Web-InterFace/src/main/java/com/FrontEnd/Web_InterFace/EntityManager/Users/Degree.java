package com.FrontEnd.Web_InterFace.EntityManager.Users;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
@Getter @Setter
public class Degree {
    private int deg_id;
    private int doc_id;
    private int deg_name;
}
