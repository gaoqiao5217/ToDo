import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean b = true;
        List<String> todo = new ArrayList<>();
        while (b) {
            showInfo();
            System.out.print("Ваш выбор: ");
            String input = s.nextLine();
            System.out.println();
            switch (input) {
                case "0":
                    b = false;
                    break;
                case "1":
                    System.out.print("Введите название задачи: ");
                    String point = s.nextLine();
                    todo.add(point);
                    System.out.println("Добавлено!");
                    showBusiness(todo);
                    break;
                case "2":
                    showBusiness(todo);
                    break;
                case "3":
                    if (!todo.isEmpty()) {
                        System.out.print("Введите номер для удаления: ");
                        String delete = s.nextLine();
                        if (!delete.matches("\\d+")) {
                            System.out.println("Вы ввели недопустимое значение");
                            break;
                        }
                        int index = Integer.parseInt(delete) - 1;
                        if (index >= todo.size()) {
                            System.out.println("Такого дела в вашем списке нет");
                        } else {
                            todo.remove(index);
                            System.out.println("Удалено!");
                        }
                    } else {
                        System.out.println("В вашем списке пока нет дел");
                    }
                    if (!todo.isEmpty()) {
                        showBusiness(todo);
                    }
                    break;
                case "4":
                    System.out.print("Введите задачу для удаления: ");
                    String delete = s.nextLine();
                    if (todo.remove(delete)) {
                        System.out.println("Удалено!");
                    } else {
                        System.out.println("Такого дела в вашем списке нет");
                    }
                    if (!todo.isEmpty()) {
                        showBusiness(todo);
                    }
                    break;
                case "5":
                    System.out.print("Введите ключевое слово: ");
                    String key = s.nextLine();
                    todo.removeIf(s1 -> s1.contains(key));
                    if (!todo.isEmpty()) {
                        showBusiness(todo);
                    }
                    break;
                default:
                    System.out.println("Вы ввели недопустимое значение!!");
                    b = false;
                    break;
            }
        }
    }

    public static void showInfo() {
        System.out.println("Выберите операцию:");
        System.out.println("0. Выход из программы\n" +
                "1. Добавить дело\n" +
                "2. Показать дела\n" +
                "3. Удалить дело по номеру\n" +
                "4. Удалить дело по названию\n" +
                "5. Удалить дела по ключевому слову");
    }

    public static void showBusiness(List<String> list) {
        System.out.println("Ваш список дел:");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, list.get(i));
        }
        System.out.println();
    }
}
