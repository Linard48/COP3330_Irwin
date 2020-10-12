import java.text.DecimalFormat;

public class Sphere implements Shape,Shape3D {

    private double radius;
    private String name;



    public Sphere(double radius) {
        super();
        this.radius = radius;
        this.name="sphere";
    }

    public String getName() {
        return name;
    }
    public double getArea() {
        DecimalFormat df = new DecimalFormat("####0.00");
        return Double.parseDouble(df.format(4*Math.PI*radius*radius));
    }


    public double getVolume() {
        DecimalFormat df = new DecimalFormat("####0.00");
        return Double.parseDouble(df.format((1.333333333333)*(Math.PI)*(radius*radius*radius)));
    }


}
