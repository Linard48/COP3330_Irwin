package directory;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        ArrayList<TaskItem> ItemList = new ArrayList<TaskItem>();

        int choice = getOptions();

        while (choice != 3) {
            switch (choice) {
                case 1:
                    new ContactList();
                    break;

                case 2:
                    new TaskList();
                    break;
            }
            break;
        }
    }

            public static int getOptions(){
                Scanner scan = new Scanner(System.in);

                System.out.println("Press 1 to create a contact list");

                System.out.println("Press 2 to create a task list");

                System.out.println("Press 3 to exit");


                System.out.println("Enter your choice");

                int choice = Integer.parseInt(scan.nextLine());

                return choice;

            }

        }

