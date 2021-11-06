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
       hs.put(1, "One");
       hs.put(2, "two");
       hs.put(3, "three");
        System.out.println(hs.get(3));
        hs.remove(3);
        System.out.println(hs.get(3));
        
       
       
    }
}
