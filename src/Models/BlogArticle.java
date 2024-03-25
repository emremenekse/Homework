package Models;

public class BlogArticle extends Nutrition {
    private String comments;

    public BlogArticle(int nutritionId, String title, String description,
            String comments) {
        super(nutritionId, title, description);
        this.comments = comments;
    }

}