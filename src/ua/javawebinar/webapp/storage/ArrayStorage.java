package ua.javawebinar.webapp.storage;

import ua.javawebinar.webapp.WebAppException;
import ua.javawebinar.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Logger;

//import java.util.logging.Level;

public class ArrayStorage implements IStorage {

    private static final int LIMIT = 100;
    private Resume[] array = new Resume[LIMIT];
    private int size = 0;

    //    protected Logger LOGGER = Logger.getLogger(this.getClass().getName()); // для базового класса с наследниками
    private static Logger LOGGER = Logger.getLogger(ArrayStorage.class.getName()); // для конкретного класса без наследования

    @Override
    public void clear() {
        LOGGER.info("Delete all resumes");
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public void save(Resume resume) /*throws WebAppException*/ {
        LOGGER.info("Save resume with uuid: " + resume.getUuid());
        int idx = getIndex(resume.getUuid()); // ==-1 такого резюме в массиве нет
        if (idx != -1) {
           /* try {
                throw new WebAppException("Resume " + resume.getUuid() + "already exists", resume);
            } catch (WebAppException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
                throw new IllegalStateException(e);
            }*/
            throw new WebAppException("Resume " + resume.getUuid() + "already exists", resume);
        }
        array[size++] = resume;
    }

    @Override
    public void update(Resume resume) {
        LOGGER.info("Update resume with uuid " + resume.getUuid());
        int idx = getIndex(resume.getUuid());
        if (idx == -1) {
            throw new WebAppException("Resume " + resume.getUuid() + "not exists", resume);
        }
        array[idx] = resume;
    }

    @Override
    public Resume load(String uuid) {
        LOGGER.info("Load resume with uuid " + uuid);
        int idx = getIndex(uuid);
        if (idx == -1) {
            throw new WebAppException("Resume " + uuid + " not exists");
        }
        return array[idx];
    }

    @Override
    public void delete(String uuid) {
        LOGGER.info("Delete resume with uuid " + uuid);
        int idx = getIndex(uuid);
        if (idx == -1) {
            throw new WebAppException("Resume " + uuid + "not exists");
        }
        if (idx != size) {
            System.arraycopy(array, idx + 1, array, idx, size - idx);
        }
        array[--size] = null;
    }

    @Override
    public Collection<Resume> getAllSorted() {
        Arrays.sort(array, 0, size);
        return Arrays.asList(Arrays.copyOf(array, size));
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
