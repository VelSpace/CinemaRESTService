import java.util.List;

class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        int first = 0;
        for(int i : list1){
            if(i == elem) first++;
        }
        int two = 0;
        for(int i : list2){
            if(i == elem) two++;
        }
        return first == two;
    }
}