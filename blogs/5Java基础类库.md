# Java基础类库

## 用户互动

### 使用Scanner获取键盘输入

- Scanner主要提供了两个方法来**扫描输入**
  - `hasNextXxx();`
    - 是否还有下一个输入项，其中`Xxx`可以是`int`、`long`等代表基本数据类型的**字符串**。
  - `nextXxx();`
    - 获取下一个输入项。`Xxx`的含义与前一个方法中的`Xxx`相同。

默认情况下，Scanner使用空白（`空格`、`Tab`、`回车`）作为多个输入项之间的**分隔符**。

如果希望改变Scanner的分隔符，使用方法`useDelimiter(String pattern);`

Scanner的读取操作可能被**阻塞**，Scanner的`hasNext();`和`next();`方法都有可能阻塞，`hasNext();`方法是否阻塞与和其相关的`next();`方法是否阻塞无关

为Scanenr设置分隔符使用`useDelimiter(String pattern);`方法即可，该方法的参数应该是一个**正则表达式**

- Scanner提供了两个简单的方法来**逐行读取**
  - `boolean hasNextLine();`
    - 返回输入源中是否还有下一行
  - `String nextLine();`
    - 返回输入源中下一行的字符串

- Scanner不仅能读取用户的键盘输入，还可以读取**文件输入**。
  - 只要在创建Scanner对象时传入一个`File`对象作为参数，就可以让Scanner读取该文件的内容。

***

## 系统相关

### System类

System类代表**当前**Java程序的运行平台，程序不能创建System类的对象，System类提供了一些**类变量**和**类方法**，允许直接通过System类来调用这些**类变量**和**类方法**。

- System类提供了代表**标准输入**、**标准输出**和**错误输出**的**类变量**，并提供了一些**静态方法**用于访问**环境变量**、**系统属性**的方法，还提供了**加载文件**和**动态链接库**的方法。
  - **加载文件**和**动态链接库**主要对`native`方法有用，对于一些特殊的功能（如访问操作系统底层硬件设备等）Java程序无法实现，必须借助C语言来完成，此时需要C语言为Java方法提供实现。
    - 1. Java程序中声明native修饰的**方法**，类似于`abstract`方法，只有**方法签名**，没有实现。编译该Java程序，生产一个`class`文件。
    - 2. 用`javah`编译第1步生产的`class`文件，将生产一个`.h`文件。
    - 3. 写一个`cpp`文件实现native方法，这一步需要包含第2步产生的`.h`文件（这个`.h`文件中包含了JDK带的`jni.h`文件）。
    - 4. 将第3步的`.cpp`文件编译成动态链接库文件。
    - 5. 在Java中用System类活动`loadLibrary..()`方法或Runtime类的`loadLibrary()`方法加载第4步产生的动态链接库文件，Java程序中就可以调用这个native方法了。

调用System类的`getenv()`、`getProperties()`、`getProperty()`等方法来访问程序所在平台的**环境变量**和**系统属性**。

System类提供了通知系统进行**垃圾回收**的`gc()`方法，以及通知系统进行**资源清理**的`runFinalization()`方法。

- System类还有两个获取系统**当前时间**的方法
  - `currentTimeMillis();`
  - `nanoTime();`
  - 它们都返回一个`long`型整数；实际上它们都返回当前时间与UTC1970年1月1日午夜的时间差，前者以**毫秒**作为单位，后者以**纳秒**作为单位。
  - 这两个方法返回的时间粒度取决于底层的操作系统，可能所在的操作系统根本不支持以毫秒、纳秒作为计时单位。
  - 许多操作系统以几十毫秒为单位测量时间，`currentTimeMillis()`方法不可能返回精确的毫秒数；而`nanoTime()`方法很少用，因为大部分操作系统都不支持使用纳秒作为计时单位。

System类的`in`、`out`、`err`分别代表系统的**标准输入（通常是键盘输入）**、**标准输出（通常是显示器）**和**错误输出流**，并提供了`setIn()`、`setOut()`和`setErr()`方法来**改变**系统的标准输入、标准输出和标准错误输出流。

System类还提供了一个`identityHashCode(Object x);`方法，该方法返回指定对象的精确`hashCode`值，根据该对象的**地址**计算得到的`hashCode`值。

### Runtime类与java9的ProcessHandle

Runtime类代表Java程序**运行时的环境**，每个Java程序都有一个**与之对应**的**Runtime实例**，应用程序通过该对象与其运行时环境相连。

应用程序不能创建自己的Runtime实例，但可以通过`getRuntime()`方法获取与之关联的Runtime对象。

Runtime类也提供了`gc()`方法或`runFinalization()`方法来通知系统进行**垃圾回收**、**清理系统资源**，并提供了`load(String filename)`和`loadLibrary(String libname)`方法来**加载文件**和**动态链接库**。

- Runtime类部分方法
  - `availableProcessors();`
  - `freeMemory();`
  - `totalMemory();`
  - `maxMemory();`
  - `exec();`

通过exec启动平台上的命令之后，它就变成了一个**进程**，Java使用Process来代表进程。

Java9新增了一个`ProcessorHandle`接口，通过该接口可获取**进程的ID**、**父进程**和**后代进程**；通过该接口的`onExit()`方法可在进程结束时完成某些行为。

`ProcessorHandle`还提供了一个`ProcessorHandle.Info`类，用于获取进程的**命令**、**参数**、**启动时间**、**累计运行时间**、**用户**等信息。

***

## 常用类

### Object类

