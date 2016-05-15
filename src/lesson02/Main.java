package lesson02;

import ru.javawebinar.webapp.model.Link;

/**
 * Created by mega on 14.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Link l = new Link("javaWebinar", "javawebinar.ru");
        Link l2 = l;
        Link l3 = new Link(l); // copy constructor
        System.out.println(l.equals(l2));  // true
        System.out.println(l.equals(l3));  // false    // after overriding - true
        System.out.println(l.getClass()); // метод класса Object, к-ый возвращает имя класса из к-го произв. инстанс
        System.out.println(l); // ru.javawebinar.webapp.model.Link@5c9a6101 - без переопред. toString
        System.out.println(l); // Link{name='javaWebinar', url='javawebinar.ru'} - после переопред. toString
        System.out.println(l.toString()); // Link{name='javaWebinar', url='javawebinar.ru'} - после переопред. toString
    }
}
