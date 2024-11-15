package com.Database.PeoplesMedDB.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DocSchedules")
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doctor_id")
    private Long doctorId; // Renamed field

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "name")
    private  String name;

    @Column(name = "email")
    private  String email;

    @Column(name = "reason")
    private  String reason;

    @Column(name = "slot_date")
    private String slotDate;

    @Column(name = "slot_time")
    private String slotTime;

    @Enumerated(EnumType.STRING)
    private Status currstatus;

    public enum Status {
        AVAILABLE, ALLOTTED
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", reason='" + reason + '\'' +
                ", slotDate='" + slotDate + '\'' +
                ", slotTime='" + slotTime + '\'' +
                ", currstatus=" + currstatus +
                '}';
    }
}
