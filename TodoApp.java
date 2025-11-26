import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp{

    private static ArrayList<String> todoList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            showMenu();
            System.out.print("\nChoose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    viewTasks();
                    break;
                case "2":
                    addTask();
                    break;
                case "3":
                    removeTask();
                    break;
                case "4":
                    clearTasks();
                    break;
                case "5":
                    System.out.println("\nExiting... Goodbye!");
                    return;
                default:
                    System.out.println("\nInvalid choice. Try again!");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n========== TO-DO MENU ==========");
        System.out.println("1. View tasks");
        System.out.println("2. Add task");
        System.out.println("3. Remove task");
        System.out.println("4. Clear all tasks");
        System.out.println("5. Exit");
    }

    private static void viewTasks() {
        if (todoList.isEmpty()) {
            System.out.println("\nNo tasks added yet.");
        } else {
            System.out.println("\nYour Tasks:");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
        }
    }

    private static void addTask() {
        System.out.print("\nEnter a new task: ");
        String task = scanner.nextLine();
        todoList.add(task);
        System.out.println("Task added successfully!");
    }

    private static void removeTask() {
        viewTasks();
        if (todoList.isEmpty()) return;

        System.out.print("\nEnter task number to remove: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < todoList.size()) {
                System.out.println("Removed: " + todoList.remove(index));
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Enter a valid number.");
        }
    }

    private static void clearTasks() {
        todoList.clear();
        System.out.println("\nAll tasks cleared!");
    }
}
