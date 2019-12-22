# Java集合

## Java集合概述

为了保存数量不确定的数据，以及保存具有映射关系的数据（也被称为**关联数组**），Java提供了**集合类**。集合类主要负责保存、盛装其他数据，因此集合类也被称为**容器类**。

集合和数组不一样，数组元素既可以是基本类型的值，也可以是对象（实际上保存的是对象的引用变量）；而集合里只能保存**对象**（实际上只是保存对象的引用变量）。

Java的集合类主要由两个接口派生而出：**Collection**和**Map**，Collection和Map是Java集合框架的**根接口**，这两个接口又包含了一些子接口或实现类。

**Set**和**List**接口是**Collection**接口派生出的两个子接口，它们分别代表了**无序集合**和**有序集合**；**Queue**是java提供的**队列**实现，类似于List。

Map实现类用于保存具有**映射关系**的数据（**关联数组**）；Map保存的每项数据都是`key-value`对；Map里的key是不可重复的，key用于标识集合里的每项数据。

### 可以把Java所有集合分成三大类

- `Set`：把一个对象添加到Set集合时，Set集合无法记住添加这个元素的顺序，所以Set里的元素**不能重复**。
- `List`：非常像一个数组，它可以记住每次添加元素的顺序、且List的长度可变。
- `Map`：也像一个罐子，只是它里面的每项数据都由两个值组成。

## Collection和Iterator接口

Collection接口是List、Set和Queue接口的父接口，该接口里定义的方法既可以用于操作Set集合，也可用于操作List和Queue集合。

Collection接口里定义了如下操作集合元素的方法：

- `boolean add(Object o)`:该方法用于向集合里添加一个元素。如果集合对象被添加操作改变了，则返回true。
- `boolean addAll(Collection c)`:该方法把集合c里的所有元素添加到指定集合里。如果集合对象被添加操作改变了，则返回true。
- `void clear()`:清除集合里的所有元素，将集合长度变为0.
- `boolean contains(Object o)`:返回集合里是否包含指定元素。
- `boolean containsAll(Collection c)`:返回集合里是否包含集合c里的所有元素。
- `boolean isEmpty()`:返回集合是否为空。当集合长度为0时返回true，否则返回false。
- `Iterator iterator()`:返回一个Iterator对象，用于遍历集合里的元素。
- `boolean remove(Object o)`:删除集合中指定元素o，当集合中包含了一个或多个元素o时，该方法只删除第一个符合条件的元素，该方法将返回true。
- `boolean removeAll(Collection c)`:从集合中删除集合c里包含的所有元素（相当于调用该方法的集合减集合c），如果删除了一个或一个以上的元素，则该方法返回true。
- `boolean retainAll(Collection c)`:从集合中删除集合c里不包含的元素（相当于把调用该方法的集合变成该集合和集合c的交集），如果该操作改变了调用该方法的集合，则该方法返回true。
- `int size()`:该方法返回集合里元素的个数。
- `Object[] toArray()`:该方法把集合转换成一个数组，所有的集合元素变成对应的数组元素。

### 使用Lambda表达式遍历集合

Java8为Iterable接口新增了一个`forEach(Consumer action)`默认方法，该方法所需参数的类型是一个**函数式接口**，而Iterable接口是Collection接口的父接口，因此Collection集合也可直接调用该方法。

当程序调用Iterable的`forEach(Consumer action)`遍历集合时，程序会依次将集合元素传给Consumer的`accept(T t)`方法（该接口中唯一的抽象方法）。正因为Consumer是函数式接口，因此可以使用Lambda表达式来遍历集合元素。

### 使用Java8增强的Iterator遍历集合元素

Iterator接口也是Java集合框架的成员，但它与Collection系列、Map系列的集合不一样：Collection系列集合、Map系列集合主要用于盛装其他对象，而Iterator则主要用于**遍历（即迭代访问）**Collection集合中的元素，Iterator对象也被称为**迭代器**。

Iterator接口隐藏了各种Collection实现类的底层细节，向应用程序提供了遍历Collection集合元素的统一编程接口。

Iterator接口里定义了如下4个方法：

- `boolean hasNext()`:如果被迭代的集合元素还没有被遍历完，则返回true。
- `Object next()`:返回集合里的下一个元素。
- `void remove()`:删除集合里的上一次next方法返回的元素。
- `void forEachRemainning(Consumer action)`:这是Java8为Iterator新增的默认方法，该方法可使用Lambda表达式来遍历集合元素。

Iterator必须依附于Collection对象，若有一个Iterator对象，则必然有一个与之关联的Collection对象。

当使用Iterato迭代访问Collection集合时，Collection集合里的元素不能被改变，只能通过Iterator的`remove()`方法删除上一次`next()`方法返回的集合元素才可以；否则将会引发`java.util.ConcurrentModificationException`异常。

Iterator迭代器采用的是**快速失败（fail-fast）**机制，一旦在迭代过程中检测到该集合已经被修改（通常是程序中的其他线程修改），程序立即引发`ConcurrentModificationException`异常，而不是显示修改后的结果，这样可以避免共享资源而引发的潜在问题。

### 使用Lambda表达式遍历Iterator

Java8起为Iterator接口新增了一个`forEachRemaining(Consumer action)`方法，该方法所需的Consumer参数同样也是函数式接口。当程序调用Iterator的`forEachRemaining(Consumer action)`遍历集合元素时，程序会依次将集合元素传给Consumer的`accept(T t)`方法（该接口中唯一的抽象方法）。

### 使用foreach循环遍历集合元素

