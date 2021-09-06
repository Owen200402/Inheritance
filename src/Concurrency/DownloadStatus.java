package Concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class DownloadStatus {
    private volatile boolean isDone;
    private AtomicInteger totalBytes = new AtomicInteger();
    private int totalFiles;

    public void incrementTotalBytes() {
        totalBytes.getAndIncrement();
    }

    public void incrementTotalFiles() {
        totalFiles++;
    }

    public int getTotalBytes() {
        return totalBytes.get();
    }

    public int getTotalFiles() {
        return totalFiles;
    }

    public boolean isDone() {
        return isDone;
    }

    public void done() {
        isDone = true;
    }
}