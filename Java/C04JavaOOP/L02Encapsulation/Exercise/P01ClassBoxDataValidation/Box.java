package L02Encapsulation.Exercise.P01ClassBoxDataValidation;

public class Box {
    private double length;
    private double height;
    private double width;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setHeight(height);
        this.setWidth(width);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public double calculateVolume() {
        return this.height * this.width * this.length;
    }

    public double calculateLateralSurfaceArea(){
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateSurfaceArea(){
        return 2 * this.length * this.width + 2 * this.length * this.height + 2 * this.width * this.height;
    }
}
