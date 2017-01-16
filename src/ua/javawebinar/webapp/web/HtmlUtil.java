package ua.javawebinar.webapp.web;

import ua.javawebinar.webapp.model.ContactType;
import ua.javawebinar.webapp.model.Resume;

public class HtmlUtil {


    public static String getContact(Resume r, ContactType type) {
        String contact = r.getContact(type);
        return contact == null ? "&nbsp;" : type.toHtml(contact);
    }


}
