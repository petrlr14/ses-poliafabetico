import java.util.ArrayList;
import java.util.List;

public class Decode {
    public static void main(String[] args) {
        List<String> alfabetos = new ArrayList<>();
        String regla = args[0];
        String word = args[1];
        String rotaciones = regla.substring(2).toLowerCase();
        String currentNumber = "";
        for (int i = 0; i < rotaciones.length(); i++) {
            char aux = rotaciones.charAt(i);
            currentNumber += aux + "";
            if (rotaciones.charAt(i) == 'd' || rotaciones.charAt(i) == 'i') {
                alfabetos.add(currentNumber);
                currentNumber = "";
            }
        }
        System.out.println(code(word, alfabetos));
    }

    private static String code(String user, List<String> alfabetos) {
        List<Integer> abc = setList();
        StringBuilder newWord = new StringBuilder();
        int offset = getOffSet(alfabetos, abc);
        for (int i = 0; i < user.length(); i++) {
            int lastIndex = abc.size() - 1;
            int index = abc.indexOf((int) user.charAt(i));
            int indexPlusOffset = index + offset;
            if (indexPlusOffset > lastIndex) {
                indexPlusOffset -= abc.size();
            }
            if (indexPlusOffset < 0) {
                indexPlusOffset = abc.size() + indexPlusOffset;
            }
            newWord.append((char) ((int) abc.get(indexPlusOffset)));
        }
        return newWord.toString();
    }

    private static int getOffSet(List<String> alfabetos, List<Integer> abc) {
        int offset = 0;
        /*getting rotations*/
        for (String x : alfabetos) {
            String numero = x.substring(0, x.length() - 1);
            if (x.charAt(x.length() - 1) == 'd') {
                offset += Integer.parseInt(numero);
            } else {
                offset -= Integer.parseInt(numero);
            }
        }
        return offset % abc.size();
    }

    private static List<Integer> setList() {
        /*filling list*/
        List<Integer> list = new ArrayList<>();
        for (int i = 97; i <= 110; i++) {
            list.add(i);
        }
        list.add(241);
        for (int i = 111; i <= 122; i++) {
            list.add(i);
        }
        for (int i = 65; i <= 78; i++) {
            list.add(i);
        }
        list.add(209);
        for (int i = 79; i <= 90; i++) {
            list.add(i);
        }
        for (int i = 48; i <= 57; i++) {
            list.add(i);
        }
        list.add((int) ' ');
        list.add((int) ',');
        return list;
    }
}
