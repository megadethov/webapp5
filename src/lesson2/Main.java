package lesson2;

import ua.javawebinar.webapp.model.Link;

public class Main {
    public static void main(String[] args) {
        Link link = new Link("JavaWebinar", "javawebinar.ru");
        Link link2 = link;
        System.out.println(link.equals(link2));
        Link link3 = new Link(link);
        System.out.println(link.getClass().getClass());
        System.out.println(link.equals(link3));

    }
}
