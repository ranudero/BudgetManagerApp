package budget;

import budget.menu.MainMenu;

public class Main {
    public static void main(String[] args) {
        // write your code here
        MainMenu mainMenu = new MainMenu();
        while (true) {
            mainMenu.show();
        }

    }
}
