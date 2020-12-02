package directory;
import java.util.Scanner;
class Date {

    private int day;
    private int month;
    private int year;

    //Default constructor, leaves class attributes as close to "blank" as possible
    public Date() {
        this(0, 0, 0);
    }

    public Date(int day, int month, int year) {
        Scanner scan = new Scanner(System.in);
        this.day = scan.nextInt();
        this.month = scan.nextInt();
        this.year = scan.nextInt();
    }

    //Following methods are accessors and mutators for day, month, and year attributes
    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //Returns date in YYYY/MM/DD format
    public String toString() {
        return String.format("%d/%d/%d", this.year, this.month, this.day);

    }
}