除可以使用Iterator接口迭代访问Collection集合里的元素之外，使用Java5提供的foreach循环迭代访问集合元素更加便捷。

与使用Ierator接口迭代访问集合元素类似的是，foreach循环中的迭代变量也不是集合元素本身，系统只是依次把集合元素的值赋给迭代变量。

同样，当使用foreach循环迭代访问集合元素时，该集合也不能被改变，否则将引发`ConcurrentModificationException`异常。

### 使用Java8新增的Predicate操作集合

Java8起为Collection集合新增了一个`removeIf(Predicate filter)`方法，该方法将会批量删除符合filter条件的所有元素。该方法需要一个Predicate**谓词**对象作为参数，Predicate也是**函数式接口**，因此可使用Lambda表达式作为参数。

### 使用Java8新增的Stream操作集合

Java8还新增了Stream、IntStream、LongStream、DoubleStream等**流式API**，这些API代表多个支持**串行和并行聚集操作**的元素。Stream是一个通用的**流接口**，而IntStream、LongStream、DoubleStream则代表元素为int、long、double的流。

Java8还为上面的每个流式API提供了对应的Builder，例如Stream.Builder、IntStream.Builder、LongStream.Builder、DoubleStream.Builder，开发者可以通过这些Builder来创建对应的流。

独立使用Stream的步骤如下：

1. 使用Stream或XxxStream的`builder()`类方法创建该Stream对应Builder。
2. 重复调用Builder的add()方法向该流中添加多个元素。
3. 调用Builder的build()方法获取对应的Stream。
4. 调用Stream的聚集方法。

Stream提供了大量的方法进行聚集操作，这些方法既可以是**中间的（intermediate）**，也可以是**末端的（terminal）**。

中间方法：中间操作允许流保持打开状态，并允许直接调用后继方法。

末端方法：末端方法是对流的最终操作。当某个Stream执行末端方法后，该流将会被**消耗**且不可再用。

除此之外，关于流的方法好有如下两个特征：

- 有状态的方法：这种方法会给流增加一些新的属性，比如元素的唯一性、元素的最大数量、保证元素以排序的方式被处理等。有状态的方法往往需要更大的性能开销。
- 短路方法：短路方法可以尽早结束对流的操作，不必检查所有的元素。

Stream常用的**中间方法**：

- `filter(Predicate predicate)`:过滤Stream中所有不符合predicate的元素。
- `mapToXxx(ToXxxFunction mapper)`:使用ToXxxFunction对流中的元素执行一对一的转换，该方法返回新流中包含了ToXxxFunction转换生成的所有元素。
- `peek(Consumer action)`:依次对每个元素执行一些操作，该方法返回的流与原有流包含相同的元素。该方法主要用于调试。
- `distinct()`:该方法用于排序流中所有重复的元素（判断元素重复的标准是使用`equals()`比较返回true)。这是一个有状态的方法。
- `sorted()`:该方法用于保证流中的元素在后继的访问中处于有序状态。这是一个有状态的方法。
- `limit(long maxSize)`:该方法用于保证对该流的后继访问中最大允许访问的元素个数。这是一个有状态的、短路方法。

Stream常用的**末端方法**：

- `forEach(Consumer action)`:遍历流中所有元素，对每个元素执行action。
- `toArray()`:将流中所有元素转换为一个数组。
- `reduce()`:该方法有三个重载的版本，都用于通过某种操作来合并流中的元素。
- `max()`:返回流中所有元素的最大值。
- `count()`:返回流中所有元素的数量。
- `anyMatch(Predicate predicate)`:判断流中是否至少包含一个元素符合Predicate条件。
- `allMatch(Predicate predicate)`:判断流中是否每个元素都符合Predicate条件。
- `noneMatch(Predicate predicate)`:判断流中是否所有元素都不符合Predicate条件。
- `findFirst()`:返回流中的第一个元素。
- `findAny()`:返回流中的任意一个元素。

Java8允许使用**流式API**来操作集合，Collection接口提供了一个`stream()`默认方法，该方法返回该集合对应的流，接下来就即可通过流式API来操作集合元素。由于Stream可以对集合元素进行整体的**聚集操作**，因此Stream极大地丰富了集合的功能。

## Set集合

Set集合与Collection基本相同，没有提供任何额外的方法。实际上Set就是Collection，只是行为略有不同（Set不允许包含重复元素）。

Set集合不允许包含相同的元素，如果试图把两个相同的元素加入同一个Set集合中，则添加操作失败，add()方法返回false，且新元素不会被加入。

### HashSet类

HashSet是Set接口的典型实现，大多数时候使用Set集合时就是使用这个实现类。HashSet按Hash算法来存储集合中的元素，因此具有很好的存取和查找性能。

HashSet具有以下特点：

- 不能保证元素的排列顺序，顺序可能与添加顺序不同，顺序也有可能发生变化。
- HashSet是**不同步**的，如果多个线程同时访问一个HashSet，假设有两个或两个以上线程同时修改了HashSet集合时，则必须通过代码来保证其同步。
- 集合元素值可以是null。

当向HashSet集合中存入一个元素时，HashSet会调用该对象的`hashCode()`方法来得到该对象的hashCode值，然后根据该hashCode值决定该对象在HashSet中的存储位置。

如果两个元素通过`equals()`方法比较返回true，但它们的`hashCode()`方法返回值不相等，HashSet将会把它们存储到不同的位置，依然可以添加成功。

也就是说，HashSet集合判断两个元素相等的标准是两个对象通过`equals()`方法比较相等，并且两个对象的`hashCode()`方法返回值也相等。

