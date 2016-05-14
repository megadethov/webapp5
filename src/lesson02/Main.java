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
    }
}
