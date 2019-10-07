package ch02.ls03;

import java.io.Serializable;

/**
 * 使用私有构造方法创建单例：公共成员是一个静态的工厂方法
 */
public class SerSingleton02 implements Serializable {
    String name;
    private SerSingleton02(){
        System.out.println("Singleton is creating");
    }

    private static SerSingleton02 instance = new SerSingleton02();

    public static SerSingleton02 getInstance(){
        return instance;
    }

    public static void createString(){
        System.out.println("create string in singleton");
    }

    /**
     * 防止序列化和反序列化破坏单例
     * @return
     */
    private Object readResolve(){
        System.out.println("read resolve");
        return instance;
    }
}
