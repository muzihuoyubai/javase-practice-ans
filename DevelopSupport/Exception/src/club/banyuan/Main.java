package club.banyuan;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    System.out.println("计算两个数字相除");
    System.out.println("请输入数字：");
    int one = nextInt();
    System.out.println("请输入模：");
    int two = nextInt();
    remainder(one, two);
  }

  static int nextInt() {
    try {
      Scanner scanner = new Scanner(System.in);
      return scanner.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("输入的不是数字，请重新输入");
      return nextInt();
    }
  }

  static void remainder(int one, int two) {
    try {
      System.out.printf("%d %% %d = %d", one, two, one % two);
    } catch (ArithmeticException e) {
      System.out.println("模不能为0，请重新输入");
      two = nextInt();
      remainder(one, two);
    }
  }
}
