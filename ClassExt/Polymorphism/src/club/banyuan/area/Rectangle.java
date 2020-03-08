package club.banyuan.area;

public class Rectangle extends Shape {

  private double a, b;

  public Rectangle(double a, double b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public double area() {
    return a * b;
  }

  @Override
  public double perimeter() {
    return 2 * (a + b);
  }

}

