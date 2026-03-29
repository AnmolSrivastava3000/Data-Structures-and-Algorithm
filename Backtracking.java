import java.lang.annotation.Retention;
import java.util.Scanner;

public class Backtracking {

    // N queens
    public static void nQueens(char board [][],int row){

        // base
        if (row==board.length) {
            printboard(board);
            return;
        }

        // column loop
        for(int j=0;j<board.length;j++){
            if(issafe(board,row,j)){
            board[row][j]='Q';
            nQueens(board, row+1); // function call
            board[row][j]='.'; //backtracking step
        }
    }
    }

    public static boolean issafe(char board[][],int row , int col){
        // vertically up
        for(int i =row-1;i>=0;i--){
            if (board[i][col]=='Q') {
                return false;
            }
        }

        // left diag
        for(int i =row-1, j=col-1;i>=0&&j>=0;i--,j--){
            if (board[i][j]=='Q') {
                return false;
            }
        }
        // right diag
        for(int i =row-1, j=col+1;i>=0&&j<board.length;i--,j++){
            if (board[i][j]=='Q') {
                return false;
            }
        }


        return true;
    }
    static int size =0;

    public static void printboard(char board[][]){
        size ++;System.out.println("_______chess board_________");
        for(int i=0;i<board.length;i++){
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }System.out.println();
        }
    }


        // N QUEENS WITH ONE SOLUTION ONLY
        // SPECIAL CASE 
        // public static boolean nQueens(char board [][],int row){

        //     // base
        //     if (row==board.length) {
        //         // printboard(board);
        //         return true;
        //     }
    
        //     // column loop
        //     for(int j=0;j<board.length;j++){
        //         if(issafe(board,row,j)){
        //         board[row][j]='Q';
        //         if (nQueens(board, row+1)) {
        //             return true;
        //         }
        //          // function call
        //         board[row][j]='.'; //backtracking step
        //         // stopped backtracking for single answer
        //     }
        // }
        // return false;
        // }




        // grid ways  , 2d arrays total condition

        public static int gridways(int i,int j ,int n,int m){
        
            // base case
            if (i ==n-1 && j == m-1) { // condition for last cell
                return 1;
            }

            // as base case has "AND" condition ,due to which in some cases 
            // boundry will be touched by one side ,so to save that.

            // condition for boundry cross
            else if (i == n || j==n ) {
                return 0;
            }
            int w1 = gridways(i+1, j, n, m);
            int w2= gridways(i, j+1, n, m);

            return w1+w2;
        }

        // grid ways O(n)
        public static int quickgridways(int n,int m){
        int a = n+m-2;int ans1= 1 ;
        int ans2=1;int ans3 =1;
            for(int i =1;i<=a;i++){
                ans1 *=i;
            }
            for(int i =1;i<=n-1;i++){
                ans2 *=i;
            }
            for(int i =1;i<=m-1;i++){
                ans3 *=i;
            }
            // System.out.println( ans1 +" 1 " + ans2 + " 2 " + ans3 +" 3"  );
            int finalans = ans1/(ans2 *ans3);
            return finalans;
        }


                //Sudoku solver
        public static boolean sudokusolver(int sudoku[][],int row, int col){
            // base case
            if (row ==9) {
                return true;
            }


            // recursion
            int nextcol=col+1;
            int nextrow=row;
            if(col+1==9){
                nextcol =0;
                nextrow=row+1;
            }

            if(sudoku[row][col]!=0){
                return sudokusolver(sudoku, nextrow, nextcol);
            }
            
            for(int digit=1;digit<=9;digit++){
                if(Sudokuissafe(sudoku, row, col,digit)){
                    sudoku[row][col]=digit;
                
                if(sudokusolver(sudoku, nextrow, nextcol)){ //soln exist
                    return true;
                }
                sudoku[row][col]=0; // backtracking (for false)
            }}
        return false;
        }

        // is safe for sudoku
        public static boolean Sudokuissafe(int sudoku[][],int row,int col,int digit){
            // column
            for(int i =0;i<9;i++){
                if(sudoku[i][col]==digit){
                    return false;
                }
            }

            // row
            for(int i =0;i<9;i++){
                if(sudoku[row][i]==digit){
                    return false;
                }
            }
            
            // grid
            int sr = (row/3)*3;
            int sc = (col/3)*3;
            
            for(int i =sr;i<sr+3;i++){
                for(int j =sc;j<sc+3;j++){
                    if(sudoku[i][j]==digit){
                        return false;
                    }
                }
            }
            return true;
        }

        // print sudoku
        public static void printsudoku(int sudoku[][]){
            for(int i=0;i<9;i++){
                for (int j = 0; j < 9; j++) {
                    System.out.print(" "+sudoku[i][j]);
                }System.out.println();
            }
        }

        

            // practice questions

            // q3
            // horse possible moves on 64 squares
            public static void horsemove(){
                int n=8;
                int sol[][]=new int [n][n];

                // filling sol
                for (int i = 0; i < sol.length; i++) {
                    for (int j = 0; j < sol.length; j++) {
                        sol[i][j]=-1;
                    }
                }

                // possible moves
                int movex[] = {1,2,2,1,-1,-2,-2,-1};
                int movey[] = {2,1,-1,-2,-2,-1,1,2};

                // as the knight starts from cell(0,0)
                sol[0][0]=0;


                if(horsemoveutil(0,0,sol,movex,movey ,1 )){
                    printhorse(sol);
                    return;
                }
                System.out.println("no solution exist");
            }
            

            // utility funcn
            public static boolean horsemoveutil(int x,int y,int sol[][],int movex[],int movey[],int movei){
                // base case
                if(movei==64){
                    return true;
                }

                for(int k =0;k<8;k++){
                    int nextx= x+movex[k];
                    int nexty= y+movey[k];
                    if(issafeforhorse(nextx,nexty,sol)){
                    sol[nextx][nexty]=movei;
                    if(horsemoveutil(nextx, nexty, sol, movex, movey, movei+1)){
                        return true;
                    }
                    else { sol[nextx][nexty]=-1;} // backtracking 
                    }
                }
                
                return false;
            }

            // is safe for horse
            public static boolean issafeforhorse(int x,int y,int sol[][]){
                if(x>=0 && x<8 && y >=0 && y<8 && sol[x][y] ==-1){
                    return true;
                }
                return false;
            }


            // print hourse
        public static void printhorse(int sol[][]){
            for(int i=0;i<8;i++){
                for (int j = 0; j < 8; j++) {
                    System.out.print(" "+sol[i][j]);
                }System.out.println();
            }
        }


            // q2 
            // is too tough ,,will do later

            // q1

            // print function
            public static void printmaze(int sol[][]){
                for (int i = 0; i < sol.length; i++) {
                    for (int j = 0; j < sol.length; j++) {
                        System.out.print(" "+sol[i][j]);
                    }   System.out.println();
                }
            }


            // main function 
            public static void maze(int maze[][]){
                int n =  maze.length;
                int sol [][] = new int[n][n];

                if(mazesol(maze,sol,0,0)== false){
                    System.out.println("no solution exist");
                    return ;
                }
                printmaze(sol);
            }

            // maze solution
            public static boolean mazesol(int maze[][],int sol[][],int x,int y ){

                // base case 
                if(x==maze.length-1 && y ==maze.length-1 && maze[x][y]==1 ){
                    sol[x][y]=1;return true;
                }
                

                
                if(issafemaze(maze,x,y)==true){
                    if(sol[x][y]==1){return false;}
                    sol[x][y] = 1;
                    if (mazesol(maze, sol, x+1, y)) {
                        return true;
                    }
                    if ( mazesol(maze,sol,x,y+1)) {
                        return true;
                    }
                    sol[x][y]=0;  // backtrack
                    return false;

                }
                return false;
            }

            // issafe for maze
            public static boolean issafemaze(int maze[][],int x ,int y){
                if(x>=0 && y>=0 && x<maze.length && y<maze.length &&
                maze[x][y]==1){
                    return true; }
                return false;
            }


    public static void main(String args[]){


        // question practice 
        // q1
        int maze1[][] = {{1,0,0,0},
                        {1,1,0,1},
                        {0,1,0,0},
                        {1,1,1,1}
};  
        // maze(maze1);


        // q2 is tough , later (after graph /tree)

        // q3
        // horse moves
        // horsemove();














    
        // System.out.println(Math.exp());

        // solver sudoku
        int sudoku[][] = {
            {0,0,8,0,0,0,0,0,0},
            {4,9,0,1,5,7,0,0,2},
            {0,0,3,0,0,4,1,9,0},
            {1,8,5,0,6,0,0,2,0},
            {0,0,0,0,2,0,0,6,0},
            {9,6,0,4,0,5,3,0,0},
            {0,3,0,0,7,2,0,0,4},
            {0,4,9,0,3,0,0,5,7},
            {8,2,7,0,0,9,0,1,3}
    };

    // if(sudokusolver(sudoku, 0, 0)){
    //     System.out.println("solution exist");
    //     printsudoku(sudoku);
    // }
    // else{System.out.println("solution not exist");}







        // grid ways  , 2d arrays total condition to travel
        // int g = gridways(0, 0, 4, 3);
        // // System.out.println(g);

        // grid ways quicker O (n)
        // System.out.println(quickgridways(4, 3));
        




// N queens

int n=4;
char board[][] = new char[n][n];
// initialise
for(int i =0;i<n;i++){
    for(int j=0;j<n;j++){
        board[i][j] = '.';
        
    }
}
    // nQueens(board,0);
    // System.out.println("total variations " + size);

            // ONLY ONE SOLUTION IN N QUEENS
            // if ( nQueens(board,0)) {
            //     System.out.println("solution is possible");
            //     printboard(board);
            // }
            // else System.out.println("solution is not possible");



        // find permutation
        // String str="abc";
        // findpermutation(str, "");




        //     //subsets of string
        // String str="abc";
        // findsubsets(str, "", 0);



            // backtracking array
        // int arr[]=new int[5];
        // changeArr(arr, 0, 1);
        // printarr(arr);
    }

    public static void changeArr(int arr[],int i , int val){
        // base case
        if(i==arr.length){
            printarr(arr);
            return;
        }
        // recursive function
        arr[i]=val;
        changeArr(arr, i+1, val+1); //fnx call step
        arr[i]=arr[i]-2; // backtracking step

    }
    
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }System.out.println();
    }

    public static void findsubsets(String str,String ans, int i){
            // base case
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else{
            System.out.println(ans);}
            return;
        }
            //recursion 
        // yes choice
        findsubsets(str,ans+str.charAt(i) ,i+1);
        // no choice
        findsubsets(str, ans, i+1);

    }


    // find permutation
    public static void findpermutation(String str,String ans){
        // base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }


        // recursion
        for(int i =0;i<str.length();i++){
            char curr= str.charAt(i);
            // "abcde" => "ab" +"de" =abde
            String newstr =str.substring(0, i)
            + str.substring(i+1); //i does not come
            // System.out.println(newstr);
            findpermutation(newstr, ans+curr);
        }

    }

    



}
