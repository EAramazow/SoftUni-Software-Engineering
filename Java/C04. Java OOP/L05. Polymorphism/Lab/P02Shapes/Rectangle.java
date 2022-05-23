package L05Polymorphism.Lab.P02Shapes;

public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculatePerimeter() {
        super.setPerimeter(this.width * 2 + this.height * 2);
        return super.getPerimeter();
    }

    @Override
    public double calculateArea() {
        super.setArea(this.width * this.height);
        return super.getArea();
    }

    public final double getHeight() {
        return height;
    }

    public final double getWidth() {
        return width;
    }
}
