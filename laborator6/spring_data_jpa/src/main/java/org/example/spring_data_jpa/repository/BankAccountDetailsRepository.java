package org.example.spring_data_jpa.repository;

import org.example.spring_data_jpa.model.BankAccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountDetailsRepository extends JpaRepository<BankAccountDetails, Long> {

    /**
     * JPL -> JAVA PERSISTENCE LANGUAGE
     */

//    BankAccountDetails findBankAccountDetailsByAccountNumber(String bankAccountNumber);

//    @Query("select b from BankAccountDetails b where b.accountNumber = ?")
//    BankAccountDetails findByAccountNumber(String bankAccountNumber);

    @NativeQuery("select * from bank_account_details where account_number = ?")
    BankAccountDetails findByAccountNumber(String bankAccountNumber);
}
