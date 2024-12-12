package com.FrontEnd.CustomerService.EntityManager.Users;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

@Data
@Scope("prototype")
@Getter
@Setter
public class BookedSchedules {
    private Long sId;
    private Long dId;
    private Long pId;
    private String slotDate;
    private String slotTime;
    private String description;
    private String status;
    private String link;
    private String docName;
    private String patName;
}
