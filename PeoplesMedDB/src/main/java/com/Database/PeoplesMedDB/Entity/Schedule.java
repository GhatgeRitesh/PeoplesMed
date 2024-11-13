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

    @Column(name = "slot_date")
    private String slotDate;

    @Column(name = "slot_time")
    private String slotTime;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        AVAILABLE, ALLOTTED
    }
}
