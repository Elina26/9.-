import java.util.function.Function;

public class LambdaRunner {
    public static <T, R> R one(T obj, Function<T, R> func) {
        return func.apply(obj);
    }

    public static Boolean two(Human h1, Human h2, ITwoHumansToBool i) {
        return i.calculate(h1, h2);
    }

    public static Boolean three(Human h1, Human h2, Human h3, int maxAge, IThreeHumansToBool i) {
        return i.calculate(h1, h2, h3, maxAge);
    }
}
