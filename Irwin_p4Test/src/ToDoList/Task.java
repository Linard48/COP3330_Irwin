package ToDoList;

import java.util.Date;

public class Task {

    private String taskname;
    private String description;
    private String date;

    Task(String taskname,String description,String date){
        this.taskname = taskname;
        this.description = description;
        if(date == null){
            /*
                 No worries Date is optional
             */
        }else{
            this.date = date;
        }

    }
    public String getTaskname() {
        return taskname;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }
}