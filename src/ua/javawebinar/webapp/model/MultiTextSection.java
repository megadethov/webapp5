package ua.javawebinar.webapp.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MultiTextSection extends Section {
    static final long serialVersionUID = 1L;

    private List<String> values = new LinkedList<>();

    public MultiTextSection(String... values) {
        this(new LinkedList<>(Arrays.asList(values)));
    }

    public MultiTextSection(List<String> values) {
        this.values = values;
    }

    public List<String> getValues() {
        return values;
    }

    public MultiTextSection() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MultiTextSection that = (MultiTextSection) o;

        if (values != null ? !values.equals(that.values) : that.values != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return values != null ? values.hashCode() : 0;
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
