package lesson4;

import ua.javawebinar.webapp.model.Organization;
import ua.javawebinar.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        new Organization.Period();
        Map<String, Resume> map = new HashMap<>();
        map.put("uuid", new Resume("uuid", "", ""));

        // bad practice
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key)); // на каждой итерации ходим в мапу по цепочке LList
        }

        // good practice - Map.Entry
        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

}
