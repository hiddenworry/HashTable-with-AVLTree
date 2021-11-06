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
public class AVLTree<K extends Comparable<K>, V> {
     AVLNode<K,V> root;
    int height(AVLNode<K,V> N) {
        if (N == null)
            return 0;
        return N.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public AVLNode<K,V> rightRotation(AVLNode<K,V> T){
        AVLNode<K,V> T1 = T.left;
        AVLNode<K,V> R1 = T1.right;

        // Perform rotation
        T1.right = T;
        T.left = R1;

        // Update heights
        T.height = max(height(T.left), height(T.right)) + 1;
        T1.height = max(height(T1.left), height(T1.right)) + 1;

        // Return new root
        return T1;
    }
    public AVLNode<K,V> leftRotation(AVLNode<K,V> T){
        AVLNode<K,V> T1 = T.right;
        AVLNode<K,V> L1 = T1.left;

        // Perform rotation
        T1.left = T;
        T.right = L1;

        // Update heights
        T.height = max(height(T.left), height(T.right)) + 1;
        T1.height = max(height(T1.left), height(T1.right)) + 1;

        // Return new root
        return T1;
    }
    // Get Balance factor of node N
    int getBalance(AVLNode<K,V> N) {
        if (N == null)
            return 0;

//        return height(N.left) - height(N.right);
        return height(N.right) - height(N.left);
    }

   private AVLNode<K,V> insert(AVLNode<K,V> node, K key, V value) {

        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new AVLNode<K,V>(key,value));

        if (key.compareTo(node.key)<0)
            node.left = insert(node.left, key, value);
        else if (key.compareTo(node.key)>0)
            node.right = insert(node.right, key, value);
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                height(node.right));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases
        // Left Left Case
        if (balance < -1 && key.compareTo(node.left.key)<0)
            return rightRotation(node);

        // Right Right Case
        if (balance > 1 && key.compareTo(node.right.key)>0)
            return leftRotation(node);

        // Left Right Case
        if (balance < -1 && key.compareTo(node.left.key)>0) {
            node.left = leftRotation(node.left);
            return rightRotation(node);
        }

        // Right Left Case
        if (balance > 1 && key.compareTo(node.right.key)<0) {
            node.right = rightRotation(node.right);
            return leftRotation(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }


    void insert(K key, V value){
        this.root = insert(this.root, key, value);
    }
    
    public void draw() {
//        draw_NLR(this.root, "", "");
        draw_NRL(this.root, "", "");
    }

    public void draw_NLR(AVLNode<K,V> node, String prefix, String childrenPrefix) {
        if (node == null) {
            return;
        }
        System.out.println(prefix + node.key);
        if (node.right == null) {
            draw_NLR(node.left, childrenPrefix + "L-- ", childrenPrefix + "    ");
        } else {
            draw_NLR(node.left, childrenPrefix + "L-- ", childrenPrefix + "|   ");
            draw_NLR(node.right, childrenPrefix + "R-- ", childrenPrefix + "    ");
        }
    }

    public void draw_NRL(AVLNode<K,V> node, String prefix, String childrenPrefix) {
        if (node == null) {
            return;
        }
        System.out.println(prefix + node.key);
        if (node.left == null) {
            draw_NRL(node.right, childrenPrefix + "R-- ", childrenPrefix + "    ");
        } else {
            draw_NRL(node.right, childrenPrefix + "R-- ", childrenPrefix + "|   ");
            draw_NRL(node.left, childrenPrefix + "L-- ", childrenPrefix + "    ");
        }
    }

    
     public K search(K key) {
        if(search(root, key) == null)
           return null;
        else
            return(search(root,key).key);

    }
     public V getValue(K key) {
        if(search(root, key) == null)
           return null;
        else
            return(search(root,key).values);

    }
     
    private AVLNode<K,V> search(AVLNode<K,V> root, K key) {
        if (root == null) {
            return null;
        } else if (key.compareTo(root.key) == 0) {
            return root;
        } else if (key.compareTo(root.key) > 0) {
            return search(root.right, key);
        } else {
            return search(root.left, key);
        }
    }
   
    private String path(AVLNode<K,V> root, K key){

        if (root == null) {
            return null;
        } else if (key.compareTo(root.key) == 0) {
            return root.key.toString() ;
        } else if (key.compareTo(root.key) > 0) {
           return   root.key + "->" + path(root.right, key).toString();

        } else {
           return  root.key+  path(root.left, key).toString();

        }

    }
    public void path(K key){
        String s = "";
        s =  s + path(root, key);
        System.out.println(s);
    }
    private int count(AVLNode<K,V> root, K key){

        if (root == null) {
            return 0;
        } else if (key.compareTo(root.key) == 0) {
            return 1;
        } else if (key.compareTo(root.key) > 0) {
            return  count(root.right,key) + 1;

        } else {
            return  count(root.left,key) + 1;

        }

    }
    public void count(K key){
        System.out.println(count(root, key));
    }
    public void delete(K key) {
        this.root = this.delete(this.root, key);
        
    }
   
    private AVLNode<K,V> delete(AVLNode<K,V> root, K key) {
        if (root == null) {
            return null;
        }
        if (key.compareTo(root.key) < 0) {
            root.left = delete(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) {

                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = findSuccessor(root).key;

            root.right = delete(root.right, root.key);

        }
        return root;
    }
     private AVLNode<K,V> findSuccessor(AVLNode<K,V> root) {

        AVLNode<K,V> p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

}
