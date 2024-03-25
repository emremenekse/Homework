package Models;

public class MedicalInfo extends Nutrition {
    private String text;
    private String type;

    public MedicalInfo(int nutritionId, String title, String description,
            String text, String type) {
        super(nutritionId, title, description);
        this.text = text;
        this.type = type;
    }
}