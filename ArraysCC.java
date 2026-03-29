import java.util.*;

public class ArraysCC {

    public static void main(String1 args[]){

        int numbers[]={-3,4,2,3};
        // maxsubarray_sumbyprefixesrevision(numbers);
        // System.out.println(trap(numbers));
        // maxsubarray_sum(numbers);
        Scanner key = new Scanner(System.in);
        int t1= key.nextInt();
        int t2= key.nextInt();
        Scanner sc = new Scanner(System.in);
        char operator= sc.next().charAt(0);
        // int t3= key.nextInt();
        // char operator ='/';
        calculate(t1, t2,operator);

        // int x = 9, y = 12;
        // int a = 2, b = 4, c = 6;
        // int exp = 4/3 * (x + 34) + 9 * (a + b * c) + (3 + y * (2 + a)) / (a + b*y);
        // System.out.println(exp);

        // System.out.println((t1+t2+t3)/3);

        // System.out.println(trappedwater(numbers));
        // kadanes(numbers);
        // maxsubarray_sum(numbers);
        // System.out.println(prefixsum(numbers));
        // System.out.println(buyandsellstocks(numbers));
    }
    



    // REVISION 
    public static void calculate(int n,int m,char l){
        int a = n, b = m ;
        char oper =l;
        switch (oper) {
                case '+': System.out.println(a+b);
                break;
                case '-':
                System.out.println(a-b);
                break;
                case '*':
                System.out.println(a*b);
                break;
                case '/':
                System.out.println(a/b);
                break;
        
            default: System.out.println("wrong operator");
                break;
        }


    }

    public static int maxsubarray_sumbyprefixesrevision(int arr[]){
        int curr=0;
        int max=Integer.MIN_VALUE;
        
        int prefix []= new int[arr.length];
        prefix[0]= arr[0];
        for(int i =1;i<prefix.length;i++){
            prefix [i] = prefix[i-1] + arr[i];
        }

        for(int i =0;i<arr.length;i++){
            
            for(int j=i;j<arr.length;j++){
                curr = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];
                if(max <curr) max=curr;System.out.println(curr);
            }
        }
        System.out.println(max);
        return max;
    }
    
    
    
    // public static int maxsubarray_sum(int arr[]){
    //     int currentsum=0;
    //     int max=Integer.MIN_VALUE;
    //     for(int i=0;i<arr.length;i++){
    //         for(int j =i;j<arr.length;j++){
    //             currentsum=0;
    //             for(int k =i;k<=j;k++){
    //                 currentsum += arr[k];
    //             }
    //             System.out.println("current sum : "+currentsum);
    //             max =Math.max(max, currentsum);
    //         }
    //     }
    //     System.out.println("maximum sum : "+max);return max;
    // }

    // public static int buyandsellstocks(int prices[]){
        
    // //     }
    // //     int buy=Integer.MAX_VALUE;
    // //     int maxprofit = 0;
    // //     int profit=0;
    // //     for(int i =0;i<prices.length;i++){
    // //         if(buy <prices[i]){
    // //             profit =prices[i]-buy;
    // //             maxprofit=Math.max(maxprofit, profit);
    // //         }
    // //         else {
    // //             buy =prices[i];
    // //         }
    // //     }
    // //     return maxprofit;
    // }

//     public static int trap(int[] height)
//         { int n = height.length; 
//         int res = 0, l = 0, r = n - 1; 
//         int rMax = height[r], lMax = height[l];
//          while (l < r) { if (lMax < rMax) { 
//             l++; 
//             lMax = Math.max(lMax, height[l]);
//             res += lMax - height[l];
//             } 
//             else { r--; 
//                 rMax = Math.max(rMax, height[r]); 
//                 res += rMax - height[r]; 
//             } } 
//             return res;
//          }
        

//     public static int trappedwater (int barheight[]){
//         int totalwater =0;
//         int leftmax[] = new int[barheight.length];
//         leftmax[0]=barheight [0];
//         int n =barheight.length;
//         for(int i=1;i<n;i++){
//             leftmax[i]=Math.max(barheight[i], leftmax[i-1]);

//         }
//         int righmax[a]=new int[barheight.length];
//         righmax[n-1]=barheight[n-1];
//         for(int i=n-2;i>=0;i--){
//             righmax[i]=Math.max(barheight[i], righmax[i+1]);
//         }
//         // now cal minimum of RM ,LM and than find waterlevel

//         for(int i =0;i<n;i++){
//             // min of rightmax,leftmax
//             int waterlevel = Math.min(righmax[i],leftmax[i]);
//             totalwater+= waterlevel-barheight[i];
//             // di has made a mistake , here if barheight is more than waterlevel , 
//             // than it will reduce totalwater , which should not be the case , 
//             // instead their should be special case which makes waterlevel-barheight 0.
//             // not with -ve barheight becoz that can't be the case

//             // lol my hypothesis is wrong ,because my understanding needs to be better , 
//             // if barheight is more than , than rightmax ,leftmax will also increase.
//             // simply it won't be more than waterlevel.or if it is than 0 water ,not -ve. 
//         }System.out.println (totalwater);
//         return (totalwater) ;
//     }


    public static void kadanes(int arr[]){

        // int cs=0;
        // int ms=Integer.MIN_VALUE;
        // for(int i =0;i<arr.length;i++){
        //     cs=cs + arr[i];
        //     if(cs<0) cs=0;
        //     ms=Math.max(ms,cs);
        // }
        // System.out.println("max subarray sum is "+ms);
    }