- 常用方法
  - `boolean equals(Object obj);`
    - 判断指定对象与该对象是否相等。
  - `protected void finalize();`
    - 当系统中没有引用变量引用到该对象时，垃圾回收器调用此方法来清理该对象的资源。
  - `Class<?> getClass();`
    - 返回该对象的运行时类。
  - `int hashCode();`
    - 返回该对象的hashCode值。
  - `String toString();`
    - 返回该对象的字符串表示。

Java还提供了一个`protected`修饰的`clone()`方法，该方法用于帮助其他对象实现**自我克隆**，就是得到一个当前对象的**副本**，而且二者之间**完全隔离**。

- 自定义类实现**克隆**的步骤
  - 1. 自定义类实现`Cloneable`接口。这是一个**标记行性**的接口，实现接口的对象可以实现**自我克隆**，接口里没有定义任何方法。
  - 2. 自定义类实现自己的`clone()`方法。
  - 3. 实现`clone()`方法时通过`super.clone();`调用`Object`实现的`clone()`方法来得到该对象的副本，并返回副本。

Object类提供的Clone机制只对对象里各实例变量进行**简单复制**，如果实例变量的类型是**引用类型**，Object的Clone机制也只是简单地**复制**这个引用变量，这样原有对象的引用类型的实例变量与克隆对象的引用类型的实例变量依然指向内存中的**同一个实例**。

Object类的`clone()`方法只是一种**浅克隆**，只克隆该对象的所有成员变量值，不会对引用类型的成员变量值所引用的对象进行克隆。

如果需要对对象进行**深克隆**，则需要进行**递归**克隆，保证所有引用类型的成员变量值所引用的对象都被复制了。

***

### Objects类

Java7新增的一个类，提供了一些**工具方法**来操作对象，这些工具方法大多是**空指针**安全的。

Java为工具类的命名习惯是添加一个字母`s`，比如操作数组的工具类是`Arrays`，操作集合的工具类是`Collections`。

***

### Java9改进的String、StringBuffer和StringBuilder类

Java提供了`String`、`StringBuffer`和`StringBuilder`三个类来封装字符串，并提供了一系列方法来操作字符串对象。

String类是**不可变类**，即一旦一个String对象被创建以后，包含在这个对象的**字符序列**是不可改变的，直至这个对象被销毁。

`StringBuffer`对象则代表一个字符序列**可变的**字符串，当一个StringBuffer被创建以后，通过StringBuffer提供的`append()`、`insert()`、`reverse()`、`setCharAt()`、`setLength()`等方法改变这个字符串对象的字符序列。一旦通过StringBuffer生产了最终想要的字符串，就可以调用它的`toString()`方法将其转换为一个String对象。

`StringBuilder`类是JDK1.5新增的类，它也代表可变字符串对象。StringBuffer和StringBuilder基本相似，两个类的构造器和方法也基本相同。不同的是，StringBuffer是**线程安全**的，而StringBuilder则没有实现线程安全功能，所以**性能略高**。

String、StringBuffer、StringBuilder都实现了`CharSequence`接口，因此`CharSequence`可认为是一个字符串的**协议接口**。

- String类提供了大量构造器来**创建**String对象
  - `String()`:创建了一个包含0个的字符串序列的String对象。
  - `String(byte[] bytes, Charset charset)`:使用指定的字符集将指定的`byte[]`数组解码成一个新的String对象。
  - `String(byte[] bytes, int offset, int length)`:使用平台默认的字符集将指定的`byte[]`数组从`offset`开始、长度为`length`的子数组解码成一个新的String对象。
  - `String(byte[] bytes, int offset, int length, String charsetName)`:使用指定的字符集将指定的`byte[]`数组从`offset`开始、长度为`length`的子数组解码成一个新的String对象。
  - `String(byte[] bytes, String charsetName)`:使用指定的字符集将指定的`byte[]`数组解码成一个新的String对象。
  - `String(char[] value, int offset, int count)`:将指定的字符数组从`offset`开始、长度为`count`的字符元素连缀成字符串。
  - `String(String original)`:根据字符串直接量来创建一个String对象。
  - `String(StringBuffer buffer)`:根据`StringBuffer`对象来创建对应的String对象。
  - `String(StringBuilder builder)`:根据`StringBuilder`对象来创建对应的String对象。

