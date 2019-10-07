package ch02.ls02;

/**
 * 第三种选择，它结合了可伸缩构造方法模式的安全性和 JavaBean 模式的可读性。 它是 Builder
 * 模式[Gamma95] 的一种形式。客户端不直接调用所需的对象，而是调用构造方法 (或静态工厂)，并使用所有必需的参
 * 数，并获得一个 builder 对象。然后，客户端调用 builder 对象的 setter 相似方法来设置每个可选参数。最后，客
 * 户端调用一个无参的 build 方法来生成对象，该对象通常是不可变的。Builder 通常是它所构建的类的一个静态成
 * 员类
 */
public class NutritionFacts03 {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder{
        // Required parameters
        private final int servingSize;
        private final int servings;
        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }
        public Builder calories(int val) {
            calories = val;
            return this;
        }
        public Builder sodium(int val) {
            sodium = val;
            return this;
        }
        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }
        public NutritionFacts03 build() {
            return new NutritionFacts03(this);
        }

    }
    private NutritionFacts03(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts03 cocaCola = new NutritionFacts03.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();

    }


}
