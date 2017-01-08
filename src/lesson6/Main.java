package lesson6;

import ua.javawebinar.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf(100) == Integer.valueOf(100)); // true
        System.out.println(Integer.valueOf(1000) == Integer.valueOf(1000)); // false
        System.out.println(Integer.valueOf(1000).equals(Integer.valueOf(1000))); // true

        List<String> es = Collections.emptyList(); // преобразует к нужному типу
        List<String> er = Collections.emptyList();

        // анонимный ArrayList / добавление в блоке инициализации
        new ArrayList<Resume>() {{
            add(new Resume());
            System.out.println(getClass());
        }};
    }
}