- String类也提供了大量方法来**操作**字符串对象
  - `char charAt(int index)`:获取字符串中指定位置的字符。
  - `int compareTo(String anotherString)`:比较两个字符串的大小。如果两个字符串的字符序列相等，则返回0；不相等时，从两个字符串第0个字符开始比较，返回第一个不相等的字符差。另一种情况，较长字符串的前面部分恰巧是较短的字符串，则返回它们的长度差。
  - `String concat(String str)`:将该String对象和str连接在一起。
  - `boolean contentEquals(StringBuffer sb)`:将该对象与StringBuffer对象sb进行比较，当它们包含的字符序列相同时返回true。
  - `static String copy ValueOf(char[] data)`:将字数组连缀成字符串。
  - `static String copyValueOf(char[] data, int offset, int count)`:将char数组的子数组中的元素连缀成字符串。
  - `boolean endsWith(String suffix)`:返回该String对象是否以`suffix`结尾。
  - `boolean equals(Object anObject)`:将字符串与指定对象比较，如果二者包含的字符序列相等，则返回true，否则返回false。
  - `boolean equalsIgnoreCase(String str)`:将字符串与`str`忽略大小写比较。
  - `byte[] getBytes()`:将该String对象转换成`byte`数组。
  - `void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)`:该方法将字符串中从`srcBegin`开始，到`srcEnd`结束的字符复制到`dst`字符数组中，其中`dstBegin`为目标字符数组的起始复制位置。
  - `int indexOf(int ch, int fromIndex)`:找出`ch`字符在该字符串中从`fromIndex`开始第一次出现的位置。
  - `int indexOf(String str)`:找出`str`子字符串在该字符串中第一次出现的位置。
  - `int indexOf(String str, int fromIndex)`:找出`str`子字符串在该字符串中从`fromIndex`开始第一次出现的位置。
  - `int lastIndexOf(int ch)`:找出`ch`字符在该字符串中最后一次出现的位置。
  - `int lastIndexOf(int ch, int fromIndex)`:找出`ch`字符中从`fronIndex`在该字符串中最后一次出现的位置。
  - `int lastIndexOf(String str)`:找出`str`子字符串在该字符串中最后一次出现的位置。
  - `int lastIndexOf(String str, int fromIndex)`:找出`str`子字符串在该字符串中从`fromIndex`开始后最后一次出现的位置。
  - `int length()`:返回当前字符串长度。
  - `String replace(char oldChar, char newChar)`:将字符串中第一个`oldChar`替换成`newChar`。
  - `boolean startsWith(String prefix)`:该String对象是否以`prefix`开始。
  - `boolean startsWith(String prefix, int toffset)`:该String对象从`toffset`位置算起，是否以`prefix`开始。
  - `String substring(int beginIndex)`:获取从`beginIndex`位置开始到结束的字符串。
  - `String substring(int beginIndex, int endIndex)`:获取从`beginIndex`位置开始到`endIndex`位置的子字符串。
  - `char[] toCharArray()`:将该String对象转换成char数组。
  - `String toLowerCase()`:将字符串转换成小写。
  - `String toUpeprCase()`:将字符串转换成大写。
  - `static String valueOf(X x)`:一系列用于将基本类型值转换为String对象的方法。

- StringBuffer、StringBuilder有两个**属性**:`length`和`capacity`。
  - 其中`length`属性表示其包含的字符串序列的长度。与String对象不同的是，StringBuffer、StringBuilder的length是可以改变的，可以通过`length()`、`setLength(int len)`方法来访问和修改其字符序列的长度。
  - `capacity`属性表示StringBuilder的**容量**，`capacity`通常比`length`大，程序通常无需关心`capacity`属性。

***

### Math类

Math类是一个**工具类**，它的构造器被定义成`private`的，因此无法创建Math类的对象；Math类中的所有方法都是**类方法**；还提供了的两个类变量`PI`和`E`。

***

### ThreadLocalRandom与Random

`Random`类专门用于生成一个**伪随机数**，它有两个构造器：一个构造器使用**默认**的种子（以当前时间作为种子），另一个构造器需要显式**传入**一个`long`型整数的种子。

`ThreadLocalRandom`类是Java7新增的一个类，它是`Random`的**增强版**。在**并发访问**的环境下，使用`ThreadLocalRandom`来代替`Random`可以**减少多线程资源竞争**，最终保证系统具有更好的**线程安全性**。

`ThreadLocalRandom`类的用法和`Random`类的用法基本相似，它提供了一个**静态**的`current()`方法来获取`ThreadLocalRandom`对象，获取该对象之后即可调用各种`nextXxx()`方法来获取伪随机数。

Random使用一个48位的种子，如果这个类的两个实例都是用同一个种子创建的，对它们以同样的顺序调用方法，则它们会产生相同的数字序列。

为避免两个Random对象产生相同的数字序列，通常推荐使用当前时间作为Random对象的种子：`System.currentTimeMillis();`

***

### BigDecimal类

`float`、`double`两种基本浮点类型的浮点数容易引起**精度丢失**。

为了**精确**表示、计算浮点数，Java提供了`BigDecimal`类，该类提供了大量的构造器用于创建BigDecimal对象，包括把所有的基本数值类型变量转换成一个BigDecimal对象，包括利用数字字符串、数字字符数组来创建BigDecimal对象。

不推荐使用`BigDecimal(double val);`构造器来创建对象，而是`BigDecimal(String val);`或`BigDecimal.valueOf(double value);`静态方法来创建BigDecimal对象。

BigDecimal类提供了`add()`、`subtract()`、`multiply()`、`divide()`、`pow()`等方法对精确浮点数进行常规算术运算。

***

### 日期、时间类

#### Date类

Java提供了`Date`类来处理日期、时间，Date对象既包含日期，也包含时间。

Date类从JDK1.0起就开始存在了，但正因为它历史悠久，所以它的大部分构造器、方法都已经~~过时~~，不在推荐使用了。

