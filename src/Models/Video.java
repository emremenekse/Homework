package Models;

public class Video extends Nutrition {
    private String transcript;
    private String topic;
    private String source;

    public Video(int nutritionId, String title, String description,
            String transcript, String topic, String source) {
        super(nutritionId, title, description);
        this.transcript = transcript;
        this.topic = topic;
        this.source = source;
    }

}