package com.HospitalService.service;

import com.HospitalService.model.Emergency_Requests;
import com.HospitalService.model.HospitalStatusDTO;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@Log
public class FilterService {

    public List<HospitalStatusDTO> getFilteredHospitals(List<HospitalStatusDTO> list, Emergency_Requests emergencyRequests){
      log.info("Filtering Hospitals");
      try{
          List<HospitalStatusDTO> filtered= new ArrayList<>();
          HashSet<Long> HospitalIds= new HashSet<>();

          Boolean AmbulanceNeeded= emergencyRequests.getAmbulanceNeed();
          String Condition= emergencyRequests.getCondition();

          for(HospitalStatusDTO dto: list){
              if(dto.getStatus_1() == null || !dto.getStatus_1()) continue;

              if("serious".equalsIgnoreCase(Condition)){
                  boolean icu= dto.getIcuAvailable();
                  boolean ot = dto.getOtActive();

                  if(!icu && !ot) continue;

                  if(AmbulanceNeeded){
                      if(dto.getAmbulanceCount() == null || dto.getAmbulanceCount()<1) continue;
                  }
              } else if ("mild".equalsIgnoreCase(Condition)) {
                  if(AmbulanceNeeded){
                      if(dto.getAmbulanceCount() == null || dto.getAmbulanceCount()<1) continue;
                  }
              }

              filtered.add(dto);
              HospitalIds.add(dto.getId());
          }
          for(HospitalStatusDTO dto :list){
              if(!HospitalIds.contains(dto.getId())){filtered.add(dto);}
          }
          log.info("Filtering Completed");

          return filtered;
      }catch (Exception e){
          log.info("Exception Occurred while filtering hospitals: "+ e.getMessage());
          return null;
      }
    }
}
