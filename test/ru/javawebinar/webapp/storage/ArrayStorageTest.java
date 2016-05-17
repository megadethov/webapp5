package ru.javawebinar.webapp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import ru.javawebinar.webapp.model.Contact;
import ru.javawebinar.webapp.model.ContactType;
import ru.javawebinar.webapp.model.Resume;

/**
 * Created by mega on 16.05.2016.
 */
public class ArrayStorageTest {

    // start coding for testing
    private static Resume R1, R2, R3;
    private ArrayStorage storage = new ArrayStorage();

    // initial block, as usual static for testing
    static {
        R1 = new Resume("Полное Имя1", "Location1");
        R1.addContact(new Contact(ContactType.MAIL, "mega@ya.ru"));
        R1.addContact(new Contact(ContactType.PHONE, "12-23-57"));
        R2 = new Resume("Полное Имя2", null);
        R2.addContact(new Contact(ContactType.SKYPE, "skype2"));
        R2.addContact(new Contact(ContactType.PHONE, "11-123-234"));
        R3 = new Resume("Полное Имя3", null);
    }

    @BeforeClass
    public static void beforeClass() {
        // the same as static {}
    }

    @Before
    public void before() {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }


    // end coding for testing

    @org.junit.Test
    public void clear() throws Exception {

    }

    @org.junit.Test
    public void save() throws Exception {

    }

    @org.junit.Test
    public void update() throws Exception {

    }

    @org.junit.Test
    public void load() throws Exception {

    }

    @org.junit.Test
    public void delete() throws Exception {
        storage.delete(R1.getUuid());
        Assert.assertEquals(2, storage.size()); // after delete = 3-1 resume
        Assert.assertEquals(null, storage.load(R1.getUuid())); // inspection for R1 delete
    }

    @org.junit.Test
    public void getAllSorted() throws Exception {

    }

    @org.junit.Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size()); // compare storage size with 3
    }

}