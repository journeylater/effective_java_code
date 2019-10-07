package ch02.ls03;

import java.io.Serializable;

/**
 * 使用私有构造方法创建单例：成员是 final 修饰的属性
 */
public class SerSingleton01 implements Serializable {

    public static final SerSingleton01 instance = new SerSingleton01();

    /**
     * 防止序列化和反序列化破坏单例
     * @return
     */
    private Object readResolve(){
        System.out.println("read resolve");
        return instance;
    }
}
