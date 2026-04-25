import java.util.*;


                //left AT THE IMPLEMENTATION PART ,THAT WAS LONG 
                // AND TOUGH .  



public class Hashmap2 {

    // hashmap implementation code 
    static class HashMap<K,V> { // <> is generics , para meterized type
        // eg they can be float ,int , boolean , etc

        
    private class Node {
        K key ;
        V value;
        
    public Node(K key , V value ){
        this.key =key;
        this.value =value;
    }
}

    private int size ;// n
    private LinkedList<Node> buckets[] ; //N = buckets.length

        @SuppressWarnings("unchecked")
    public HashMap(){
        this.size =4;
        this.buckets = new LinkedList[4];
        for(int i =0;i<4;i++){
            this.buckets[i]=new LinkedList<>();
        }
    }
    private int hashFunction(K key){
        int hc = key.hashCode();
        // 1234567; -1234566;
        return Math.abs(hc)%size;
    }

    private int SearchInLL (K key,int bi){
        LinkedList <Node> ll = buckets[bi];

        for(int i =0f)
    }



    public void put (K key ,V value ){
        int bi =hashFunction(key); // 0 to size-1
        int di =SearchInLL(key);
    }

    public boolean containsKey(K key){
        return false;
    }

    public V remove(K key){
        return null;
    }







    }

    

    public static void main(String[] args) {

        HashMap<String ,Integer> hm = new HashMap<>();

        // insert
        hm.put("India", 100);
        hm.put("US" , 50);
        hm.put("china", 150);
        hm.put("australia", 90);
        hm.put("UK", 10);
        
        

        // System.out.println(hm);

        // // get O(1) , gives 'null' if not found  
        // int population  =hm.get("India");
        // System.out.println(population);

        // // containskey -O(1) // gives true ,false
        // System.out.println(hm.containsKey("japan"));

        // // remove ,gives "null" if false
        // System.out.println(hm.remove("china"));
        //         System.out.println(hm);

        // to clear all
        // hm.clear();

        // // size 
        // System.out.println(hm.size());

        // // is empty 
        // System.out.println(hm.isEmpty());


    // Iterate
    Set<String> keys = hm.keySet();
    // System.out.println(keys);

    for (String k : keys) {
        System.out.println("key "+k+" value " + hm.get(k));
    }

    }








}