当把一个对象放入HashSet中时，如果需要重写该对象对应类的`equals()`方法，则也应该重写其`hashCode()`方法。规则是：如果两个对象通过`equals()`方法比较返回true，这两个对象的hashCode值也应该相同。

如果两个对象通过`equals()`方法比较返回true，但这两个对象的`hashCode()`方法返回不同的hashCode值时，这将导致HashSet会把这两个对象保存在Hash表的不同位置，从而使两个对象都可以添加成功，这就与Set集合规则冲突了。

如果两个对象的`hashCode()`方法返回相同的hashCode值，但它们通过`equals()`方法比较返回false时将更麻烦：因为两个对象的hashCode值相同，HashSet将试图把他们保存到同一个位置，但又不行（否则将只剩下一个对象），所及实际上会在这个位置用链式结构来保存多个对象；而HashSet访问集合元素时也是根据元素的hashCode来快速定位的，如果HashSet中两个以上的元素具有相同的hashCode值，将会导致性能下降。

HashSet中每个能存储元素的**槽位（slot）**通常称为**桶（bucket）**，如果有多个元素的hashCode值相同，但它们通过`equals()`方法比较返回false，就需要在一个“桶”里放多个元素，这样会导致性能下降。

重写hashCode()方法的基本规则：

- 在程序运行过程中，同一个对象多次调用`hashCode()`方法应该返回相同的值。
- 当两个对象通过`equals()`方法比较返回true时，这两个对象的`hashCode()`方法应该返回相等的值。
- 对象中用作`equals()`方法比较标准的实例变量，都应该用于计算hashCode值。

重写hashCode()方法的一般步骤：

1. 把对象内每个有意义的实例变量（即每个参与`equals()`方法比较标准的实例变量）计算出一个int类型的hashCode值。
  - hashCode值的计算方式：
    - boolean:`hashCode = (f ? 0 : 1);`
    - (byte、short、char、int):`hashCode = (int)f;`
    - long:`hashCode = (int)(f >>> 32));`
    - float:`hashCode = Float.floatToIntBits(f);`
    - double:`long l = Double.doubleToLongBits(f); hashCode = (int)(l ^ (l >>> 32));`
    - 引用类型:`hashCode = f.hashCode();`

2. 用第1步计算出的多个hashCode值组合计算除一个hashCode值返回。

为了避免直接相加产生偶然相等（两个对象的f1、f2实例变量并不相等，但它们的hashCode的和恰好相等），可以通过为各实例变量的hashCode值乘以任意一个**质数**后再相加。

如果向HashSet中添加一个可变对象后，后面程序修改了该可变对象的实例变量，则可能导致它与集合中的其他元素相同，这就有可能导致HashSet中包含两个相同的对象。

当程序把可变对象添加到HashSet中之后，尽量不要去修改该集合元素中参与计算的`hashCode()`、`equals()`的实例变量，否则将会导致HashSet无法正确操作这些集合元素。

当向HashSet中添加可变对象时，必须十分小心。如果修改HashSet集合中的对象，有可能导致该对象与集合中的其他对象相等，从而导致HashSet无法精确访问该对象。

### LinkedHashSet类

HashSet类还有一个**子类**LibkedHashSet，LinkedHashSet集合也是根据元素的hashCode值来决定元素的存储位置，但它同时使用链表维护元素的次序，当遍历LinkedHashSet集合里的元素时，LinkedHashSet将会按元素的**添加顺序**来访问集合里的元素。

LinkedHashSet需要维护元素的插入顺序，因此性能略低于HashSet性能，但在迭代访问Set里的全部元素时将有很好的性能，因此它以链表来维护内部顺序。

### TreeSet类

TreeSet是SortedSet接口的实现类，TreeSet可以确保集合元素处于**排序状态**。与HashSet集合相比，TreeSet还提供了如下几个额外的方法：

- `Comparator comparator()`:如果TreeSet采用了定制排序，则该方法返回定制排序所使用的Comparator；如果TreeSet采用了自然排序，则返回null。
- `Object first()`:返回集合中的第一个元素。
- `Object last()`:返回集合中的最后一个元素。
- `Object lower(Object e)`:返回集合中位于指定元素之前的元素（即小于指定元素的最大元素，参考元素不需要是TreeSet集合里的元素）。
- `Object higher(Object e)`:返回集合中位于指定元素之后的元素（即大于指定元素的最大元素，参考元素不需要是TreeSet集合里的元素）。
- `SortedSet subSet(Object fromElement, Object toElement)`:返回此Set的子集合，范围从fromElement（包含）到toElement（不包含）。
- `SortedSet headSet(Object toElement)`:返回此Set集合的子集，由小于toElement的元素组成。
- `SortedSet tailSet(Object fromElement)`:返回此Set的子集，由大于或等于fromElement的元素组成。

TreeSet并不是根据元素的插入顺序进行排序，而是根据元素实际值的大小进行排序的。

HashSet集合采用hash算法来决定元素的存储位置不同，TreeSet采用红黑树的数据结构来存储集合的元素。

TreeSet支持两种排序方式：**自然排序**和**定制排序**。默认情况下，TreeSet采用自然排序。

#### 自然排序

TreeSet会调用集合元素的`compareTo(Object obj)`方法来比较元素之间的大小关系，然后将集合元素升序排序。

Java提供了一个Comparable接口，该接口里定义了一个`compareTo(Object obj)`方法，该方法返回一个**整数值**，实现该接口的类必须实现该方法，实现了该接口的类的对象就可以比较大小。当一个对象obj1调用该方法与另一个对象obj2进行比较时，如果该方法返回0，则表明这两个对象相等；如果该方法返回一个正整数，则表明ob1大于obj2；如果该方法返回一个负整数，则表明ob1小于obj2。

