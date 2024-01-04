package DataStructures.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
public class HashMap<K, V> {
    ArrayList<LinkedList<MapNode<K, V>>> hashMap;
    int size;
    int buckets;
    
    public HashMap(int b) {
        hashMap = new ArrayList();
        for(int i = 0; i < b; i++) {
            hashMap.add(new LinkedList<MapNode<K, V>>());
        }
        size = 0;
        buckets = b;
    }
    
    private double loadFacCalc()  {
        if (buckets == 0) {
            return 0;
        }
        return ((double) size)/buckets;
    }
 
    private int hashFunction(K a,  int b) {
        return a.hashCode() %  (b - 1);
    }
    
    private void resize() {
        ArrayList<LinkedList<MapNode<K, V>>> temp = new ArrayList();
        //doubles the size of the arraylist every time
        for(int i = 0; i < 2 * buckets; i++) {
            temp.add(new LinkedList<MapNode<K, V>>());
        }
        //rehashes all of the elements
        for(int i = 0; i < buckets; i++) {
            for(int j = 0; j < hashMap.get(i).size(); j++) {
                int x = hashFunction(hashMap.get(i).get(j).key, buckets * 2);
                temp.get(x).add(hashMap.get(i).get(j));
            }
        }
        buckets *= 2;
        hashMap = temp;
    }
    
    public void add(MapNode<K,  V>  a)  {
        //Checks for duplicates, throws error if needed
        if(hashMap.size() > hashFunction(a.key, buckets) && !hashMap.get(hashFunction(a.key, buckets)).isEmpty()) {
            for(MapNode<K, V> elem: hashMap.get(hashFunction(a.key, buckets))) {
                if(a.key.equals(elem.key))  {
                    throw new IllegalArgumentException("Duplicate key");
                }
            }       
        }
        //ensures proper loadFactor
        if(loadFacCalc() > 0.75)  { 
            resize();
        }
        hashMap.get(hashFunction(a.key, buckets)).add(a);
        size++;
    }
    
    public V get(K k) {
        int in = hashFunction(k, buckets);
        for(int i = 0; i < hashMap.get(in).size(); i++) {
            if(k.equals(hashMap.get(in).get(i).key)) {
                return hashMap.get(in).get(i).val;
            }
        }
        return null;
    }

    public K remove(K k) {
        int in = hashFunction(k, buckets);
        for(int i = 0; i < hashMap.get(in).size(); i++) {
            if(k.equals(hashMap.get(in).get(i).key)) {
                K temp = hashMap.get(in).remove(i).key;
                size--;
                return temp;
            }
        }
        throw new IllegalArgumentException("Not in list");
    }
    
    public String toString() {
        String s = "(";
        for(int i = 0; i < hashMap.size(); i++) {
            if(i == 0) {
                s += "[";
            }
            else {
                s +=", [";
            }
            for(int j = 0; j < hashMap.get(i).size(); j++) {
                if(j == 0) {
                    s += hashMap.get(i).get(j).toString();
                }
                else {
                    s += " ," + hashMap.get(i).get(j).toString();
                }
            }
            s += "]";
        }
        return s + ")";
    }
    /* public static void main(String[] args) {
        HashMap<Double, Integer> a =  new HashMap<Double, Integer>(2);
        a.add(new MapNode<Double, Integer>(1.5, 1));
        a.add(new MapNode<Double, Integer>(2.5, 2));
        a.add(new MapNode<Double, Integer>(3.5, 3));
        a.add(new MapNode<Double, Integer>(4.5, 4));
        System.out.println(a.size);
        System.out.println(a);
        System.out.println(a.get(1.5));
        a.remove(2.5);
        System.out.println(a.get(2.5));
        System.out.println(a);
        a.add(new MapNode<Double, Integer>(4.5, 3));
        System.out.println(a);
    } */
}