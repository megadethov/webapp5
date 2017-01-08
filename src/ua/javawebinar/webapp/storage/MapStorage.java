package ua.javawebinar.webapp.storage;

import ua.javawebinar.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage<String> {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected void doClear() {
        map.clear();
    }

    @Override
    protected String getContext(String uuid) {
        return uuid;
    }

    @Override
    protected boolean exist(String key) {
        return map.containsKey(key);
    }

    @Override
    protected void doSave(String key, Resume resume) {
        map.put(key, resume);
    }

    @Override
    protected void doUpdate(String key, Resume resume) {
        map.put(key, resume);
    }

    @Override
    protected Resume doLoad(String key) {
        return map.get(key);
    }

    @Override
    protected void doDelete(String key) {
        map.remove(key);
    }

    @Override
    protected List<Resume> doGetAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}
