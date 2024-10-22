import contextcfg.ContextConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.DatabaseConnectionService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        var databaseConnectionService = context.getBean(DatabaseConnectionService.class);

        databaseConnectionService.connect();
    }
}
