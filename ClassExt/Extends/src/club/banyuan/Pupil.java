package club.banyuan;

public class Pupil extends Student {

  public Pupil(String name) {
    super(name);
  }

  @Override
  public void study() {
    System.out.println(getName() + "在学习小学课程");
  }
}
