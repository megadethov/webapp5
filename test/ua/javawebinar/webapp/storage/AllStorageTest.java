package ua.javawebinar.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ArrayStorageTest.class, MapStorageTest.class, DataStreamFileStorageTest.class, SerializeFileStorageTest.class})
public class AllStorageTest {
}
