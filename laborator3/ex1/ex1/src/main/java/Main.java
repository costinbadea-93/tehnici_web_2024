import config.ContextConfiguration;
import model.BankAccount;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BankAccountService;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        BankAccountService bankAccountService = context.getBean(BankAccountService.class);

        System.out.println("Bank account list:");
        System.out.println(bankAccountService.getBankAccounts());

        BankAccount bankAccount4 = BankAccount.builder()
                .accountNumber("00504C5")
                .accountOwner("Adrian")
                .balance(50000)
                .build();

        bankAccountService.createBankAccount(bankAccount4);

        System.out.println("Bank account list:");
        System.out.println(bankAccountService.getBankAccounts());

        bankAccountService.deleteBankAccountByAccountNumber("00504C5");

        System.out.println("Bank account list:");
        System.out.println(bankAccountService.getBankAccounts());

    }
}
