import java.util.*;

public class Main {

    static void changeList(List<String> list) {
       String maxstr = "";
       for(String s : list){
           if(s.length() > maxstr.length()) maxstr = s;
       }
       for(int i=0;i< list.size();i++){
           list.set(i, maxstr);
       }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}
interface demo{

}
class A implements demo{
}
class B implements demo{

}
class Main1{
    public static void main(String[] args) {
        HashMap<Integer, demo> hm = new HashMap<>();
        hm.put(1, new A());
        hm.put(2, new B());
    }
}