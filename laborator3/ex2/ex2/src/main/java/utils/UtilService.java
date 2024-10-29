package utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("prototype")
public class UtilService {
    public int getNumberOfAvailablePorts() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
