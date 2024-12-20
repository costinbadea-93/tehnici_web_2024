package org.example.spring_data_jpa;

import org.example.spring_data_jpa.model.BankAccountDetails;
import org.example.spring_data_jpa.repository.BankAccountDetailsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

    private final BankAccountDetailsRepository bankAccountDetailsRepository;

    public SpringDataJpaApplication(BankAccountDetailsRepository bankAccountDetailsRepository) {
        this.bankAccountDetailsRepository = bankAccountDetailsRepository;
    }

    public static void main(String[] args) {
        /**BankAccountDetails
         * BankAccount
         * BankAccountUser
         *
         * 1-M -> BankAccountUser -> BankAccount
         * 1-1 -> BankAccount -> BankAccountDetails
         */
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        BankAccountDetails bankAccountDetails = BankAccountDetails
//                .builder()
//                .accountNumber("Acc 1")
//                .balance(20000)
//                .currency("USD")
//                .build();

        BankAccountDetails bankAccountDetails = new BankAccountDetails();
        bankAccountDetails.setAccountNumber("Acc1");
        bankAccountDetails.setBalance(500);
        bankAccountDetails.setCurrency("USD");

        bankAccountDetailsRepository.save(bankAccountDetails);
    }
}
