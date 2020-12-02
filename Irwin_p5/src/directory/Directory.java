package directory;

import java.io.*;
import java.util.*;

public class Directory

{public Directory() throws IOException { ArrayList<Person> personList = new ArrayList<Person>();

    int choice=getOption();

    while(choice!=10)

    {switch (choice)

    { case 1: addPerson(personList); break;

        case 2: editPerson(personList); break;

        case 3: display(personList); break;

        case 4: searchPerson(personList); break;

        case 5: searchPhone(personList); break;

        case 6: delete(personList); break;

        case 7: displayphone(personList); break;

        case 8: savelisttofile(personList); break;

        case 9: loadlist(personList); break;

        default: System.out.println("Wrong choice");

    }

        choice=getOption();



    }

}

    public static int getOption()

    { Scanner scan = new Scanner(System.in);

        System.out.println("Press 1 to Add Person");

        System.out.println("Press 2 to Edit");

        System.out.println("Press 3 to Display");

        System.out.println("Press 4 to Search Name");

        System.out.println("Press 5 to Search Phone");

        System.out.println("Press 6 to Delete by Phone number");

        System.out.println("Press 7 print contact List");

        System.out.println("Press 8 save contact List");

        System.out.println("Press 9 load contact List");

        System.out.println("Press 10 Exit");

        System.out.println("Enter your choice");

        int choice = Integer.parseInt(scan.nextLine());

        return choice;

    }

    public static void addPerson(ArrayList<Person> personList)

    { Person A1 = new Person();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name: ");

        A1.name = sc.nextLine();

        System.out.println("Enter Email: ");

        A1.email = sc.nextLine();

        System.out.println("Enter telephone number: ");

        A1.telephone = sc.nextLong();

        personList.add(A1);

        System.out.println("Phone Book \n"+personList+"\n");

    }

    public static void searchPerson(ArrayList<Person> personList)

    { Scanner scan = new Scanner(System.in);

        Person temp = new Person();

        System.out.println("Enter person's name: ");

        String personName = scan.nextLine();

        for(int i = 0; i < personList.size(); i++)

        { temp=personList.get(i);

            if(personName.equals(temp.getName()))

            {

                System.out.println("Person Email :"+temp.getEmail());

                System.out.println("Person Phone no :"+temp.getphone());

                return;

            }



        }

        System.out.println("Person not found");

    }

    public static void searchPhone(ArrayList<Person> personList)

    { Scanner scan = new Scanner(System.in);

        long no;

        Person temp = new Person();

        System.out.println("Enter person's phone no: ");

        no = scan.nextLong();

        for(int i = 0; i < personList.size(); i++)

        { temp=personList.get(i);

            if(no !=(temp.getphone()))

            {

                return;

            }

            else

            {

                System.out.println("Person Name :"+temp.getName());

                System.out.println("Person Email :"+temp.getEmail());

            }

        }

        System.out.println("Person not found");

    }

    public static void delete(ArrayList<Person> personList)

    { Scanner scan = new Scanner(System.in);

        long no;

        Person temp = new Person();

        System.out.println("Enter person's phone no: ");

        no = scan.nextLong();

        for(int i = 0; i < personList.size(); i++)

        { temp=personList.get(i);

            if(no !=(temp.getphone()))

            {



                return;

            }

            else

            {

                personList.remove(i);

                System.out.println("Phone Book \n"+personList+"\n");

                return;

            }

        }

        System.out.println("Person not found");

    }

    public static void display(ArrayList<Person> personList)

    {

        System.out.println("Phone Book\n"+personList);

    }

    public static void displayphone(ArrayList<Person> personList)

    {

        Person temp = new Person();

        for(int i = 0; i < personList.size(); i++)

        { temp=personList.get(i);

            System.out.println("Phone Book\n"+temp.getphone());

        }

    }

    public static void editPerson(ArrayList<Person> personList)

    { Scanner scan = new Scanner(System.in);

        Person temp = new Person();

        System.out.println("Enter person's name: ");

        String personName = scan.nextLine();

        for(int i = 0; i < personList.size(); i++)

        { temp=personList.get(i);

            if(personName.equals(temp.getName()))

            {

                System.out.println("Enter Email to edit :");

                temp.email = scan.nextLine();

                System.out.println("Enter Phone no to edit :");

                temp.telephone = scan.nextLong();

                return;

            }

        }

        System.out.println("Person not found");

    }
    public static void savelisttofile(ArrayList<Person> ItemList) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter r;
        PrintWriter w;
        System.out.println("What file would you like to save to? Please enter an exact file location");
        r = new BufferedWriter(new FileWriter(in.nextLine()));

        for (Person task : ItemList) {
            System.out.println(" Writing to the file contents ");
            r.write(task.getName());
            r.write("  ");
            r.write((int) task.getphone());
            r.write("  ");
            r.write(String.valueOf(task.getEmail()));
            r.write("  ");
        }
        r.flush();
        r.close();
    }
    public static void loadlist(ArrayList<Person> ItemList) throws IOException {
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
            ItemList.add(new Person());
        }
    }
}