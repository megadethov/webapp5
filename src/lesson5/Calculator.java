package lesson5;

import ua.javawebinar.webapp.model.Resume;

import java.util.Comparator;

public class Calculator {
    public int abs(int value) {
        return Math.abs(value);
    }

    public static void main(String[] args) {
        System.out.println(new Comparator<Resume>() {
            @Override
            public int compare(Resume o1, Resume o2) {
                System.out.println(this.getClass().getName());
                return 0;
            }
        });
    }
}
