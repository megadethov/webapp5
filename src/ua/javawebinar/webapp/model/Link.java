package ua.javawebinar.webapp.model;

import java.io.Serializable;

public class Link implements Serializable {
    static final long serialVersionUID = 1L;

    public static Link EMPTY = new Link();

    private final String name;
    private final String url;

    public Link(String name, String url) {
        this.name = name;
        this.url = url;
    }

    // Конструктор копирования (пердпочтительнее, чем clone())
    public Link (Link link) {
        this.name = link.name;
        this.url = link.url;
    }

    public Link() {
        this("", null);
    }

    public static Link getEMPTY() {
        return EMPTY;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (!name.equals(link.name)) return false;
        return url != null ? url.equals(link.url) : link.url == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
