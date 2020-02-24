/**
 * ANS 注释标注的内容为新增的代码
 */
class Elephant {

  int heightInCM;
}

class Fridge {

  int heightInCM;
  Elephant storageElephant;
  Lion storageLion;

  void store(Elephant elephant) {
    // ANS 增加是否为null，如果不为null表示装了一个动物
    if (storageElephant != null || storageLion != null) {
      System.out.println("冰箱已经满了");
    } else {
      storageElephant = elephant;
    }
  }

  // ANS 重载方法
  void store(Lion lion) {
    if (storageElephant != null || storageLion != null) {
      System.out.println("冰箱已经满了");
    } else {
      storageLion = lion;
    }
  }

  /**
   * ANS 将storeage结果返回，并且将storeage置null
   */
  Elephant remove() {
    Elephant rlt = storageElephant;
    storageElephant = null;
    return rlt;
  }
}

/**
 * ANS
 */
class Lion {

  int heightInCM;
}

class ObjectDemo {

  static Elephant createElephant(int heightInCM) {
    System.out.printf("创建一个大象，高度%d厘米\n", heightInCM);
    // 使用定义的类作为数据类型
    // 使用new 创建一个对象（实例）
    Elephant elephant = new Elephant();
    // 使用. 访问对象的属性，可以对属性赋值或使用
    elephant.heightInCM = heightInCM;
    return elephant;
  }

  static Fridge createFridge(int heightInCM) {
    System.out.printf("创建一个冰箱，高度%d厘米\n", heightInCM);
    Fridge fridge = new Fridge();
    fridge.heightInCM = heightInCM;
    return fridge;
  }

  static void putInElephant(Elephant elephant, Fridge fridge) {
    System.out.printf("把%d厘米高的大象装进%d厘米高的冰箱\n", elephant.heightInCM, fridge.heightInCM);
    if (elephant.heightInCM < fridge.heightInCM) {

      // 使用对象方法
      fridge.store(elephant);
      System.out.printf("冰箱里面的大象高度是%d厘米\n", fridge.storageElephant.heightInCM);
    } else {
      System.out.printf("冰箱装不下!\n");
    }

  }

  // ANS 创建狮子类
  static Lion createLion(int heightInCM) {
    System.out.printf("创建一个狮子，高度%d厘米\n", heightInCM);
    Lion lion = new Lion();
    lion.heightInCM = heightInCM;
    return lion;
  }

  public static void main(String[] args) {
    Elephant elephant = createElephant(300);
    Fridge fridge = createFridge(500);
    putInElephant(elephant, fridge);

    fridge.store(createLion(200));
  }
}


