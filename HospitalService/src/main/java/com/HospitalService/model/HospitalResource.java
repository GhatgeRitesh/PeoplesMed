package com.HospitalService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "HospitalResource")
public class HospitalResource{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Integer bedCount;
        private Integer ambulanceCount;
        private Boolean otAvailable;
        private Boolean staffPresent;

        @OneToOne
        @JoinColumn(name = "hospital_id")
        private Hospital hospital;
}
