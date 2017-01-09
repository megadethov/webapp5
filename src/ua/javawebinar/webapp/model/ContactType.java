package ua.javawebinar.webapp.model;

public enum  ContactType {
    PHONE("Тел."),
    MOBILE("Мобильный"),
    HOME_PHONE("Доиашний тел."),
    SKYPE("Skype"),
    MAIL("Почта"),
    ICQ("ICQ");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

   public static  ContactType[] values = ContactType.values();

}
