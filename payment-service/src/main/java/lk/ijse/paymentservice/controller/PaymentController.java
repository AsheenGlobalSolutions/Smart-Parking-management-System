package lk.ijse.paymentservice.controller;

import lk.ijse.paymentservice.dto.PaymentDTO;
import lk.ijse.paymentservice.dto.ResponseDTO;
import lk.ijse.paymentservice.service.PaymentService;
import lk.ijse.paymentservice.util.VarList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> savePayment(@RequestBody PaymentDTO paymentDTO) {
        try {
        int code = paymentService.createPayment(paymentDTO);
        switch (code){
            case VarList.OK:
                return ResponseEntity.ok(new ResponseDTO(VarList.OK,"Payment Saved",null));
            case VarList.Not_Acceptable:
                return ResponseEntity.badRequest().body(new ResponseDTO(VarList.Not_Acceptable,"Payment Already Exists",null));
            default:
                return ResponseEntity.internalServerError().body(new ResponseDTO(VarList.Internal_Server_Error,"Something went wrong",null));
        }
    }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseDTO(VarList.Internal_Server_Error,"Something went wrong",null));
        }
    }
}
