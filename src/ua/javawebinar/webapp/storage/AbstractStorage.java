package ua.javawebinar.webapp.storage;

import ua.javawebinar.webapp.WebAppException;
import ua.javawebinar.webapp.model.Resume;

import java.util.logging.Logger;

public abstract class AbstractStorage implements IStorage {
    protected Logger logger = Logger.getLogger(this.getClass().getName()); // для базового класса с наследниками

    @Override
    public void save(Resume resume) {
        logger.info("Save resume with uuid: " + resume.getUuid());
        // Pattern Template method
        doSave(resume);
    }

    protected abstract void doSave(Resume resume);


}
