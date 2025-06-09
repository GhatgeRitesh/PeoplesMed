package com.HospitalService.service;

import com.HospitalService.model.Hospital;
import com.HospitalService.model.HospitalStatus;
import com.HospitalService.model.HospitalStatusDTO;
import com.HospitalService.model.Login;
import com.HospitalService.repository.HospitalRepo;
import com.HospitalService.repository.HospitalStatusRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log
public class HospitalService {
    @Autowired
    private HospitalRepo hospitalRepo;

    @Autowired
    private HospitalStatusRepo hospitalStatusRepo;

    public boolean save(Hospital hospital){
        if(hospital == null) {
            log.info("Object received empty");
            return false;
        }
        try{
            log.info("Saving hospital Details");
            hospitalRepo.save(hospital);
            log.info("Hospital Details saved successfully");
            return true;
        }catch(Exception e){
            log.info("Exception occurred while savinf hospital details");
            log.info("Exception:- "+ e);
            return false;
        }
    }

    public Hospital getHosital(String name, String contact){
        try {
            if (name == null || contact == null) throw new RuntimeException("Name and Contact are null");
            log.info("Fetching Hospital details");
            Optional<Hospital> hospital= hospitalRepo.findByNameAndContact(name , contact);
            log.info("fetched hospital successfully: "+ hospital.orElse(null).getName());
            return hospital.orElse(null);
        }catch (Exception e){
            log.info("Exception while fetching hospital details: "+ e.getMessage());
            return null;
        }
    }

    public List<HospitalStatusDTO> getCityHospitals(String city){
        try{
            if(city == null){throw new RuntimeException("city value is null");}
            List<HospitalStatusDTO> list= hospitalRepo.findHospitalStatusByCity(city);
            log.info("Hospital Data Fetched as : "+ list.toString());
            return list;
        }catch(Exception e){
            log.info("Exception Occurred while fetching Hospital DTO: "+ e.getMessage());
            return null;
        }
    }

    public Boolean setStatus(HospitalStatus hospitalStatus){
        try{

            hospitalStatusRepo.save(hospitalStatus);
            return true;
        }catch (Exception e){
            log.info("Error while saving hospital status: "+ e.getMessage());
            return false;
        }
    }

    public Optional<Hospital> getCreds(Login login){
        try{
            if(login == null) throw new RuntimeException("login DTO is empty");
            log.info("Fetching hospital creds");
            Optional<Hospital> hospital= hospitalRepo.findByNameAndContact(login.getName(),login.getContact());

            log.info("Fetched Hospital Creds:"+ hospital.orElse(null).toString() );
            return hospital;
        }catch (Exception e){
            log.info("Exception in service: "+ e.getMessage());
            return Optional.empty();
        }
    }

    public HospitalStatus getHospitalStatus(Long H_id){
        try {
            if (H_id == null) {
                throw new RuntimeException("Hospital Id is missing");
            }
            log.info("Fetching Hospital Status for H_id: "+ H_id);
            HospitalStatus result = hospitalStatusRepo.findByHospitalId(H_id);
            log.info("Fetched Successfully: "+ result.toString());
            return result;
        }catch(Exception e){
            log.info("Exception Occurred while fetching hospital status: "+ e.getMessage());
            return null;
        }
    }

    public Hospital getHospitalByID(Long h_Id){
        try{
            if (h_Id == null) throw new RuntimeException("ID is null");
            log.info("Finding hospital for id :"+ h_Id);
            Optional<Hospital> hospital=hospitalRepo.findById(h_Id);
            return hospital.orElse(null);
        }catch (Exception e){
            log.info("Exception while finding hospital for ID: "+ h_Id +" with exception :"+e.getMessage());
            return  null;
        }
    }

    public boolean updateHospitalStatus(Long hospital_id,HospitalStatus hospitalStatus){
        try {

            log.info("Fetching Current status");
            HospitalStatus currStatus= hospitalStatusRepo.findByHospitalId(hospital_id);
            if(currStatus == null) throw new RuntimeException("Hospital Status Not found");
            log.info("current Status :-"+ currStatus);
            log.info("updating current status with : "+ hospitalStatus.toString());
            currStatus.setIcuAvailable(hospitalStatus.getIcuAvailable());
            currStatus.setPresentDoctor(hospitalStatus.getPresentDoctor());
            currStatus.setOtActive(hospitalStatus.getOtActive());
            currStatus.setStatus_1(hospitalStatus.getStatus_1());
            currStatus.setStaffCount(hospitalStatus.getStaffCount());
            currStatus.setAmbulanceCount(hospitalStatus.getAmbulanceCount());

            hospitalStatusRepo.save(currStatus);
            return true;
        }catch (Exception e){
            log.info("Exception While Saving current status:> "+ e.getMessage());

            return false;
        }
    }
}
