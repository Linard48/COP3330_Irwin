package directory;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;


public class TaskList {
    public TaskList() throws IOException { ArrayList<TaskItem> ItemList = new ArrayList<TaskItem>();

            int choice=getOption();

            while(choice!=9)

            {switch (choice)

            { case 1: addItem(ItemList); break;

                case 2: editTask(ItemList); break;

                case 3: display(ItemList); break;

                case 4: searchItem(ItemList); break;

                case 5: delete(ItemList); break;

                case 6: displayDate(ItemList); break;

                case 7: savelisttofile(ItemList); break;

                case 8: loadlist(ItemList); break;

                default: System.out.println("Wrong choice");

            }

                choice=getOption();



            }

        }


        public static int getOption()

        { Scanner scan = new Scanner(System.in);

            System.out.println("Press 1 to Add Item");

            System.out.println("Press 2 to Edit");

            System.out.println("Press 3 to Display");

            System.out.println("Press 4 to Search Title");

            System.out.println("Press 5 to Delete by Title");

            System.out.println("Press 6 print task List");

            System.out.println("Press 7 to save task List");

            System.out.println("Press 8 to load task List");

            System.out.println("Press 9 Exit");

            System.out.println("Enter your choice");

            int choice = Integer.parseInt(scan.nextLine());

            return choice;

        }

        public static void addItem(ArrayList<TaskItem> ItemList)

        { TaskItem A1 = new TaskItem();

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter title: ");

            A1.title = sc.nextLine();
            if (A1.title == null || A1.title.isEmpty()) {
                System.out.print("Please input the new task title with 1 or more characters: ");
                A1.title = sc.nextLine();
            }

            System.out.println("Enter Description: ");

            A1.description = sc.nextLine();

            System.out.println("Enter date (YYYY-MM-DD): ");

            A1.date = new Date();

            ItemList.add(A1);

            System.out.println("Phone Book \n"+ItemList+"\n");

        }

        public static void searchItem(ArrayList<TaskItem> ItemList)

        { Scanner scan = new Scanner(System.in);

            TaskItem temp = new TaskItem();

            System.out.println("Enter Title: ");

            String TaskTitle = scan.nextLine();

            for(int i = 0; i < ItemList.size(); i++)

            { temp=ItemList.get(i);

                if(TaskTitle.equals(temp.getTitle()))

                {

                    System.out.println("Task description :"+temp.getDescription());

                    System.out.println("Task Date :"+temp.getDate());

                    return;

                }



            }

            System.out.println("Item not found");

        }


        public static void delete(ArrayList<TaskItem> ItemList)


        { Scanner scan = new Scanner(System.in);

            TaskItem temp = new TaskItem();

            System.out.println("Enter Title: ");

            String TaskTitle = scan.nextLine();

            for(int i = 0; i < ItemList.size(); i++)

            { temp=ItemList.get(i);

                if(TaskTitle.equals(temp.getTitle()))

                {

                        ItemList.remove(temp);
                        return;

                }



            }

            System.out.println("Item not found");

        }

        public static void display(ArrayList<TaskItem> ItemList)

        {

            System.out.println("Phone Book\n"+ItemList);

        }

        public static void displayDate(ArrayList<TaskItem> ItemList)

        {

            TaskItem temp = new TaskItem();

            for(int i = 0; i < ItemList.size(); i++)

            { temp=ItemList.get(i);

                System.out.println("Phone Book\n"+temp.getDate());

            }

        }

        public static void editTask(ArrayList<TaskItem> ItemList)

        { Scanner scan = new Scanner(System.in);

            TaskItem temp = new TaskItem();

            System.out.println("Enter Title: ");

            String TaskTitle = scan.nextLine();

            for(int i = 0; i < ItemList.size(); i++)

            { temp=ItemList.get(i);

                if(TaskTitle.equals(temp.getTitle()))

                {

                    System.out.println("Enter description to edit :");

                    temp.description = scan.nextLine();

                    System.out.println("Enter date to edit :");

                    temp.date = new Date();
                    int taskYear = scan.nextInt();
                    int taskMonth = scan.nextInt();
                    int taskDay = scan.nextInt();


                    return;

                }

            }

            System.out.println("Task not found");

        }
    public static void savelisttofile(ArrayList<TaskItem> ItemList) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter r;
        PrintWriter w;
        System.out.println("What file would you like to save to? Please enter an exact file location");
        r = new BufferedWriter(new FileWriter(in.nextLine()));

        for (TaskItem task : ItemList) {
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
    public static void loadlist(ArrayList<TaskItem> ItemList) throws IOException {
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
            ItemList.add(new TaskItem());
        }
    }
    }

