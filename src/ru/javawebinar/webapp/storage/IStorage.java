package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.WebAppException;
import ru.javawebinar.webapp.model.Resume;

import java.util.Collection;

/**
 * Created by mega on 16.05.2016.
 */
public interface IStorage {
    void clear(); // cleaning storage (for JUnit)
    void save(Resume r) throws WebAppException; // CRUD - create
    void update(Resume r); // CRUD - update
    Resume load(String uuid); // CRUD - read (from storage)
    void delete(String uuid); // CRUD - delete
    Collection<Resume> getAllSorted(); // get sorted list of Resume in the storage
    int size();

}
