import config.ContextConfiguration;
import model.BankAccount;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BankAccountService;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        var bankAccount1 = new BankAccount("000150C5", "Alex", 40000);
        var bankAccount2 = new BankAccount("000250C5", "Ionut", 50000);

        var bankAccountService = context.getBean(BankAccountService.class);

        System.out.println("Bank Accounts before transfer: ");

        System.out.println(bankAccount1);
        System.out.println(bankAccount2);

        bankAccountService.makeTransfer(bankAccount1, bankAccount2, 3000);
//        bankAccountService.makeTransfer1(bankAccount1, bankAccount2, 3000);
//        bankAccountService.makeTransfer2(bankAccount1, bankAccount2, 3000);

        System.out.println("Bank Accounts after transfer: ");

        System.out.println(bankAccount1);
        System.out.println(bankAccount2);
    }
}
