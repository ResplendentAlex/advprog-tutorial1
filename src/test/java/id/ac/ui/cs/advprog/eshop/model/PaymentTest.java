package id.ac.ui.cs.advprog.eshop.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.PaymentStatus;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    private Map<String, String> voucherPaymentData;
    private Map<String, String> codPaymentData;
    private List<Product> products;
    private Order order;

    @BeforeEach
    void setUp() {
        voucherPaymentData = new HashMap<>();
        voucherPaymentData.put("voucherCode", "ESHOP1234ABC5678");
        codPaymentData = new HashMap<>();
        codPaymentData.put("address", "Citra 1 Ext. Blok AB-3 No.1");
        codPaymentData.put("deliveryFee", "12000");
        products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        Product product2 = new Product();
        product2.setProductId("a2c62328-4a37-4664-83c7-f32db8620155");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);
        products.add(product1);
        products.add(product2);
        order = new Order("13652556-012a-4c07-b546-54eb1396d79b", products,
                1708560000L, "Safira Sudrajat");
    }

    @Test
    void testCreatePaymentWithoutPaymentData() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("13652556-012a-4c07-b546-54eb1396d79c", "VOUCHER", null, this.order);
        });
    }

    @Test
    void testCreateVoucherPaymentWithInvalidPaymentData() {
        Map<String, String> paymentDataWithoutESHOPPrefix = new HashMap<String, String>();
        Map<String, String> paymentDataWithoutEightNumbers = new HashMap<String, String>();
        Map<String, String> paymentDataWithLessThanSixteenCharacters = new HashMap<String, String>();
        Map<String, String> paymentDataWithGreaterThanSixteenCharacters = new HashMap<String, String>();
        paymentDataWithoutESHOPPrefix.put("voucherCode", "1234ABCDEFGH5678");
        paymentDataWithoutEightNumbers.put("voucherCode", "ESHOP1234ABCDEFG");
        paymentDataWithLessThanSixteenCharacters.put("voucherCode", "ESHOP1234ABC567");
        paymentDataWithGreaterThanSixteenCharacters.put("voucherCode", "ESHOP1234ABC56781234");
        Payment paymentWithoutESHOPPrefix = new Payment("13652556-012a-4c07-b546-54eb1396d79b", "VOUCHER",
                paymentDataWithoutESHOPPrefix, this.order);
        Payment paymentWithoutEightNumbers = new Payment("13652556-012a-4c07-b546-54eb1396d79b", "VOUCHER",
                paymentDataWithoutEightNumbers, this.order);
        Payment paymentWithLessThanSixteenCharacters = new Payment("13652556-012a-4c07-b546-54eb1396d79b", "VOUCHER",
                paymentDataWithLessThanSixteenCharacters, this.order);
        Payment paymentWithGreaterThanSixteenCharacters = new Payment("13652556-012a-4c07-b546-54eb1396d79b", "VOUCHER",
                paymentDataWithGreaterThanSixteenCharacters, this.order);

        assertEquals(PaymentStatus.REJECTED.getValue(), paymentWithoutESHOPPrefix.getStatus());
        assertEquals(PaymentStatus.REJECTED.getValue(), paymentWithoutEightNumbers.getStatus());
        assertEquals(PaymentStatus.REJECTED.getValue(), paymentWithLessThanSixteenCharacters.getStatus());
        assertEquals(PaymentStatus.REJECTED.getValue(), paymentWithGreaterThanSixteenCharacters.getStatus());
    }

    @Test
    void testCreateCODPaymentWithInvalidData() {
        Map<String, String> paymentDataWithoutAddress = new HashMap<String, String>();
        paymentDataWithoutAddress.put("deliveryFee", "12000");
        Map<String, String> paymentDataWithoutDeliveryFee = new HashMap<String, String>();
        paymentDataWithoutDeliveryFee.put("address", "Citra 1 Ext. Blok AB-3 No.1");
        Map<String, String> paymentDataWithEmptyAddress = new HashMap<String, String>();
        paymentDataWithEmptyAddress.put("address", "");
        paymentDataWithEmptyAddress.put("deliveryFee", "12000");
        Map<String, String> paymentDataWithEmptyDeliveryFee = new HashMap<String, String>();
        paymentDataWithEmptyDeliveryFee.put("address", "Citra 1 Ext. Blok AB-3 No.1");
        paymentDataWithEmptyDeliveryFee.put("deliveryFee", "");
        Payment paymentWithoutAddress = new Payment("13652556-012a-4c07-b546-54eb1396d79b", "COD",
                paymentDataWithoutAddress, this.order);
        Payment paymentWithoutDeliveryFee = new Payment("13652556-012a-4c07-b546-54eb1396d79b", "COD",
                paymentDataWithoutDeliveryFee, this.order);
        Payment paymentWithEmptyAddress = new Payment("13652556-012a-4c07-b546-54eb1396d79b", "COD",
                paymentDataWithEmptyAddress, this.order);
        Payment paymentWithEmptyDeliveryFee = new Payment("13652556-012a-4c07-b546-54eb1396d79b", "COD",
                paymentDataWithEmptyDeliveryFee, this.order);

        assertEquals(PaymentStatus.REJECTED.getValue(), paymentWithoutAddress.getStatus());
        assertEquals(PaymentStatus.REJECTED.getValue(), paymentWithoutDeliveryFee.getStatus());
        assertEquals(PaymentStatus.REJECTED.getValue(), paymentWithEmptyAddress.getStatus());
        assertEquals(PaymentStatus.REJECTED.getValue(), paymentWithEmptyDeliveryFee.getStatus());
    }

    @Test
    void testCreateVoucherPaymentSuccess() {
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b", "VOUCHER", this.voucherPaymentData,
                this.order);
        assertEquals("SUCCESS", payment.getStatus());
        assertSame(this.voucherPaymentData, payment.getPaymentData());
        assertSame(this.order, payment.getOrder());
    }

    @Test
    void testCreatePaymentWithoutOrder() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("13652556-012a-4c07-b546-54eb1396d79b", "VOUCHER", this.voucherPaymentData, null);
        });
    }


    @Test
    void testCreatePaymentWithInvalidMethod() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("13652556-012a-4c07-b546-54eb1396d79b", "WOOF", this.voucherPaymentData, this.order);
        });
    }

    @Test
    void testCreateCODPaymentSuccess() {
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b", "COD", this.codPaymentData, this.order);
        assertEquals("SUCCESS", payment.getStatus());
        assertSame(this.codPaymentData, payment.getPaymentData());
        assertSame(this.order, payment.getOrder());
    }
}
