package ua.javawebinar.webapp.model;

public class TextSection extends Section {
    private String title;
    private String comment;

    public TextSection(SectionType type, String title, String comment) {
        super(type);
        this.title = title;
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }
}


