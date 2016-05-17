package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.WebAppException;
import ru.javawebinar.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;
//import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mega on 16.05.2016.
 */
public class ArrayStorage implements IStorage {

    private static final int LIMIT = 100;
    private Resume[] arr = new Resume[LIMIT];
    private int size = 0; // array size
    // protected Logger LOGGER = Logger.getLogger(getClass().getName()); // the name of class will be
    // displayed when logging
    private static Logger LOGGER = Logger.getLogger(ArrayStorage.class.getName()); // the same

    @Override
    public void clear() {
        /*for (int i = 0; i < LIMIT; i++) {
            arr[i] = null;
        }*/
        LOGGER.info("Delete all resumes");
        Arrays.fill(arr, null); // fill all cell - null
        size = 0; // array size
    }

    @Override
    public void save(Resume r) {
        LOGGER.info("Save resume with uuid = " + r.getUuid());
        int idx = getIndex(r.getUuid());

        if (idx != -1) {
           /* try {
                throw new WebAppException("Resume " + r.getUuid() + " already exists", r);
            } catch (WebAppException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
                throw new IllegalStateException(e); // unchecked, not require try-catch or throws
            }*/
            throw new WebAppException("Resume " + r.getUuid() + " already exists", r);
            arr[size++] = r; //  enter resume to array and ++ size of array
        }

    }

    @Override
    public void update(Resume r) {
        LOGGER.info("Update resume with " + r.getUuid());
        int idx = getIndex(r.getUuid());
        if (idx == -1) {
            throw new WebAppException("Resume " + r.getUuid() + " not exist", r);
        }
        arr[idx] = r;
    }

    @Override
    public Resume load(String uuid) {
        LOGGER.info("Load resume with uuid " + uuid);
        int idx = getIndex(uuid);
        if (idx == -1) {
            throw new WebAppException("Resume " + uuid + " not exist");
        }
        return arr[idx];
    }

    @Override
    public void delete(String uuid) {
        LOGGER.info("Delete resume with uuid = " + uuid);
        int idx = getIndex(uuid);
        if (idx == -1) {
            throw new WebAppException("Resume " + uuid + " not exist");
        }
        int numMoved = size - idx - 1;
        if (numMoved > 0) {
            System.arraycopy(arr, idx + 1, arr, idx, numMoved);
            arr[--size] = null; // clear to let GC do its work
        }

    }

    @Override
    public Collection<Resume> getAllSorted() {
        Arrays.sort(arr, 0, size);
        return Arrays.asList(Arrays.copyOf(arr, size));
    }

    @Override
    public int size() {
        return 0;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < LIMIT; i++) {
            if (arr[i] != null) {
                if (arr[i].getUuid().equals(uuid)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
