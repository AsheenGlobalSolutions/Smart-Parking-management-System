package lk.ijse.vehicleservice.service.impl;

import lk.ijse.vehicleservice.dto.VehicleDTO;
import lk.ijse.vehicleservice.entity.Vehicle;
import lk.ijse.vehicleservice.repo.VehicleRepo;
import lk.ijse.vehicleservice.service.VehicleService;
import lk.ijse.vehicleservice.util.VarList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int saveVehicle(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getVehicleId())) {
            return VarList.Not_Acceptable; // Vehicle already exists
        }
        vehicleRepo.save(modelMapper.map(vehicleDTO, Vehicle.class));
        return VarList.Created; // Vehicle saved successfully
    }

    @Override
    public VehicleDTO searchVehicle(int vehicleId) {
        vehicleRepo.findById(vehicleId);
        return null;
    }

    @Override
    public int deleteVehicle(int vehicleId) {
        if (vehicleRepo.existsById(vehicleId)) {
            vehicleRepo.deleteById(vehicleId);
            return VarList.OK; // Vehicle deleted successfully
        } else {
            return VarList.Not_Found; // Vehicle not found
        }
    }

    @Override
    public int updateVehicle(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getVehicleId())) {
            vehicleRepo.save(modelMapper.map(vehicleDTO, Vehicle.class));
            return VarList.OK; // Vehicle updated successfully
        } else {
            return VarList.Not_Found; // Vehicle not found
        }
    }

    @Override
    public VehicleDTO getVehicleById(int vehicleId) {
        vehicleRepo.findById(vehicleId);
        return null;
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        vehicleRepo.findAll();
        return modelMapper.map(vehicleRepo.findAll(), new TypeToken<List<VehicleDTO>>(){}.getType());
    }
}
