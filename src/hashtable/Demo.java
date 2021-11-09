/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

/**
 *
 * @author ADMIN
 */
public class Demo {

    public static void main(String[] args) throws Exception {
        HashTable<Integer, String> hs = new HashTable<>();
        hs.put(1, "A");
        hs.put(11, "B");
        hs.put(21, "C");
        hs.put(31, "D");
        hs.put(41, "E");
        hs.put(51, "F");
        hs.put(61, "G");
        hs.put(71, "H");
        hs.put(81, "I");
        hs.put(91, "J");
        hs.put(101, "K");
        hs.put(111, "L");
        hs.put(121, "M");
      hs.remove(31);
      hs.remove(51);
      hs.remove(81);
      hs.remove(1);
      hs.remove(91);
      hs.remove(71);
      // remove and rebalance
        hs.test();
        System.out.println(hs.get(41));
        System.out.println(hs.get(91));

    }
}