//     public static int prefixsum(int arr[]){
//         int max = Integer.MIN_VALUE;
//         int currsum = 0;
//         int prefix[] = new int[arr.length];
//         prefix[0] = arr[0];
//         // calculate prefix array
//         for(int i =1;i<prefix.length;i++){
//             prefix[i]= prefix[i-1] + arr[i];
//         } 

//         // calculate prefix sum
//         for(int i=0;i<prefix.length;i++){
//             // int start =i;
//             for(int j =i;j<arr.length;j++){
//                 // int end = j;
//                 currsum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
//             }
//             if(currsum > max){
//                 max = currsum;
//             }
            
//         }
//         return max;
//     }



//     // int key = 16;
// //    System.out.println("key is at arrary "+binarysearch(numbers,key));

//         // System.out.println("largest is "+largestvalue(numbers));

//         // int key =10;

//         // int index= linearsearch(numbers,key);
//         // if(index == -1){
//         //     System.out.print("Not found");
//         // }
//         // else System.out.print("key is at index "+ index);


//     public static void maxsubarray_sum(int no[]){
//         int max = Integer.MIN_VALUE;
        
//         for(int i =0;i<no.length;i++){
//             int start =i;
//             for(int j=i;j<no.length;j++){
//                 int end = j;
//                 int currentsum =0;
//                 for(int k = start ; k<=end; k++){
//                     // System.out.print(" "+no[k]);
//                     currentsum += no[k];
//                 }
//                 System.out.println(currentsum);
//                 if(max <currentsum){
//                     max =currentsum;
//                 }
//             }
//         }System.out.println("max sum is "+max);
//     }


//     public static void printsubarray(int no[]){
//         int  ts =0;
//         for(int i=0;i<no.length;i++){
//             int start = i;
            
//             for(int j=i;j<no.length;j++){
//                 int end =j;
//                 for(int k =start;k<=end;k++){
//                     System.out.print(" " + no[k]);
//                 }System.out.println();
//                 ts++;
//             }
//             System.out.println();
            
//         }System.out.println(" total subarray is "+ts);
//     }

//     public static void pairofarray(int no[]){
//         int  tp =0;
//         for(int i=0;i<no.length;i++){
            
//             int current = no[i] ;
//             for(int j=i+1;j<no.length;j++){
//                 System.out.print("("+no[i]+ ","+no[j]+") ");
//                 tp++;
//             }
//             System.out.println();
            
//         }System.out.println(" total pair is "+tp);
//     }


//     // BINARY SEARCH OF KEY , function
// // public static int binarysearch(int numbers[],int key){
// // int start = 0 , end = numbers.length-1;
// // while(start<=end){
// //     int mid = (start + end)/2;
// //     if(numbers[mid]== key){
// //         return mid;
// //     }
// //     if(numbers[mid]< key){
// //         start = mid +1;
// //     }
// //     else end = mid -1;
// // }
// // return -1;
// // }



// // public static void reverseofarray(int numbers[]){
// //     int first=0, end= numbers.length-1;
// //     while(first<end){
// //         int temp = first;
// //         numbers[first]= numbers[end];
// //         numbers[end] = temp;
// //         first++;
// //         end--;
// //     }
// //     // return numbers; 
// // // }
// //     reverseofarray(numbers);
// //         for(int i =0;i<numbers.length;i++){
// //         System.out.print(" "+numbers[i]);

//     // public static int largestvalue(int numbers[]){
//     //     int largest = Integer.MIN_VALUE;
//     //     int Smallest =Integer.MAX_VALUE;
//     //     for(int i=0;i<numbers.length;i++){
//     //         if(largest < numbers[i]){
//     //             largest=numbers[i];
//     //         }
//     //     if(Smallest > numbers[i]){
//     //             Smallest=numbers[i];
//     //         }
//     //     }
//     //     System.out.println("smallest array is " + Smallest);
//     //     return largest;

//     // }

//         // int marks[]= {97,98,99};
//         // update(marks);
//         // for(int i=0;i<marks.length;i++){
//         //     System.out.print(marks[i]+" ");
//         // }


//         // Scanner scan = new Scanner(System.in);
//         // int phy;
//         // phy = scan.nextInt();

//         // marks[0] =scan.nextInt();
//         // marks[1] =scan.nextInt();
//         // marks[2] =scan.nextInt();

//         // System.out.println("phy :"+ marks[0]);
//         // System.out.println("che :"+ marks[1]);
//         // System.out.println("math :"+ marks[2]);

//         // marks[2]=100;

//     // System.out.print("math updated "+marks[2]);

    


// // public static void update(int marks[]){
    
// //     for(int i=0;i<marks.length;i++){
// //         marks[i] += 1;
// //     }}


// //  function for finding a specific value in arrays
//     // public static int linearsearch(int numbers[], int key){

//     //     for(int i =0;i< numbers.length;i++){
//     //         if( numbers[i]== key){
//     //             return i;
//     //         }
            
//     //     }
//     //     return -1;
//     // }



    }