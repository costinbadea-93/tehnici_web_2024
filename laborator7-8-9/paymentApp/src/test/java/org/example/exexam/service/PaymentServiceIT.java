package org.example.exexam.service;

import org.example.exexam.dto.PaymentDto;
import org.example.exexam.repository.PaymentRepository;
import org.example.exexam.utils.PaymentStatus;
import org.example.exexam.utils.PaymentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.example.exexam.utils.PaymentUtil.fromDtoToPayment;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test") //the test will use the configuration from the application-test.properties file
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class PaymentServiceIT {

    @MockitoBean //instead of the deprecated @MockBean
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentService paymentService;

    @Test
    @DisplayName("Cancel payment - happy flow")
    void cancelPaymentWithSuccess() {

        var paymentId = 1;
        var paymentDto = PaymentDto
                .builder()
                .amount(2000)
                .customer("Customer8")
                .paymentType(PaymentType.POS)
                .paymentStatus(PaymentStatus.PROCESSED)
                .build();

        var payment = fromDtoToPayment(paymentDto);


        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(payment));
        when(paymentRepository.save(payment)).thenReturn(payment);

        var result = paymentService.cancelPayment(paymentId);

        assertEquals(PaymentStatus.CANCELLED, result.getPaymentStatus());
        assertEquals("Customer8", result.getCustomer());
        assertEquals(PaymentType.POS, result.getPaymentType());

        verify(paymentRepository).save(payment);
    }

}
