import java.util.List;
import java.util.ArrayList;
public class Solution {
    
    // arranging input in ascending order
    public static String ascending(String n){
        char[] temp_arr = n.toCharArray();
        for(int i=0;i<temp_arr.length;i++){
            for(int j=i+1;j<temp_arr.length;j++){
                if(temp_arr[i] > temp_arr[j]){
                    char temp = temp_arr[i];
                    temp_arr[i] = temp_arr[j];
                    temp_arr[j] = temp;
                }
            }
        }
        String result = new String(temp_arr);
        return result;
    }
    // arranging input in descending order
    public static String descending(String n){
        char[] temp_arr = n.toCharArray();
        for(int i=0;i<temp_arr.length;i++){
            for(int j=i+1;j<temp_arr.length;j++){
                if(temp_arr[i] < temp_arr[j]){
                    char temp = temp_arr[i];
                    temp_arr[i] = temp_arr[j];
                    temp_arr[j] = temp;
                }
            }
        }
        String result = new String(temp_arr);
        return result;
    }
    // conversion of decimal to given base
    public static String decimalToBase(String n, int base){
        return Integer.toString(Integer.parseInt(n,10),base);
    }
    // conversion of given base to decimal
    public static String baseToDecimal(String n, int base){
        return Integer.toString(Integer.parseInt(n,base),10);
    }
    // adjust length of result from subtraction result to length of original input
    public static String fitLength(String n, int org){
        if(org > n.length()){
            while(org != n.length()) n="0"+n;
        }
        return n;
    }
    
    // SOLUTION
    public static int solution(String n, int b) {
        int k = n.length();
        List<String> minion_id_list = new ArrayList<String>();
        while(true){
            String x = descending(n);
            String y = ascending(n);
            try{
                int xi = Integer.parseInt(baseToDecimal(x,b));
                int yi = Integer.parseInt(baseToDecimal(y,b));
                int z = xi-yi;
                
                String minionID = fitLength(decimalToBase(Integer.toString(z),b),k);
                if(n.equals(minionID) || minion_id_list.contains(minionID)){
                    return minion_id_list.size() - minion_id_list.indexOf(minionID);
                }
                else{
                    n = minionID;
                    minion_id_list.add(minionID);
                }
            }catch(Exception ignored){}
        }
    }
}