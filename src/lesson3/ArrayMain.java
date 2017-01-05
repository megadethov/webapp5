package lesson3;

import ua.javawebinar.webapp.model.Link;
import ua.javawebinar.webapp.model.Resume;

public class ArrayMain {
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3};
        int[] arr = {1, 2, 3};
        System.out.println(arr.getClass());
        System.out.println(arr.length);

        Resume[] resumes = new Resume[10];
        System.out.println(resumes.getClass());
        System.out.println(resumes.length);

        Link link = new Link();
//        resumes[0] = link; // compile error
//        ((Object[])resumes)[0] = link; // runtime error - java.lang.ArrayStoreException
    }
}
