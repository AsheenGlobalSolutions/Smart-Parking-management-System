package lk.ijse.parkingspaceservice.controller;

import lk.ijse.parkingspaceservice.dto.ParkingSpaceDTO;
import lk.ijse.parkingspaceservice.dto.ResponseDTO;
import lk.ijse.parkingspaceservice.service.ParkingSpaceService;
import lk.ijse.parkingspaceservice.utill.VarList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/parking-space")

public class ParkingSpaceController {

    private final ParkingSpaceService parkingSpaceService;

    public ParkingSpaceController(ParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }

    @GetMapping("getAll")
    public ResponseEntity<ResponseDTO> getAllParkingSpace() {
        List<ParkingSpaceDTO> allParkingSpace = parkingSpaceService.getAllParkingSpace();
        return  ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(VarList.OK, "All Parking Space", allParkingSpace));
    }

    @PostMapping("save")
    public ResponseEntity<ResponseDTO> saveParkingSpace(@RequestBody ParkingSpaceDTO parkingSpaceDTO) {
        int res = parkingSpaceService.saveParkingSpace(parkingSpaceDTO);
        return switch (res) {
            case VarList.Created -> // Accepted
                    ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created, "Parking Space saved successfully", null));
            case VarList.Not_Acceptable -> // Not Acceptable
                    ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new ResponseDTO(VarList.Not_Found, "Parking Space already exists", null));
            default -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, "Internal Server Error", null));
        };
    }

    @PutMapping("update")
    public ResponseEntity<ResponseDTO> updateParkingSpace(@RequestBody ParkingSpaceDTO parkingSpaceDTO) {
        int res = parkingSpaceService.updateParkingSpace(parkingSpaceDTO);
        return switch (res) {
            case VarList.OK -> ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO(VarList.OK, "Parking Space updated successfully", null));
            case VarList.Not_Found -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDTO(VarList.Not_Found, "Parking Space not found", null));
            default -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, "Internal Server Error", null));
        };
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseDTO> deleteParkingSpace(@PathVariable int id) {
        int res = parkingSpaceService.deleteParkingSpace(id);
        return switch (res) {
            case VarList.OK -> ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO(VarList.OK, "Parking Space deleted successfully", null));
            case VarList.Not_Found -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDTO(VarList.Not_Found, "Parking Space not found", null));
            default -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, "Internal Server Error", null));
        };
    }
}
