package lesson0.json;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Integer history;

    @SerializedName("geo")
    private List<String> geoHistory = new ArrayList<>();

    public Person(String name, Integer history, List<String> geoHistory) {
        this.name = name;
        this.history = history;
        this.geoHistory = geoHistory;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", history=").append(history);
        sb.append(", geoHistory=").append(geoHistory);
        sb.append('}');
        return sb.toString();
    }
}
