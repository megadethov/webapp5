package ua.javawebinar.webapp.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class OrganizationSection extends Section {
    static final long serialVersionUID = 1L;

private List<Organization> values = new LinkedList<>();

    public OrganizationSection() {
    }

    public OrganizationSection(Organization... values) {
        this.values = new LinkedList<>(Arrays.asList(values));
    }

    public OrganizationSection(List<Organization> values) {
        this.values = values;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return !(values != null ? !values.equals(that.values) : that.values != null);

    }

    @Override
    public int hashCode() {
        return values != null ? values.hashCode() : 0;
    }

    @Override
    public String toString() {
        return values.toString();
    }

    public List<Organization> getValues() {
        return values;
    }
}
