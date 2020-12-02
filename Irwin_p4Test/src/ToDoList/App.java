package ToDoList;

import java.io.*;
import java.util.*;

class todo {
    public static final List<Task> todolist = new ArrayList<Task>();
    public static String filename = "/a/path.txt";

    public static void main(String args[]) throws IOException {
        Scanner s = new Scanner(System.in);
        /*
        Prompting user to input values
         */
        System.out.println("1.  create a new to-do list ");
        System.out.println("2.  load a to-do list from a file");
        System.out.println("3.  create a new entry, and add it into the list");
        System.out.println("4.  find an entry in the list by name, and display it");
        System.out.println("5.   find an entry in the list by name, and remove it");
        System.out.println("6.   display the entry with the earliest due date");
        System.out.println("7.   display all entries for a specific due date");
        System.out.println("8.   display all entries in the list");
        System.out.println("9.  save the list into a file   ");
        System.out.println("10.  exit  ");

        System.out.println("Please select your choice and input your number");
        int choice = s.nextInt();

        switch (choice) {
            case 1:
                System.out.println("1.  create a new to-do list ");
                createList();
                break;
            case 2:
                System.out.println("2.  load a to-do list from a file");
                loadlist();
                break;
            case 3:
                System.out.println("3.  create a new entry, and add it into the list");
                addtolist();
                break;
            case 4:
                System.out.println("4.  find an entry in the list by name, and display it");
                String taskid = "23";
                findentry(taskid);
                break;
            case 5:
                System.out.println("5.   find an entry in the list by name, and remove it");
                String task = "23";
                findentryremove(task);
                break;
            case 6:
                System.out.println("6.   display the entry with the earliest due date");
                displayearliest();
                break;
            case 7:
                System.out.println("7.   display all entries for a specific due date");
                String duedate = "23-10-2018";
                displayentries(duedate);
                break;
            case 8:
                System.out.println("8.   display all entries in the list");
                displayallentries();
                break;
            case 9:
                System.out.println("9.  save the list into a file   ");
                savelisttofile();
                break;
            case 10:
                System.out.println("You have entered 10 which is to exit ");
                System.exit(0);
                break;
        }

    }

    public static void createList() {
        todolist.add(new Task("task1", "this a new task description", "12-2-2018"));
    }

    public static void loadlist() throws IOException {
        BufferedReader r;
        PrintWriter w;

        r = new BufferedReader(new FileReader("C:\\Users\\A.I\\Documents\\COP3330-HOLLANDER\\List.txt"));
        String contentLine = r.readLine();
             /*
             Task name , Task Description and Date is being seperated by white spaces in the file.
              */
        String[] g = contentLine.split("\\s+");
        for (int i = 0; i < g.length; i++) {
            System.out.println(" Printing the file contents " + g[i]);
            todolist.add(new Task(g[0], g[1], g[2]));
        }
    }

    public static void savelisttofile() throws IOException {
        BufferedWriter r;
        PrintWriter w;

        r = new BufferedWriter(new FileWriter("C:\\Users\\A.I\\Documents\\COP3330-HOLLANDER\\List.txt"));

             /*
             Task name , Task Description and Date is being seperated by white spaces in the file.
              */

        for (Task t : todolist) {
            System.out.println(" Writing to the file contents " + t.getDate());
            r.write(t.getTaskname());
            r.write(t.getDescription());
            r.write(t.getDate());
        }
        r.flush();
        r.close();
    }

    public static void addtolist(){
        todolist.add(new Task("task2", "this a new task description", "12-2-2018"));
        System.out.println("Done adding");
    }

    public static void findentry(String key){
        boolean check = false;
        for(Task task: todolist){
            if(task.getTaskname().equalsIgnoreCase(key)){
                check = true;
                System.out.println("Entry found");
                System.out.println(" Task id " + task.getTaskname() + " Desc " + task.getDescription() + " Date is " + task.getDate());
            }
        }
        if(!check){
            System.out.println(" Sorry no entry found here ");
        }
    }

    public static void findentryremove(String key){
        boolean check = false;
        for(Task task: todolist){
            if(task.getTaskname().equalsIgnoreCase(key)){
                check = true;
                System.out.println("Entry found");
                System.out.println(" Task id " + task.getTaskname() + " Desc " + task.getDescription() + " Date is " + task.getDate());
            /*
            Removing it
             */
                todolist.remove(task);
                System.out.println("Removed Bingo");

            }
        }
        if(!check){
            System.out.println(" Sorry no entry found here ");
        }
    }
    public static void displayearliest(){
        Collections.sort(todolist, (o1, o2) -> (o1.getDate().compareTo(o2.getDate())));
        Task task = todolist.get(0);
        System.out.println(" Earliest due date is ");
        System.out.println(" Task id " + task.getTaskname() + " Desc " + task.getDescription() + " Date is " + task.getDate());
    }

    public static void displayentries(String duedate){
        boolean check = false;
        for(Task task: todolist){
            if(task.getDate().equalsIgnoreCase(duedate)){
                check = true;
                System.out.println("Entry found");
                System.out.println(" Task id " + task.getTaskname() + " Desc " + task.getDescription() + " Date is " + task.getDate());
            }
        }
        if(!check){
            System.out.println(" Sorry no entry found here for the given due date");
        }
    }

    public static void displayallentries(){
        for(Task task: todolist){
            System.out.println("Displaying entries");
            System.out.println(" Task id " + task.getTaskname() + " Desc " + task.getDescription() + " Date is " + task.getDate());
        }
    }
}