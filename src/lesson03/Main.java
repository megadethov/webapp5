package lesson03;

import ru.javawebinar.webapp.model.Contact;
import ru.javawebinar.webapp.model.ContactType;

/**
 * Created by mega on 15.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Contact contact = new Contact(ContactType.PHONE, "044-123-45-67");
    }
}
