import java.util.ArrayList;
import java.util.List;

public class Poli {

    public static void main(String[] args) {
        List<String> alfabetos=new ArrayList<>();
        String regla=args[0];
        String word=args[1];
        String rotaciones=regla.substring(2).toLowerCase();
        String currentNumber="";
        for(int i=0; i<rotaciones.length(); i++){
            char aux=rotaciones.charAt(i);
            currentNumber+=aux+"";
            if(rotaciones.charAt(i)=='d' || rotaciones.charAt(i)=='i'){
                alfabetos.add(currentNumber);
                currentNumber="";
            }
        }
        alfabetos.forEach(System.out::println);
        System.out.println(calclo(word, alfabetos));
    }

    private static String calclo(String user, List<String> alfabetos) {
        int offset = 0;
        String newWord = "";
        List<Integer> abc=setList();

        /*getting rotations*/
        for (String x : alfabetos) {
            String numero = x.substring(0, x.length() - 1);
            if (x.charAt(x.length() - 1) == 'd') {
                offset -= Integer.parseInt(numero);
            } else {
                offset += Integer.parseInt(numero);
            }
        }

        for(int i=0; i<user.length(); i++){
            int lastIndex=abc.size()-1;
            int index=abc.indexOf((int)user.charAt(i));
            int indexPlusOffset=index+offset;
            if((indexPlusOffset)>lastIndex){
                index=(-1)+(indexPlusOffset-lastIndex);
            }else if(indexPlusOffset<0) {
                index = abc.size() + (indexPlusOffset);
            }else{
                index=indexPlusOffset;
            }
            newWord+=(char)((int)abc.get(index));
        }
        return newWord;
    }

    private static List<Integer> setList(){
        /*filling list*/
        List<Integer> list=new ArrayList<>();
        for(int i=97; i<=110; i++){
            list.add(i);
        }
        list.add(164);
        for(int i=111; i<=122; i++){
            list.add(i);
        }
        for(int i=65; i<=78; i++){
            list.add(i);
        }
        list.add(165);
        for(int i=79; i<=90; i++){
            list.add(i);
        }
        for(int i=48; i<=57; i++){
            list.add(i);
        }
        return list;
    }
}
