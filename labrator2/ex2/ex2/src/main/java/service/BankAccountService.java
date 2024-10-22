package service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
//@Lazy
public class BankAccountService {

    public BankAccountService(){
        System.out.println("Creating bankAccout");
    }

    public void doTransfer() {
        System.out.println("Doing transfer");
    }
}
