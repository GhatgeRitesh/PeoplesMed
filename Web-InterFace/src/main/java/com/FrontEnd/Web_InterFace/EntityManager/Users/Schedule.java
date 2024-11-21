package com.FrontEnd.Web_InterFace.EntityManager.Users;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
public class Schedule {
    private Long sId;
    private Long dId;
    private Long pId;
    private String slotDate;
    private int Limit;
    private String slotTime;
    private String description;
    @Override
    public String toString() {
        return "Schedule{" +
                "sId=" + sId +
                ", dId=" + dId +
                ", pId=" + pId +
                ", slotDate='" + slotDate + '\'' +
                ", Limit=" + Limit +
                ", slotTime='" + slotTime + '\'' +
                ", description'" + description + '\'' +
                '}';
    }
}
