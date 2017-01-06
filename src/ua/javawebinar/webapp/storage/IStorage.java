package ua.javawebinar.webapp.storage;

import com.sun.org.apache.regexp.internal.RE;
import ua.javawebinar.webapp.WebAppException;
import ua.javawebinar.webapp.model.Resume;

import java.util.Collection;

public interface IStorage {
    void clear();

    void save(Resume resume) throws WebAppException;

    void update(Resume resume);

    Resume load(String uuid);

    void delete(String uuid);

    Collection<Resume> getAllSorted();

    int size();
}
