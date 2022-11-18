package com.example.springbootjpa.domain.entity;

import com.example.springbootjpa.domain.dto.HospitalResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Entity
@Table(name = "nation_wide_hospitals")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String openServiceName;
    private int openLocalGovernmentCode;
    private String managementNumber;
    private LocalDateTime licenseDate;
    private int businessStatus;
    private int businessStatusCode;
    private String phone;
    private String fullAddress;
    private String roadNameAddress;
    private String hospitalName;
    private String businessTypeName;
    private int healthcareProviderCount;
    private int patientRoomCount;
    private int totalNumberOfBeds;
    private float totalAreaSize;

    public static HospitalResponseDto of(Hospital hospital) {
        return new HospitalResponseDto(hospital.getId(),
                hospital.getRoadNameAddress(),
                hospital.getHospitalName(),
                hospital.businessTypeName,
                hospital.patientRoomCount,
                hospital.totalNumberOfBeds,
                hospital.totalAreaSize);
    }
}
