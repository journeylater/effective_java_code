package ch02.ls03;

/**
 * 在第二个实现单例的方法中，公共成员是一个静态的工厂方法：
 * 所有对 Elvis.getInstance 的调用都返回相同的对象引用，并且不会创建其他的 Elvis 实例（与前面提到的
 * 警告相同）。
 * 公共属性方法的主要优点是 API 明确表示该类是一个单例：公共静态属性是 final 的，所以它总是包含相同的对
 * 象引用。 第二个好处是它更简单。
 * 静态工厂方法的一个优点是，它可以灵活地改变你的想法，无论该类是否为单例而不必更改其 API。 工厂方法返
 * 回唯一的实例，但是可以修改，比如，返回调用它的每个线程的单独实例。 第二个好处是，如果你的应用程序需要
 * 它，可以编写一个泛型单例工厂（generic singleton factory ）（条目 30）。 使用静态工厂的最后一个优点是方法引用
 * 可以用 supplier ，例如 Elvis::instance 等同于 Supplier<Elvis> 。 除非与这些优点相关的，否则公共属
 * 性方法是可取的。
 *
 */
public class Elvis02 {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis() { ... }
    public static Elvis getInstance() { return INSTANCE; }
    public void leaveTheBuilding() { ... }

    /**
     * 创建一个使用这两种方法的单例类 (第 12 章)，仅仅将 implements Serializable 添加到声明中是不够的。
     * 为了维护单例的保证，声明所有的实例属性为 transient ，并提供一个 readResolve 方法 (条目 89)。否则，每
     * 当序列化实例被反序列化时，就会创建一个新的实例，在我们的例子中，导致出现新的 Elvis 实例。为了防止这种情
     * 况发生，将这个 readResolve 方法添加到 Elvis 类：
     * @return
     */
    private Object readResolve() {
// Return the one true Elvis and let the garbage collector
// take care of the Elvis impersonator.
        return INSTANCE;
    }

}
