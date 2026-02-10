package assignments.singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private String fileName;
    private BufferedWriter writer;

    private Logger() {
        this.fileName = "app.log";
        openWriter();
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public synchronized void setFileName(String fileName) {
        close();
        this.fileName = fileName;
        openWriter();
    }

    public synchronized void write(String message) {
        if (writer == null) {
            return;
        }
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.println("Failed to write log message: " + e.getMessage());
        }
    }

    public synchronized void close() {
        if (writer == null) {
            return;
        }
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to close logger: " + e.getMessage());
        } finally {
            writer = null;
        }
    }

    private void openWriter() {
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            writer = null;
            System.out.println("Failed to open log file: " + e.getMessage());
        }
    }
}
