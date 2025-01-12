package org.example.exexam.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.exexam.dto.PaymentDto;
import org.example.exexam.model.Payment;
import org.example.exexam.repository.PaymentRepository;
import org.example.exexam.service.PaymentService;
import org.example.exexam.utils.PaymentStatus;
import org.example.exexam.utils.PaymentType;
import org.example.exexam.utils.PaymentUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PaymentController.class) //this tells Spring Boot to auto-configure a Spring web context
// for integration tests for the DestinationController class
public class PaymentControllerIT {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockitoBean
    private PaymentService paymentService;
    @MockitoBean
    private PaymentRepository paymentRepository;
    @MockitoBean
    private PaymentUtil paymentUtil;

    @Test
    void createPayment() throws Exception {
        // Arrange
        var paymentDto = PaymentDto.builder()
                .paymentStatus(PaymentStatus.NEW)
                .paymentType(PaymentType.ONLINE)
                .amount(2000)
                .customer("C1")
                .build();

        when(paymentService.addPayment(any())).thenReturn(Payment.builder()                .paymentStatus(PaymentStatus.NEW)
                .paymentType(PaymentType.ONLINE)
                .amount(2000)
                .customer("C1").build());

        // Act & Assert
        mockMvc.perform(post("/payment/new")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(paymentDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.amount").value(paymentDto.getAmount()))
                .andExpect(jsonPath("$.paymentStatus").value(paymentDto.getPaymentStatus().name()));
    }
}
