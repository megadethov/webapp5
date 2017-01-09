package lesson5;

import ua.javawebinar.webapp.model.ContactType;
import ua.javawebinar.webapp.model.Resume;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Comparator<Resume>() {
            @Override
            public int compare(Resume o1, Resume o2) {
                System.out.println(this.getClass().getName());
                return 0;
            }
        });

        Resume R1 = new Resume("Full Name1", "location1");
        R1.addContact(ContactType.MAIL, "mail1@ya.ru");
        R1.addContact(ContactType.PHONE, "11111");
        Resume R2 = new Resume("Full Name2", null);
        R2.addContact(ContactType.SKYPE, "skype2");
        R2.addContact(ContactType.PHONE, "22222");
        Resume R3 = new Resume("Full Name3", null);

        List<Resume> resumes = new ArrayList<>(Arrays.asList(R1, R2, R3));
        print(resumes);
    }

    private static <T> void print(List<T> list) {
        list.forEach((r) -> System.out.println(r.getClass().getSimpleName()));
    }
}
