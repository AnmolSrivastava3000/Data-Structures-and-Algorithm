public class divideandconquer {

    // 2nd revision 21 11 25,


                //  practice q3 ,
    
        public static long getInversionCount(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        // Use an auxiliary array for the merge step
        int[] temp = new int[arr.length];
        return mergeSort(arr, temp, 0, arr.length - 1);
    }

    /**
     *  Recursive function that performs the divide and conquer.
     */
    private static long mergeSort(int[] arr, int[] temp, int left, int right) {
        long inversionCount = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            // 1. Inversions in the left half
            inversionCount += mergeSort(arr, temp, left, mid);
            
            // 2. Inversions in the right half
            inversionCount += mergeSort(arr, temp, mid + 1, right);
            
            // 3. Inversions when merging two halves
            inversionCount += merge(arr, temp, left, mid, right);
        }
        return inversionCount;
    }

    /**
     *  Merges two sorted subarrays and counts cross-inversions.
    */
    private static long merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;      // Pointer for the left subarray
        int j = mid + 1;   // Pointer for the right subarray
        int k = left;      // Pointer for the merged array (arr)
        long inversionCount = 0;

        // Copy elements to the temporary array (temp) for merging
        for (int l = left; l <= right; l++) {
            temp[l] = arr[l];
        }

        // Compare elements and count inversions
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                // No inversion: Element from left array is smaller/equal
                arr[k++] = temp[i++];
            } else {
                // Inversion found: temp[i] > temp[j]
                // Since L and R are sorted, all remaining elements in L (from i to mid)
                // must also be greater than temp[j].
                
                // 1. Place the element from the right array into arr
                arr[k++] = temp[j++];   
                
                // 2. Count the inversions
                // The number of remaining elements in the left subarray is (mid - i + 1)
                inversionCount += (mid - i + 1);
            }
        }

        // Copy the remaining elements of the left half (if any)
        while (i <= mid) {
            arr[k++] = temp[i++];
        }  
        
        // (No need to copy remaining right elements, as explained in previous chat)

        return inversionCount;
    }

    // // Example Usage
    // public static void main(String[] args) {
    //     int[] arr1 = {2, 4, 1, 3, 5};
    //     // Inversions: (2, 1), (4, 1), (4, 3). Total: 3
    //     System.out.println("Array 1 Inversion Count: " + getInversionCount(arr1)); // Output: 3

    //     int[] arr2 = {5, 4, 3, 2, 1};
    //     // Inversions: 4 + 3 + 2 + 1 = 10 (Maximum)
    //     System.out.println("Array 2 Inversion Count: " + getInversionCount(arr2)); // Output: 10
    // }




    // q2 from practice questions
    // 🗳️ Boyer-Moore Voting Algorithm
