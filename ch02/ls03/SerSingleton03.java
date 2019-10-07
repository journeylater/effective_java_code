package ch02.ls03;

import java.io.Serializable;

/**
 * 单例的第三种方法是声明单一元素的枚举类,这种方式类似于公共属性方法，但更简洁，提供了免费的序列化机制，并提供了针对多个实例化的坚固保证，即
 * 使是在复杂的序列化或反射攻击的情况下。这种方法可能感觉有点不自然，但是单一元素枚举类通常是实现单例的最
 * 佳方式
 */
public enum SerSingleton03 implements Serializable {

    INSTANCE;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SerSingleton03 getInstance() {
        return INSTANCE;
    }

}
