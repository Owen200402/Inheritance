package Inheritance;

public class VideoProcessor {
    private VideoEncoder encoder;
    private VideoDatabase database;
    private NotificationService notificationServiceService;

    public VideoProcessor(VideoEncoder encoder,
                          NotificationService notificationService,
                          VideoDatabase database) {
        this.encoder = encoder;
        this.notificationServiceService = notificationService;
        this.database = database;
    }

    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        notificationServiceService.sendEmail(video.getUser());
    }
}
