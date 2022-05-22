import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.*;

public class LambdaRunnerTest {
    String str = "Раз, два, три.";
    LambdaDemo lambdaDemo = new LambdaDemo();
    Human me = new Student("Цымбалей","Элина","Андреевна",19, Human.Gender.FEMALE,
            "ОмГУ","МатФак","Прикладная математика и информатика");
    Human friend = new Student("Лукина","Валерия","Сергеевна",20, Human.Gender.FEMALE,
            "НГУ","ФИЯ","Лингвистика");
    Human mom = new Human("Цымбалей","Елена","Ивановна",46, Human.Gender.FEMALE);

    @Test //1.для строки символов получить ее длину
    public void one() {
        Integer actual = LambdaRunner.one(str, LambdaDemo.StringLength);
        Integer expected = 14;
        assertEquals(actual, expected);
    }

    @Test //2.для строки символов получить ее первый символ, если он существует, или null иначе
    public void two0() {
        String actual = LambdaRunner.one(str, LambdaDemo.FirstSymbol);
        String expected = "Р";
        assertEquals(actual, expected);
    }
    @Test
    public void two1() {
        String actual = LambdaRunner.one("", LambdaDemo.FirstSymbol);
        assertNull(actual);
    }

    @Test //3.для строки проверить, есть ли пробелы.
          //возвращает true если пробелы есть.
          //false иначе
    public void three0() {
        assertTrue(LambdaRunner.one(str, LambdaDemo.Spaces));
    }
    @Test
    public void three1() {
        assertFalse(LambdaRunner.one("12345", LambdaDemo.Spaces));
    }

    @Test //4.слова в строке разделены запятыми, по строке получить количество слов в ней
    public void four0() {
        Integer actual = LambdaRunner.one(str, LambdaDemo.CountOfWords);
        Integer expected = 3;
        assertEquals(actual, expected);

        actual = LambdaRunner.one("a,,,b", LambdaDemo.CountOfWords);
        expected = 2;
        assertEquals(actual, expected);
    }
    @Test
    public void four() {
        Integer actual = LambdaRunner.one(str, LambdaDemo.CountOfWords);
        Integer expected = 3;
        assertEquals(actual, expected);

        actual = LambdaRunner.one(",a,,,b,f,ytty,", LambdaDemo.CountOfWords);
        expected = 4;
        assertEquals(actual, expected);
    }

    @Test //5.по человеку получить его возраст
    public void five() {
        Integer actual = LambdaRunner.one(me, LambdaDemo.getHumanAge);
        Integer expected = 19;
        assertEquals(actual, expected);
    }

    @Test //6.по двум людям проверить, что у них одинаковая фамилия
    public void six() {
        assertFalse(LambdaRunner.two(me, friend, LambdaDemo.surnames));
        assertTrue(LambdaRunner.two(me, mom, LambdaDemo.surnames));
    }

    @Test //7.получить фамилию, имя и отчество человека в виде одной строки (разделитель — пробел)
    public void seven() {
        String expected = "Цымбалей Элина Андреевна";
        String actual = LambdaRunner.one(me, LambdaDemo.getSNP);
        assertEquals(expected, actual);
    }

    @Test //8.сделать человека старше на один год (по объекту Human создать новый объект)
    public void eight() {
        Human meOlder = LambdaRunner.one(me, LambdaDemo.MakeOlder);
        assertEquals(meOlder.getAge(), 20);
    }

    @Test //9.по трем людям и заданному возрасту maxAge проверить, что все три человека моложе maxAge
    public void nine() {
        assertTrue(LambdaRunner.three(me, friend, mom, 47, LambdaDemo.maxAge));
        assertFalse(LambdaRunner.three(me, friend, mom, 25, LambdaDemo.maxAge));
    }
}