Java的一些常用类已经实现的Comparable接口，并提供了比较大小的标准。下面是实现了Comparable接口的常用类：

- BigDecimal、BigInteger以及所有的数值型对应的包装类：按它们对应的**数值大小**进行比较。
- Character:按字符的**UNICODE值**进行比较。
- Boolean:true对应包装类实例大于false对应的包装类实例。
- String:按字符串中字符的**UNICODE值**进行比较。
- Date、Time：后面的时间、日期比前面的时间、日期大。

如果试图把一个对象添加到TreeSet时，该对象的类必须实现Comparable接口，否则程序将会抛出异常。

大部分类在实现`compareTo(Object obj)`方法时，都需要将被比较对象obj强制类型转换成相同类型，因为只有相同类的两个实例才会比较大小。

如果希望TreeSet能正常运作，TreeSet只能添加**同一种类型**的对象。

当把一个对象加入TreeSet集合中时，TreeSet调用该对象的`compareTo(Object obj)`方法与容器中的其他对象比较大小，然后根据**红黑树结构**找到它的存储位置。如果两个对象通过`compareTo(Object obj)`方法比较相等，新对象将无法添加到TreeSet集合中。

TreeSet集合判断两个对象唯一标准就是`compareTo(Object obj)`方法。

当需要把一个对象放入TreeSet中，重写该对象对应类的`equals()`方法时，应保证该方法与`compareTo(Object obj)`方法有一致的结果，其规则是：如果两个对象通过`equals()`方法比较返回true时，这两个对象通过`compareTo(Object obj)`方法比较应返回0。

当执行了删除元素代码成功后，TreeSet会对集合中的元素**重新索引**（不是重新排序），接下来就可以删除TreeSet中的所有元素了，包括那些被修改过实例变量的值。与HashSet类似的是，如果TreeSet中包含了可变对象，当可变对象的实例变量被修改时，TreeSet在处理这些对象时将会非常复杂，而且容易出错。

#### 定制排序

TreeSet的自然排序是根据集合元素的大小，TreeSet将它们以升序排序。

如果需要实现定制排序，例如以降序排序，则可以通过Comparable接口的帮助。该接口里包含了一个`int compare(T o1, T o2)`方法，该方法用于比较o1和o2的大小：如果该方法返回正整数，则表明o1大于o2；如果该方法返回0，则表明o1等于o2；如果该方法返回负整数，则表明o1小于o2。

如果需要实现定制排序，则需要在创建TreeSet集合对象时，提供一个Comparator对象与该TreeSet集合关联，由该Comparator对象负责集合元素的排序逻辑。由于Comparator是一个**函数式接**口，因此可使用Lambda表达式来代替Comparator对象。

当通过Comparator对象（或Lambda表达式）来实现TreeSet的定制排序时，依然不可以向TreeSet中添加类型不同的对象，否则还会引发`ClassCastException`异常。使用定制排序时，TreeSet对集合元素排序不管集合元素本身的大小，而是由Comparator对象（或Lambda表达式）负责集合元素的排序规则。

TreeSet判断两个集合元素的相等的标准是：通过Comparator（或Lambda表达式）比较两个元素返回了0，这样TreeSet不会把第二个元素添加到集合中。

### EnumSet类

EnumSet是一个转为**枚举类**设计的集合类，EnumSet中的所有元素都必须是指定枚举类型的枚举值，该枚举类型在创建EnumSet时显示或隐式地指定。EnumSet的集合元素也是有序的，EnumSet以枚举值在Enum类内定义顺序来决定集合元素的顺序。

EnumSet在内部以**位向量**的形式存储，这种存储形式非常紧凑、高效，因此EnumSet对象占用内存很小，而且运行效率很好。尤其是进行**批量操作**（如调用`containsAll()`和`retainAll()`方法）时，如果其参数也是EnumSet集合，则该批量操作的执行速度也非常快。

EnumSet集合不允许加入null元素，如果试图插入null元素，EnumSet将抛出`NullPointerException`异常。如果只是想判断EnumSet是否包含null元素或试图删除null元素都不会抛出异常，只是删除操作将返回false，因为没有任何null元素被删除。

EnumSet类没有暴露任何构造器来创建该类的实例，程序应该通过它提供的**类方法**来创建EnumSet对象。EnumSet类它提供了如下常用的类方法来创建EnumSet对象:

- `EnumSet allOf(Class elementType)`：创建一个包含指定枚举类里所有枚举值的EnumSet集合。
- `EnumSet complementOf(EnumSet s)`：创建一个其元素类型与指定EnumSet里元素类型相同的EnumSet集合，新EnumSet集合包含原EnumSet集合所不包含的、此枚举类剩下的枚举值（即新EnumSet集合和原EnumSet集合的集合元素加起来就是该枚举类的所有枚举值）。
- `EnumSet copyOf(Collection c)`：使用一个普通集合来创建EnumSet集合。
- `EnumSet copyOf(EnumSet s)`：创建一个与指定EnumSet具有相同元素类型、相同集合元素的EnumSet集合。
- `EnumSet noneOf(Class elementType)`：创建一个元素类型为指定枚举类型的空EnumSet。
- `EnumSet Of(E first, E... rest)`：创建一个包含一个或多个枚举值的EnumSet集合，传入的多个枚举值必须属于同一个枚举类。
- `EnumSet range(E from, E to)`：创建一个包含从from枚举值到to枚举值范围内所有枚举值的EnumSet集合。

