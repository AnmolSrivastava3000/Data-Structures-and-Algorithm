import java.util.*;

public class Arraylist {

        // practice q1 
        public static boolean q1(ArrayList<Integer> nums ){
            boolean inc = true;
            boolean dec =true;
            for(int i =0;i<nums.size()-1;i++){
                if (nums.get(i)<nums.get(i+1)) {
                    dec =false;
                }
                if (nums.get(i)>nums.get(i+1)) {
                    inc=false;
                }
            }
            return inc || dec;
        }

            // q2
        public static ArrayList<Integer> findLonely (ArrayList<Integer>nums) {
    Collections.sort(nums);
ArrayList<Integer> list=new ArrayList<>();
for(int i=1;i<nums.size()-1;i++) {
if(nums.get(i-1)+1<nums.get(i)&&nums.get(i)+1<nums.get(i+1)){list.add(nums.get(i));
}}
if(nums.size() ==1) {list.add(nums.get(0));}
if(nums.size() >1){
    if(nums.get(0) +1<nums.get(1)) {
    list.add(nums.get(0));
}
if(nums.get(nums.size()-2)+1<nums.get(nums.size()-1))
{list.add(nums.get(nums.size()-1));
}
}
return list;
}

        // `   q3
        public static int mostfrequent(ArrayList<Integer> nums,int key){
            int result[]=new int[1000];
            for(int i=0;i<nums.size()-1;i++){
                if (nums.get(i)==key) {
                    result[nums.get(i+1)-1]++;
                }
            }
            int ans =0;
            int max = Integer.MIN_VALUE;
            for(int i=0;i<1000;i++){
                if (result[i]>max) {
                    max= result[i];
                    ans= i+1;
                }
            }
            return ans;
        }

        // Q4
        // beautiful arraylist
        public static ArrayList<Integer> beautifulArray(int n) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(1);
        
            for (int i = 2; i <= n; i++) {
                ArrayList<Integer> temp = new ArrayList<>();
        
                for (Integer e : ans) {
                    if (2 * e-1 <= n) {
                        temp.add(e * 2-1);
                    }
                }

                for (Integer e : ans) {
                    if (2 * e  <= n) {
                        temp.add(e * 2 );
                    }
                }
                
                ans = temp;
            }
        
            return ans;
        }


        






    public static void main(String[] args) {


                // practice Q's
                // q1
        //         ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add (4);
        // list.add(5);
        // list.add(6);
        // list.add(7);
        // System.out.println(q1(list));


        // Q'2
        // ArrayList<Integer> result = findLonely(list);
        // System.out.println(result);


        // Q'3
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(100);
        // list.add(200);
        // list.add (1);
        // list.add(10);
        // list.add(1);
        // list.add(8);
        // list.add(200);
        // list.add (1);
        // list.add(9);
        // int key =1;

        // System.out.println(mostfrequent(list, key));


        // Q4
        // beautiful arraylist
        System.out.println(beautifulArray(3));  



                // Arraylist , 1st time 





        // System.out.println("");


        // // Java collection Framework
        // // className objectName = new className();
        // ArrayList<Integer> list = new ArrayList<>();
        // ArrayList<Integer> list2 = new ArrayList<>();
        // ArrayList<Integer> list3 = new ArrayList<>();


        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add (4);
        // list.add(5);
        // list.add(6);
        // list.add();
        

        // System.out.println(list);

        // // get operation - O(1)
        // int element = list.get(2);
        // System.out.println(element);

        // list.remove(2);
        // System.out.println(list);
        
        // list.set(2, 10);
        // System.out.println(list);
        // System.out.println(list.contains(1));

        // // another way to add
        // list.add(1,9);
        // System.out.println(list);

                //size of AL
        // System.out.println(list.size());

        // // print AL
        // for(int i =0;i<list.size();i++){
        //     System.out.println(list.get(i));

        // // reverse print
        // for(int i=list.size()-1;i>=0;i--){
        //     System.out.println(list.get(i));
        // }

        // find max in AL
        // int max=Integer.MIN_VALUE;
        // for(int i=0;i<list.size();i++){
        //     // if(max<list.get(i)){
        //         // max = list.get(i);
        //     // }
        //     max = Math.max(max,list.get(i));
        // }
        // System.out.println(max);

            // swap 2 nos
        // swap(list, 1, 3);
        //         System.out.println(list);

        // System.out.println(list);
        // Collections.sort(list); // ascending
        // System.out.println(list);
        // //descending
        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        // Implementation

        // Multidimensional ArrayList
        // ArrayList<ArrayList<Integer>> mainlist  = new ArrayList<>();
        // ArrayList<Integer> list = new ArrayList<>();
        // // list.add(1);list.add(2);
        

        // // mainlist.add(list);

        // ArrayList<Integer> list2 = new ArrayList<>();
        // list2.add(3);list2.add(4);
        // mainlist.add(list2);
        // // mainlist in java 0.list 
        // // 1. list2 
        
        // for(int i=0;i<mainlist.size();i++){
        //     ArrayList<Integer> currlist = mainlist.get(i);
        //     for(int j =0;j<currlist.size();j++){
        //         System.out.print(currlist.get(j)+ " ");
        //     }
        // }
        // System.out.println("\n\t"+mainlist);

        // question
        // ArrayList<Integer> list3 = new ArrayList<>();
        // for(int i =1;i<=5;i++){
        //     list.add(i*1); //12345
        //     list2.add(i*2) ; // 246810
        //     list3.add(i*3) ; // 3 6 9 12 15
        // }
        // mainlist.add(list);
        // mainlist.add(list2);
        // mainlist.add(list3);
        
        // System.out.println(mainlist);
        // for(int i =0;i<mainlist.size();i++){
        //     ArrayList<Integer> currlist = mainlist.get(i);
        //     for(int j=0;j<currlist.size();j++){
        //         System.out.print(currlist.get(j));
        //     }System.out.println();
        // }

        //         // stored water Q
        // ArrayList<Integer> height = new ArrayList<>();
        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        // height.add(7);

        // System.out.println(storewater(height));
        // container with most water Q's
        // System.out.println(storefast(height));


        // ArrayList<Integer> list = new ArrayList<>();
        
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        // list.add(6);
        // Pair sum bruteforce
        // System.out.println(pairsum1(list, 53));
        // pointer approach 
        // System.out.println(pairsumfast(list, 5));


            //pair sum 2 (code)
        
        //     list.add(11);
        //     list.add(15);
        //     list.add(6);
        //     list.add(8);
        //     list.add(9);
        //     list.add(10);
        //     int target = 16;


        // System.out.println(pairsum2(list, 16));



    }
        


