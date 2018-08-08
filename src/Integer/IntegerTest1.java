package Integer;

/**
 * @author liubaoqing
 * @createTime 2018-08-02
 * @description
 */
public class IntegerTest1 {
   public static void main(String[] args) {
      Integer a = new Integer(200);
      Integer b = new Integer(200);
      Integer c = 200;
      Integer e = 200;
      int d = 200;
      /**
       * System.out.println(a==b);//false
       * 每次使用new关键字，都会在堆内存中申请一块空间，存放相应的对象的值，然后在栈中存放这块内存的引用地址。
       * 而==运算符比较两者所指向对象的地址是否相同，申请了两块空间，地址肯定不相同
       */
      /**
       * System.out.println(a.equals(b));//true
       * System.out.println(a.equals(c));//true
       * System.out.println(c.equals(e));//true
       * System.out.println(c.equals(d));//true
       *
         public boolean equals(Object obj) {
          if (obj instanceof Integer) {
               return value == ((Integer)obj).intValue();
          }
          return false;
         }
         public int intValue()
         {
             return value;
         }
       首先，判断传进来的Object类型是不是Integer类的一个实例，如果不是直接返回false；
       如果是则判断两者的成员变量value值是不是相等的（Integer类中定义的private final int value）,
       这块又回到了基本类型的比较。value的值在创建这个对象的时候被赋值，两个Integer对象传递的参数都为200，
       所以value值相等，返回true。
       */
      /**
       * System.out.println(a==c);       //false
       * System.out.println(c==e);       //false
       *
       * 自动装箱、自动拆箱机制。
       * Integer c = 200
       * 相当于：
       * Integer c = Integer.valueOf(200);

         public static Integer valueOf(int i) {
            assert IntegerCache.high >= 127;
            if (i >= IntegerCache.low && i <= IntegerCache.high)
               return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
         }
       上面这段代码首先规定了一个范围，默认IntegerCache.low 是-127，Integer.high是128，
       如果参数中的i在这个范围之内，则返回一个数组中的内容，如果不在这个范围，则new一个新的Integer对象并返回。
       查看Integer类的源码可以发现，这个数组里面缓存了基本类型-128-127之间的Integer对象。
       但是由于第11行是与一个new出来的对象做比较，所以==肯定返回的false。
       */
      /**
       * System.out.println(d == a);     //true
       * System.out.println(d==c);       //true
       *
       * 这块进行比较的时候，会对Integer对象进行自动拆箱，也就是调用intValue方法，方法如上。
       * 两个基本数据类型进行==判断，根据值比较，所以结果为true。
       */
      /**
       * System.out.println(a.equals(d));//true
       *
       * 首先调用equals方法的肯定是Integer对象，但是Integer类中重写的equals方法参数是一个Object类型呀，
       * 怎么能传递一个基本数据类型进去呢？
       * 所以，这块又是一个自动装箱的表现，当传递一个int类型给equals这个方法时，
       * java会自动将这个值打包装箱为Integer类，而Integer类的最终父类又是Object
       */
   }
}
