package club.banyuan;

public class Main {

  public static void main(String[] args) {
    showQuarter(Month.AUG);
    showQuarter(Month.JUN);
    showQuarter(Month.DEC);
  }

  /**
   * 根据月份输出第几季度
   *
   * @param month 月份的枚举类型
   */
  static void showQuarter(Month month) {
    switch (month) {
      case JAN:
      case FEB:
      case MAR:
        System.out.println("第一季度：" + month);
        break;
      case APR:
      case MAY:
      case JUN:
        System.out.println("第二季度：" + month);
        break;
      case JUL:
      case AUG:
      case SEP:
        System.out.println("第三季度：" + month);
        break;
      case OCT:
      case NOV:
      case DEC:
        System.out.println("第四季度：" + month);
        break;
      default:
        break;
    }
  }
}
