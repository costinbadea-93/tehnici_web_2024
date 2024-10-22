import service.MessagingService;
import utils.EmailNotificationMangerImpl;
import utils.NotificationManger;
import utils.SmsNotificationManagerImpl;

public class Main {
    public static void main(String[] args) {
        /**
         * IOC -> INVERSION OF CONTROL (DI -> DEPENDENCY INJECTION)
         * AOP -> ASPECT ORIENTED PROGRAMMING
         */

        /**
         * DI Example
         */
        var notificationManger1 = new EmailNotificationMangerImpl();
        var notificationManger2 = new SmsNotificationManagerImpl();

        var messagingService = new MessagingService(notificationManger2);
        messagingService.sendMessage();
    }
}
