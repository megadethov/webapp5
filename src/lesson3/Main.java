package lesson3;

import ua.javawebinar.webapp.model.Contact;
import ua.javawebinar.webapp.model.ContactType;

public class Main {
    public static void main(String[] args) {
        Contact contact = new Contact(ContactType.PHONE, "555-55-55");
        ContactType contact2 = ContactType.ICQ;
        System.out.println(ContactType.ICQ == contact2);
    }

}
