import java.util.Arrays;
import java.util.Objects;

public class main {
    public static void main(String[] args) {
        String str = ",bnf, d,,,r,,rs,,";
        String[] words = str.split(",");
        System.out.println(Arrays.toString(words));
        for (int i=0; i<words.length; i++) {
            System.out.println("["+words[i]+"]");
        }

        int c=0;
        System.out.println("EGSBSrs");
        for (int i=0; i<words.length; i++) {
            if (!words[i].equals("")) {
                System.out.println("["+words[i]+"]");
                c++;
            }

        }

        System.out.println(c);

    }
}
