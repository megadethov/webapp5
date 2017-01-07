package ua.javawebinar.webapp.storage;

import ua.javawebinar.webapp.WebAppException;
import ua.javawebinar.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

//import java.util.logging.Level;

public class ArrayStorage extends AbstractStorage {

    private static final int LIMIT = 100;
    private Resume[] array = new Resume[LIMIT];
    private int size = 0;

    @Override
    public void doClear() {
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    protected boolean exist(String uuid) {
        return getIndex(uuid) != -1;
    }

    @Override
    public void doUpdate(Resume resume) {
        int idx = getIndex(resume.getUuid());
        array[idx] = resume;
    }

    @Override
    public Resume doLoad(String uuid) {
        int idx = getIndex(uuid);
        return array[idx];
    }

    @Override
    public void doSave(Resume resume) {
       // int idx = getIndex(resume.getUuid()); // ==-1 такого резюме в массиве нет
        array[size++] = resume;
    }

    @Override
    public void doDelete(String uuid) {
        int idx = getIndex(uuid);
        if (idx != size) {
            System.arraycopy(array, idx + 1, array, idx, size - idx);
        }
        array[--size] = null;
    }

    @Override
    public List<Resume> doGetAll() {
        return new ArrayList<>(Arrays.asList(Arrays.copyOf(array, size)));
    }

    @Override
    public int size() {
        return size;
    }

    // поиск Резюме:
    // нет return -1
    // есть return его индекс
    private int getIndex(String uuid) {
        for (int i = 0; i < LIMIT; i++) {
            if (array[i] != null) {
                if (array[i].getUuid().equals(uuid)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
