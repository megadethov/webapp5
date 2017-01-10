package ua.javawebinar.webapp.storage;

import ua.javawebinar.webapp.WebAppException;
import ua.javawebinar.webapp.model.Resume;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

//import java.util.logging.Level;

public class ArrayStorage extends AbstractStorage<Integer> {

    private static final int LIMIT = 100;
    private Resume[] array = new Resume[LIMIT];
    private int size = 0;


    @Override
    public void doClear() {
        Arrays.fill(array, null);
        size = 0;
    }

    // поиск Резюме:
    // нет return -1
    // есть return его индекс
    @Override
    protected Integer getContext(String uuid) {
        for (int i = 0; i < LIMIT; i++) {
            if (array[i] != null) {
                if (array[i].getUuid().equals(uuid)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    protected boolean exist(Integer index) {
        return index != -1;
    }

    @Override
    protected void doSave(Integer index, Resume resume) {
        array[size++] = resume;
    }

    @Override
    protected void doUpdate(Integer index, Resume resume) {
        array[index] = resume;
    }

    @Override
    protected Resume doLoad(Integer index) {
        return array[index];
    }

    @Override
    protected void doDelete(Integer index) {
        if (index != size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index);
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
}
