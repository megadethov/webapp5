package ua.javawebinar.webapp.storage;

import com.google.gson.GsonBuilder;
import ua.javawebinar.webapp.model.*;
import ua.javawebinar.webapp.utils.XmlParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonFileStorage extends FileStorage {
    private JsonParser jsonParser;

    public JsonFileStorage(String path) {
        super(path);
    }

    @Override
    protected void write(OutputStream os, Resume resume) throws IOException {
        try (Writer w = new OutputStreamWriter(os, StandardCharsets.UTF_8);) {
            JsonParser.write(resume, w);
        }
    }

    @Override
    protected Resume read(InputStream is) throws IOException {
        try (Reader r = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            return JsonParser.read(r, Resume.class);
        }
    }
}
