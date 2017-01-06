package ua.javawebinar.webapp.model;

import java.util.List;

public class MultiTextSection extends Section {
    private List<String> values;

    public MultiTextSection(SectionType type, List<String> values) {
        super(type);
        this.values = values;
    }

    public List<String> getValues() {
        return values;
    }
}
