package lk.ijse.vehicleservice.service;

import lk.ijse.vehicleservice.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    int saveVehicle(VehicleDTO vehicleDTO);
    VehicleDTO searchVehicle(int vehicleId);
    int deleteVehicle(int vehicleId);
    int updateVehicle(VehicleDTO vehicleDTO);
    VehicleDTO getVehicleById(int vehicleId);
    List<VehicleDTO> getAllVehicles();
}
