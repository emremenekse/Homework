package DataAccessAbstractions;

import Models.Nutrition;

public interface INutritionDao {
    boolean createNutrition(Nutrition nutrition);

    Nutrition readNutrition(int nutritionId);

    boolean updateNutrition(Nutrition nutrition);

    boolean deleteNutrition(int nutritionId);
}
