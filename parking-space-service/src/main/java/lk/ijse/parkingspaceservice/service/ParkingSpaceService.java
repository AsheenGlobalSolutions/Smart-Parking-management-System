package lk.ijse.parkingspaceservice.service;

import lk.ijse.parkingspaceservice.dto.ParkingSpaceDTO;

import java.util.List;

public interface ParkingSpaceService {
    int saveParkingSpace(ParkingSpaceDTO parkingSpaceDTO);
    int updateParkingSpace(ParkingSpaceDTO parkingSpaceDTO);
    int deleteParkingSpace(int id);
    ParkingSpaceDTO getParkingSpace(int id);
    List<ParkingSpaceDTO> getAllParkingSpace();
}
