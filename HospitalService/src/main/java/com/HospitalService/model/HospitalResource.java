package com.HospitalService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@Table(name = "HospitalResource")
public class HospitalResource{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "resource_id")
        private Long id;

        @Column(name = "icu_available")
        private Boolean icuAvailable;

        @Column(name = "ot_available")
        private Boolean otAvailable;

        @Column(nullable = false)
        private String status; // Can be "Open" or "Close"

        @Column(name = "staff_count")
        private Integer staffCount;

        @ManyToOne
        @JoinColumn(name = "hospital_id", referencedColumnName = "h_id")
        private Hospital hospital;
}
