package com.EmergencyServcice.Model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class DataHolder {
    private Long emergencyRequestId;
    private List<HospitalStatusDTO> list;
}