当试图复制Collection集合里的元素来创建EnumSet集合时，必须保证Collection集合里的所有元素都是同一个枚举类的枚举值。

### 各Set实现类的性能分析

HashSet和TreeSet是Set的两个典型实现，到底如何选择HashSet和TreeSet？HashSet的性能总是比TreeSet好（特别是最常用的添加、查询元素等操作），因为TreeSet需要额外的红黑树算法来维护集合元素的次序。只有当需要一个保持排序的Set时，才应该使用TreeSet，否则都应该使用HashSet。

HashSet还有一个子类：LinkedHashSet，对于普通的插入、删除操作，LinkedHashSet比HashSet要略微慢一点，这是由维护链表所带来的额外开销造成的，但由于有了链表，遍历LinkedHashSet会更快。

EnumSet是所有Set实现类中性能最好的，但它只能保存同一个枚举类的枚举值作为集合元素。

Set的三个实现类HashSet、TreeSet和EnumSet都是线程不安全的。如果有多个线程同时访问一个Set集合，并且有超过一个线程修改了该Set集合，则必须手动保证该Set集合的同步性。通常可以通过Collection工具类的synchronizedSortedSet方法来“包装”该Set集合。此操作最好再创建时进行，以防止对Set集合的意外非同步访问。例如：`SortedSet s = Collections.synchronizedSortedSet(new TreeSet(...));`

## List集合

List集合代表一个元素有序、可重复的集合，集合中每个元素都有其对应的顺序索引。List集合允许使用重复元素，可以通过索引来访问指定位置的集合元素。List集合默认按元素的添加顺序设置元素的索引。

### Java8改进的List接口和ListIterator接口

List作为Collection接口的子接口，当然可以使用Collection接口里的全部方法。而且由于List是有序集合，因此List集合里增加了一些根据索引来操作集合元素的方法。

- `void add(int index, Object element)`：将元素element插入到List集合的index处。
- `boolean addAll(int index, Collection c)`：将集合c所包含的所有元素都插入到List集合的index处。
- `Object get(int index)`：返回集合index索引处的元素。
- `int indexOf(Object o)`：返回对象o在List集合中第一次出现的位置索引。
- `int lastIndexOf(Object o)`：返回对象o在List集合中最后一次出现的位置索引。
- `Object remove(int index)`：删除并返回index索引处的元素。
- `Object set(int index, Object element)`：将index索引处的元素替换成element对象，返回被替换的旧元素。
- `List subList(int fromIndex, int toIndex)`：返回从索引fromIndex（包含）到索引toIndex（不包含）处所有集合元素组成的子集合。

所有的List实现类都可以调用这些方法来操作集合元素。与Set集合相比，List增加了根据索引来插入、替换和删除集合元素的方法。除此之外，Java8还为List接口添加了如下两个默认方法。

- `void replaceAll(UnaryOperator operator)`：根据operator指定的计算规则重新设置List集合的所有元素。
- `void sort(Comparator c)`：根据Comparator参数对List集合的元素排序。

Lisi**判断两个对象相等**只要通过`equals()`方法比较返回true即可。

`remove(new A());`程序试图删除一个A对象，Lit将会调用该A对象的`equals()`方法依次与集合元素进行比较，如果该`equals()`方法以某个集合元素作为参数时返回true。

当调用List的`set(int index, Object element)`方法来改变List集合指定索引处的元素时，指定的索引必须是List集合的有效索引。`set(int index, Object element)`方法不会改变List集合的长度。

Java8为List集合增加了`sort()`和`replaceAll()`两个常用的默认方法，其中`sort()`方法需要一个Comparator对象来控制元素排序，程序可使用Lambda表达式来作为参数；而`replaceAll()`方法则需要一个UnaryOperator来替换所有集合元素，UnaryOperator也是一个函数式接口，因此也可使用Lambda表示作为参数。

与Set只提供了一个`iterator()`方法不同，List还额外提供了一个`listIterator()`方法，该方法返回一个ListIterator对象，ListIterator接口继承了Iterator接口，提供了专门操作List的方法。ListIterator接口在Iterator接口基础上增加了如下方法。

- `boolean hasPrevious()`：返回该迭代器关联的集合是否还有上一个元素。
- `Object previous()`：返回该迭代器的上一个元素。
- `void add(Object o)`：在指定位置插入一个元素。

拿ListIterator与普通的Iterator进行对比，不难发现ListIterator增加了向前迭代的功能（Iterator只能向后迭代），而且ListIterator还可通过`add()`方法向List集合中添加元素（Iterator只能删除元素）。

### ArrayList和Vector实现类

ArrayList和Vector类都是**基于数组**实现的List类，所以ArrayList和Vector类封装了一个动态的、允许再分配的**Object[]数组**。ArrayList和Vector对象使用`initialCapacity`参数来设置该数组的长度，当向ArrayList或Vector中添加元素超出了该数组的长度时，它们的initialCapacity会**自动增加**。

当向ArrayList或Vector集合中添加大量元素时，可使用`ensureCapacity(int minCapacity)`方法一次性地增加initialCapacity。这可以减少重分配的次数，从而提高性能。

除此之外，ArrayList和Vector还提供了如下两个方法来重新分配Object[]数组。

- `void ensureCapacity(int minCapasity)`：将ArrayList或Vector集合的Object[]数组长度增加大于或等于minCapacity。
- `void trimToSize()`：调整ArrayList或Vector集合的Object[]数组长度为当前元素的个数。调用该方法可减少ArrayList或Vector集合对象占用的存储空间。

