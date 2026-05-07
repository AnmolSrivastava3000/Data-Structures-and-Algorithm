import java.util.*;

import javax.print.DocFlavor.STRING;

public class Recursion {
    public static void main(String args[]){
        
        // printdec(12);
        // printinc(12);
        // int x =fact((int)5);
        // System.out.println(x);
        // int x=calcsum(5);
        // System.out.println(x);
        // fibonacci no
        // int x = fib(25);
        // System.out.println(x);

        // sorting
        int arr[] = {2,3,2,4,456,4,93};
// System.out.println(issorted(arr, 0));

        // find key array
        int key = 4;
        // System.out.println(findkey(arr, 0,key));

// last occurence
    // System.out.println(lastocc(arr, key, 0));

//power of 
    // System.out.println(power(4,2));

        // // // tiling prblem
        // System.out.println(tilingproblem(0));
        // System.out.println(tilingproblem(1));
        // System.out.println(tilingproblem(5));
        // System.out.println(tilingproblem(6));
        // System.out.println(tilingproblem(7));
        // System.out.println(tilingproblem(8));
        // System.out.println(tilingproblem(9));
        // System.out.println(tilingproblem(10));
        // System.out.println(tilingproblem(11));
        // System.out.println(tilingproblem(12));
        // System.out.println(tilingproblem(13));

        // remove duplicate in array
        // String str = "appnnacollege";
        // removedup(str, 0, new StringBuilder(""), new boolean[26]);

        // // friendsPairing
        // System.out.println(friendsPairing(1));
        // System.out.println(friendsPairing(2));
        // System.out.println(friendsPairing(3));
        // System.out.println(friendsPairing(4));
        // System.out.println(friendsPairing(5));
        // System.out.println(friendsPairing(6));
        // System.out.println(friendsPairing(9));
        // System.out.println(friendsPairing(10));
        // System.out.println(friendsPairing(11));
        // System.out.println(friendsPairing(12));
        // System.out.println(friendsPairing(13));

        // print binary string without consecutive 1
        // printbinstrings(2, 0, "");


        // int numbers[]={1,-2,6,-1,3};.
        // System.out.println(fibn(6));
        ;
    }

    // public static void printbinstrings(int n , int lastplace, String str){
    //     // base case
    //     if(n== 0 ){
    //         System.out.println(str);
    //         return;
    //     }
        
    //     // kaam
    //     printbinstrings(n-1, 0, str+"0");

    //     if(lastplace == 0){
    //     printbinstrings(n-1, 1, str+"1");
    //     }
    // }

    public static int friendsPairing(int n){
        if(n==1 || n ==2){
            return n;
        }
        // choice
        // single
        int fnm1 = friendsPairing(n-1);

        // pair
        int fnm2 = friendsPairing(n-2);
        int pairways = (n-1)*fnm2;
        // totways
        int totways = fnm1 +pairways;
        return totways;
        // return friendsPairing(n-1) +(n-1)*friendsPairing(n-2);
    }



// public static void removedup(String1 str , int idx ,StringBuilder newstr,boolean map[] ){
//     if(idx ==str.length()){
//         System.out.println(newstr);
//         return;
//     }
//     char currchar = str.charAt(idx);
//     if(map [currchar-'a']==true){
//         // duplicate
//         removedup(str, idx+1, newstr, map);

//     }
//     else{ 
//         map[currchar-'a'] =true;
//         removedup(str, idx+1, newstr.append(currchar), map);
// }
// }


// public static int tilingproblem(int n){
//     // 2 x n (floor size)
//     //base case
//     if(n==0|| n==1){
//         return 1;
//     }
//     // kaam
//     // vertical choice
//     int fnm1= tilingproblem(n-1);

//     // horizontal choice
//     int fnm2 = tilingproblem(n-2);

//     int totalways = fnm1 +fnm2;
//     return totalways;

// }


// public static int optpower(int a, int n ){
//     if(n==0){
//         return 1; 
//     }
//     int halfpower=optpower(a, n/2);
//     int halfpowersq = halfpower *halfpower;

//     // int halfpowersq = optpower(a, n/2) * optpower(a, n/2);
//     // n is odd
//     if(n % 2 !=0){ halfpowersq = a *halfpowersq;
// }
// return halfpowersq;
// }


//     public static int power(int x,int n){
//         if(n==0){
//             return 1;
//         }
//         // int xnm1= power(x,n-1);
//         // int xn = x *xnm1;
//         // return xn;
//         return x *power(x, n-1);
//     }


//     public static int lastocc(int arr[],int key , int i){
//         if(i==arr.length){
//             return -1;
//         }
//         int isfound = lastocc(arr, key, i+1);
//         // isfound is working as switch
//         if(isfound ==-1 && arr[i]==key){
//             return i;
//         }

//         // // check with self
//         // if(arr[i]== key){
//         //     return i;
//         // }
//         return isfound;
//     }


//     public static int findkey(int arr[],int i,int key){
//         if(i==arr.length-1){
//             return -1;
//         }
//         if(arr[i] == key){
//             return i;
//         }
//         return findkey(arr, i+1,key);

//     }

//     public static boolean issorted (int arr[],int i){
//         if(i==arr.length-1){
//             return true;
//         }
//         if(arr[i]>arr[i+1]){
//             return false;
//         }
//         return issorted(arr, i+1);

//     }


//     public static int fib(int n ){
//         if(n == 0 || n ==1){
//             return n;
//         }
//         int fnm1 = fib(n-1);
//         int fnm2 = fib(n-2);
//         int fn = fnm1 +fnm2;
//         return fn;
        
//     }

// public static int calcsum(int n){
//     if(n== 1){
//         return 1;
//     }
//     int sum=calcsum(n-1);
//     int sn = n +sum;
//     return sn;
// }







// public static int fact(int n){
//     if(n==1){
//         return 1;
//     }
//     int facto = n * fact(n-1);
//     return facto;
// }

//     // in inc order 1 to n
//     public static void printinc(int n ) {
//         if(n == 1){
//             System.out.println(n);
//             return;
//         }
//         printinc(n-1);
//         System.out.println("" + n );
        
        
//     }


    
//     // numbers in decreasing order
//         public static void printdec(int n ) {
//             if(n == 1){
//                 System.out.println(n);
//                 return;
//             }
//             System.out.println("" + n );
//             printdec(n-1);
            
//         }


//     public static int fibn(int n){
//         if(n==1 || n== 0) {
//             return n ;
//         }
        
//             // int fnm= printdec(n-1);
//             int fnm1=fibn(n-1);
//             int fnm2=fibn(n-2);
//             int fn = fnm1+fnm2 ;
//         // System.out.println(n+" "+ fn);
//         // printdec(n+1);
//         return fn;
//     }
}

