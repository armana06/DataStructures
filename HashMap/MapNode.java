package DataStructures.HashMap;
public class MapNode<K, V> {
    K key;
    V val;
    public MapNode(K e, V k) {
        key = e;
        val = k;
    }
    public String toString() {
        return "{" + key.toString() + ":" + val.toString() + "}";
    }
    public static void main(String[] args) {
        MapNode<Integer, Double> a = new MapNode<Integer, Double>(1, 1.5);
        System.out.println(a.val);
    }
}