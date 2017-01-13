package lesson0.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Main {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        Person person = new Person("Vasya", 30, Arrays.asList("One", "Two", "Three"));
        String js = GSON.toJson(person);
        System.out.println(js);

        Person person1 = GSON.fromJson(js, Person.class);
        System.out.println(person1);
    }
}
