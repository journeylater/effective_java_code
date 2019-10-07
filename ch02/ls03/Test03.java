package ch02.ls03;

/**
 * 03.使用私有构造方法或枚类实现 Singleton 属性
 */

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test03 {

    /**
     * 特权客户端可以使用 AccessibleObject.setAccessible,反射攻击
     */
    @Test
    public void test01() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        SerSingleton01 singleton01 = SerSingleton01.instance;
        SerSingleton01 singleton02 = SerSingleton01.instance;
        System.out.println("正常情况下，实例化两个实例是否相同：" + (singleton01 == singleton02));

        Constructor<SerSingleton01> constructor = null;
        constructor = SerSingleton01.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SerSingleton01 singleton03 = constructor.newInstance();  //反射获取实例
        System.out.println("通过反射攻击单例模式情况下，实例化两个实例是否相同：" + (singleton01 == singleton03));

    }

    /**
     *  问题：序列化和反序列化会破坏单例
     *  解决：加入readResolve()
     * @throws Exception
     */
    @org.junit.Test
    public void test02() throws Exception {
        SerSingleton02 s1 = null;
        SerSingleton02 s = SerSingleton02.getInstance();

        FileOutputStream fos = new FileOutputStream("a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("a.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s1 = (SerSingleton02) ois.readObject();
        Assert.assertEquals(s, s1);
    }

    @Test
    public void test3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {

        //单一枚举类能否被反射破坏单例
//        SerSingleton03 singleton01 = SerSingleton03.INSTANCE;
//        SerSingleton03 singleton02 = SerSingleton03.INSTANCE;
//        System.out.println("正常情况下，实例化两个实例是否相同：" + (singleton01 == singleton02));
//
//        Constructor<SerSingleton03> constructor = null;
//        constructor = SerSingleton03.class.getDeclaredConstructor(String.class, int.class);////其父类的构造器
//        constructor.setAccessible(true);
//        SerSingleton03 singleton03 = constructor.newInstance();  //反射获取实例
//        System.out.println("通过反射攻击单例模式情况下，实例化两个实例是否相同：" + (singleton01 == singleton03));



        //单一枚举类能否被序列化和反序列化破坏单例
        SerSingleton03 s = SerSingleton03.INSTANCE;
        s.setContent("枚举单例序列化");
        System.out.println("枚举序列化前读取其中的内容：" + s.getContent());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SerEnumSingleton.obj"));
        oos.writeObject(s);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("SerEnumSingleton.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        SerSingleton03 s1 = (SerSingleton03) ois.readObject();
        ois.close();
        System.out.println(s + "\n" + s1);
        System.out.println("枚举序列化后读取其中的内容：" + s1.getContent());
        System.out.println("枚举序列化前后两个是否同一个：" + (s == s1));
    }

}
