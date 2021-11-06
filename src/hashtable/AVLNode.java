package hashtable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class AVLNode<K,V> {
      K key;
      V values;
    int height;
    AVLNode<K,V> left, right;
 
    AVLNode(K key, V value) {
        this.key = key;
        this.values = value;
        this.height = 1;
        this.left = this.right = null;
    }
   
}
