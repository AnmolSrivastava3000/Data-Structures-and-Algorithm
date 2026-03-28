import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Arraylist_revision {
    

    // container with most water
    public static void water(ArrayList<Integer> height){

        int maxw=0;
        // brute force
        for (int i = 0; i < height.size(); i++) {
            for (int j = i+1; j < height.size(); j++) {
                int ht=Math.min(height.get(i),height.get(j) );
                int width = j-i;
                int currwater= ht*width;
                maxw= Math.max(maxw, currwater);
            }
        }
        System.out.println(maxw+" is the max water stored");
    }

    // container with most water ,2 pointer approach -
    public static void pointerwater(ArrayList<Integer> height){

        int max =0 ,right=height.size()-1;
        
        for(int i=0;i<right;){
            int width = right-i;
            if(height.get(i)<height.get(right)){
                max = Math.max(max, width*(height.get(i)));
                i=i+1;
            }
            else{
                max = Math.max(max, width*(height.get(right)));
                right =right-1;
            }
        }

    System.out.println("max water is - "+max);

    }


    // pair sum 1 - find any pair in sorted arraylist has a target sum.
    public static boolean pairsum1(ArrayList<Integer> arr,int target){

        for(int i=0;i<arr.size()-1;i++){
            for (int j = i+1; j < arr.size(); j++) {
                if (arr.get(i)+arr.get(j)==target) {
                    return true;
                }
            }
        }
        

return false;

    }

    // pair sum 2 pointer
    public static boolean pairpointer(ArrayList<Integer> arr, int tar){

        int left= 0; int right = arr.size()-1;
        while (left<right) {
            if (arr.get(right)+arr.get(left)==tar) {
                return true;
            }
            else if (arr.get(right)+arr.get(left)<tar) {
                left++;
            }
            else right--;
        }
        return false;
    }

    // pair sum 2 
    // find if any pair in sorted and rotated AL has tar sum 
    // brute force of pair sum 1 will work 
    // now for rotated and sorted array ,first find the index at which arr pivot

    public static boolean pairsum2(ArrayList<Integer> arr, int tar){

        int pivot=-1; 
        int n =arr.size();
        
        // find pivot
        for (int i = 0; i < n-1; i++) {
            if (arr.get(i)>arr.get(i+1)) {
                pivot =i;
                break;
            }
        }

        int left  = (pivot ==-1)? 0:(pivot+1);
        int right = (pivot ==-1)? n-1:pivot;

        while (left !=right) {
            int curr =arr.get(left) + arr.get(right);
            if (curr==tar) {
                return true;
            }

            if (curr<tar) {
                left = (left+1)%n;
            }
            else{
                right =(n +right-1)%n;
            }
        }

        return false;
    }

            // practice questions
            // q2
    public static ArrayList<Integer> Lonely(ArrayList<Integer> nums) {
    Collections.sort(nums);
    ArrayList<Integer> list = new ArrayList<>();
    int n = nums.size();

    for (int i = 0; i < n; i++) {
        boolean isLonely = true;

        // Check left neighbor
        if (i > 0) {
            if (nums.get(i) == nums.get(i - 1) || nums.get(i) == nums.get(i - 1) + 1) {
                isLonely = false;
            }
        }

        // Check right neighbor
        if (i < n - 1) {
            if (nums.get(i) == nums.get(i + 1) || nums.get(i) == nums.get(i + 1) - 1) {
                isLonely = false;
            }
        }

        if (isLonely) {
            list.add(nums.get(i));
        }
    }
    return list;
}


        // Q3 ,most frequent no  
    public static int mostfrequent (ArrayList<Integer> nums, int key){
            int result []=new int[1000];

            for (int i = 0; i < nums.size()-1; i++) {
                if (nums.get(i)==key) {
                    result[nums.get(i+1)-1]++;
                }
            }

            int max= Integer.MIN_VALUE;
            int ans=0;

            for (int i = 0; i < result.length; i++) {
                if (result[i]>max) {
                    max= result[i];
                    ans =i+1;
                }
            }

            return ans;

        }


        
    // one of more imp distinction is this from q4 is using while loop to stop the code from unnessary going 

        // q4 ,beautiful array
        public static void beauList(int n){
            ArrayList<Integer> ans =new ArrayList<>();
            ans.add(1);
            while (ans.size()<n) {
                ArrayList<Integer> temp =new ArrayList<>();
                for ( Integer e : ans) {
                    if (e*2 -1 <=n) {
                        temp.add(2*e-1);
                    }
                }
                for (Integer e : ans) {
                    if (e*2 <=n) {
                        temp.add(2*e);
                    }
                }
                ans =temp;
            }

            // print ans
            System.out.println(ans);

        }
        

        // recursive
        public static void beauList_recursion(int n){
            ArrayList<Integer> res= new ArrayList<>();
            dividecon(1,1,res,n);
            System.out.println(res);
        }

        public static void dividecon(int start,int incre, ArrayList<Integer> ans,int n){
            if (start + incre >n) {
                ans.add(start);
                return;
            }
            dividecon(start,2*incre ,ans,n);

            dividecon(start+incre,2*incre,ans,n);

        }




    public static void main(String[] args) {

        // q4 recursive
        beauList_recursion(5);

        // q4 -iterative
        beauList(5);

        // practice q3
        ArrayList<Integer> mfn =new ArrayList<>();
        mfn.add(2);
        mfn.add(7);
        mfn.add(2);
        mfn.add(3);
        mfn.add(2);
        mfn.add(1);
        mfn.add(2);
        // int ans =mostfrequent(mfn,2);
        // System.out.println(ans);


        // practice q2 
        ArrayList<Integer> lon =new ArrayList<>();
        lon.add(2);
        lon.add(7);
        lon.add(8);
        lon.add(1);
        lon.add(4);
        // ArrayList<Integer> ans= Lonely(lon);
        // System.out.println(ans);

        // paair sum 1 /pointer ,
        ArrayList<Integer> height= new ArrayList<>();
        height.add(1);
        height.add(2);
        height.add(2);
        height.add(3);
        height.add(5);
        height.add(6);
        height.add(8);
        // System.out.println(pairsum1(height,18));
        // System.out.println(pairpointer(height, 10)); 


        // pair sum 2
        // System.out.println(pairsum2(height, 15));

        // container with most water
        // ArrayList<Integer> height= new ArrayList<>();
        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(3);
        // height.add(5);
        // height.add(6);
        // height.add(2);
        // water(height);
        // pointerwater(height);
        

        // class name objectname = new classname();

        // ArrayList<Integer> list = new ArrayList<>();
        // ArrayList<Integer> list1 = new ArrayList<>();
        // ArrayList<Integer> list2 = new ArrayList<>();


        // list.add(1); //O(1)
        // list.add(2);
        // list.add(3);

        // System.out.println(list);


        // get element = for specific element

        // delete - remove O(n)

        // set element at index
        // list.set(2, 5);
        // System.out.println(list);

        // contains - checks specific no
        // System.out.println(list.contains(1));

        // list.add(1); 
        // O(1) -adds at end

        // list.add(1,9);
        // O(n) 
        // System.out.println(list);

        // size of AL
        // list.size();
         //-this is method /funcn ,not prop ,due to arraylist

        // loop se print
        // for (int i = 0; i < list.size(); i++) {
        //     System.out.print(list.get(i)+" ");
        // }


        // sorting an arraylist
        // System.out.println(list);
        // Collections.sort(list);
        // System.out.println(list);

        // descending
        // Collections.sort(list,Collections.reverseOrder());
        // System.out.println(list);
        // comparator - fncn logic , define logic of sorting ,for funcn ,can be applied to obj ,
        // O(nlog(n))


        // AL implementation - array +dynamic size
        // - keeps doubling or 1.5x



        // // multi dimensional arraylist
        // ArrayList<ArrayList<Integer>> list_main = new ArrayList<>();
        // ArrayList<Integer> list1 = new ArrayList<>();

        // list1.add(1); list1.add(2);
        // list_main.add(list1);

        // ArrayList<Integer> list2 = new ArrayList<>();
        // // () is constructor call
        // list2.add(3); list2.add(5);
        // list_main.add(list2);

        // // System.out.println(list_main);

        // // more sophisticated way
        // for (int i = 0; i < list_main.size(); i++) {
        //     ArrayList<Integer> temp = list_main.get(i);
        //     for (int j = 0; j < temp.size(); j++) {
        //         System.out.print(temp.get(j)+ " ");
        //     }
        //     System.out.println();
        // }






    }








}
