package config;

import aspect.BankAccountAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"service"})
@EnableAspectJAutoProxy
public class ContextConfiguration {
    /**
     * Pointcut -> expresie de interceptare a comportamentului
     * JoinPoint -> interceptarea in urma pointcutului
     * Advice -> in ce imprejurimi vrem sa facem interceptarea
     *          -before advice
     *          -after advice
     *          -after returning
     *          -after throwing
     *          -around (cel mai puternic dintre advice uri)
     */

    @Bean
    public BankAccountAspect bankAccountAspect() {
        return new BankAccountAspect();
    }
}
