package com.FrontEnd.Web_InterFace.EntityManager.Users;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Getter @Setter
public class UpdateScheduleDTO {
    private Long doctorid;
    private Long patientid;
    private String description;
    private String slottime;
    private String date;

    @Override
    public String toString() {
        return "UpdateScheduleDTO{" +
                "doctorid=" + doctorid +
                ", patientid=" + patientid +
                ", description='" + description + '\'' +
                ", slottime='" + slottime + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
