package Concurrency;

public class DownloadFileTask implements Runnable{
    private final DownloadStatus status;

    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());

        for (int i = 0; i < 1000_000; i++) {
            if (Thread.currentThread().isInterrupted())
                break;
            status.incrementTotalBytes();
        }

        status.done();

        synchronized (status) {
            status.notify();
        }

        System.out.println("Download Complete: " + Thread.currentThread().getName());
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
