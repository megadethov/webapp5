package ua.javawebinar.webapp.storage;

import ua.javawebinar.webapp.WebAppException;
import ua.javawebinar.webapp.model.Resume;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage implements IStorage {
    protected final Logger LOGGER = Logger.getLogger(this.getClass().getName()); // для базового класса с наследниками

    @Override
    public void clear() {
        LOGGER.info("Delete all resumes");
        doClear();
    }

    protected abstract void doClear();

    protected abstract boolean exist(String uuid);

    @Override
    public void save(Resume resume) {
        LOGGER.info("Save resume with uuid: " + resume.getUuid());
        if (exist(resume.getUuid())) {
            throw new WebAppException("Resume " + resume.getUuid() + "already exists", resume);
        }
        doSave(resume);
    }

    protected abstract void doSave(Resume resume);

    @Override
    public void update(Resume resume) {
        LOGGER.info("Update resume with uuid " + resume.getUuid());
        if (!exist(resume.getUuid())) {
            throw new WebAppException("Resume " + resume.getUuid() + "not exists", resume);
        }
        doUpdate(resume);
    }

    protected abstract void doUpdate(Resume resume);

    @Override
    public Resume load(String uuid) {
        LOGGER.info("Load resume with uuid " + uuid);
        if (!exist(uuid)) {
            throw new WebAppException("Resume " + uuid + " not exists");
        }
        return doLoad(uuid);
    }

    protected abstract Resume doLoad(String uuid);

    @Override
    public void delete(String uuid) {
        LOGGER.info("Delete resume with uuid " + uuid);
        if (!exist(uuid)) {
            throw new WebAppException("Resume " + uuid + "not exists");
        }
        doDelete(uuid);
    }

    protected abstract void doDelete(String uuid);

    @Override
    public Collection<Resume> getAllSorted() {
        LOGGER.info("getAllSorted");
        List<Resume> list = doGetAll();
        Collections.sort(list);
        return list;
    }

    protected abstract List<Resume> doGetAll();

    public abstract int size();
}
