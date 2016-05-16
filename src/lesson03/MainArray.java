package lesson03;

import ru.javawebinar.webapp.model.Link;
import ru.javawebinar.webapp.model.Resume;

/**
 * Created by mega on 16.05.2016.
 */
public class MainArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};
        System.out.println(arr.length); // 3
        System.out.println(arr.getClass()); // class [I

        Resume[] resumes = new Resume[10];
        System.out.println(resumes.length); // 10
        System.out.println(resumes.getClass()); // class [Lru.javawebinar.webapp.model.Resume;

        Link l = new Link();
       // resumes[0] = l; // incompatible types
        ((Object[])resumes)[0] = l; // cast Resume to Object
        // but in runtime we get java.lang.ArrayStoreException
    }
}
