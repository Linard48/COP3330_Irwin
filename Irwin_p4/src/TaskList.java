import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {

    public static void savelisttofile() throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter r;
        PrintWriter w;
        System.out.println("What file would you like to save to? Please enter an exact file location");
        r = new BufferedWriter(new FileWriter(in.nextLine()));

        for (TaskItem task : App.list) {
            System.out.println(" Writing to the file contents ");
            r.write(task.getTitle());
            r.write("  ");
            r.write(task.getDescription());
            r.write("  ");
            r.write(String.valueOf(task.getDate()));
            r.write("  ");
        }
        r.flush();
        r.close();
    }

    public static void createList() throws IOException {
        ArrayList<TaskItem> newList = new ArrayList<>();
    }

    public static void loadlist() throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader r;
        PrintWriter w;
        System.out.println("What file would you like to load from? Please enter an exact location");
        r = new BufferedReader(new FileReader(in.nextLine()));
        String contentLine = r.readLine();
             /*
             Task name , Task Description and Date is being separated by white spaces in the file.
              */
        String[] g = contentLine.split("\\s+");
        for (int i = 0; i < g.length; i++) {
            System.out.println(g[i]);
            App.list.add(new TaskItem(g[0], g[1], g[2]));
        }
    }
}
