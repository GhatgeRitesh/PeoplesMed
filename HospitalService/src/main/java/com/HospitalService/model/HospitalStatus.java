package com.HospitalService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "HospitalStatus")
public class HospitalStatus {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "icu_available", nullable = false)
        private Boolean icuAvailable;

        @Column(name = "present_doctor")
        private String presentDoctor;

        @Column(name = "ot_active", nullable = false)
        private Boolean otActive;

        @Column(name = "status", nullable = false)
        private String status; // e.g., "open" or "close"

        @Column(name = "staff_count")
        private Integer staffCount;

        @Column(name = "ambulance_count")
        private Integer ambulanceCount;

        @OneToOne
        @JoinColumn(name = "h_id", referencedColumnName = "h_id", nullable = false)
        private Hospital hospital;

}
