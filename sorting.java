import java.util.Arrays;
import java.util.Collections;

public class sorting {
    

// bubble sort

    public static void bubblesort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
                // for (int a = 0; a < arr.length; a++) {
                //     System.out.print(" "+arr[a]);
                // }
            }System.out.println();
        }
System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }
    }


    // selection sort
    public static void selectionsort(int arr[]){

        for(int i=0;i<arr.length-1;i++){
            int minposition = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minposition]>arr[j]){
                    minposition=j;
                } }
                // for (int a = 0; a < arr.length; a++) {
                //     System.out.print(" "+arr[a]);
                // }System.out.println();
                // swap
                int temp=arr[i];
                arr[i]=arr[minposition];
                arr[minposition]=temp;
        }
System.out.println();

        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }
    }


// insertion
public static void insertionsort(int arr[]){

    for(int i=1;i<arr.length;i++){
        int curr = arr[i];
        int prev=i-1;
    while (prev>=0 && arr[prev]>curr ) {
        arr[prev+1]=arr[prev];
        prev--;
    }
    // inserting element
    arr[prev+1]=curr;
    }
System.out.println();

    // for (int i = 0; i < arr.length; i++) {
    //     System.out.print(" "+arr[i]);
    // }
}

    public static void countingsort(int arr[]){

        // finding largest element
        int largest=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>largest){largest=arr[i];}
        }
        int count[] =new int[largest+1];
        
        // saaving vaalue of array in count
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int j=0;
        // saving count array in original
        for (int i = 0; i < count.length; i++) {
            while(count[i]>0){
                arr[j]=i;count[i]--;j++;
            }
            
        }
        



    }




    public static void main(String[] args) {
        

        int arr[]={5,4,3,2,1,2,4,4,3};
        // insertionsort(arr);
        // Arrays.sort(arr,Collections.reverseOrder());
        
        countingsort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }



    }
}
