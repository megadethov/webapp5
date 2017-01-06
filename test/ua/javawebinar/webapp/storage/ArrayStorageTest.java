package ua.javawebinar.webapp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.javawebinar.webapp.model.Contact;
import ua.javawebinar.webapp.model.ContactType;
import ua.javawebinar.webapp.model.Resume;

import static org.junit.Assert.*;

public class ArrayStorageTest {
    private static Resume R1, R2, R3;

    private ArrayStorage storage = new ArrayStorage();

    static {
        R1 = new Resume("Full Name1", "location1");
        R1.addContacts(new Contact(ContactType.MAIL, "mail1@ya.ru"));
        R1.addContacts(new Contact(ContactType.PHONE, "11111"));
        R2 = new Resume("Full Name2", null);
        R2.addContacts(new Contact(ContactType.SKYPE, "skype2"));
        R2.addContacts(new Contact(ContactType.PHONE, "22222"));
        R3 = new Resume("Full Name3", null);

    }

    @BeforeClass
    public static void beforeClass() {
        // the same as static{}
    }

    @Before
    public void before() {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }

    @Test
    public void clear() throws Exception {

    }

    @Test
    public void save() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void load() throws Exception {

    }

    @Test
    public void delete() throws Exception {
        storage.delete(R1.getUuid());
        Assert.assertEquals(2, storage.size());
        Assert.assertEquals(null, storage.load(R1.getUuid()));

    }

    @Test
    public void getAllSorted() throws Exception {

    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());

    }

}