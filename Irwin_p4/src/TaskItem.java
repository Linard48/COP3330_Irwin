public class TaskItem {
    private Date date;
    private String title;
    private String description;
    private int taskID;

    //Default constructor leaves attributes blank
    public TaskItem(String s, String s1, String s2) {
        this(null, null, null, 0);
    }

    public TaskItem(Date date, String title, String description, int taskID) {
        this.date = date;
        this.description = description;
        this.title = title;
        this.taskID = taskID;
    }

    //Following are accessors and mutators for date, title, description, and taskID attributes
    public Date getDate() {
        return this.date;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public int getTaskID() {
        return this.taskID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Prints out the current task in the format of “* Task ID: title, dd/mm/yyyy, hh:mm, location”
    public void printTask() {
        System.out.printf("* Task %d: %s, %s, %s\n", this.taskID, this.title, this.description, this.date.toString());
    }
}

