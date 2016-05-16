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

        System.out.println(link instanceof Link); // true (not recommend to use - polymorphism better)
        System.out.println(Link.class.isInstance(link)); // true analog instanceof

        String str = "Ja" + "va";
        String str2 = "Java";
        System.out.println(str == str2); // true (JVM use String constant internal pool)

        // BAD practice (a lot of new String object - on each loop)
        String fill = "";
        for (int i = 0; i < 10; i++) {
            fill += "A";
        }
        System.out.println(fill); // AAAAAAAAAA

        // GOOD practice use StringBuilder / StringBuffer ( one String object - on all loops)
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            sb.append('B');
        }
        System.out.println(sb.toString()); // BBBBBBBBBB
    }
}
