package ua.javawebinar.webapp.storage;

import ua.javawebinar.webapp.WebAppException;
import ua.javawebinar.webapp.model.ContactType;
import ua.javawebinar.webapp.model.Resume;
import ua.javawebinar.webapp.model.Section;
import ua.javawebinar.webapp.model.SectionType;

import java.io.*;
import java.util.Map;

public class SerializeFileStorage extends FileStorage {

    public SerializeFileStorage(String path) {
        super(path);
    }

    protected void write(File file, Resume resume) {
        try (
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(resume);
        } catch (IOException e) {
            throw new WebAppException("Unable to write file " + file.getAbsolutePath(), resume, e);
        }
    }

    protected Resume read(File file) {
        Resume resume = null;
        try (FileInputStream is = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(is);) {
          resume = (Resume) ois.readObject();
        } catch (IOException e) {
            throw new WebAppException("Unable to write file " + file.getAbsolutePath(), e);
        } catch (ClassNotFoundException e) {
            throw new WebAppException("Error read resume", e);
        }
        return resume;
    }
}
