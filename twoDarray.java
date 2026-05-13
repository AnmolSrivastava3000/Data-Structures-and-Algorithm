import java.util.Scanner;

public class twoDarray{


    // spiral matrix 
    public static void spiral(int matrix[][]){
        int sr=0;
        int sc=0;
        int er=matrix.length-1;
        int ec=matrix[0].length-1;

        while (sr<=er && sc<=ec) {

            // top
            for(int i=sc;i<=ec;i++){
                System.out.print(" "+matrix[sr][i]);
            }

            // right
            for(int j=sr+1;j<=er;j++){
                System.out.print(" "+matrix[j][ec]);
            }

            // bottom
            for(int i=ec-1;i>=sc;i--){
                // if(sr==er){break;} 
                //this is break condition for repeating cases ,in odd  matrix
                // starting column and ending column should not be same ,2 times.
                                // only for some odd cases ,rare 
                System.out.print(" "+matrix[er][i]);
            }

            // left
            for(int i=er-1;i>=sr+1;i--){
                // if(sc==ec){break;} 
                //this is break condition for repeating cases ,in odd  matrix
                // starting row and ending row should not be same ,2 times.
                // only for some odd cases ,rare 
                System.out.print(" "+matrix[i][sc]);
            }
            sr++;sc++;er--;ec--;

            
        }
    }







    // search in sorted matrix
    public static void search(int arr[][],int key){
        int s=0;
        int sk=arr[0].length-1;

        // search
        while(sk>=0 && s<=arr.length-1){
            if(arr[s][sk]==key){
                System.out.println(key+"is at _"+s+","+sk);return;
            }
            else if(key<arr[s][sk]){
                sk--;
            }
            else s++;
    }

    System.out.println("key not found");
    }


                // diagonal sum finding mtd


    public static void diagonalsum(int arr[][]){
        // normal mtd
        // int sum=0;
        // for(int i =0;i<arr.length;i++){
        //     for (int j = 0; j < arr[0].length; j++) {
        //         if (arr.length % 2 !=0 && i==j) { //arr.length % 2 !=0  is unnecesaaary condition
        //             sum+=arr[i][j];//primary diagonal
        //         }
        //         if(i+j == arr.length-1){
        //             if ( j==i) {
        //                 continue;
        //             }
        //             sum+=arr[i][j];
        //         }
        //     }
            
        // }
        // System.out.println("sum is "+sum);


        // optimised
        int sum=0;
        for(int i =0;i<arr.length;i++){
            // primaary diag
            sum+=arr[i][i];
            // 2ndary 
            if(i != arr.length-1-i){
            sum+=arr[i][arr.length-1-i];
        }
        
        }
        System.out.println("sum is "+sum);
        






    }







    public static void main(String1[] args) {
        System.out.println(2);


        // inserting element
        // int matrix[][]=new int[2][2];
        // int m =matrix.length;
        // int n=matrix[0].length;

        // Scanner sc1= new Scanner(System.in);
        
        
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         matrix[i][j]=sc1.nextInt();
        //     }
        // }



        // printing 
        
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(matrix[i][j]+" ");
        //     }
        // }
        

        // smallest
        // int sm=Integer.MAX_VALUE;
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(sm>matrix[i][j])
        //         sm=matrix[i][j];
        //     }
        // }
        // System.out.println("\n"+sm);



        // spiral matrix
        // int arr[][]=new int[4][4];
        // int a=1;
        // for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<arr[0].length;j++){
        //         arr[i][j]=a;a++;
        //     }
        // }

        // // printing spiral
        // for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<arr[0].length;j++){
        //     System.out.print(arr[i][j]+" ");;
        //     }System.out.println();
        // }
            
        // spiral(arr);


        // diagonal sum
        int arr[][]=new int[5][5];
        int a=1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=a;a++;
            }
        }
// printing
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
            System.out.print(arr[i][j]+" ");;
            }System.out.println();
        }
            

        diagonalsum(arr);





        // seach in sorted matrix

        // int arr[][]=new int[4][4];
        // int a=1;
        // for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<arr[0].length;j++){
        //         arr[i][j]=a;a++;
        //     }
        // }

        // // printing spiral
        // for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<arr[0].length;j++){
        //     System.out.print(arr[i][j]+" ");;
        //     }System.out.println();
        // }

        // search(arr,15);





    }




}

