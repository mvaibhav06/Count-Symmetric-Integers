import java.util.ArrayList;
import java.util.List;

public class SymmetricIntegers {
    public static List<Integer> getDigits(int num){
        List<Integer> temp = new ArrayList<>();

        while(num > 0){
            int a = num%10;
            temp.add(a);
            num /= 10;
        }
        //Collections.reverse(temp);
        if(temp.size()%2 != 0) return new ArrayList<Integer>();
        return temp;
    }
    public static int countSymmetricIntegers(int low, int high) {
        int out = 0;
        for(int i=low; i<=high; i++){
            List<Integer> temp = getDigits(i);
            int fsum = 0;
            int lsum = 0;
            int index = temp.size()/2;
            if (temp.size() == 0) continue;
            for(int j=0; j<index; j++){
                fsum += temp.get(j);
            }
            for(int j=index; j<temp.size(); j++){
                lsum += temp.get(j);
            }
            if(fsum == lsum){
                out++;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println(countSymmetricIntegers(1,100));
    }
}