//         public static boolean pairsum2(ArrayList<Integer> list, int target){
//             int bp = -1;int n = list.size();
//             for(int i = 0 ;i<list.size();i++){
//                 if (list.get(i)>list.get(i+1)) {//breaking poiint
//                     bp = i;
//                     break;
//                 }
//             }

//             int lp=bp+1; // smallest
//             int rp =bp;// largest
//             while(lp!=rp){
//                 // case1
//                 if(list.get(lp)+list.get(rp) == target){
//                     return true;
//                 }

//                 // case 2
//                 if(list.get(lp)+list.get(rp)<target){
//                     lp= (lp+1)%n;
//                 }
            
//                 // case 3
//                 else{
//                     rp= (rp +n -1)%n;
//                 }
//             }
//             return false;
//         }



//     // o(n)
//     public static boolean pairsumfast(ArrayList<Integer> list, int target){
//         int lp = 0;int rp= list.size()-1;
//         while(lp<rp){
//         // if case 1
//         if(list.get(lp)+list.get(rp)==target){
//             return true;
//         }
//         else if(list.get(lp)+list.get(rp)>target){
//             rp--;
//         }
//         else{ lp ++;
//         }
//         }
//         return false;
//     }



// // public static boolean pairsum1(ArrayList<Integer> list, int target){
// //     for(int i =0;i<list.size();i++){
// //         for(int j=i+1;j<list.size();j++){
// //             if(list.get(i )+list.get(j)== target){
// //                 return true;
// //             }
// //         }
// //     }
// //     return false;
// // }



//         // stored water Q in O(n) 2 pointer approach
//     public static int storefast(ArrayList<Integer> height){
//         int maxwater = 0;
//         int lp =0;
//         int rp = height.size()-1;
//         while (lp<rp) {
//             int width = rp -lp;
//             // cal water areaa
//             int ht = Math.min(height.get(lp), height.get(rp));
//             int currwater = ht * width;
//             maxwater = Math.max(maxwater, currwater);
//             // update ptr
//             if(height.get(lp) < height.get(rp)){
//                 lp++;
//             }
//             else{
//                 rp--;
//             }
//         }
//         return maxwater;
//     }




//         // stored water Q
//         public static int storewater(ArrayList<Integer> height){
//             int maxwater =0;
//             // brute force same as pair of array Q
//             for(int i = 0;i <height.size();i++){
//                 for(int j = i+1 ;j<height.size();j++){
//                     int ht = Math.min(height.get(i), height.get(j));
//                     int width = j-i;
//                     int currwater = ht *width;
//                     maxwater = Math.max(maxwater,currwater);
                    
//                 }
//             }
// // O(n^2)   
//         return maxwater;
//         }






//         public static void swap(ArrayList<Integer> list, int idx1,int idx2){
//             int temp = list.get(idx1);
//             list.set(idx1,list.get(idx2));
//             list.set(idx2,temp);
//         }
        





    }