ArrayList和Vector的显著区别是：ArrayList是**线程不安全**的，当多个线程访问同一个ArrayList集合时，如果有超过一个线程修改了ArrayList集合，则程序必须手动保证该集合的同步性；但Vector集合则是**线程安全**的，无须程序保证该集合的同步性。因为Vector是线程安全的，所以Vector的性能比ArrayList的性能要低。实际上，即使需要保证List集合线程安全的，也同样不推荐使用Vector实现类。会有一个Collections工具类，它可以将一个ArrayList变成线程安全的。

Vector还提供了一个Stack子类，它用于模拟**栈**这种数据结构，“栈”通常是指**后进先出（LIFO）**的容器。最后“push”进栈的元素，将最先被“pop”出栈。与Java中的其他集合一样，进栈出栈都是Object，因此从栈中取出元素后必须进行**类型转换**，除非是使用Object具有的操作。所以Stack类里提供了如下几个方法。

- `Object peek()`：返回“栈”的第一个元素，但并不将该元素“pop”出栈。
- `Object pop()`：返回“栈”的第一个元素，并将该元素“pop”出栈。
- `void push(Object item)`：将一个元素“push”进栈，最后一个进“栈”的元素总是位于“栈“顶。

由于Stack继承了Vector，因此它也是一个非常古老的Java集合类，它同样是线程安全的、性能较差的，因此应该尽量少用Stack类。如果程序需要使用”栈“这种数据结构，则可以考虑ArrayDeque。

ArrayDeque也是List的实现类，ArrayDeque即实现了List接口，也实现了Deque接口，由于实现了Deque接口，因此可以作为栈来使用；而且ArrayDeque底层也是基于数组的实现，因此性能也很好。

### 固定长度的List

操作数组的工具类：Arrays，该工具类提供了`asList(Object... a)`方法，该方法可以把一个数组或指定个数的对象转换成一个List集合，这个List集合既不是ArrayList实现类的实例，也不是Vector实现类的实例，而是Arrays的内部类**ArrayList**的实例。

Arrays.ArrayList是一个固定长度的List集合，程序只能遍历访问该集合里的元素，不可增加、删除该集合里的元素。

## Queue集合

Queue用于模拟队列这种数据结构，队列通常是指**先进先出（FIFO）**的容器。队列的头部保存在队列存放时间最长的元素，队列的尾部保存在队列中存放时间最短的元素。新元素插入（offer）到队列的尾部，访问元素（poll）操作会返回队列头部的元素。通常，队列不允许随机访问队列中的元素。

Queue接口中定义了如下几个方法。

- `void add(Object e)`：将指定元素加入此队列的尾部。
- `Object element()`：获取队列头部的元素，但是不删除该元素。
- `boolean offer(Object e)`：将指定元素加入此队列的尾部。当使用有容量限制的队列时，此方法通常比`add(Object e)`方法更好。
- `Object peek()`：获取队列头部的元素，但是不删除该元素。如果此队列为空，则返回null。
- `Object poll()`：获取队列头部的元素，并删除该元素。如果此队列为空，则返回null。
- `Object remove()`：获取队列头部的元素，并删除该元素。

Queue接口有一个PriorityQueue实现类。除此之外，Queue还有一个Deque接口，Deque代表一个**双端队列**，双端队列可以同时从两端来添加、删除元素，因此Deque的实现类即可当成队列使用，也可当成栈使用。Java为Deque提供了ArrayDeque和LinlkedList两个实现类。

### PriorityQueue实现类

PriorityQueue是一个比较标准的队列实现类。之所以说它是比较标准的队列实现，而不是绝对标准的队列实现，是因为PriorityQueue保存队列元素的顺序并不是按加入队列的顺序，而是按队列元素的大小进行重新排序。因此当调用`peek()`方法或者`poll()`方法取出队列中的元素时，并不是取出最先进入队列的元素，而是去除队列中最小的元素。

PriorityQueue不允许插入null元素，它还需要对队列元素进行排序，PriorityQueue的元素有两种排序方式。

- 自然排序：采用自然排序的PriorityQueue集合中的元素必须实现了Comparable接口，而且应该是同一个类的多个实例，否则可能导致ClassCastException异常。
- 定制排序：创建PriorityQueue队列时，传入一个Comparable对象，该对象负责对队列中的所有元素进行排序。采用定制排序时不要求队列元素实现Comparable接口。

PriorityQueue队列对元素的要求与TreeSet对元素的要求基本一致。

### Deque接口与ArrayDeque实现类

Deque接口是Queue接口的子接口，它代表一个双端队列，Deque接口里定义了一些双端队列的方法，这些方法允许从两端来操作队列的元素。

- `void addFirst(Object e)`：将指定元素插入该双端队列的开头。
- `void addLast(Object e)`：将指定元素插入该队列的末尾。
- `Iterator descendingIterator()`：返回该双端队列对应的迭代器，该迭代器将以逆向顺序来迭代队列中的元素。
- `Object getFirst()`：获取但不删除双端队列的第一个元素。
- `Object getLast()`：获取但不删除双端队列的最后一个元素。
- `boolean offerFirst(Object e)`：将指定元素插入该双端队列的开头。
- `boolean offerLast(Object e)`：将指定元素插入该双端队列的末尾。
- `Object peekFirst()`：获取但不删除该双端队列的第一个元素；如果双端队列为空，则返回null。
- `Object peekLast()`：获取但不删除该双端队列的最后一个元素；如果双端队列为空，则返回null。
- `Object pollFirst()`：获取并删除该双端队列的第一个元素；如果此双端队列为空，则返回null。
- `Object pollLast()`：获取并删除该双端队列的最后一个元素；如果此双端队列为空，则返回null。
- `Object pop()`：栈方法，pop出该双端队列所表示的栈的栈顶元素。相当于`removeFirst()`。
- `void push(Object e)`：栈方法，将一个元素push进该双端队列所表示的栈的栈顶。相当于`addFirst(e)`。
- `Object removeFirst(Object e)`：获取并删除该双端队列的第一个元素。
- `Object removeFirstOccurrence(Object o)`：删除该双端队列的第一次出现的元素o。
- `Object removeLast(Object e)`：获取并删除该双端队列的最后一个元素。
- `Object removeLastOccurrence(Object o)`：删除该双端队列的最后一次出现的元素o。

