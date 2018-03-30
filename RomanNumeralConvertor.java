import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.TreeMap;

public class RomanNumeralConvertor {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      //find smallest 
      System.out.println(convert(Integer.parseInt(line)));
    }
  }
     static TreeMap<Integer, String> map = new TreeMap<Integer, String>(); //TreeMap allowing for ordered keys so we can takw advantage for floorkey function
     static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }
    public static String convert(int n) {
        int k =  map.floorKey(n); //key closest to the value but not greater then
        if ( n == k ) {
            return map.get(n);
        }
        return map.get(k) + convert(n-k); //recursively calls for next po e.g 1205 --> 1000 (M) --> 200 (C) --> 100 (C) --> 5 (V)
    }

}