// Since the problem guarantees that a majority element always exists, the final value stored in candidate is guaranteed to be the majority element.
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            // Step 1: If count is 0, elect a new candidate
            if (count == 0) {
                candidate = num;
            }

            // Step 2: Vote for or against the candidate
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Since the problem guarantees the majority element always exists, 
        // the final 'candidate' is the answer.
        return candidate;
    }


    // practice q1 ,all from gemini
    public static void mergeSort(String[] arr) {
        if (arr == null || arr.length < 2) {
            return; // Base case: already sorted or empty
        }
        mergeSort(arr, new String[arr.length], 0, arr.length - 1);
    }

    /**
     * Recursive helper function for the divide step.
     * @param arr The array being sorted.
     * @param temp The temporary array used during the merge process.
     * @param low The starting index of the subarray.
     * @param high The ending index of the subarray.
     */
    private static void mergeSort(String[] arr, String[] temp, int low, int high) {
        if (low < high) {
            // 1. Divide (Find the midpoint)
            int middle = low + (high - low) / 2; // Avoids potential integer overflow

            // Recursively sort the left half
            mergeSort(arr, temp, low, middle);

            // Recursively sort the right half
            mergeSort(arr, temp, middle + 1, high);

            // 2. Conquer (Merge the sorted halves)
            merge(arr, temp, low, middle, high);
        }
    }

    /**
     * Merges two sorted subarrays into a single sorted array.
     * This is the core comparison and sorting step.
     * @param arr The main array where the sorted results are stored.
     * @param temp The temporary array for merging.
     * @param low The starting index of the first subarray.
     * @param middle The ending index of the first subarray.
     * @param high The ending index of the second subarray.
     */
    private static void merge(String[] arr, String[] temp, int low, int middle, int high) {
        // Copy both halves into the temporary array
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }

        int i = low;        // Pointer for the first half (low to middle)
        int j = middle + 1; // Pointer for the second half (middle+1 to high)
        int k = low;        // Pointer for the main array (arr)

        // Compare and merge the two halves
        while (i <= middle && j <= high) {
            // String comparison using compareTo():
            // A.compareTo(B) returns < 0 if A is lexicographically smaller than B.
            if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i]; // Take from the left half
                i++;
            } else {
                arr[k] = temp[j]; // Take from the right half
                j++;
            }
            k++;
        }

        // Copy the remaining elements of the left half (if any)
        while (i <= middle) {
            arr[k] = temp[i];
            k++;
            i++;
        }

        // The remaining elements of the right half are already in the correct position
        // in the temp array relative to each other, but since we copied the whole segment
        // to temp at the start, no extra step is needed for the right side remainder.
    }


    private static void printArray(String[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("\"" + arr[i] + "\"");
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }










            // easiest way to dissect -sorted rotated array
    // mid ko nikalne ke liye ,just check if mid is bigger than si ,if it is ,it lies on l1 ,if not it lies on line2 ,as it is smaller than si ,
    
    // now to find target ,check weather it is on which side of mid ,by checking if it is bigger than mid or smaller than ,so now only quarter you have to find is in on of l1 left ,l1 right ,l2 left ,l2 right.

// divide and conquer revision

    public static void quicksortrevision(int arr[],int si,int ei){

        if(si>=ei){
            return;
        }

        int pidx = partitionrevision(arr, si, ei);
        quicksort(arr, si, pidx-1);
        quicksort(arr, pidx+1, ei);

    }

    public static int partitionrevision(int arr[],int si,int ei){

        int i= si-1;
        for(int j=si;j<ei;j++) {
            if (arr[j]<=arr[ei]) {
                i++;
                // swap for the smaller side of pivot 
                int temp1 = arr[j];
                arr[j]= arr[i];
                arr[i]=temp1;
            }
        }
            // placing the pivot element
            i++;
            int temp1 =arr[i] ;
            arr[i]=arr[ei];
            arr[ei] =temp1;
            
            return i;

    }












    // 1st revision , 27 2 25 , 


    // practice q's
    // q1
        public static String[] mergesortarr(String[] arr,int lo,int hi){
            if (lo==hi) {
                String []A={arr[lo]};
                return A;
            }
            int mid = lo + (hi-lo)/2;
            String arr1[]=mergesortarr(arr, lo, mid);
            String arr2[]=mergesortarr(arr, mid+1, hi);
            String arr3[] = mergearr(arr1,arr2);
            return arr3;
        }

        public static String[] mergearr(String[] arr1,String[] arr2){
            int m = arr1.length;
            int n = arr2.length;
            String[] arr3 = new String[m+n];
            int idx =0;
            int i =0;
            int j=0;
            while (i<m&&j<n) {
                if (isAlphabeticallySmaller(arr1[i],arr2[j])) {
                    arr3[idx]=arr1[i];
                    i++;
                    idx++;
                }
                else{
                    arr3[idx]=arr2[j];
                    j++;
                    idx++;
                }}
                while (i<m) {
                    arr3[idx]=arr1[i];
                    i++;idx++;
                }
                while (j<n) {
                    arr3[idx]=arr2[j];
                    j++;idx++;
                }
            
            return arr3;
        }

        static boolean isAlphabeticallySmaller(String str1,String str2){
            if (str1.compareTo(str2)<0) {
                return true;
            }
            return false;
        }



    public static void main(String[] args) {

            // practice Q's
            // q1
            String arr3[]= {"sun","earth","mars","mercury"};
            String a[]=mergesortarr(arr3, 0, arr3.length-1);
            for(int i =0;i<a.length;i++){
                System.out.print(" " +a[i]);
            }

        // mergesort
        int arr[]={6,3,9,5,2,8};
        // mergesort(arr, 0, arr.length-1);

        quicksort(arr, 0, arr.length-1);

        // sorted n rotated array search
        // int arr2[]={6,7,8,9,1,2,3};
        // int target = 3;
        // int idx= search(arr2,target,0,arr2.length-1);
        // System.out.println(idx);
        // printarr(arr);
    }
    

    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }System.out.println();
    }



    // sorted n rotated array search
