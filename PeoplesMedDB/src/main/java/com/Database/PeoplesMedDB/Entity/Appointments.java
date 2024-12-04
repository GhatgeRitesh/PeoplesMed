package com.Database.PeoplesMedDB.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Appointments")
@Getter @Setter
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aId;

    @Column(name = "DoctorID")
    private Long dId;

    @Column(name = "SlotDate")
    private String slotDate;

    @Column(name = "SlotLimit")
    private int Limit;

    @Column(name = "SlotTime")
    private String slotTime;

    @Override
    public String toString() {
        return "Appointments{" +
                "aId=" + aId +
                ", dId=" + dId +
                ", slotDate='" + slotDate + '\'' +
                ", Limit=" + Limit +
                ", slotTime='" + slotTime + '\'' +
                '}';
    }
}
