package ua.javawebinar.webapp.storage;

import ua.javawebinar.webapp.model.Resume;

import java.util.Collection;

// TODO: 06.01.2017 Implements MapStorage
public class MapStorage extends AbstractStorage {
    @Override
    public void clear() {

    }

    @Override
    public void update(Resume resume) {

    }

    @Override
    public Resume load(String uuid) {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Collection<Resume> getAllSorted() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    protected void doSave(Resume resume) {

    }
}
