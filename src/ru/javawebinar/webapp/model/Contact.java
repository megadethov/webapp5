package ru.javawebinar.webapp.model;

/**
 * Created by mega on 14.05.2016.
 */
public class Contact {
    private String type;
    private String value;

    public Contact(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
