package ua.javawebinar.webapp.storage;

public class JsonFileStorageTest extends AbstractStorageTest {
    {
        storage = new JsonFileStorage("./file_storage");
    }
}
