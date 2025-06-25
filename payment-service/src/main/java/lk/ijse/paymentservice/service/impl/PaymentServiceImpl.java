package lk.ijse.paymentservice.service.impl;

import lk.ijse.paymentservice.dto.PaymentDTO;
import lk.ijse.paymentservice.entity.Payment;
import lk.ijse.paymentservice.repo.PaymentRepo;
import lk.ijse.paymentservice.service.PaymentService;
import lk.ijse.paymentservice.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int createPayment(PaymentDTO paymentDTO) {
        if (paymentRepo.existsById(paymentDTO.getPaymentId())) {
            return VarList.Not_Acceptable;
        }

        System.out.println(paymentDTO.toString());
        paymentRepo.save(modelMapper.map(paymentDTO, Payment.class));
        return VarList.OK;
    }
}
