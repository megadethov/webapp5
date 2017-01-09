package ua.javawebinar.webapp.storage;

import ua.javawebinar.webapp.WebAppException;
import ua.javawebinar.webapp.model.ContactType;
import ua.javawebinar.webapp.model.Resume;
import ua.javawebinar.webapp.model.Section;
import ua.javawebinar.webapp.model.SectionType;

import java.io.*;
import java.util.List;
import java.util.Map;

public class DataStreamFileStorage extends FileStorage {

    public DataStreamFileStorage(String path) {
        super(path);
    }

    protected void write(File file, Resume resume) {
        try (
                FileOutputStream fos = new FileOutputStream(file);
                DataOutputStream dos = new DataOutputStream(fos);
        ) {

            dos.writeUTF(resume.getFullName());
            dos.writeUTF(resume.getLocation());
            dos.writeUTF(resume.getHomePage());
            Map<ContactType, String> contacts = resume.getContacts();
            dos.writeInt(contacts.size()); // кол-во контактов в Резюме
            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                dos.writeInt(entry.getKey().ordinal());
                dos.writeUTF(entry.getValue());
            }
            for (Map.Entry<SectionType, Section> entry : resume.getSections().entrySet()) {
                dos.writeInt(entry.getKey().ordinal());
                dos.writeUTF(entry.getValue().toString()); // TODO: 09.01.2017 check this
            }
        } catch (IOException e) {
            throw new WebAppException("Unable to write file " + file.getAbsolutePath(), resume, e);
        }
    }

    protected Resume read(File file) {
        Resume r = new Resume();
        try (FileInputStream is = new FileInputStream(file);
             DataInputStream dis = new DataInputStream(is);) {
            r.setFullName(dis.readUTF());
            r.setLocation(dis.readUTF());
            r.setHomePage(dis.readUTF());
            int contactSize = dis.readInt();
            for (int i = 0; i < contactSize; i++) {
                r.addContact(ContactType.values[dis.readInt()], dis.readUTF());
            }
// TODO: 09.01.2017 sections implementations
        } catch (IOException e) {
            throw new WebAppException("Unable to write file " + file.getAbsolutePath(), e);
        }
        return null;
    }
}
