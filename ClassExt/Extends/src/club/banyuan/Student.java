package club.banyuan;

public class Student {

  private String name;

  public Student(String name) {
    this.name = name;
  }

  // 使用final禁止重写get和set方法
  final public String getName() {
    return name;
  }

  final public void setName(String name) {
    this.name = name;
  }

  public void study() {
    System.out.println("学生学习");
  }
}
