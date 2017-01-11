package ua.javawebinar.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Organization implements Serializable {
    static final long serialVersionUID = 1L;

    private Link link;
    private List<Period> periods;

    public Organization() {
    }

    public Organization(Link link, List<Period> periods) {
        this.link = link;
        this.periods = periods;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Period implements Serializable { // static - nested, no static - inner
        static final long serialVersionUID = 1L;
        public static final LocalDate NOW = LocalDate.of(3000, 1, 1);
        private LocalDate startDates;
        private LocalDate sendDates;
        private String position;
        private String content;

        public Period() {
        }

        public Period(int startYear, Month startMonth, int endYear, Month endMonth, String position, String content) {
            this(LocalDate.of(startYear, startMonth, 1), LocalDate.of(endYear, endMonth, 1), position, content);
        }

        public Period(LocalDate startDates, LocalDate sendDates, String position, String content) {
            this.startDates = startDates;
            this.sendDates = sendDates;
            this.position = position;
            this.content = content;
//            link.getName(); // из статика нет доступа к полям внешнего класса
        }
    }
}
