package ua.javawebinar.webapp.storage;

import ua.javawebinar.webapp.model.Resume;

import java.util.*;

public class MapStorage/* extends AbstractStorage*/ {

    private Map<String, Resume> map = new HashMap<>();

//    @Override
//    protected void doClear() {
//        map.clear();
//    }

//    @Override
//    protected boolean getContext(String uuid) {
////        return map.get(uuid) != null; the same
//        return map.containsKey(uuid);
//    }
//
//    @Override
//    protected void doSave(Resume resume) {
//        map.put(resume.getUuid(), resume);
//    }
//
//    @Override
//    protected void doUpdate(Resume resume) {
//        map.put(resume.getUuid(), resume);
//    }
//
//    @Override
//    protected Resume doLoad(String uuid) {
//        return map.get(uuid);
//    }
//
//    @Override
//    protected void doDelete(String uuid) {
//        map.remove(uuid);
//    }
//
//    @Override
//    protected List<Resume> doGetAll() {
//        return new ArrayList<>(map.values());
//    }
//
//    @Override
//    public int size() {
//        return map.size();
//    }
}
