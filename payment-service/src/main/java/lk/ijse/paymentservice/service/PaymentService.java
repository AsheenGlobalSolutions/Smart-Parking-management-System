package lk.ijse.paymentservice.service;

import lk.ijse.paymentservice.dto.PaymentDTO;
import lk.ijse.paymentservice.entity.Payment;

public interface PaymentService {
    int createPayment(PaymentDTO paymentDTO);
}
