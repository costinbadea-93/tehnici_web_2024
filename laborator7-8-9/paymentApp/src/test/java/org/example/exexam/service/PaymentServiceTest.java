package org.example.exexam.service;

import org.example.exexam.dto.PaymentDto;
import org.example.exexam.repository.PaymentRepository;
import org.example.exexam.utils.PaymentStatus;
import org.example.exexam.utils.PaymentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.example.exexam.utils.PaymentUtil.fromDtoToPayment;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class PaymentServiceTest {

    @BeforeEach
        //this method is invoked before the execution of every test
    void setUp() {
        //common code, useful for every test in this class
    }

    @BeforeAll //this method executes only once, before all tests (when the test class is prepared to be run)
    static void beforeAll() {
        //connection to a db for an integration test
        //preparing a file
        //setting of application properties
    }

    @AfterEach
        //this method is invoked after the execution of every test
    void tearDown() {

    }

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

//    @Test
//    public void add10PaymentsTest() {
//        var payment = Payment
//                .builder()
//                .amount(2000)
//                .customer("Customer8")
//                .paymentType(PaymentType.ONLINE)
//                .paymentStatus(PaymentStatus.NEW)
//                .build();
//
//        when(paymentRepository.save(payment)).thenReturn(payment);
//
//        assertThrows(
//                RuntimeException.class,
//                () -> paymentService.add10Payments(),
//                "Something went wrong"
//        );
//    }


    @Test
    void testAddPaymentWithSuccess(){
        var paymentDto = PaymentDto
                .builder()
                .amount(2000)
                .customer("Customer8")
                .paymentType(PaymentType.POS)
                .paymentStatus(PaymentStatus.PROCESSED)
                .build();

        var payment = fromDtoToPayment(paymentDto);

        when(paymentRepository.save(payment)).thenReturn(payment);

        var result = paymentService.addPayment(paymentDto);

        assertEquals(paymentDto.getCustomer(), result.getCustomer());
        assertEquals(paymentDto.getAmount(), result.getAmount());
        verify(paymentRepository).save(payment);
    }

    @Test
    void testCancelPaymentWithSuccess(){
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
        verify(paymentRepository).save(payment);
    }


    @Test
    void testCancelPaymentWithPaymentNotFound(){
        var paymentId = 1;
        var paymentDto = PaymentDto
                .builder()
                .amount(2000)
                .customer("Customer8")
                .paymentType(PaymentType.POS)
                .paymentStatus(PaymentStatus.PROCESSED)
                .build();

        var payment = fromDtoToPayment(paymentDto);


        when(paymentRepository.findById(paymentId)).thenReturn(Optional.empty());
        when(paymentRepository.save(payment)).thenReturn(payment);

        assertThrows(
                RuntimeException.class,
                () -> paymentService.cancelPayment(paymentId),
                "The payment does not exist"
        );
    }


    @Test
    void testCancelPaymentWithPaymentAlreadyCancelled(){
        var paymentId = 1;
        var paymentDto = PaymentDto
                .builder()
                .amount(2000)
                .customer("Customer8")
                .paymentType(PaymentType.POS)
                .paymentStatus(PaymentStatus.CANCELLED)
                .build();

        var payment = fromDtoToPayment(paymentDto);


        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(payment));
        when(paymentRepository.save(payment)).thenReturn(payment);

        assertThrows(
                RuntimeException.class,
                () -> paymentService.cancelPayment(paymentId),
                "Payment is already cancelled"
        );
    }
}
