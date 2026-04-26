    import java.util.*;

    public class Javabasic{

    public static void printarray(int arr[]){
    
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
            System.out.println();

    }

    public static void main(String1 args[]){
    

    int arr[] = {7, 8, 1, 3, 2};

        towerOfHanoi(4,'A','B','C');




    // //insertion sort
    // for(int i=1; i<arr.length; i++) {
    //     int current = arr[i];
    //     int j = i - 1;
    //         while(j >= 0 && arr[j] > current) {
    //             //Keep swapping
    //             arr[j+1] = arr[j];
    //             j--; 
    //         }
    //     arr[j+1] = current;
    // }
    // printarray(arr);



    // // selection sort
    //     for(int i =0;i<arr.length-1;i++){
    //         int smallest = i;
    //         for(int j =i+1;j<arr.length;j++){
    //             if(arr[smallest]>arr[j]){
    //                 smallest=j;
    //             }
    //         }
    //         int temp=arr[smallest];
    //         arr[smallest]=arr[i];
    //         arr[i]=temp;
    //     }
    //     printarray(arr);



    // bubble sort 
    // for(int i =0;i < arr.length-1;i++){
    //     for(int j =0;j<arr.length-i-1;j++){
    //         if(arr[j]>arr[j+1]){
    //             int temp = arr[j];
    //             arr[j] =arr[j+1];
    //             arr[j+1] =temp;
    //         }
    //     }
    }
    // printarray(arr);
    
    public static void towerOfHanoi(int n, int src, int aux, int dest){
        if (n==1){
        System.out.println(src+" -> "+dest);
        return;
        }
        towerOfHanoi(n-1,src,dest,aux);
        towerOfHanoi(1,src,aux,dest);
        towerOfHanoi(n-1,aux,src,dest);
        }




}
    