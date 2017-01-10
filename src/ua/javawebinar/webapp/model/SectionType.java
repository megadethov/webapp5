package ua.javawebinar.webapp.model;

import java.io.Serializable;

public enum SectionType implements Serializable {
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");

    static final long serialVersionUID = 1L;

    private String title;

    SectionType(String title) {
        this.title = title;
    }
}
