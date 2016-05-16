package lesson03;

import ru.javawebinar.webapp.model.Contact;
import ru.javawebinar.webapp.model.ContactType;
import ru.javawebinar.webapp.model.Link;

import java.lang.reflect.Field;

/**
 * Created by mega on 15.05.2016.
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Contact contact = new Contact(ContactType.PHONE, "044-123-45-67");
        ContactType contactType = ContactType.ICQ;
        System.out.println(ContactType.ICQ == contactType); // true

        // reflection
        Field f = Link.class.getDeclaredField("url");
        f.setAccessible(true); // разрешить отражать приват поля
        Link link = new Link("bla-bla", "URL12");
        System.out.println(f.get(link)); // URL12

    }
}
