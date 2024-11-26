package com.Database.PeoplesMedDB.Entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

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

