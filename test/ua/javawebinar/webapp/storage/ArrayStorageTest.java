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
    {
        storage = new ArrayStorage();
    }
}