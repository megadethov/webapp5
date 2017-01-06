package ua.javawebinar.webapp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.javawebinar.webapp.WebAppException;
import ua.javawebinar.webapp.model.Contact;
import ua.javawebinar.webapp.model.ContactType;
import ua.javawebinar.webapp.model.Resume;

import static org.junit.Assert.*;

public class ArrayStorageTest extends AbstractStorageTest {
    private /*static*/ Resume R1, R2, R3;

    private ArrayStorage storage = new ArrayStorage();

    static {
       /* R1 = new Resume("Full Name1", "location1");
        R1.addContacts(new Contact(ContactType.MAIL, "mail1@ya.ru"));
        R1.addContacts(new Contact(ContactType.PHONE, "11111"));
        R2 = new Resume("Full Name2", null);
        R2.addContacts(new Contact(ContactType.SKYPE, "skype2"));
        R2.addContacts(new Contact(ContactType.PHONE, "22222"));
        R3 = new Resume("Full Name3", null);*/

    }

    @BeforeClass // the same as static{}
    public static void beforeClass() {
       /* R1 = new Resume("Full Name1", "location1");
        R1.addContacts(new Contact(ContactType.MAIL, "mail1@ya.ru"));
        R1.addContacts(new Contact(ContactType.PHONE, "11111"));
        R2 = new Resume("Full Name2", null);
        R2.addContacts(new Contact(ContactType.SKYPE, "skype2"));
        R2.addContacts(new Contact(ContactType.PHONE, "22222"));
        R3 = new Resume("Full Name3", null);*/
    }

    @Before
    public void before() {
        R1 = new Resume("Full Name1", "location1");
        R1.addContacts(new Contact(ContactType.MAIL, "mail1@ya.ru"));
        R1.addContacts(new Contact(ContactType.PHONE, "11111"));
        R2 = new Resume("Full Name2", null);
        R2.addContacts(new Contact(ContactType.SKYPE, "skype2"));
        R2.addContacts(new Contact(ContactType.PHONE, "22222"));
        R3 = new Resume("Full Name3", null);
        storage.clear();
        storage.save(R3);
        storage.save(R1);
        storage.save(R2);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void save() throws Exception {
        Resume R4 = new Resume("Full Name4", "location4");
        R4.addContacts(new Contact(ContactType.MAIL, "mail4@ya.ru"));
        R4.addContacts(new Contact(ContactType.PHONE, "44444"));
        storage.save(R4);
        assertEquals(4, storage.size());
    }

    @Test (expected = WebAppException.class)
    public void saveExists() throws Exception {
        storage.save(R3);
    }

    @Test
    public void update() throws Exception {
        R2.setFullName("Update #2");
        storage.update(R2);
        assertEquals(R2, storage.load(R2.getUuid()));
    }

    @Test
    public void load() throws Exception {
        assertEquals(true, R1.equals(storage.load(R1.getUuid())));
        assertEquals(true, R2.equals(storage.load(R2.getUuid())));
        assertEquals(true, R3.equals(storage.load(R3.getUuid())));
    }

    @Test(expected = WebAppException.class)
    public void deleteNonFound() throws Exception {
        storage.load("dummy");
    }

    @Test
    public void delete() throws Exception {
        storage.delete(R1.getUuid());
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void getAllSorted() throws Exception {
        Resume[] src = new Resume[]{R1, R2, R3};
        assertArrayEquals(src, storage.getAllSorted().toArray()); // Здесь сравнивается содержимое массивов
//        assertTrue(src.equals(storage.getAllSorted().toArray())); // false, проверка на совпадение расположения в памяти
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());

    }

}