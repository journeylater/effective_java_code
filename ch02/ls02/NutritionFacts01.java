package ch02.ls02;

/**
 * 可伸缩（telescoping constructor）构
 * 造方法模式，在这种模式中，只提供了一个只所需参数的构造函数，另一个只有一个可选参数，第三个有两个可选参
 * 数，等等，
 *
 * 简而言之，可伸缩构造方法模式是有效的，但是当有很多参数时，很难编写客户端代码，而且很难读懂它。读者
 * 不知道这些值是什么意思，并且必须仔细地计算参数才能找到答案。一长串相同类型的参数可能会导致一些细微的
 * bug。如果客户端意外地反转了两个这样的参数，编译器并不会抱怨，但是程序在运行时会出现错误行为
 */
public class NutritionFacts01 {
    private final int servingSize; // (mL) required
    private final int servings; // (per container) required
    private final int calories; // (per serving) optional
    private final int fat; // (g/serving) optional
    private final int sodium; // (mg/serving) optional
    private final int carbohydrate; // (g/serving) optional

    public NutritionFacts01(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts01(int servingSize, int servings,
                            int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts01(int servingSize, int servings,
                            int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts01(int servingSize, int servings,
                            int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts01(int servingSize, int servings,
                            int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {

        NutritionFacts01 nutritionFacts01 = new NutritionFacts01(240, 8, 100, 0, 35, 27);

    }

}
