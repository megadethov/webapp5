package ua.javawebinar.webapp.storage;

import ua.javawebinar.webapp.WebAppException;
import ua.javawebinar.webapp.model.Resume;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<T> implements IStorage {
    protected final Logger LOGGER = Logger.getLogger(this.getClass().getName()); // для базового класса с наследниками

    @Override
    public void clear() {
        LOGGER.info("Delete all resumes");
        doClear();
    }

    protected abstract void doClear();

    protected abstract T getContext(String uuid);

    protected abstract boolean exist(T context);

    @Override
    public void save(Resume resume) {
        LOGGER.info("Save resume with uuid: " + resume.getUuid());
        T context = getContext(resume.getUuid());
        if (exist(context)) {
            throw new WebAppException("Resume " + resume.getUuid() + "already exists", resume);
        }
        doSave(context, resume);
    }

    protected abstract void doSave(T context, Resume resume);

    @Override
    public void update(Resume resume) {
        LOGGER.info("Update resume with uuid " + resume.getUuid());
        T context = getContext(resume.getUuid());
        if (!exist(context)) {
            throw new WebAppException("Resume " + resume.getUuid() + "not exists", resume);
        }
        doUpdate(context, resume);
    }

    protected abstract void doUpdate(T context, Resume resume);

    @Override
    public Resume load(String uuid) {
        LOGGER.info("Load resume with uuid " + uuid);
        T context = getContext(uuid);
        if (!exist(context)) {
            throw new WebAppException("Resume " + uuid + " not exists");
        }
        return doLoad(context);
    }

    protected abstract Resume doLoad(T context);

    @Override
    public void delete(String uuid) {
        LOGGER.info("Delete resume with uuid " + uuid);
        T context = getContext(uuid);
        if (!exist(context)) {
            throw new WebAppException("Resume " + uuid + "not exists");
        }
        doDelete(context);
    }

    protected abstract void doDelete(T context);

    @Override
    public Collection<Resume> getAllSorted() {
        LOGGER.info("getAllSorted");
        List<Resume> list = doGetAll();

        Collections.sort(list, new Comparator<Resume>() {
            @Override
            public int compare(Resume o1, Resume o2) {
                int cmp = o1.getFullName().compareTo(o2.getFullName());
                if (cmp != 0) return cmp;
                return o1.getUuid().compareTo(o2.getFullName());
            }
        });

        /*Collections.sort(list, (o1, o2) -> {
            int cmp = o1.getFullName().compareTo(o2.getFullName());
            if (cmp != 0) return cmp;
            return o1.getUuid().compareTo(o2.getFullName());
        });*/

        return list;
    }

    protected abstract List<Resume> doGetAll();

    public abstract int size();
}
