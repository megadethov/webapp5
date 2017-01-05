package lesson3;

import ua.javawebinar.webapp.model.Contact;
import ua.javawebinar.webapp.model.ContactType;
import ua.javawebinar.webapp.model.Link;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Contact contact = new Contact(ContactType.PHONE, "555-55-55");
        ContactType contact2 = ContactType.ICQ;
        System.out.println(ContactType.ICQ == contact2);

        Link l = new Link("NAME", "URL");

        // all declared fields
       /* for (Field field : l.getClass().getDeclaredFields()) {
            field.setAccessible(true); // else - java.lang.IllegalAccessException
            Object value = field.get(l);
            if (value != null) System.out.println(field.getName() + " = " + value);
        }*/

        // url field
//        Field field = l.getClass().getDeclaredField("url");
        Field field = Link.class.getDeclaredField("url");
        field.setAccessible(true);
        System.out.println(field.get(l));
    }

}
