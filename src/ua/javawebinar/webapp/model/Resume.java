package ua.javawebinar.webapp.model;

import java.util.*;

public class Resume /*implements Comparable<Resume>*/ {
    private String uuid;
    private String fullName;
    private String location;
    private String homePage;
    Map<ContactType, String> contacts = new EnumMap<>(ContactType.class); // Реализация Мапы, у к-ой ключи - Enum
    Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

    public static final Resume EMPTY;
    static {
        EMPTY = new Resume();
    }

    public Resume(String uuid, String fullName, String location) {
        this.uuid = uuid;
        this.fullName = fullName;
        this.location = location;
    }

    public Resume() {
    }

    public Resume(String fullName, String location) {
        this(UUID.randomUUID().toString(), fullName, location);
    }

    public void addSection(SectionType type, Section section) {
        sections.put(type, section);
    }

    public void addContacts(ContactType contactType, String value) {
        contacts.put(contactType, value);
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLocation() {
        return location;
    }

    public String getHomePage() {
        return homePage;
    }

    public String getContact(ContactType type) {
        return contacts.get(type);
    }

    public Section getSections(SectionType type) {
        return sections.get(type);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    //    @Override
    public int compareTo(Resume o) {
        return fullName.compareTo(o.fullName);
    }

    // реализация без Мапы
    /*private String getEmail(List<Contact> list) {
        for (Contact c : list) {
            if (c.getType() == ContactType.MAIL) {
                return c.getValue();
            }
        }
        return null;
    }*/

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Resume{");
        sb.append("uuid='").append(uuid).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
