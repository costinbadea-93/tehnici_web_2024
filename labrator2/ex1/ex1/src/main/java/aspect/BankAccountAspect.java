package aspect;

import model.BankAccount;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;
import java.util.Objects;

@Aspect
public class BankAccountAspect {

    @Pointcut("execution(* service.BankAccountService.*(..))")
    private void bankAccountPointCut() {}


    @Before("bankAccountPointCut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        var methodName = joinPoint.getSignature().getName();
        var methodArgs = joinPoint.getArgs();

        System.out.println("Calling " + methodName + " before with " + Arrays.toString(methodArgs) + " arguments");
    }


    @After("bankAccountPointCut()")
    public void afterAdvice(JoinPoint joinPoint) {
        var methodName = joinPoint.getSignature().getName();
        var methodArgs = joinPoint.getArgs();

        System.out.println("Calling " + methodName + " after with " + Arrays.toString(methodArgs) + " arguments");
    }

    @AfterReturning(value = "bankAccountPointCut()", returning = "value")
    public void afterReturningAdvice(JoinPoint joinPoint, Object value) {
        var methodName = joinPoint.getSignature().getName();
        var methodArgs = joinPoint.getArgs();

        System.out.println("Calling " + methodName + " after returning value " + value);
    }

    @AfterThrowing(value = "bankAccountPointCut()", throwing = "value")
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable value) {
        var methodName = joinPoint.getSignature().getName();
        var methodArgs = joinPoint.getArgs();

        System.out.println("Error during method execution " + methodName + " " + value);
    }

    @Around("bankAccountPointCut()")
    public Object afterThrowingAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        var methodName = proceedingJoinPoint.getSignature().getName();
        var methodArgs = proceedingJoinPoint.getArgs();

        var bankAccount1 = new BankAccount("000000", "Bogdan", 40000);
        var bankAccount2 = new BankAccount("000001", "Adrian", 50000);

        try{
            System.out.println("Executing arround advice");
            return proceedingJoinPoint.proceed(new Object[]{bankAccount1, bankAccount2, 1000});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
