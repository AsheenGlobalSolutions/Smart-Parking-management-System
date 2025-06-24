package lk.ijse.vehicleservice.controller;

import lk.ijse.vehicleservice.dto.ResponseDTO;
import lk.ijse.vehicleservice.dto.VehicleDTO;
import lk.ijse.vehicleservice.service.VehicleService;
import lk.ijse.vehicleservice.util.VarList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("save")
    public ResponseEntity<ResponseDTO> saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        try {
            int res = vehicleService.saveVehicle(vehicleDTO);
            return switch (res) {
                case VarList.Created -> // Accepted
                        ResponseEntity.status(HttpStatus.CREATED)
                                .body(new ResponseDTO(VarList.Created, "Vehicle saved successfully", null));
                case VarList.Not_Acceptable -> // Not Acceptable
                        ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                                .body(new ResponseDTO(VarList.Not_Found, "Vehicle already exists", null));
                default -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ResponseDTO(VarList.Internal_Server_Error, "Internal Server Error", null));
            };

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, "Internal Server Error: " + e.getMessage(), null));
        }
    }
    @GetMapping("search/{vehicleId}")
    public ResponseEntity<ResponseDTO> searchVehicle(@PathVariable int vehicleId) {
        try {
            VehicleDTO vehicleDTO = vehicleService.searchVehicle(vehicleId);
            if (vehicleDTO != null) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new ResponseDTO(VarList.OK, "Vehicle found", vehicleDTO));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseDTO(VarList.Not_Found, "Vehicle not found", null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, "Internal Server Error: " + e.getMessage(), null));
        }
    }
    @DeleteMapping("delete/{vehicleId}")
    public ResponseEntity<ResponseDTO> deleteVehicle(@PathVariable int vehicleId) {
        try {
            int res = vehicleService.deleteVehicle(vehicleId);
            return switch (res) {
                case VarList.OK -> ResponseEntity.status(HttpStatus.OK)
                        .body(new ResponseDTO(VarList.OK, "Vehicle deleted successfully", null));
                case VarList.Not_Found -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseDTO(VarList.Not_Found, "Vehicle not found", null));
                default -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ResponseDTO(VarList.Internal_Server_Error, "Internal Server Error", null));
            };
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, "Internal Server Error: " + e.getMessage(), null));
        }
    }

    @PutMapping("update")
    public ResponseEntity<ResponseDTO> updateVehicle(@RequestBody VehicleDTO vehicleDTO) {
        try {
            int res = vehicleService.updateVehicle(vehicleDTO);
            System.out.println(vehicleDTO.getVehicleId());
            return switch (res) {
                case VarList.OK -> ResponseEntity.status(HttpStatus.OK)
                        .body(new ResponseDTO(VarList.OK, "Vehicle updated successfully", null));
                case VarList.Not_Found -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseDTO(VarList.Not_Found, "Vehicle not found", null));
                default -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ResponseDTO(VarList.Internal_Server_Error, "Internal Server Error", null));
            };
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, "Internal Server Error: " + e.getMessage(), null));
        }
    }

    @GetMapping("get/{vehicleId}")
    public ResponseEntity<ResponseDTO> getVehicle(@PathVariable int vehicleId) {
        try {
            VehicleDTO vehicleDTO = vehicleService.searchVehicle(vehicleId);
            if (vehicleDTO != null) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new ResponseDTO(VarList.OK, "Vehicle found", vehicleDTO));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseDTO(VarList.Not_Found, "Vehicle not found", null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, "Internal Server Error: " + e.getMessage(), null));
        }
    }

    @GetMapping("getAll")
    public ResponseEntity<ResponseDTO> getAllVehicles() {
        try {
            List<VehicleDTO> vehicleDTOList = vehicleService.getAllVehicles();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO(VarList.OK, "Vehicles found", vehicleDTOList));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, "Internal Server Error: " + e.getMessage(), null));
        }
    }
}
