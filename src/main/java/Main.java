import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        Scanner scanner = new Scanner(System.in);
        logger.log("Просим пользователя ввести входные данные для списка");
        Integer[] params;
        do {
            params = inputListParams(scanner);
        } while (params[0] < 1 || params[1] < 1);
        logger.log("Создаём и наполняем список");
        List<Integer> list = newList(params);
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        Integer filterValue;
        do {
            filterValue = inputFilterValue(scanner);
        } while (filterValue < 1);
        logger.log("Запускаем фильтрацию");
        List<Integer> filterList = new Filter(filterValue).filterOut(list);
        logger.log("Выводим результат на экран");
        printList(filterList, "Отфильтрованный список:");
        logger.log("Завершаем программу");
    }

    public static Integer[] inputListParams(Scanner input) {
        Logger logger = Logger.getInstance();
        Integer[] listParams = new Integer[2];
        System.out.print("Введите размер списка: ");
        String sizeStr = input.nextLine();
        try {
            listParams[0] = Integer.parseInt(sizeStr);
            if (listParams[0] < 0) logger.log("Введено не положительное значение размера списка");
        } catch (Exception e) {
            logger.log("Введено некорректное значение, не являющееся целым числом для размера списка");
        }
        System.out.print("Введите верхнюю границу для значений: ");
        String topValueStr = input.nextLine();
        try {
            listParams[1] = Integer.parseInt(topValueStr);
            if (listParams[1] < 0) logger.log("Введено не положительное значение для верхней границы значений");
        } catch (Exception e) {
            logger.log("Введено некорректное значение, не являющееся целым числом для верхней границы значений");
        }
        return listParams;
    }

    public static List<Integer> newList(Integer[] params) {
        Random random = new Random();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < params[0]; i++) {
            result.add(random.nextInt(params[1]));
        }
        printList(result, "Вот случайный список:");
        return result;
    }

    public static Integer inputFilterValue(Scanner input) {
        Logger logger = Logger.getInstance();
        System.out.print("Введите порог для фильтра: ");
        String filterValueStr = input.nextLine();
        Integer filterValue = -1;
        try {
            filterValue = Integer.parseInt(filterValueStr);
            if (filterValue < 1) logger.log("Введено не положительное значение границы фильтра");
        } catch (Exception e) {
            logger.log("Введено некорректное значение, не являющееся целым числом для порога фильтра");
        }
        return filterValue;
    }

    public static void printList(List<Integer> list, String msg) {
        System.out.print(msg);
        list.stream().forEach(value -> System.out.print(" " + value));
        System.out.println();
    }
}