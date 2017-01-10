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
    private static final String NULL = "null";

    public DataStreamFileStorage(String path) {
        super(path);
    }

    protected void write(File file, Resume resume) {
        try (
                FileOutputStream fos = new FileOutputStream(file);
                DataOutputStream dos = new DataOutputStream(fos);
        ) {

            writeString(dos, resume.getFullName());
            writeString(dos, resume.getLocation());
            writeString(dos, resume.getHomePage());
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
        Resume r = new Resume(file.getName()); // Uuid = имя файла
        try (FileInputStream is = new FileInputStream(file);
             DataInputStream dis = new DataInputStream(is);) {
            r.setFullName(readString(dis));
            r.setLocation(readString(dis));
            r.setHomePage(readString(dis));
            int contactSize = dis.readInt();
            for (int i = 0; i < contactSize; i++) {
                r.addContact(ContactType.values[dis.readInt()], readString(dis));
            }
// TODO: 09.01.2017 sections implementations
        } catch (IOException e) {
            throw new WebAppException("Unable to write file " + file.getAbsolutePath(), e);
        }

        return r;
    }

    private void writeString(DataOutputStream dos, String str) throws IOException {
        dos.writeUTF(str == null ? NULL : str);
    }

    private String readString(DataInputStream dis) throws IOException {
        String str = dis.readUTF();
        return str.equals(NULL) ? null : str;
    }
}
