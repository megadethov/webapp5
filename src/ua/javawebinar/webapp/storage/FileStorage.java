package ua.javawebinar.webapp.storage;

import ua.javawebinar.webapp.WebAppException;
import ua.javawebinar.webapp.model.ContactType;
import ua.javawebinar.webapp.model.Resume;
import ua.javawebinar.webapp.model.Section;
import ua.javawebinar.webapp.model.SectionType;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class FileStorage extends AbstractStorage<File> {
    private File dir;

    public FileStorage(String path) {
        this.dir = new File(path);
        if (!dir.isDirectory() || !dir.canWrite())
            throw new IllegalArgumentException("'" + path + "' is not directory or is not writable");
    }

    @Override
    protected void doClear() {
        File[] files = dir.listFiles();
        if (files == null) return;
        for (File file : files) {
            doDelete(file);
        }
    }

    @Override
    protected File getContext(String fileName) {
        return new File(dir, fileName);
    }

    @Override
    protected boolean exist(File file) {
        return file.exists();
    }

    @Override
    protected void doSave(File file, Resume resume) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new WebAppException("Unable to create file " + file.getAbsolutePath(), resume, e);
        }
        write(file, resume);
    }

    protected void write(File file, Resume r) {
        try {
            write(new FileOutputStream(file), r);
        } catch (IOException e) {
            throw new WebAppException("Unable to write file " + file.getAbsolutePath(), r, e);
        }
    }

    protected Resume read(File file) {
        try {
            return read(new FileInputStream(file));
        } catch (IOException e) {
            throw new WebAppException("Unable to read file " + file.getAbsolutePath(), e);
        }
    }

    protected abstract void write(OutputStream os, Resume r) throws IOException;

    protected abstract Resume read(InputStream is) throws IOException;

    @Override
    protected void doUpdate(File file, Resume resume) {
        write(file, resume);
    }

    @Override
    protected Resume doLoad(File file) {
        return read(file);
    }

    @Override
    protected void doDelete(File file) {
        if (!file.delete()) throw new WebAppException("File " + file.getAbsolutePath() + " can't be deleted");
    }

    @Override
    protected List<Resume> doGetAll() {
        File[] files = dir.listFiles();
        if (files == null) return Collections.emptyList();
        List<Resume> list = new ArrayList<>(files.length);
        for (File file : files) {
            list.add(read(file));
        }
        return list;
    }

    @Override
    public int size() {
        return dir.listFiles().length;
    }
}
