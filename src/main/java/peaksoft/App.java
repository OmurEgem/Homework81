package peaksoft;

import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.util.Scanner;

/**
 * Hello world!
 */

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        UserService userService = new UserServiceImpl();



while (true) {
    serviceSelection(userService);
}
    }

    private static void serviceSelection(UserService userService) throws Exception {

        choiceString();

        int a = scanner.nextInt();

        switch (a) {
            case 1: {
                userService.createUsersTable();
                break;
            }
            case 2: {
                userService.dropUsersTable();
                break;
            }
            case 3: {
                addUser(userService);
                break;
            }
            case 4: {
                System.out.println(userService.getAllUsers());
                break;
            }
            case 5: {
                System.out.println(userService.getAllUser());
                break;
            }
            case 6: {
                userService.UpdateUsers();
                break;
            }
            case 7: {
                userService.removeUserByName();
                break;
            }
            case 8: {
                userService.cleanUsersTable();
                break;
            }
            case 9: {
                System.exit(0);
                break;
            }
            default: {
                throw new Exception("1ден-9ка ичинен танда");
            }
        }
    }

    private static void addUser(UserService userService) {
        userService.saveUser("Askar", "Akaev", (byte) 34);
        userService.saveUser("Aza", "Motuev", (byte) 60);
        userService.saveUser("John", "Matroimov", (byte) 45);
        userService.saveUser("Aza", "Tokaev", (byte) 23);
        userService.saveUser("Vladimir", "Putinov", (byte) 90);
        userService.saveUser("Aza", "Selaev", (byte) 16);

    }


    public static void choiceString() {
        System.out.println(
                        "1 - Таблица курулат\n" +
                        "2 - Таблица жок кылуу\n" +
                        "3 - Юзерди кошуу\n" +
                        "4 - Баарын чыгаруу\n" +
                        "5 - Аза жана жашы 20дан чон болгон баардык юзерлерди чыгаруу\n" +
                        "6 - Аты Аза болгон юзерлердин жашын 18ге озгортунуз.\n" +
                        "7 - Аты Аза болгон юзерлерди очурунуз.\n" +
                        "8 - Таблицаны тазалоо \n" +
                        "9 - Программадан чыгуу");
    }

}

