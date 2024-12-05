package com.Database.PeoplesMedDB.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Schedule")
@Getter @Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sId;

    @Column(name = "DoctorID")
    private Long dId;

    @Column(name = "PatientID")
    private Long pId;

    @Column(name = "SlotDate")
    private String slotDate;

    @Column(name = "SlotLimit")
    private int Limit;

    @Column(name = "SlotTime")
    private String slotTime;

    @Column(name = "description")
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
                ", description='" + description+ '\'' +
                '}';
    }
}