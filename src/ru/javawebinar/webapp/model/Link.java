package ru.javawebinar.webapp.model;

/**
 * Created by mega on 14.05.2016.
 */
public class Link {

    public static Link EMPTY = new Link(); // пустой объект c конструктором по умолчанию

    private final String name;
    private final String url;

    // конструктор по умолчанию создает пустой объект (name = "", url = null)
    public Link() {
        this("", null);
    }

    // copy constructor
    public Link(Link link) {
        this(link.name, link.url);
    }

    public Link(String name, String url) {
        this.name = name;
        this.url = url;
    }
 // метод для доступа к статик полю EMPTY
    public static Link empty() {
        return EMPTY;
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

    @Override
    public String toString() {
        return "Link{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
