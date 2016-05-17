package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.util.Collection;

/**
 * Created by mega on 16.05.2016.
 */
public class ArrayStorage implements IStorage {

    private static final int LIMIT = 100;
    private Resume[] arr = new Resume[LIMIT];

    @Override
    public void clear() {
        for (int i = 0; i < LIMIT; i++) {
            arr[i] = null;
        }
    }

    @Override
    public void save(Resume r) {
        for (int i = 0; i < LIMIT; i++) {
            if (arr[i] == null) {
                arr[i] = r;
                break;
            } else {
                if (arr[i].equals(r)) {
                    throw new IllegalStateException("Already exists");
                }

            }
        }
    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public Resume load(String uuid) {
        return null;
    }

    @Override
    public void delete(String uuid) {
        for (int i = 0; i < LIMIT; i++) {
            if (arr[i].getUuid() == uuid) {
                arr[i] = null;
            } else {
                throw new IllegalStateException("Nothing to delete");
            }
        }

    }

    @Override
    public Collection<Resume> getAllSorted() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
