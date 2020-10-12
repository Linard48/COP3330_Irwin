public class Cube implements Shape,Shape3D {
    private double side;
    private String name;


    public Cube(double side) {
        super();
        this.side = side;
        this.name="cube";
    }


    public double getArea() {
        return 6*side*side;
    }

    public String getName() {
        return name;
    }


    public double getVolume() {
        return side*side*side;
    }


}