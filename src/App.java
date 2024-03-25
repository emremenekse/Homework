import Models.Nutrition;
import java.util.Scanner;
import DataAccessLayer.NutritionDAO;

public class App {
    public static void main(String[] args) throws Exception {
        NutritionDAO dal = new NutritionDAO();
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Add Nutrition");
            System.out.println("2. Read Nutrition");
            System.out.println("3. Update Nutrition");
            System.out.println("4. Delete Nutrition");
            System.out.println("0. Exit");
            System.out.print("Enter an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    Nutrition newNutrition = getNutritionDetailsFromUser(scanner);
                    if (dal.createNutrition(newNutrition)) {
                        System.out.println("Nutrition added successfully.");
                    } else {
                        System.out.println("Nutrition could not be added.");
                    }
                    break;
                case 2:
                    System.out.print("Enter Nutrition ID to read: ");
                    int idToRead = scanner.nextInt();
                    Nutrition nutrition = dal.readNutrition(idToRead);
                    if (nutrition != null) {
                        System.out.println(nutrition);
                    } else {
                        System.out.println("Nutrition not found.");
                    }
                    break;
                case 3:
                    Nutrition updateNutrition = getNutritionDetailsFromUser(scanner);
                    if (dal.updateNutrition(updateNutrition)) {
                        System.out.println("Nutrition updated successfully.");
                    } else {
                        System.out.println("Nutrition could not be updated.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Nutrition ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    if (dal.deleteNutrition(idToDelete)) {
                        System.out.println("Nutrition deleted successfully.");
                    } else {
                        System.out.println("Nutrition could not be deleted.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 0);

        scanner.close();

    }

    private static Nutrition getNutritionDetailsFromUser(Scanner scanner) {
        System.out.print("Enter Nutrition ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        return new Nutrition(id, title, description);
    }
}
