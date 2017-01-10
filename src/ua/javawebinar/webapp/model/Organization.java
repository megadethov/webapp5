package ua.javawebinar.webapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Organization implements Serializable {
    static final long serialVersionUID = 1L;

    private Link link;
    private List<Period> periods;

    public static class Period { // static - nested, no static - inner
        private Date startDates;
        private Date sendDates;
        private String position;
        private String content;

        public Period() {
        }

        public Period(Date startDates, Date sendDates, String position, String content) {
            this.startDates = startDates;
            this.sendDates = sendDates;
            this.position = position;
            this.content = content;
//            link.getName(); // из статика нет доступа к полям внешнего класса
        }
    }
}
