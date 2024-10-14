package com.Database.PeoplesMedDB.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @Column(name = "doctor_id", nullable = false)
    private Long doctorId;

    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @Column(name = "schedule_date", nullable = false)
    private Date date;


    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", date=" + date +
                '}';
    }
}
