public class Square implements Shape, Shape2D {
    private double side;
    private String name;


    public Square(double side) {
        super();
        this.side = side;
        this.name="square";
    }
    public double getArea() {
        return side*side;
    }
    public String getName() {
        return name;
    }
}