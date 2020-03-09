## 目的
熟悉泛型类和泛型方法的编写和使用，对以后集合的api有初步的认识

## 练习
实现一个可以自动扩容的MyArray类，类的内部定义一个具有初识长度的Object数组
创建时不需要定义数组的长度，当保存的数据数量超过内部预设的数值上限后，自动扩容

需要实现的方法如下
```
  /**
   * @return 返回保存了多少个元素
   */
  int size();

  /**
   * @return true 数组中没有保存元素，false 数组中至少保存了一个元素
   */
  boolean isEmpty();

  /**
   * @param o 添加的元素
   * @return true 添加成功，false 添加失败
   */
  boolean add(T o);

  /**
   * @param o 待删除的元素
   * @return true 删除成功，false 删除失败或者数组中没有保存这个元素
   */
  boolean remove(T o);

  /**
   * @param index 删除指定位置的元素
   * @return 返回指定位置的元素
   * @throws ArrayIndexOutOfBoundsException 如果传入的index不合法，抛出此异常
   */
  T remove(int index);

  /**
   * 清空数组中保存的数据
   */
  void clear();

  /**
   * @param index 数组下标
   * @return 指定下标处的元素
   */
  T get(int index);

  /**
   * 替换指定下标处的元素
   *
   * @param index   要替换的元素下标
   * @param element 替换后的元素
   * @return 被替换的元素
   */
  T set(int index, T element);
```
