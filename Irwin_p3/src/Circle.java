import java.text.DecimalFormat;

public class Circle implements Shape, Shape2D {
    private double side;
    private String name;

    public Circle(double side) {
        super();
        this.side = side;
        this.name="circle";
    }
    public double getArea() {
        DecimalFormat df = new DecimalFormat("####0.00");
        return Double.parseDouble(df.format(Math.PI*side*side));
    }
    public String getName() {
        return name;
    }
}