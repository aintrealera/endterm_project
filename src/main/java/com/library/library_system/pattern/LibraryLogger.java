package com.library.library_system.pattern;

public class LibraryLogger {
    private static LibraryLogger instance;

    private LibraryLogger() {}

    public static synchronized LibraryLogger getInstance() {
        if (instance == null) {
            instance = new LibraryLogger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LIBRARY SYSTEM]: " + message);
    }
}

