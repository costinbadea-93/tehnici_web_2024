package org.example.exexam.repository;

import jakarta.transaction.Transactional;
import org.example.exexam.model.Payment;
import org.example.exexam.utils.PaymentStatus;
import org.example.exexam.utils.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer>, JpaSpecificationExecutor<Payment> {

    @Modifying
    @Query("update Payment ps set ps.paymentStatus = :paymentStatus where ps.customer = :customer")
    @Transactional
    void cancelPayment(@Param("paymentStatus") PaymentStatus paymentStatus, @Param("customer") String customer);

    List<Payment> findAllByPaymentStatusOrPaymentType(PaymentStatus paymentStatus, PaymentType paymentType);

}
