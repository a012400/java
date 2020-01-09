## 题型分值

### 一、 选择题，共15题，每题1分

### 二、判断题，共5题，没题1分

### 三、填空题，共10空，每空1分

### 四、简答题，共5题，每题5分

### 五、程序阅读题，两大题，10个空，每空2分

### 六、综合编程应用题，共1题，共25分

## 第一章

### Java语言的四大主要特点

面向对象、跨平台、安全、分布式、动态、多线程

### 面向对象的四大特征

抽象、封装、继承、多态

## 第四章

### 构造方法的定义规则

```java
[访问权限修饰符] 构造方法名(形参列表)
{
    // 构造方法体
}
```

1. 方法名必须与类名相同
2. 不要声明返回值类型
3. 只能被public、protected、private、默认包权限（不写修饰符）修饰
4. 构造方法仅在创建对象时执行，使用`new`关键字调用一个类的构造器

> 构造方法是类的一个特殊方法，在创建对象时实现初始化对象属性的一些操作，例如下代码，演示了常用的构造方法使用方式。

```java
public class Person	// 定一个类，其名叫Person
{
    private int age;	// Person类的成员变量
    
    public Person(int num)	// Person的一个构造方法
    {
        this.age = num;		// 在调用构造方法时传入一个int型的参数
        					// 将其参数的值赋给Person的属性age
    }
    public Person()		// 构造方法可以不光一个，可以有多个
    {
        this.age = 0;	// 因为此构造器无形参，可以将Person类的age属性设为0或其他任意整型值
    }
    
    public static void main(String[] args)	// main方法的定义格式
    {
        Person aa = new Person(16);	// 调用上面定义的第一个构造方法
        Person bb = new Person();		// 调用第二个构造方法
        // aa的age属性的值是16，由第一个构造方法传入并赋值
        // bb的age属性为0，在第二个构造方法中赋值
    }
```



### main方法的定义格式

```java
public static void main(String[] args)
{
    // 方法体
}
```

### 封装的定义与使用方法

封装是把对象的属性和操作结合为一个独立的整体，并尽可能隐藏对象的内部细节，对外界形成一个边界，只保留有限的外部接口与外界进行联系。

通用采用的方式是将数据成员私有化，声明private，只允许在类的内部直接存取，外界则使用类声明的两个共开的接口（getter和setter方法）进行访问。

> 下面代码实现了封装，并提供了getter、setter方法的一般使用格式。

```java
public class Person
{
    private int age;	// 将Person类的属性age的访问权限设为private，外界无法直接调用并赋值
    
    public void setAge(int age)		// Person的setter方法
    {
        this.age = age;	// this.age访问的是Person类的age属性，而age是方法形参传入的值
    }
    
    public int getAge()		// Person的getter方法
    {
        return this.age;
    }	
    
```



### 类和对象的关系

类是对象的抽象，而对象是类的具体实例。类是抽象的，不占用内存，而对象是具体的，占用存储空间。类是用于创建对象的蓝图，它是一个定义包括在特定类型的对象中的方法和变量的软件模板。

类与对象的关系就如模具和铸件的关系 类的实例化结果就是对象，而对一类对象的抽象就是类，类描述了一组有相同属性和相同方法的对象

> 下面代码说明了什么是类和对象和类和对象的关系。

```java
public class Person	// 创建一个名为Person的类
{
    // 类的属性，例如人类有年龄、姓名等
    private int age;
    private String name;
    
    // 类的方法，例如人类可以吃、喝等行为
    public void eat()
    {
        System.out.println("---吃---");
    }
    
    // 下面代码是构造方法
    public Person(int age, String name)		// 此构造方法传入两个参数
    {
        this.age = age;		// 注意区分前后的区别
        this.name = name;
    }
    
    // main方法
    public static void main(String[] args)
    {
        // 下面声明了一个aa的变量，并使用new调用Person的构造方法创建对象
        // Person是类  aa是对象（也叫类的实例）
        Person aa = new Person(16, "fx");
        // 使用对象调用方法
        aa.eat();	// 调用的是上面代码第一个定义的方法，在屏幕打印输出"---吃---"
```

