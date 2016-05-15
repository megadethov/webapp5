package ru.javawebinar.webapp.model;

/**
 * Created by mega on 14.05.2016.
 */
public class Contact {
    private ContactType type;
    private String value;

    public Contact(ContactType type, String value) {
        this.type = type;
        this.value = value;
    }

    public ContactType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
