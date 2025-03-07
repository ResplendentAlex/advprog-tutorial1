package id.ac.ui.cs.advprog.eshop.service;

import java.util.List;
import java.util.Map;

import enums.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        if (!PaymentMethod.contains(method)) {
            throw new IllegalArgumentException();
        }
        return paymentRepository.addPayment(order, method, paymentData);
    }

    @Override
    public Payment setStatus(Payment payment, String status) {
        return paymentRepository.setStatus(payment, status);
    }

    @Override
    public Payment getPayment(String paymentId) {
        return paymentRepository.getPayment(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.getAllPayments();
    }
}
