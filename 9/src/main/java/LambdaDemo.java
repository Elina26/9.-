import java.util.Arrays;
import java.util.function.Function;

public class LambdaDemo {
    //1.для строки символов получить ее длину
    public static Function<String, Integer> StringLength = String::length;

    //2.для строки символов получить ее первый символ, если он существует, или null иначе
    public static Function<String, String> FirstSymbol = (str) -> {
        if ((str != null) && (!str.equals(""))) return String.valueOf(str.charAt(0));
        else return null;
    };

    //3.для строки проверить, есть ли пробелы.
    //возвращает true если пробелы есть.
    //false иначе
    public static Function<String, Boolean> Spaces = (str) -> {
        int c = 0;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i)==' ') c++;
        }
        return c != 0;
    };

    //4.слова в строке разделены запятыми, по строке получить количество слов в ней
    public static Function<String, Integer> CountOfWords = (str) -> {
        String[] words = str.split(",");
        int count=0;
        for (String word : words) {
            if (!word.equals("")) {
                count++;
            }
        }
        return count;
    };

    //5.по человеку получить его возраст
    public static Function<Human, Integer> getHumanAge = Human::getAge;

    //6.по двум людям проверить, что у них одинаковая фамилия
    static ITwoHumansToBool surnames = (human1, human2) -> human1.getSurname().equals(human2.getSurname());

    //7.получить фамилию, имя и отчество человека в виде одной строки (разделитель — пробел)
    public static Function<Human, String> getSNP = (human) -> new String(human.getSurname()+" "+
            human.getName()+" "+human.getPatronymic());

    //8.сделать человека старше на один год (по объекту Human создать новый объект)
    public static Function<Human, Human> MakeOlder = (human) -> new Human(human.getSurname(), human.getName(),
            human.getPatronymic(), human.getAge()+1, human.getGender());

    //9.по трем людям и заданному возрасту maxAge проверить, что все три человека моложе maxAge
    static IThreeHumansToBool maxAge = (Human human1, Human human2, Human human3, int maxAge) -> {
        return (human1.getAge() < maxAge) && (human2.getAge() < maxAge) && (human3.getAge() < maxAge);
    };
}

interface ITwoHumansToBool {
    boolean calculate(Human human1, Human human2);
}
interface IThreeHumansToBool {
    boolean calculate(Human human1, Human human2, Human human3, int maxAge);
}