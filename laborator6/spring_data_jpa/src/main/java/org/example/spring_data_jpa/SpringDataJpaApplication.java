package org.example.spring_data_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaApplication {

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

}
