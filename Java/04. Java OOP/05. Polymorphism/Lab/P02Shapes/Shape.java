package L05Polymorphism.Lab.P02Shapes;

public abstract class Shape {
   private double perimeter;
   private double area;


    public abstract double calculatePerimeter();
    public abstract double calculateArea();


    protected void setArea(double area) {
        this.area = area;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }
}
