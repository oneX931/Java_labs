package org.example;

import java.io.IO;

public class OperationLog implements AutoCloseable {
    private final String title;
    private int count;

    public OperationLog(String title) {
        this.title = title;
        IO.println("[Журнал] Сеанс \"" + title + "\" открыт");
    }

    public void record(String text) {
        count++;
        IO.println("[Журнал] #" + count + ": " + text);
    }

    @Override
    public void close() {
        IO.println("[Журнал] Сеанс \"" + title + "\" закрыт, записей: " + count);
    }
}