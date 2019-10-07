package ch02.ls02;

/**
 * JavaBeans 模式，在这种模式中，调用一个无参数的构造函
 * 数来创建对象，然后调用 setter 方法来设置每个必需的参数和可选参数
 *
 * 这种模式没有伸缩构造方法模式的缺点。有点冗长，但创建实例很容易，并且易于阅读所生成的代码
 *
 * 不幸的是，JavaBeans 模式本身有严重的缺陷。由于构造方法在多次调用中被分割，所以在构造过程中 JavaBean
 * 可能处于不一致的状态。该类没有通过检查构造参数参数的有效性来执行一致性的选项。在不一致的状态下尝试使用
 * 对象可能会导致与包含 bug 的代码大相径庭的错误，因此很难调试。
 */
public class NutritionFacts02 {
    // Parameters initialized to default values (if any)
    private int servingSize = -1; // Required; no default value
    private int servings = -1; // Required; no default value
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    // Setters
    public void setServingSize(int val) { servingSize = val; }
    public void setServings(int val) { servings = val; }
    public void setCalories(int val) { calories = val; }
    public void setFat(int val) { fat = val; }
    public void setSodium(int val) { sodium = val; }
    public void setCarbohydrate(int val) { carbohydrate = val; }

    public static void main(String[] args) {
        NutritionFacts02 cocaCola = new NutritionFacts02();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
    }

}
