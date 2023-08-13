package practicum.user;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

public class UserGenerator {
    User user;

    public User makeUser() {
        user = new User();
        String mail = "mail" + new Random().nextInt(999999) + "@test.com";
        String password = RandomStringUtils.randomAlphanumeric(6);
        user.setEmail(mail);
        user.setPassword(password);
        return user;
    }

}
