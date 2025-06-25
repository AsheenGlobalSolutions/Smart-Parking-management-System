package lk.ijse.parkingspaceservice.service.impl;

import lk.ijse.parkingspaceservice.dto.ParkingSpaceDTO;
import lk.ijse.parkingspaceservice.entity.ParkingSpace;
import lk.ijse.parkingspaceservice.repo.ParkingSpaceRepo;
import lk.ijse.parkingspaceservice.service.ParkingSpaceService;
import lk.ijse.parkingspaceservice.utill.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {

    @Autowired
    private ParkingSpaceRepo parkingSpaceRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int saveParkingSpace(ParkingSpaceDTO parkingSpaceDTO) {
        if (parkingSpaceRepo.existsById(parkingSpaceDTO.getId())) {
            return VarList.Not_Acceptable;
        }
        parkingSpaceRepo.save(modelMapper.map(parkingSpaceDTO, ParkingSpace.class));
        return VarList.Created;
    }

    @Override
    public int updateParkingSpace(ParkingSpaceDTO parkingSpaceDTO) {
        if (parkingSpaceRepo.existsById(parkingSpaceDTO.getId())) {
            parkingSpaceRepo.save(modelMapper.map(parkingSpaceDTO, ParkingSpace.class));
            return VarList.OK;
        } else {
            return VarList.Not_Found;
        }
    }

    @Override
    public int deleteParkingSpace(int id) {
        if (parkingSpaceRepo.existsById(id)) {
            parkingSpaceRepo.deleteById(id);
            return VarList.OK;
        } else {
            return VarList.Not_Found;
        }
    }

    @Override
    public ParkingSpaceDTO getParkingSpace(int id) {
        if (parkingSpaceRepo.existsById(id)) {
            return modelMapper.map(parkingSpaceRepo.findById(id), ParkingSpaceDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public List<ParkingSpaceDTO> getAllParkingSpace() {
        parkingSpaceRepo.findAll();
        return modelMapper.map(parkingSpaceRepo.findAll(), new TypeToken<List<ParkingSpaceDTO>>(){}.getType());
    }
}
