import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class App {
    public static ArrayList<TaskItem> list = new ArrayList<TaskItem>();

    public App() {
        //Initialize arraylist
        this.list = new ArrayList<>();
    }

    public TaskItem[] getSortedList() {
        //Create empty array the size of the current arraylist's size
        TaskItem[] sortedList = new TaskItem[this.list.size()];
        //Fill the new list with the unordered values from the arraylist
        for (int i = 0; i < this.list.size(); i++) {
            sortedList[i] = this.list.get(i);
        }

        return sortedList;
    }

    public void addTask(TaskItem task) {
        this.list.add(task);
    }

    public void deleteTask(int taskID) {
        //For each task in the task list, check if the ID given is equal to the task's ID. If it is, remove that task from the list
        //Note, it doesn't use a for-each loop because you can't delete an object while it is being used by the loop
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getTaskID() == taskID) {
                this.list.remove(i);
            }
        }
    }

    public void deleteAllTasks() {
        this.list.clear();
    }

    public int getTaskNumber() {
        return this.list.size();
    }

    public void printList(TaskItem[] tasks) {
        System.out.println("-------------------------");
        for (TaskItem task : tasks) {
            task.printTask();
        }
        System.out.println("-------------------------");
    }

    public static void displayMenu() {
        System.out.println("1: Add a task");
        System.out.println("2: List all tasks");
        System.out.println("3: Delete a task");
        System.out.println("4: Delete all tasks");
        System.out.println("5: Exit the program");
        System.out.println("6. Save list to file");
        System.out.println("7. Load list from file");
        System.out.println("8. Create new list");
        System.out.print("Please select an action from above: ");
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        //Defines the To-Do List instance
        App toDoList = new App();
        //Defines a variable that keeps the loop going until user exits
        boolean running = true;
        //Main loop runs until user exists
        while (running) {
            //Displays the menu, and then switches the number to user inputs to choose which action to do
            displayMenu();
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    //Add a task
                    //in.nextLine() for this case, and all cases after this, is used to clear the buffer of the scanner
                    in.nextLine();
                    System.out.print("Please input the new task title: ");
                    String taskTitle = in.nextLine();
                    if (taskTitle == null || taskTitle.isEmpty()){
                        System.out.print("Please input the new task title with 1 or more characters: ");
                        taskTitle = in.nextLine();
                    }
                    System.out.print("Please input the new task description: ");
                    String taskDescription = in.nextLine();
                    System.out.print("Please input the new task date (YYYY-MM-DD): ");
                    int taskYear = in.nextInt();
                    int taskMonth = in.nextInt();
                    int taskDay = in.nextInt();
                    in.nextLine();
                    //Creates a new task using all the values that were input by the user, and the To-Do List's task number to get the task ID
                    TaskItem newTask = new TaskItem(new Date(taskYear, taskMonth, taskDay), taskTitle, taskDescription, toDoList.getTaskNumber() + 1);
                    //Adds the new task to the list
                    toDoList.addTask(newTask);
                    //Display the sorted tasks
                    System.out.printf("Task %d is added. The list is as follows:\n", newTask.getTaskID());
                    toDoList.printList(toDoList.getSortedList());
                    break;
                case 2:
                    //List all tasks
                    toDoList.printList(toDoList.getSortedList());
                    break;
                case 3:
                    //Delete a task
                    toDoList.printList(toDoList.getSortedList());
                    in.nextLine();
                    System.out.print("Please input the task ID to be deleted: ");
                    int taskID = in.nextInt();
                    toDoList.deleteTask(taskID);
                    System.out.printf("\nTask %d is deleted. The list is as follow:\n", taskID);
                    toDoList.printList(toDoList.getSortedList());
                    break;
                case 4:
                    //Delete all tasks
                    toDoList.deleteAllTasks();
                    System.out.println("All tasks deleted. The list is empty");
                    break;
                case 5:
                    //Exit program
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                case 6:
                    TaskList.savelisttofile();
                    break;
                case 7:
                    TaskList.loadlist();
                    break;
                case 8:
                    TaskList.createList();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

}
