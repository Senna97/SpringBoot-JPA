package com.example.springbootjpa.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HospitalResponseDto {
    private int id;
    private String roadNameAddress;
    private String hospitalName;
    private String businessTypeName;
    private int patientRoomCount;
    private int totalNumberOfBeds;
    private float totalAreaSize;
    private String businessStatusName;

    private String message;

    public HospitalResponseDto(int id, String roadNameAddress, String hospitalName, String businessTypeName, int patientRoomCount, int totalNumberOfBeds, float totalAreaSize) {
        this.id = id;
        this.roadNameAddress = roadNameAddress;
        this.hospitalName = hospitalName;
        this.businessTypeName = businessTypeName;
        this.patientRoomCount = patientRoomCount;
        this.totalNumberOfBeds = totalNumberOfBeds;
        this.totalAreaSize = totalAreaSize;
    }

    public HospitalResponseDto(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public void setBusinessStatusName(String businessStatusName) {
        this.businessStatusName = businessStatusName;
    }
}