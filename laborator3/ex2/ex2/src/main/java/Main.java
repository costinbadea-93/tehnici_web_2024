import config.ContextConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.ServerConfigService;
import utils.UtilService;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        /**
         * beans scopes
         * singleton(sa nu l incurcati cu design patternul de singleton)
         *    - aceiasi instanta de bean ori de cate ori o cer
         * prototype
         *     - o sa imi dea o instanta noua din context
         *
         *     injectarea de bean prototype in singleton => singleton
         */

        UtilService u1 = context.getBean(UtilService.class);
        UtilService u2 = context.getBean(UtilService.class);

        System.out.println("Printing hash codes for beans: ");

        System.out.println("B1 " + u1.hashCode());
        System.out.println("B2 " + u2.hashCode());

        ServerConfigService s1 = context.getBean(ServerConfigService.class);
        ServerConfigService s2 = context.getBean(ServerConfigService.class);

        System.out.println("Printing hash codes for s1: "  + s1.getUtilService().hashCode());
        System.out.println("Printing hash codes for s2: "  + s2.getUtilService().hashCode());

        System.out.println("Printing value s1: "  + s1.getUtilService().getNumberOfAvailablePorts());
        System.out.println("Printing value s2: "  + s2.getUtilService().getNumberOfAvailablePorts());

    }
}
