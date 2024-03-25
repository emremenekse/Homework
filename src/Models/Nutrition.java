package Models;

public class Nutrition {
    private int nutritionId;
    private String title;
    private String description;

    public Nutrition(int nutritionId, String title, String description) {
        this.nutritionId = nutritionId;
        this.title = title;
        this.description = description;
    }

    public int getNutritionId() {
        return nutritionId;
    }

    public void setNutritionId(int nutritionId) {
        this.nutritionId = nutritionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Nutrition{" +
                "nutritionId=" + nutritionId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
