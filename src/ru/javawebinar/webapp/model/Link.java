package ru.javawebinar.webapp.model;

/**
 * Created by mega on 14.05.2016.
 */
public class Link {
    private final String name;
    private final String url;

    public Link(String name, String url) {
        this.name = name;
        this.url = url;
    }

    // copy constructor
    public Link(Link link) {
        this.name = link.name;
        this.url = link.url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        return name != null ? name.equals(link.name) : link.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