Date类提供了6个构造器，其中4个已经`Deprecated`(Java不在推荐使用，使用不再推荐的构造器时编译会提出警告信息，并导致程序性能、安全性能等方面的问题），剩下的两个构造器：
  - `Date()`:生成一个代表当前日期时间的Date对象。该构造器在底层调用`System.currentMillis()`获得`long`整数作为日期参数。
  - `Date(long date)`:根据指定的`long`型整数来生成一个Date对象。该构造器的参数表示创建的Date对象和GMT1970年1月1日00:00:00之间的时间差，以毫秒作为计时单位。

Date对象的大部分方法也`Deprecated`了，剩下为数不多的几个方法：
  - `boolean after(Date when)`:测试该日期是否在指定日期when之后。
  - `boolean before(Date when)`:测试该日期是否在指定日期when之前。
  - `long getTime()`:返回该时间对应的long型整数，即从GMT1970-01-01 00:00:00到该Date对象之间的时间差，以毫秒作为计时单位。
  - `void setTime(long time)`:设置Date对象的时间。

总体来说，Date是一个设计相当糟糕的类，Java官方推荐尽量少用Date的构造器和方法。

#### Calendar类

由于`Date`类在设计上存在一些缺陷，所以Java提供了`Calendar`类来更好地处理日期和时间。

`Calendar`类本身是一个**抽象类**，它是所有日历类的**模板**，并提供了一些所有日历**通用**的方法；但它本身不能直接实例化，程序只能创建`Calendar`子类的实例，Java本身提供了一个`GregorianCalendar`类，一个代表**格里高利日历**的子类，它代表了通常所说的**公历**。

`Calendar`类是一个抽象类，所以不能使用构造器来创建Calendar对象。但它提供了几个**静态**`getInstance()`方法来获取`Calendar`对象，这些方法根据`TimeZone`、`Locale`类来获取特定的`Calendar`，如果不指定`TimeZone`、`Locale`，则使用默认的`TimeZone`、`Locale`来创建`Calendar`。

`Calendar`和`Date`都是表示日期的工具类，他们直接可以**自由转换**。

Calendar类提供了大量**访问**、**修改**日期时间的方法：
  - `void add(int field, int amount)`:根据日历的规则，为给定的日历字段添加或减去指定的时间量。
  - `int get(int field)`:返回指定日历字段的值。
  - `int getActualMaximum(int field)`:返回指定日历字段可能拥有的最大值。
  - `int getActualMinimum(int field)`:返回指定日历字段可能拥有的最小值。
  - `void set(int field, int value)`:为给定的日历字段设置为给定值。
  - `void set(int year, int month, int date)`:设置Calendar对象的年、月、日三个字段的值。
  - `void set(int year, int month, int date, int hourOfDay, int minute, int second)`:设置Calendar对象的年、月、日、时、分、秒6个字段的值。
	

上面的很多方法都需要一个`int`类型的`field`参数，`field`是`Cakendar`类的**类变量**，如`Calendar.YEAR`、`Calendar.MONTH`等分别代表了年、月、日、小时、分钟、秒等时间字段。

`Calendar.MONTH`字段代表月份，月份的**起始值**不是1，而是0。

Calendar类的**注意点**：

1. `add`与`roll`的**区别**
    - `add(int field, int amount)`的功能非常强大，`add`主要用于改变`Calendar`的特定字段的值。有两条规则：
      - 当被修改的字段超出它允许的范围时，会发生**进位**，即上一级字段也会增大。
      - 如果下一级字段也需要改变，那么该字段会修正到变化**最小**的值。
    - `roll()`的规则与`add()`的处理规则不同：当被修改的字段**超出**它允许的**范围**时，上一级字段**不会增大**；下一级字段的处理规则与`add()`相似。
2. 设置`Calendar`的**容错性**
    - Calendar有两种解释日历字段的模式：`lenient`模式和`non-lenient`模式。当处于`lenient`模式时，每个时间字段可**接受**超过它允许范围的值；当处于`non-lenient`模式时，如果为某个时间字段设置的值超出了它允许的取值范围，程序将会**抛出异常**。
3. `set()`方法**延迟修改**
    - `set(f, value)`方法将日历字段`f`更改为`value`，此处它还设置了一个**内部成员变量**，以**指示**日历字段`f`已经被更改。尽管日历字段`f`是**立即更改**的，但该`Calendar`所代表的时间**不会**立即修改，直到下次调用`get()`、`getTime()`、`getTimeInMillis()`、`add()`或`roll()`时才会**重新计算**日历的时间。

***

### Java8新增的日期、时间包

Java8新增了一个java.time包，该包包含如下常用类：

- `Clock`:该类用于获取**指定时区**的当前日期、时间。该类可取代System类的currentTimeMillis()方法，而且提供了更多方法来获取当前日期、时间。该类提供了大量静态方法来获取`Clock`对象。
- `Duration`:该类代表**持续时间**。该类可以非常方便地获取一段时间。
- `Instant`:代表一个具体的**时刻**，可以精确到纳秒。该类提供了静态的`now()`方法来获取**当前时刻**，也提供了静态的`now(Clock clock)`方法来获取`clock`对应的时刻。除此之外，它还提供了一系列`minusXxx()`方法在当前时刻基础上减去一段时间，也提供了`plusXxx()`方法在当前时刻基础上加上一段时间。
- `LocalDate`:该类代表不带时区的**日期**，例如1999-10-30。该类提供了静态的`now()`方法来获取当前日期，也提供了静态的`now(Clock clock)`方法来获取当前`clock`对应的日期。除此之外，它还提供了一系列`minusXxx()`方法在当前年份基础上减去几年、几月、几周或几日，也提供了`plusXxx()`方法在当前年份基础上加上几年、几月、几周或几日。
- `LocalTime`:该类代表不带时区的**时间**，例如10:30:13。该类提供了静态的`now()`方法来获取当前时间，也提供了静态的`now(Clock clock)`方法来获取`clock`对应的时间。除此之外，它还提供了一系列`minusXxx()`方法在当前年份基础上减去几小时、几分、几秒等，也提供了`plusXxx()`方法在当前年份基础上加上加几小时、几分、几秒等。
- `LocalDateTime`:该类代表不带时区的**日期、时间**，例如1999-10-30T10:30:13。该类提供了静态的`now()`方法来获取当前日期、时间，也提供了静态的`now(Clock clock)`方法来获取`clock`对应的日期、时间。除此之外，它还提供了一系列`minusXxx()`方法在当前年份基础上减去几年、几月、几日几小时、几分、几秒等，也提供了`plusXxx()`方法在当前年份基础上加上几年、几月、几日几小时、几分、几秒等。
- `MonthDay`:该类仅代表**月日**，例如--10-30。该类提供了静态的`now()`方法来获取当前月日，也提供了静态的`now(Clock clock)`方法来获取`clock`对应的月日。
- `Year`:该类仅代表**年**，例如1999。该类提供了静态的`now()`方法来获取当前年份，也提供了静态的`now(Clock clock)`方法来获取`clock`对应的年份。除此之外，它还提供了`minusYears()`方法在当前年份基础上减去几年，也提供了`plusYear()`方法在当前年份基础上加上几年。
- `YearMonth`:该类仅代表**年月**，例如1999-10。该类提供了静态的`now()`方法来获取当前年月，也提供了静态的`now(Clock clock)`方法来获取`clock`对应的年月。除此之外，它还提供了`minusXxx()`方法在当前年月基础上减去几年、几月，也提供了`plusXxx()`方法在当前年月基础上加上几年、几月。
	- `ZonedDateTime`:该类代表一个**时区化**的日期、时间。
	- `ZoneId`:该类代表一个**时区**。
	- `DayOfWeek`:这是一个**枚举类**，定义了周日到周六的枚举值。
	- `Month`:这是一个**枚举类**，定义了一月到十二月的枚举值。

***

### 正则表达式

正则表达式是一个强大的**字符串处理工具**，可以对字符串进行**查找、提取、分割、替换**等操作。

`String`类里也提供了如下几个**特殊方法**：

- `boolean matches(String regex)`:判断该字符串**是否匹配**指定的正则表达式。
- `String replaceAll(String regex, String replacement)`:将该字符串中所有匹配`regex`的字串**替换**成`replacement`。
- `String repalceFirst(String regex, String replacement)`:将该字符串中第一个匹配`regex`的字串**替换**成`replacement`。
- `String[] split(String regex)`:以`regex`作为分隔符，把该字符串**分割**成多个字串。

上面这些特殊的方法都依赖于Java提供的正则表达式支持，除此之外，Java还提供了`Pattern`和`Matches`两个类专门用于提供正则表达式支持。

**创建正则表达式**

正则表达式所支持的**合法字符**：

- `x`:字符x(x可代表**任何**合法的字符)
- `\0mnn`:**八进制**数0mnn所代表的字符
- `\xhh`:**十六进制**值0xhh所代表的字符
- `\uhhhh`:**十六进制**值0xhhhh所代表的`Unicode`字符
- `\t`:制表符('\u000A')
- `\n`:新行(换行)符('\u000A')
- `\r`:回车符('\u000D')
- `\f`:换页符('\u000C')
- `\a`:报警(bell)符('\u0007')
- `\e`:Escape符('\u001B')
- `\cx`:`x`对应的控制符。x值必须为`A~Z`或`a~z`之一。

正则表达式中有一些**特殊字符**，这些特殊字符在正则表达式中有其特殊的用途，如果需要匹配这些特殊字符，就必须首先将这些字符**转义**，也就是在前面加一个反斜线(`\`)。

- `$`:匹配一行的结尾。
- `^`:匹配一行的开头。
- `()`:标记子表达式的开始和结束位置。
- `[]`:用于确定中括号表达式的开始和结束位置。
- `{}`:用于标记前面子表达式的出现频度。
- `*`:指定前面子表达式可以出现零次或多次，
- `+`:指定前面表达式可以出现一次或多次。
- `?`:指定前面子表达式可以出现零次或一次。
- `\`:用于转义下一个字符，或指定八进制、十六进制字符。
- `|`:指定两项之间任选一项。

**预定义字符**

- `.`:可以匹配任何字符。
- `\d`:匹配`0~9`的所有数字。
- `\D`:匹配非数字。
- `\s`:匹配所有的空白字符，包括空格、制表符、回车符、换页符、换行符等。
- `\S`:匹配所有的非空白字符。
- `\w`:匹配所有的单词字符，包括0~9所有数字、26个英文字母和下划线(_)。
- `\W`:匹配所有的非单词字符。

**方括号表达式**

- 表示枚举:例如`[fx]`,表示f、x其中任意一个字符;`[jk]`表示j、x其中任意一个字符。
- 表示范围-:例如`[a-f]`,表示`a~f`范围内的任意字符；如`[a-cx-z]`,表示`a~c`、`x~z`范围内的任意字符。
- 表示求否`^`:例如`[^abc]`,表示非a、b、c的任意字符；`[^a-f]`,表示不是`a~f`范围内的任意字符。
- 表示与运算`&&`:例如`[a-z&&[def]]`,求`a~z`和`[def]`的交集，表示d、e或f;`[a-z&&[^bc]]`,`a~z`范围内的所有字符，除b和c之外，即`[ad-z]`。
- 表示并运算:并运算与前面的枚举类似。例如`[a-d[m-p]]`,表示`[a-dm-p]`。

**边界匹配符**
	
- `^`:行的开头
- `$`:行的结尾
- `\b`:单词的边界
- `\B`:非单词的边界
- `\A`:输入的开头
- `\G`:前一个匹配的结尾
- `\Z`:输入的结尾，仅用于最后的结束符。
- `\z`:输入的结尾

**数量标识符**

- `Greedy`(**贪婪模式**):数量标识符**默认**采用贪婪模式，除非另有表示。贪婪模式的表达式会一直匹配下去，直到无法匹配为止。
  - `X?`:X表达式出现零次或一次
  - `X*`:X表达式出现零次或多次
  - `X+`:X表达式出现一次或多次
  - `X{n}`:X表达式出现n次
  - `X{n,}`:X表达式最少出现n次
  - `X{n,m}`:X表达式最少出现n次，最多出现m次
- `Reluctant`(**勉强模式**):用问号后缀(`?`)表示，它只会匹配最少的字符。也称为**最小匹配**模式。
  - `X??`:X表达式出现零次或一次
  - `X*?`:X表达式出现零次或多次
  - `X+?`:X表达式出现一次或多次
  - `X{n}?`:X表达式出现n次
  - `X{n,}?`:X表达式最少出现n次
  - `X{n,m}?`:X表达式最少出现n次，最多出现m次
- `Possessive`(**占有模式**):用加号后缀(`+`)表示，目前只有Java支持占有模式，通常比较少用。
  - `X?+`:X表达式出现零次或一次
  - `X*+`:X表达式出现零次或多次
  - `X++`:X表达式出现一次或多次
  - `X{n}+`:X表达式出现n次
  - `X{n,}+`:X表达式最少出现n次
  - `X{n,m}+`:X表达式最少出现n次，最多出现m次

**使用正则表达式**

一旦在程序中定义了正则表达式，就可以使用`Pattern`和`Matcher`来使用正则表达式。

`Pattern`对象是正则表达式**编译后**在内存中的**表示形式**，因此，正则表达式字符串必须**先被编译为Pattern对象**，然后再利用Pattern对象创建对应的`Matcher`对象。执行匹配所涉及的状态**保留**在`Matcher`对象中，多个`Matcher`对象可共享同一个`Pattern`对象。

如果某个正则表达式仅需一次使用，则可直接使用Pattern类的静态`matches()`方法，此方法自动把指定字符串编译成**匿名**`Pattern`对象，并执行匹配。

Pattern是**不可变类**，可供多个并发线程安全使用。

`Matcher`类提供了如下几个常用方法：

- `find()`:返回目标字符串中是否包含与`Pattern`匹配的子串。
- `group()`:返回上一次与`Pattern`匹配的子串。
- `start()`:返回上一次与`Pattern`匹配的子串在目标字符串中的开始位置。
- `end()`:返回上一次与`Pattern`匹配的子串在目标字符串中的结束位置加1。
- `lookingAt()`:返回目标字符串前面部分与`Pattern`是否匹配。
- `matches()`:返回整个目标字符串与`Pattern`是否匹配。
- `reset()`:将现有的`Matcher`对象应用于一个新的字符序列。

通过`Matcher`类的`find()`和`group()`方法可以从目标字符串中**依次取出**特定子串（匹配正则表达式的子串）。

`find()`方法依次查找字符串中与`Pattern`匹配的子串，一旦找到对应的子串，下次调用`find()`方法时将接着向下查找。

`find()`方法还可以传入一个`int`类型的参数，带`int`参数的`find()`方法将从该`int`索引处向下搜索。`start()`和`end()`方法主要用于确定子串在目标字符串中的位置。

使用`find()`、`group()`方法逐项取出目标字符串中与指定正则表达式匹配的子串，并使用`start()`、`end()`方法返回子串在目标字符串中的位置。

`matches()`和`lookingAt()`方法有点相似，只是`matches()`方法要求**整个字符串**和`Pattern`**完全匹配**时才返回`true`，而`lookingAt()`只要字符串以`Pattern`开头就会返回`true`。`reset()`方法可将现有的`Matcher`对象应用于新的字符序列。

从某个角度看，`Matcher`的`matches()`、`lookingAt()`和`String`类的`equals()`、`startWith()`有点相似。区别是`String`类的`equals()`和、`startWith()`都是与字符串进行比较，而`Matcher`的`matches()`和`lookingAt()`则是与正则表达式进行匹配。

`String`类里也提供了`matches()`方法，该方法返回该字符串是否匹配指定的正则表达式。

还可以利用正则表达式对目标字符串进行**分割、查找、替换**等操作。

`Matcher`类提供了`replaceAll(String replacement)`把字符串中所有与正则表达式匹配的子串替换成`replacement`，还提供了一个`replaceFirst(String replacement)`方法，该方法仅替换**第一个**匹配的子串。

`String`类也提供了`replaceAll()`、`replaceFirst()`、`split()`等方法。

***

### 变量处理和方法处理

Java9引入了一个新的`VarHandle`类，并增强了原有的`MethodHandle`类。通过这两个类，允许Java像**动态语言**一样引用变量、饮用方法，并调用它们。

Java9增强的`MethodHandle`

- `MethodHandle`为Java增强了**方法引用**的功能，方法引用的概念有点类似于C的**函数指针**。这种方法引用是一种轻量级的引用方式，它不会检查方法的访问权限，也不管方法所属的类、实例方法或静态方法，`MethodHandle`就是**简单代表**特定的方法，并可通过`MethodHandle`来**调用方**法。
- 为了使用`MethodHandle`类，还涉及如以下几个类：
  - `MethodHandles`:`MethodHandle`的**工厂类**，它提供了一系列静态方法用于获取`MethodHandle`。
  - `MethodHandles.Lookup`:`Lookup`**静态内部类**也是`MethodHandle`、`VarHandle`的**工厂类**，专门用于获取`MethodHandle`和`VarHandle`。
  - `MethodType`:代表一个**方法类型**。`MethodType`根据方法的形参、返回值类型来确定方法类型。
  - 程序使用`MethodHandles.Lookup`对象根据类、方法名、方法类型来获取`MethodHandle`对象。获取的方法名是一个**字符串类型**，这意味着通过`MethodHandle`可以让Java**动态调用**某个方法。

Java9增强的`VarHandle`

- `VarHandle`主要用于**动态操作**数组的元素或对象的成员变量。`VarHandle`和`MethodHandle`非常相似，它也需要通过`MethodHandles`来获取实例，接下来调用`VarHandle`的方法即可**动态操作**指定**数组**的元素或指定**对象**的成员变量。

***

### Java9改进的国际化与格式化

国际化是指应用程序运行时，可根据客户端请求来自的国家/地区、语言的不同而显示不同的界面。

#### Java国际化的思路：

- Java程序的国际化思路是将程序中的标签、提示等信息放在**资源文件**中，程序需要支持哪些国家、语言环境，就对应提供的资源文件。
- 资源文件是`key-value`对，每个资源文件中的`key`是不变的，但`value`则随不同的国家、语言而改变。
- Java程序的国际化主要是通过如下三个类完成：
  - `java.util.ResourceBundle`:用于加载国家、语言资源包。
  - `java.util.Locale`:用于封装特定的国家/区域、语言环境。
  - `java.text.MessageFormat`:用于格式化带占位符的字符串。
- 资源文件的**命名**可以有如下三种形式：
  - `baseName_language_country.properties`
  - `baseName_language.properties`
  - `baseName.properties`
- 其中`baseName`是资源文件的基本名，用户可随意指定；而`language`和`country`都不可随意变化，必须是Java所支持的语言和国家。

#### Java支持的国家和语言：

- 可调用`Locale`类的`getAvailableLocales()`方法，该方法返回一个`Locale`数组，该数组包含了Java所支持的国家和语言。

#### 完成程序国际化：

  - 为了让字符串常量可以改变，可以将需要输出的各种字符串（不同的国家/语言环境对应不同的字符串）定义在**资源包**中。
  - Java9支持使用`UTF-8`字符集来保存属性文件，这样在属性文件中就可以直接包含非西欧字符。
  - Java9程序国际化的关键类是`ResourceBundle`，它有一个静态方法：`getBUndle(String baseName, Locale locale)`,该方法将根据`Locale`加载资源文件，而`Locale`封装了一个国家、语言。

使用`MessageFormat`处理包含占位符的字符串：

- 如果需要输出的消息中必须包含动态的内容，可以使用带**占位符**的消息。
- 例如：`msg=你好！{0}!今天是{1}`。当程序使用`ResourceBundle`的`getString()`方法来取出`msg`对应的字符串时，程序还需要为`{0}`和`{1}`两个**占位符**赋值。
- 此时需要使用`MessageFormat`类，该类包含一个有用的静态方法：
  - `format(String pattern, Object... values)`:返回后面的多个参数值填充前面的`pattern`字符串，其中`patter`不是正则表达式，而是一个带占位符的字符串。

#### 使用类文件代替资源文件：

除使用属性文件作为资源文件外，`Java`也允许使用类文件代替资源文件，即将所有的`key-value`对存入`class`文件。

使用类文件来代替资源文件必须满足以下条件：

- 该类的类名必须是`baseName_language_country`,这与属性文件的命名相似。
- 该类必须继承`ListResourceBundle`,并重写`getContents()`方法，该方法返回`Object`数组，该数组的每一项都是`key-value`对。

如果系统同时存在资源文件、类文件，系统将以类文件为主，而不会调用资源文件。

对于简体中文的`Locale`，`ResourceBundle`搜索资源文件的顺序是：
- `baseName_zh_CN.class`
- `baseName_zh_CN.properties`
- `baseName_zh.class`
- `baseName_zh.properties`
- `baseName.class`
- `baseName.properties`

#### Java9新增的日志API

Java9强化了原有的日志API，这套日志API只是定义了记录消息的最小API，开发者可将这些日志消息路由到各种主流的日志框架（如`SLF4J`、`Log4J`等），否则默认使用Java传统的`java.util.logging`日志`API`。

这套日志API的用法非常简单，只要两步即可：

- 调用`System`类的`getLogger(String name)`方法获取`System.Logger`对象
- 调用`System.Logger`对象的`log()`方法输出日志。该方法的第一个参数用于指定**日志级别**。
  - 日志级别：
    - Java9日志级别
      - `ALL`:最低级别，系统将会输出所有**日志信息**。
      - `TRACE`:输出系统的各种**跟踪信息**。
      - `DEBUG`:输出系统的各种**调试信息**。
      - `INFO`:输出系统内需要提示用户的**提示信息**。
      - `WARNING`:只输出系统内警告用户的**警告信息**。
      - `ERROR`:只输出系统发生错误的**错误信息**。
      - `OFF`:关闭日志输出。
    - 传统日志级别
      - `ALL`:最低级别，系统将会输出所有**日志信息**。
      - `FINER`:输出系统的各种**跟踪信息**。
      - `FINE`:输出系统的各种**调试信息**。
      - `INFO`:输出系统内需要提示用户的**提示信息**。
      - `WARNING`:只输出系统内警告用户的**警告信息**。
      - `SERVRE`:只输出系统发生错误的**错误信息**。
      - `OFF`:关闭日志输出。

Java9的日志API也支持国际化，`System`类除使用简单的`getLogger(String name)`方法获取`System.Logger`对象之外，还可使用`getLogger(String name, ResourceBundle bundle)`方法来获取该对象，该方法需要传入一个国际化语言资源包，这样该`Logger`对象即可根据`key`来输出国际化的日志信息。

#### 使用`NumberFormat`格式化数字

`MessageFormat`是抽象类`Format`的子类，`Format`抽象类还有两个子类:`NumberFormat`和`DateFormat`,它们分别用以实现**数值**、**日期**的格式化。`NumberFormat`、`DateFormat`可以将数值、日期转换成字符串，也可以将字符串转换成数值、日期。

`NumberFormat`和`DateFormat`都包含了`format()`和`parse()`方法，其中`format()`用于将数值、日期格式化成字符串，`parse()`用于将字符串解析成数值、日期。

`NumberFormat`也是一个抽象基类，所以无法通过它的构造器来创建`NumberFormat`对象，它提供了如下几个类方法来得到`NumberFormat`对象：

- `getCurrencyInstance()`:返回默认`Locale`的**货币格式器**。也可以在调用该方法时传入指定的`Locale`，则获取指定`Locale`的货币格式器。
- `getIntegerInstance()`:返回默认`Locale`的**整数格式器**。也可以在调用该方法时传入指定的`Locale`，则获取指定`Locale`的整数格式器。
- `getNumberInstance()`:返回默认`Locale`的通用**数值格式器**。也可以在调用该方法时传入指定的`Locale`，则获取指定的`Locale`的通用数值格式器。
- `getPercentInstance()`:返回默认的`Locale`的**百分数格式器**。也可以在调用该方法时传入指定的`Locale`，则获取指定的`Locale`的百分数格式器。

一旦获得了`NumberFormat`对象后，就可以调用它的`format()`方法来格式化数值，包括整数和浮点数。

#### 使用`DateFormat`格式化日期、时间

- 与`NumberFormat`相似的是，`DateFormat`也是一个**抽象类**，它也提供了如下几个类方法用于获取`DateFormat`对象：
  - `getDateInstance()`:返回一个**日期格式器**，它格式化后的字符串只有日期，没有时间。该方法可以传入多个参数，用于指定日期样式和`Locale`等参数；如果不指定这些参数，则使用默认参数。
  - `getTimeInstance()`:返回一个**时间格式器**，它格式化后的字符串只有时间，没有日期。该方法可以传入多个参数，用于指定时间样式和`Locale`等参数；如果不指定这些参数，则使用默认参数。
  - `getDateTimeInstance()`:返回一个**日期、时间格式器**，它格式化后的字符串既有日期，也有时间。该方法可以传入多个参数，用于指定日期样式、时间样式和`Locale`等参数；如果不指定这些参数，则使用默认参数。

上面三个方法可以指定日期样式、时间**样式参数**，它们是`DateFormat`的4个静态常量:`FULL`、`LONG`、`MEDIUM`和`SHORT`，通过这4个样式参数可以控制生成的格式化字符串。

`DateFormat`的`parse()`方法可以把一个字符串**解析**成`Date`对象，但它要求被解析的字符串必须符合日期字符串的要求，否则可能抛出`ParseException`异常。

#### 使用`SimpleDateFormat`格式化日期

`DateFormat`的`parse()`方法可以把字符串解析成`Date`对象，但`parse()`方法不够灵活，它要求被解析的字符串必须满足特定的格式；为了更好地格式化日期、解析日期字符串，Java提供了`SimpleDateFormat`类。

  - `SimpleDateFormat`是`DateFormat`的子类。
  - `SimpleDateFormat`可以非常灵活地格式化`Date`，也可以用于解析各种格式的日期字符串。创建`SimpleDateFormat`对象时需要传入一个`pattern`字符串，这个`pattern`不是正则表达式，而是一个日期模板字符串。

***

### Java8新增的日期、时间格式器

`java.time.format`包下提供了一个`DateTimeFormatter`格式器类，该类相当于`DateFormat`和`SimpleDateFormat`的合体。

`DateTimeFormatter`不仅可以将日期、时间对象格式化成字符串，也可以将特定格式的字符串解析成日期、时间对象。

为了使用`DateTimeFormatter`进行格式化或解析，必须先获取`DateTimeFormatter`对象，获取对象有如下三种常见的方式：

- 直接使用**静态常量**创建`DateTimeFormatter`格式器。`DateTimeFormatter`类中包含了大量形如`ISO_LOCAL_DATE`、`ISO_LOCAL_TIME`、`ISO_LOCAL_DATE_TIME`等静态常量，这些静态常量本身就是`DateTimeFormatter`实例。
- 使用代表不同风格的**枚举值**来创建`DateTimeFormatter`格式器。在`FormatStyle`**枚举类**中定义了`FULL`、`LONG`、`MEDIUM`、`SHORT`四个**枚举值**，它们代表日期、时间不同的风格。
- 根据**模式字符串**来创建`DateTimeFormatter`格式器。类似于`SimpleDateFormat`，可以采用模式字符串来创建`DateTimeFormatter`。

#### 使用DateTimeFormatter完成格式化

使用`DateTimeFormatter`将日期、时间(`LocalDate`、`LocalDateTime`、`LocalTime`等实例)格式化为字符串，可通过如下两种方式：

- 调用`DateTimeFormatter`的`format(TemporalAccessor temporal)`方法执行格式化，其中`LocalDate`、`LocalDateTime`、`LocalTime`类都是`TemporalAccessor`接口的**实现类**。
- 调用`LocalDate`、`LocalDateTime`、`LocalTime`等日期、时间对象的`format(DateTimeFormatter formatter)`方法执行格式化。

`DateTimeFormatter`则提供了一个`toFormat()`方法，该方法可获取`DateTimeFormatter`对应的`Format`对象。

#### 使用DateTimeFormatter解析字符串

使`DateTimeFormatter`将指定格式的字符串解析成日期、时间对象(`LocalDate`、`LocalDateTime`、`LocalTime`等实例)，可通过日期、时间对象提供的`parse(CharSequence text, DateTimeFormatter formatter)`方法进行解析。

