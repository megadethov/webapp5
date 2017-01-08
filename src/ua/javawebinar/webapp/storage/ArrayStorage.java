package ua.javawebinar.webapp.storage;

import ua.javawebinar.webapp.WebAppException;
import ua.javawebinar.webapp.model.Resume;

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
    protected boolean exist(Integer context) {
        return context != -1;
    }

    @Override
    protected void doSave(Integer context, Resume resume) {
        array[size++] = resume;
    }

    @Override
    protected void doUpdate(Integer context, Resume resume) {
        array[context] = resume;
    }

    @Override
    protected Resume doLoad(Integer context) {
        return array[context];
    }

    @Override
    protected void doDelete(Integer context) {
        if (context != size - 1) {
            System.arraycopy(array, context + 1, array, context, size - context);
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
