/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;


import java.util.Objects;

/**
 *
 * @author ADMIN
 */
class Node<K, V> {

    K key;
    V Val;

    public Node(K key, V val) {
        this.key = key;
        Val = val;
    }
}

public class HashTable<K extends Comparable<K>, V> {

    private static final int numBuckets = 10;
    private AVLTree<K, V>[] buckets;
    private AVLTree<K, V> list = null;
    private int size;

    public HashTable() {
        this.buckets = new AVLTree[numBuckets];
        size = 0;
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new AVLTree<>();
        }

    }

    public int size() {
        return size;
    }

    private final int hashCode(K key) {
        return Objects.hashCode(key);
    }

    private int hash(K key) {
        return hashCode(key) % numBuckets;
    }

    // put key value vao bang bam
    public void put(K key, V value) throws Exception {
        /*
        index = hash(key)
        lay ra danh sach lien ket
        them cap key value vao danh sach lien ket
        /
         */
        int index = hash(key);
        list = buckets[index];

        if (list.search(key) != null) {
            throw new Exception("Duplicate key");
        }
        list.insert(key, value);
    }
// return value dua vao key

    public V get(K key) {
        int index = hash(key);
        list = buckets[index];       
        return list.getValue(key);
    }


    public void remove(K key) {
        int index = hash(key);
        list = buckets[index];
        list.delete(key);
        size--;
        

      
    }

}
