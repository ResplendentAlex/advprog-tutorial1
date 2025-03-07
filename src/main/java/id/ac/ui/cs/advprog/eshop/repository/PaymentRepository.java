package id.ac.ui.cs.advprog.eshop.repository;

import enums.OrderStatus;
import enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PaymentRepository {
    private List<Payment> paymentData;

    public PaymentRepository() {
        this.paymentData = new ArrayList<>();
    }

    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        String uuid = UUID.randomUUID().toString();
        Payment payment = new Payment(uuid, method, paymentData, order);
        this.paymentData.add(payment);
        return payment;
    }

    public Payment setStatus(Payment payment, String status) throws IllegalArgumentException {
        if (!PaymentStatus.contains(status)) {
            throw new IllegalArgumentException();
        }
        payment.setStatus(status);
        if (status.equals(PaymentStatus.REJECTED.getValue())) {
            payment.getOrder().setStatus(OrderStatus.FAILED.getValue());
        } else if (status.equals(PaymentStatus.SUCCESS.getValue())) {
            // Used extended conditions to allow for extension in case another payment status is added.
            payment.getOrder().setStatus(OrderStatus.SUCCESS.getValue());
        }
        return payment;
    }

    public Payment getPayment(String paymentId) {
        for (Payment payment : paymentData) {
            if (payment.getId().equals(paymentId)) {
                return payment;
            }
        }
        return null;
    }

    public List<Payment> getAllPayments() {
        return paymentData;
    }
}
