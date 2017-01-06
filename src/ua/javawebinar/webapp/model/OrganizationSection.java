package ua.javawebinar.webapp.model;

import java.util.List;

public class OrganizationSection extends Section {
    List<Organization> values;

    public OrganizationSection(SectionType type, List<Organization> values) {
        super(type);
        this.values = values;
    }

    public List<Organization> getValues() {
        return values;
    }
}