### 创建某个类的构造方法，创建某个类的对象，用setXxx()、getXxx()方法去设置和获取值的代码

> 在上面已经说明了很多遍了，创建某个类的构造方法，创建某个类的对象就是使用new关键字调用构造方法，用setXxx()、getXxx()方法去设置和获取值的代码就是封装的实现

```java
public class Person {
    private int age;
    public Person(int age) {
        this.age = age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }
    public static void main(String[] args) {
        Person qwq = new Person(16);
        qwq.setAge(17);
        int age = qwq.getAge();
        System.out.println(age);	// 输出17
    }
}
```

### 什么叫方法的重载？构造方法可以重载吗？

Java的方法重载，就是在类中可以创建多个方法，它们可以有相同的名字，但必须具有不同的参数，即或者是参数的个数不同，或者是参数的类型不同。调用方法时通过传递给它们的不同个数和类型的参数，以及传入参数的顺序来决定具体使用哪个方法。

构造方法也是方法，可以重载。

口诀：两同一不同

- 两同
  - 同一个类中
  - 方法名称相同
- 一不同
  - 参数列表不同

> 下面代码实现了方法的重载

```java
public class Person {
    // 定义一个无参数的构造方法
    public Person() {
        System.out.println("无参数构造器");
    }
    // 定义一个带参数的构造方法
    // 构造方法也是方法，方法名都是Person，但前一个和后一个构造方法的形参不同
    // 实现了方法的重载
    public Person(double pi) {
        System.out.println("一个参数的构造器，其值为" + pi);
    }
    
    // 先定义一个名为PrintHaha方法，无形参
    public void printHaha() {
        System.out.println("无参数的printHaha方法");
    }
    // 再定义一个名为printHaha的方法，但是形参列表不同
    // 实现了重载
    public void printHaha(String hi) {
        System.out.println("一个参数的printHaha方法");
    }
    
    public static void main(String[] args) {
        // 下面两行代码调用了名都为Person的构造方法（构造方法也是方法）
        // 但是形参不一样，所以调用的不是同一个构造方法
        Person pp = new Person();	// 将会在屏幕打印"无参数构造器"
        Person p2 = new Person(3.14);	// 将在屏幕打印"一个参数的构造器，其值为3.14"
        // 因为有两个名为printHaha方法，Java在执行时检测形参的数量和类型
        // 决定执行哪一个方法
        pp.printHaha();		// 在屏幕打印"无参数的printHaha方法"
        p2.printHaha("hhahahah");	// 在屏幕打印"一个参数的printHaha方法"
```

> 方法的重载可以理解为在Java的类中有多个名字相同的方法，但是实现的功能不一样，Java在运行时自动检测要执行哪一个方法（通过区分形参列表来区分）。

## 第五章

### 类的继承规则

继承：从已有的类中派生出新的类。新的类能吸收已有类的数据属性和行为并能扩展新的能力

继承分类

- 单继承：一个子类最多只能有一个父类。

- 多继承：一个子类可有两个以上的父类。

Java类只支持单继承，而接口支持多继承。Java多继承的功能则是通过接口方式来间接实现的。

继承关键字：`extends`

> 如下代码简单地说明了什么是继承

```java
class Father {
    // private、public、protected三个访问权限修饰符
    // private是私有的，除了当前类（Father）能访问，其他任何类都不能访问
    // protected是只要当前类和子类能访问，其他类不能访问
    // public是所有类都能访问，不管是否是不是子类
    private int age;
    protected double weight;
    public String name;
}

// 定义一个Son类，继承了Father类
// 继承一个类会得到父类的属性和方法
// 顾名思义，继承就是接收父类的”遗产“
// 这个“遗产”有属性、方法
public class Son extends Father {
    public static void main(String[] args) {
        Son sss = new Son();
        // 继承了父类后，可以访问继承得来的“遗产”
        sss.weight = 85.2;
        sss.name = "fx";
        // 对于private修饰的属性，子类或其他类都不能访问
        // 下面代码会引起错误
        sss.age = 21;
    }
}   
```



### 所以类的父类Object类的定义与介绍

Object类：Java中所有类的父类，定义和实现了Java系统下所有类的共同行为，所有的类都是由这个类继承、扩充而来的。