package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.dto.HospitalResponseDto;
import com.example.springbootjpa.domain.entity.Hospital;
import com.example.springbootjpa.respository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalResponseDto getHospital(int id) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        if (optionalHospital.isPresent()) {
            Hospital hospital = optionalHospital.get();
            HospitalResponseDto hospitalResponseDto = Hospital.of(hospital);

            switch (hospital.getBusinessStatusCode()) {
                case 13:
                    hospitalResponseDto.setBusinessStatusName("영업중");
                    break;
                case 24:
                    hospitalResponseDto.setBusinessStatusName("직권폐업");
                    break;
                case 3:
                    hospitalResponseDto.setBusinessStatusName("폐업");
                    break;
                case 2:
                    hospitalResponseDto.setBusinessStatusName("휴업");
                    break;
            }
            return hospitalResponseDto;
        } else {
            return new HospitalResponseDto(id, "상태코드가 없습니다.");
        }
    }
}