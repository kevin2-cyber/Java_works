package io.java.music;

import java.util.ArrayList;

public class MusicOrganizer {

    private ArrayList<String> files;

    public MusicOrganizer() {
        files = new ArrayList<>();
    }

    public void addFile(String fileName) {
        files.add(fileName);
    }

    public int getNumberOfFiles() {
        return files.size();
    }

    public void listFile(int index) {
        if (index >= 0 && index < files.size()) {
            String fileName = files.get(index);
            System.out.println(fileName);
        }
    }

    public void removeFile(int index) {
        if (index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }
}
