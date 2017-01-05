package lesson2;

import ua.javawebinar.webapp.model.Link;

public class Main {
    public static void main(String[] args) {
//        Link link = new Link("JavaWebinar", "javawebinar.ru");
//        Link link2 = link;
//        System.out.println(link.equals(link2));
//        Link link3 = new Link(link);
//        System.out.println(link.getClass().getClass());
//        System.out.println(link.equals(link3));
//        System.out.println(Link.getEMPTY());

//        print(10); // not work
//        new Main().print(10); // work
//        System.out.println(new Integer(100).hashCode()); // 100

//        Integer obj = 5;
        Integer obj = null;

        print(obj); // NPE with unboxing - obj.intValue();
    }

    /*static void print(Object obj) {
        System.out.println("Object - " + obj);
    }*/

    static void print(int i) {
        System.out.println("int - " + i);
    }
}