public static int search (int arr[],int tar,int si ,int ei){
    // base casee 
    if(si>ei) return -1;

    // kaam 
    int mid= si+ (ei-si)/2;
    // case found
    if (arr[mid]==tar) {
        return mid;
    }

    // mid on Line 1
    if (arr[si]<=arr[mid]) {
        // case a
        if(arr[si]<=tar &&tar<=arr[mid]){
            return search(arr, tar, si,mid-1);
        } 
        // case b ,2nd half of line 1
        else return search(arr, tar,mid+1, ei);
    }
    // line 2 
    else{
        
            // case c
            if(arr[mid+1]<=tar &&tar<=arr[ei]){
                return search(arr, tar, mid+1,ei);
            } 
            // case d,2nd half of line 2
            else return search(arr, tar,si,mid-1 );
    }

}


    //quick sort
    public static void quicksort(int arr[],int si,int ei){
        if (si>=ei) {
            return;
        }
        int pidx = partition(arr,si ,ei);
        quicksort(arr, si, pidx-1); 
        quicksort(arr, pidx+1, ei);
    }


    public static int partition(int arr[],int si,int ei){
        int pivot = arr[ei];
        int i =si-1;
        for(int j =si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                // swap
                int temp =arr[j];
                arr[j]= arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei]=arr[i];
        arr[i]= temp;
        return i;
    }


    // merge sort 

    public static void mergesort(int arr[],int si ,int ei){
        // base case
        if(si>=ei){
            return ;
        }

        
        // kaam
        int mid = si+(ei-si)/2; 
        mergesort(arr, si, mid);
        mergesort(arr, mid+1, ei);
        merge(arr,si,mid,ei);

    }


    public static void merge (int arr[],int si,int mid,int ei){
        int temp[]=new int[ei-si+1];
        int i =si;
        int j=mid+1;
        int k=0;
        while (i<=mid && j<=ei) {
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;k++;
            }
            else{temp[k]=arr[j];
                k++;j++;
            }}
            // left over of left part
            while (i<=mid) {
                temp[k++]=arr[i++];
            }
            // left over of right part
            
            while (j<=ei) {
                temp[k++]=arr[j++];
            }
            // copy temp to original arr
            for(k=0,i=si;k<temp.length;k++,i++){
                arr[i]=temp[k];
            }
        
    }
}



// public class divideandconquer {
    
//     public static void main(String args[]){
//         // System.out.println("hi");

//         int arr[] = {2,352,3,5,6,34};
//         // merge sort
//         // mergesort(arr, 0, arr.length-1);

//         // quick sort
//         quicksort(arr,0,arr.length-1);


//         printarr(arr);

//     }

//     public static void quicksort(int arr[],int si ,int ei){
//         // base case
//         if(si>=ei){
//             return;
//         }
//         // last element
//         int pIdx =partition(arr,si,ei);
//         quicksort(arr, si, pIdx-1); //left part
//         quicksort(arr, pIdx+1, ei); // right part



//     }

//     public static int partition(int arr[],int si ,int ei){
//         int pivot = arr[ei];
//         int i = si -1; // to make place for element smaller than pivot
//         for(int j = si ; j<ei;j++){
//             if(arr[j]<=pivot){
//                 i++;
//                 //swap
//                 int temp = arr[j];
//                 arr[j] = arr[i];
//                 arr[i] = temp ;
//             }
//         }
//         i++;
//         int temp = pivot ;
//         arr[ei] = arr[i]; // as pivot is variable so no pivot
//         arr[i] = temp;
//         return i;
//     }

//     public static void mergesort(int arr[],int si ,int ei){
//     if(si>=ei){
//         return;
//     } // base case
    
//         //kaam
//     int mid = si +(ei-si)/2;
//     mergesort(arr, si, mid);// left 
//     mergesort(arr, mid+1, ei);// right
//     merge (arr,si,mid,ei);

//     }

//     public static void merge(int arr[],int si ,int mid,int ei ){
//         int temp[] =new int[ei - si +1];
//         int i = si; // iterater for left part
//         int j = mid +1; // iterater for right part
//         int k = 0; //iterater for temp arr 

//         while(i<=mid && j <=ei ){
//             if(arr[i]<arr[j]){
//                 temp [k] =arr[i];
//                 i++;k++;
//             }
//             else{
//                 temp [k] = arr[j];
//                 j++;k++;
//             }
//         }
//         // leftover of left part
//         while(i<=mid){
//             temp[k++]= arr[i++];
//         }
//         // leftover  right part
//         while (j<=ei){
//             temp[k++] = arr[j++];
//         }
//         // copy temp to original array
//         for(k=0 , i=si;k<temp.length;k++,i++){
//             arr[i]= temp[k] ; 
//         }
//     }


//     public static void printarr(int arr[]){
//         for(int i=0;i<arr.length;i++){
//             System.out.print(arr[i]+ " ");
//         }System.out.println();
//     }


        
//         // public static void mergesort(int arr[], int si ,int ei){
//         //     if(si>=ei){
//         //     return;}
        
//         // int mid = (si+ei)/2;
//         // mergesort(arr,si,mid);
//         // mergesort(arr,mid+1,ei);
//         // merge(arr,si,mid,ei);
//         // }
        
//         // public static void merge (int arr[], int si ,int mid, int ei){
//         // int k =0;
//         // int temp []= new int [ei-si+1];
//         // int i =si;
//         // int j = mid+1;
//         // while(i<=mid && j<=ei){
//         //     if(arr[i]<arr[j]){
//         //     temp[k] =arr[i]; i++ ;k++;}
//         // else{temp[k]= arr[j];k++;j++;}}
        
//         // //left over of left 
//         // while(i <=mid){
//         //     temp[k++]= arr[i++];}
//         // //left over of right
//         // while(j <=ei){
//         // temp[k++]= arr[j++];}
        
//         // // copy temp to original array
//         // for(k=0, i = si;k<temp.length;k++ ,i++){
//         //     arr[i]=temp[k];}
//         // }
//         }
        
        



