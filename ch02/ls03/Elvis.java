package ch02.ls03;

/**
 * 有两种常见的方法来实现单例。两者都基于保持构造方法私有和导出公共静态成员以提供对唯一实例的访问。在
 * 第一种方法中，成员是 final 修饰的属性：
 * 私有构造方法只调用一次，来初始化公共静态 final Elvis.INSTANCE 属性。缺少一个公共的或受保护的构造
 * 方法，保证了全局的唯一性：一旦 Elvis 类被初始化，一个 Elvis 的实例就会存在——不多也不少。客户端所做的任何
 * 事情都不能改变这一点，但需要注意的是：特权客户端可以使用 AccessibleObject.setAccessible 方法，以反
 * 射方式调用私有构造方法 (条目 65)。如果需要防御此攻击，请修改构造函数，使其在请求创建第二个实例时抛出异
 * 常。
 */
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() { ... }
    public void leaveTheBuilding() { ... }

}
