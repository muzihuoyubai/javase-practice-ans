package club.banyuan;

public class Senior extends Student {

  public Senior(String name) {
    super(name);
  }

  @Override
  public void study() {
    System.out.println(getName() + "在学习高中课程");
  }
}
