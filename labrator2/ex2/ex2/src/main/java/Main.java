import config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BankAccountService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);

        System.out.println("Executing main method");

        var bankAccService = context.getBean(BankAccountService.class);
        bankAccService.doTransfer();
    }
}