Deque不仅可以当成双端队列使用，而且可以被当成栈来使用，因为该类还包含了pop（出栈）、push（入栈）两个方法。

**Deque的方法与Queue的方法对照表**

|   Queue的方法     |         Deque的方法        |
| :--------------: | :-----------------------: |
| add(e)/offer(e)  |  addLast(e)/offerLast(e)  |
| remove()/poll()  | removeFirst()/pollFirst() |
| element()/peek() |  getFirst()/peekFirst()   |

**Deque的方法与Stack的方法对照表**

| Stack的方法  |         Deque的方法        |
| :---------: | :-----------------------: |
|   push(e)   | addFirst(e)/offerFirst(e) |
|    pop()    | removeFirst()/pollFirst() |
|   peek()    |  getFirst()/peekFirst()   |

Deque接口提供了一个典型的实现类：ArrayDeque，从该名称就可以看出，它是一个基于数组实现的双端队列，创建Deque时同样可指定一个numElements参数，该参数用于指定Object[]数组的长度；如果不指定numElements参数，Deque底层的数组长度为16。

ArrayList和ArrayDeque两个集合类的实现机制基本相似，它们底层都采用一个动态的、可重分配的Object[]数组来存储集合元素，当集合元素超出了该数组的容量时，系统会在底层重新分配一个Object[]数组来存储集合元素。

因此程序中需要使用**栈**这种数据结构时，推荐使用ArrayDeque，尽量避免使用Stack——因为Stack是古老的集合，性能较差。

### LinkedList实现类

LinkedList类是List接口的实现类，可以根据索引来随机访问集合中的元素。除此之外，LinkedList还实现了Deque接口，可以被当成双端队列来使用，因此既可以被当成**栈**来使用，也可以当成**队列**使用。

LinkedList与ArrayList、ArrayDeque的实现机制完全不同，ArrayList、ArrayDeque内部以**数组**的形式来保存集合中的元素，因此随机访问集合元素时有较好的性能；而LinkedList内部以**链表**的形式来保存集合中的元素，因此随机访问集合元素时性能较差，但在插入、删除元素时性能比较出色（只需改变指针所指的地址即可）。虽然Vector也是以**数组**的形式来存储集合元素的，但因为它实现了线程的**同步功能**（而且实现机制也不好），所以各方面性能都比较差。

对于所有的内部基于数组的集合实现，例如ArrayList、ArrayDeque等，使用随机访问的性能比使用Iterator迭代访问的性能要好，因为随机访问会被映射成对数组元素的访问。

### 各种线性表的性能分析

Java提供的List就是一个线性表接口，而ArrayList、LinkedList又是线性表的两种典型实现：基于数组的线性表和基于链的线性表。Queue代表队列，Deque代表了双端队列（既可作为队列使用，也可作为栈使用）。

一般来说，由于数组以一块**连续内存区**来保存所有的数组元素，所以数组在随机访问时性能最好，所有的内部以数组作为底层实现的集合在**随机访问**时性能都比较好；而内部以链表作为底层实现的集合在执行插入、删除操作时有较好的性能。但总体来说，ArrayList的性能比LinkedList的性能要好，因此大部分时候应该考虑使用ArrayList。

关于使用List集合的建议。

- 如果需要遍历List集合元素，对于ArrayList、Vector集合，应该使用随机访问方法（get）来遍历集合元素，这样性能更好；对于LinkedList集合，则应该采用迭代器（Iterator）来遍历集合元素。
- 如果需要经常执行插入、删除操作来改变包含大量数据的List集合的大小，可考虑使用LinkedList集合。使用ArrayList、Vector集合可能需要经常重新分配内部数组的大小，效果可能较差。
- 如果有多个线程需要同时访问List集合中的元素，可考虑使用Collections将集合包装成线程安全的集合。

## Java8增强的Map集合

Map用于保存具有映射关系的数据，因此Map集合里保存着两组值，一组值用于保存Map里的key，另外一组值用于保存Map里的value，key和value都可以是任何引用类型的数据。Map里的key不允许重复，即同一个Map对象的任何两个key通过`equals()`方法比较总是返回false。

key和value之间存在单向一对一关系，即通过指定的key，总能找到唯一的、确定的value。

如果把Map里的所有key放在一起来看，它们就组成了Set集合（所有的key没有顺序，key与key之间不能重复），实际上Map包含了一个`keySet()`方法，用于返回Map里的所有key组成的Set集合。

Map里key集和Set集合里的元素的存储形式很像，Map子类和Set子类在名字上也惊人地相似，比如Set接口下有HashSet、LinkedHashSet、SortedSet（接口）、TreeSet、EnumSet等子接口和实现类，而Map接口下则有HashMap、LinkedHashMap、SortedMap（接口）、TreeMap、EnumMap等子接口和实现类。Map的这些实现类和子接口中key集的存储形式和对应Set集合中元素的存储形式完全相同。

