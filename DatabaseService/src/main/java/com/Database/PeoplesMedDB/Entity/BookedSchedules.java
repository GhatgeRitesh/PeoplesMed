package com.Database.PeoplesMedDB.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "BookedSchedules")
@Getter
@Setter
public class BookedSchedules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sId;

    @Column(name = "DoctorID")
    private Long dId;

    @Column(name = "PatientID")
    private Long pId;

    @Column(name = "SlotDate")
    private String slotDate;

    @Column(name = "SlotTime")
    private String slotTime;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "link")
    private String link;

    @Column(name = "doctorName")
    private String docName;

    @Column(name = "patientName")
    private String patName;

    @Override
    public String toString() {
        return "BookedSchedules{" +
                "sId=" + sId +
                ", dId=" + dId +
                ", pId=" + pId +
                ", slotDate='" + slotDate + '\'' +
                ", slotTime='" + slotTime + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", link='" + link + '\'' +
                ", docName='" + docName + '\'' +
                ", patName='" + patName + '\'' +
                '}';
    }
}
