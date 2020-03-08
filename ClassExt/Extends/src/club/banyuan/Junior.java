package club.banyuan;

public class Junior extends Student {

  public Junior(String name) {
    super(name);
  }

  @Override
  public void study() {
    System.out.println(getName() + "在学习中学课程");
  }
}