Set和Map之间的关系非常密切。虽然Map中存放的元素是key-value对，Set集合中放的元素是单个对象，但如果把key-value对中的value当成key的附庸：key在哪里，value就跟在哪里。Map提供了一个Entry内部类来封装key-value对，而计算Entry存储时则只考虑Entry封装的key。从Java源码来看，Java是先实现了Map，然后通过包装一个所有value都为null的Mao就实现了Set。

如果把Map里的所有value放在一起来看，它们有非常类似于一个List：元素与元素之间可以重复，每个元素可以根据索引来查找，只是Map中的索引不再使用整数值，而是以另一个对象作为索引。Map有时也被称为字典，或关联数组。Map接口中定义了如下常用的方法。

- `void clear()`：删除该Map对象中的所有key-value对。
- `boolean containsKey(Object key)`：查询Map中是否包含指定的key，如果包含则返回true。
- `boolean containsValue(Object value)`：查询Map中是否包含一个或多个value，如果包含则返回true。
- `Set entrySet()`：返回Map中包含的key-value对所组成的Set集合，每个集合元素都是Map.Entry（Entry是Map的内部类）对象。
- `Object get(Object key)`：返回指定key所对应的value；如果此Map中不包含该key，则返回null。
- `boolean isEmpty()`：查询该Map是否为空（即不包含任何key-value对），如果为空则返回true。
- `Set keySet()`：返回该Map中所有key组成的Set集合。
- `Object put(Object key, Object value)`：添加一个key-value对，如果当前Map中已有一个与该key相等的key-value对，则新的key-value对会覆盖原来的key-value对。
- `void putAll(Map m)`：将指定Map中的key-value对复制到本Map中。
- `Object remove(Object key)`：删除指定key所对应的key-value对，返回删除key所关联的value，如果该key不存在，则返回null。
- `Object remove(Object key, Object value)`：这是Java8新增的方法，删除指定key、value所对应的key-value对。如果该Map中成功地删除该key-value对，该方法返回true，否则返回false。
- `int size()`：返回该Map里的key-value对的个数。
- `Collection values()`：返回该Map里所有value组成的Collection。

Map接口提供了大量的实现类，典型实现如**HashMap**和**Hashtable**等、HashMap的子类**LinkedHashMap**，还有SortedMap子接口及该接口的实现类**TreeMap**，以及**WeakHashMap**、**IdentityHashMap**等。

Map里包括了一个内部类Entry，该类封装了一个key-value对。Entry包含如下三个方法。

- `Object getKey()`：返回该Entry里包含的key值。
- `Object getValue()`：返回该Entry里包含的value值。
- `Object setValue(V value)`：设置该Entry里包含的value值，并返回新设置的value值。

Map集合最典型的用法就是成对地添加、删除key-value对，接下来即可判断该Map中是否包含指定key，是否包含指定value，也可以通过Map提供的`keySet()`方法获取所有key组成的集合，进而遍历Map中所有的key-value对。

添加key-value对时，Map允许多个value重复，但如果添加key-value对时Map中已有重复的key，那么新添加的value会覆盖原来对应的value，该方法会返回被覆盖的value。

### Java8为Map新增的方法

Java8除为Map增加了`remove(Object key, Object value)`默认方法之外，还增加了如下方法。

- `Object compute(Object key, BiFunction remappingFunction)`：该方法使用remappingFunction根据**原key-value对**计算一个新的value。只要新的value不为null，就是用新的value**覆盖**原value；如果原value不为null，但新的value为null，则删除原key-value对；如果原value、新value同时为null，那么该方法不改变任何key-value对，直接返回null。
- `Object computeIfAbsent(Object key, Function mappingFunction)`：如果传给该方法的key参数在Map中对应的value为null，则使用mappingFunction**根据key**计算一个新的结果，如果计算结果不为null，则用计算结果覆盖原有的value。如果原Map原来不包括该key，那么该方法可能会添加一组key-value。
- `Object computeIfPresent(Object key, BiFunction remappingFcuntion)`：如果传给该方法的key参数在Map中对应的value不为null，该方法将使用remappingFunction根据**原key-value**计算一个新的结果，如果计算结果不为null，则使用该结果覆盖原来的value；如果计算结果为null，则删除原key-value对。
- `void forEach(BiConsumer action)`：该方法是Java8为Map新增的一个遍历key-value对的方法，通过该方法可以更简洁地遍历Map的key-value对。
- `Object getOrDefault(Object key, V defaultValue)`：获取指定key对应的value。如果该key不存在，则返回defaultValue。
- `Object merge(Object key, Object value, BiFunction remappingFunction)`：该方法会根据key参数获取该Map中对应的value。如果获取的value为null，则直接用传入的value覆盖原有的value（在这种情况下，可能要添加一组key-value对）；如果获取的value不为null，则使用remappingFunction函数根据原value、新value计算一个新的结果，并用得到的结果去覆盖原有的value。
- `Object putIfAbsent(Object key, Object value)`：该方法会自动检测指定key对应的value是否为null，如果该key对应的value为null，该方法会用新的value代替原来的null值。
- `Object replace(Object key, Object value)`：将Map中指定key对应的value替换成新value。与传统`put()`方法不同的是，该方法不可能添加新的key-value对。如果尝试替换的key在原Map中不存在，该方法不会添加key-value，而是返回null。
- `boolean replace(K key, V oldValue, V newValue)`：将Map中指定key-value对原value替换成新value。如果在Map中找到指定的key-value对，则执行替换并返回true，否则返回false。
- `replaceAll(BiFunction function)`：该方法使用BiFunction对原key-value对执行计算，并将计算结果作为该key-value对的valu值。

