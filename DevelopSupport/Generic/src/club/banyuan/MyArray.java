package club.banyuan;

import java.util.Arrays;

public class MyArray<T> {

  /**
   * 初始化空间，如果空间不够用，再增加这么多空间
   */
  protected static final int INIT_SIZE = 20;

  /**
   * 用来保存数据的数组，如果数组满了，就重新创建一个数组，长度为当前数组长度+INIT_SIZE
   */
  protected Object[] objects = new Object[INIT_SIZE];
  /**
   * 记录保存了多少个元素
   */
  private int elementCount;
  /**
   * 记录一共有多少个可用存储空间
   */
  protected int totalSize = INIT_SIZE;

  /**
   * @return 返回保存了多少个元素
   */
  public int size() {
    return elementCount;
  }

  /**
   * @return true 数组中没有保存元素，false 数组中至少保存了一个元素
   */
  public boolean isEmpty() {
    return elementCount == 0;
  }

  /**
   * @param o 添加的元素
   * @return true 添加成功，false 添加失败
   */
  public boolean add(T o) {
    // 如果数组满了，进行扩容
    if (elementCount == totalSize) {
      objects = Arrays.copyOf(objects, totalSize + INIT_SIZE);
      totalSize += INIT_SIZE;
    }
    objects[elementCount] = o;
    elementCount++;
    return true;
  }

  /**
   * @param o 待删除的元素
   * @return true 删除成功，false 删除失败或者数组中没有保存这个元素
   */
  public boolean remove(T o) {
    for (int i = 0; i < elementCount; i++) {
      if (objects[i] == o) {
        // 如果找到这个元素，则将后面的元素依次左移，覆盖掉这个位置上面的元素
        // 不需要手动释放元素的存储空间，因为由垃圾回收器处理
        if (elementCount - 1 - i >= 0) {
          System.arraycopy(objects, i + 1, objects, i, elementCount - 1 - i);
        }
        elementCount--;
        objects[elementCount] = null;// 移除最后一个元素的引用，方便垃圾回收器回收
        return true;
      }
    }
    return false;
  }

  /**
   * @param index 删除指定位置的元素
   * @return 返回指定位置的元素
   * @throws ArrayIndexOutOfBoundsException 如果传入的index不合法，抛出此异常
   */
  public T remove(int index) {
    // 抛出非受检异常，不需要catch，用来提醒调用者传入的参数不合法
    if (index < 0 || index >= elementCount) {
      throw new ArrayIndexOutOfBoundsException("index不合法：" + index);
    }
    T deleted = (T) objects[index];
    // 直接调用已经实现好的方法
    remove(deleted);
    return deleted;
  }

  /**
   * 清空数组中保存的数据
   */
  public void clear() {
    // 新建一个数组，原始的存储区域由垃圾回收器回收
    objects = new Object[INIT_SIZE];
    totalSize = INIT_SIZE;
    elementCount = 0;
  }

  /**
   * @param index 数组下标
   * @return 指定下标处的元素
   */
  public T get(int index) {
    if (index < 0 || index >= elementCount) {
      throw new ArrayIndexOutOfBoundsException("index不合法：" + index);
    }
    return (T) objects[index];
  }

  /**
   * 替换指定下标处的元素
   *
   * @param index   要替换的元素下标
   * @param element 替换后的元素
   * @return 被替换的元素
   */
  public T set(int index, T element) {
    if (index < 0 || index >= elementCount) {
      throw new ArrayIndexOutOfBoundsException("index不合法：" + index);
    }
    T result = (T) objects[index];
    objects[index] = element;
    return result;
  }

  public static void main(String[] args) {
    MyArray<String> myArray = new MyArray<>();
    System.out.println(myArray.isEmpty()); // true
    myArray.add("a");
    myArray.add("b");
    myArray.add("c");
    System.out.println(myArray.size()); // 3
    System.out.println(myArray.isEmpty()); // false
    System.out.println(myArray.get(1)); // b
    System.out.println(myArray.remove(1)); // b
    System.out.println(myArray.size()); // 2
    System.out.println(myArray.get(1)); // c
    myArray.set(1, "f");
    System.out.println(myArray.get(1)); // f
    System.out.println(myArray.remove("a")); // true
    System.out.println(myArray.size()); // 1
    myArray.clear();
    System.out.println(myArray.isEmpty()); // true
  }
}
