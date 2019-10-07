package ch02.ls02;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Builder 模式非常适合类层次结构。 使用平行层次的 builder，每个嵌套在相应的类中。 抽象类有抽象的
 * builder；具体的类有具体的 builder
 */
public abstract class Pizza {

    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>>{

        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        protected abstract T self();

    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // See Item 50
    }

}
