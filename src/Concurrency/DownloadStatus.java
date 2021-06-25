package Concurrency;

import java.util.concurrent.atomic.LongAdder;

public class DownloadStatus {
    private volatile boolean isDone;
    private LongAdder totalBytes = new LongAdder();
    private int totalFiles;

    public void incrementTotalBytes() {
        totalBytes.increment();
    }

    public void incrementTotalFiles() {
        totalFiles++;
    }

    public int getTotalBytes() {
        return totalBytes.intValue();
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