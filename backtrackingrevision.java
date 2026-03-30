public class backtrackingrevision {


    // this revision is complete 17 12 25


    // practice Q's
    // q1 ,rat in maze
    public static void solvemaze(int maze[][]){

        int N = maze.length;
        int sol[][] = new int[N][N];
        if (solvemaze(maze, 0, 0, sol)) {
            ratprint(sol);
        }
        else{
            System.out.println("soln do not exist");
        }
        }


public static boolean solvemaze(int maze[][],int x,int y ,int sol[][]) {
        
        if (x ==maze.length-1 && y==maze.length-1 && maze[x][y]==1) {
            sol[x][y]=1;
            return true;
        }


        if (israt(maze, x, y)) {
            if (sol[x][y]==1) {
                return false;
            }
            sol[x][y]=1;
            if (solvemaze(maze, x+1, y, sol)) {
                return true;
            }
            if (solvemaze(maze, x, y+1, sol)) {
                return true;
            }
            sol[x][y]=0;
            return false;
        }

        return false;
        }

        // is safe funcn
        public static boolean israt(int maze[][],int x,int y){

            if (x>=0 && x<maze.length && y>=0 && y<maze.length && 
                maze[x][y]==1) {
                return true;
            }

            return false;
        }

        public static void ratprint(int sol[][]){
            for (int i = 0; i < sol.length; i++) {
                for (int j = 0; j < sol.length; j++) {
                    System.out.print(" "+ sol[i][j]);
                }
                System.out.println();
            }
        }


        //Q3
        // knight tour

        public static void knight(int board[][],int x,int y){

            int sol[][] = new int[board.length][board.length];
            knight(board, x, y,sol,0);

        }

        public static boolean knight(int board[][],int x,int y,
        int sol[][] ,int position){

            int newx= x;
            int newy= y+1;
            if (newy==board.length) {
                newx +=1;
                newy=0;
            }

            if (isknight(board,x,y,sol)) {
                sol[x][y]= position;
                position+=1;
                if (knight(board, newx, newy, sol, position)) {
                    return true;
                }
                sol [x][y]=0;
                position -=1;
            }
            return false;
        }

        public static boolean isknight(int board[][],int x,int y,
        int sol[][]){

            if(x>=0 && x<board.length && y>=0 && y<board.length &&)

            return false;
        }


        // Q2
        // keypad combination



        // q3





    public static void main(String[] args) {
        

        // practice question
        // q1 rat in maze
        int maze[][] = { 
            {1,0,0,0},
            {1,1,0,1},
            {1,1,1,0},
            {0,1,1,1} 
        };
            solvemaze(maze);



                    // this is theory 

        // on arrays
        int arr[]=new int[5];
        // changearr(arr, 0, 1);
        // printArr(arr);


        // find subsets
        // String str = "abc";
        // subsets(str,"",0);


        // find permutations
        // n! permutations for n element and due to strings ,tc -O(N *N!)
        // permutation("abc", "");


        // N queens
            // time complexity -O(n!) 
        int n =4;
        char board[][]= new char[n][n];
        // initialize
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]='.';
            }
        }

        // if(nQueens_singlesolutions(board,0)){
        //     System.out.println("solutions exists");
        // }
        // else{ System.out.println("no solutions for n queens");}

        // n queens count ways
        // System.out.println(count+" is total ways to count ");

        // n queens single solution



        // grid ways
        int a =4,  b=4;
        // System.out.println(gridways(0,0,a,b));
        // time complexity = O(2^(n+m))
    
        // grid ways trick for linear time 
        // total characters = n-1 + m-1;
        // use combination
        // (n-1+m-1)!/(n-1)!(m-1)!



        // sudoku solver
        int sudoku[][] = { 
        {0, 0, 8, 0, 0, 0, 0, 0, 0},
        {4, 9, 0, 1, 5, 7, 0, 0, 2},
        {0, 0, 3, 0, 0, 4, 1, 9, 0},
        {1, 8, 5, 0, 6, 0, 0, 2, 0},
        {0, 0, 0, 0, 2, 0, 0, 6, 0},
        {9, 6, 0, 4, 0, 5, 3, 0, 0},
        {0, 3, 0, 0, 7, 2, 0, 0, 4},
        {0, 4, 9, 0, 3, 0, 0, 5, 7},
        {8, 2, 7, 0, 0, 9, 0, 1, 3} 
    };

        // if(sudokusolver(sudoku, 0, 0)){
        // printsudoku(sudoku);}
        // else{
        //     System.out.println("solutions doesn't exist");
        // }

        int evilSudoku[][] = {
    {0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 3, 0, 8, 5},
    {0, 0, 1, 0, 2, 0, 0, 0, 0},
    {0, 0, 0, 5, 0, 7, 0, 0, 0},
    {0, 0, 4, 0, 0, 0, 1, 0, 0},
    {0, 9, 0, 0, 0, 0, 0, 0, 0},
    {5, 0, 0, 0, 0, 0, 0, 7, 3},
    {0, 0, 2, 0, 1, 0, 0, 0, 0},
    {0, 0, 0, 0, 4, 0, 0, 0, 9}
};


    // if(sudokusolver(evilSudoku, 0, 0)){
    //     printsudoku(evilSudoku);}
    //     else{
    //         System.out.println("solutions doesn't exist");
    //     }


    }




    // Sudoku solver
        public static boolean sudokusolver(int sudoku[][],int row ,int col){

            // base case
            if (row==9) {
                return true;
            }

            // recursion
            int nextrow = row;
            int nextcol = col+1;
            if (nextcol==9) {
                nextcol=0;
                nextrow = row + 1; 
            }

            if (sudoku[row][col]!=0) {
                return sudokusolver(sudoku, nextrow, nextcol);
            }

        for(int digit=1;digit<=9;digit++){
            
            if (sudoku_safe(sudoku, row, col,digit)) {
                sudoku[row][col] =digit;
                if (sudokusolver(sudoku, nextrow, nextcol)) {
                    return true;  //soln exist
                }
                sudoku[row][col]=0;
            }
            
            }
        return false;
        }

        public static boolean sudoku_safe(int sudoku[][],int row,int col,int digit){
            // for row
            for(int i=0;i<9;i++){
                if (sudoku[row][i]==digit) {
                    return false;
                }
            }

            // for column
            for(int i=0;i<9;i++){
                if (sudoku[i][col]==digit) {
                    return false;
                }
            }

            // for 3*3 grid
            col = (col/3)*3;
            row = (row/3)*3;
            for (int i = row; i <row+ 3; i++) {
                for(int j=col ;j<col+3;j++){
                    if (sudoku[i][j]==digit) {
                        return false;
                    }
                }
            }

            return true;
        }

        // print sudoku
        public static void printsudoku(int sudoku[][]){
            for (int i = 0; i < sudoku.length; i++) {
                for (int j = 0; j < sudoku.length; j++) {
                    System.out.print(" "+sudoku[i][j]);
                }
                System.out.println();
            }
        }


        // grid ways trick for linear time 
    // use combination formula for all possible paths ,without arrangement 


        // grid ways
        // no of ways to reach from(0,0) to (n-1,m-1) in n*m grid
        // please look at images in lecture for more clarity ,it is pretty simple question
        public static int gridways(int i ,int j ,int n ,int m){

            // base case
            if (i==n-1 || j==m-1) {
                return 1;
            }
            else if (i==n || j==m) {
                return 0;
            }

            int w1= gridways(i+1, j, n, m);
            int w2 =gridways(i, j+1, n, m);
            return w1+w2;

        }




    //  n queens -count ways ,total no of ways in which we can solve n queens problem

    public static boolean nQueens_singlesolutions(char board[][],int row){
        // base
        if (row ==board.length) {
            //  single solutions for n queens

            printboard(board);
            return true;
        }

        // column loop
        for (int j = 0; j < board.length; j++) {
            if (issafe(board,row,j)) {
            board[row][j]= 'Q';
            if(nQueens_singlesolutions(board, row+1)){
                return true;
            }
            board[row][j]='.'; // backtracking
            }
        }
        return false;
    }






        //  just change print function in base case of n queens
        static int count=0;


    // n queens
    public static void nQueens(char board[][],int row){
        // base
        if (row ==board.length) {
            printboard(board);

            // n queens count ways 
            // count++;

            //  single solutions for n queens
            return;
        }

        // column loop
        for (int j = 0; j < board.length; j++) {
            if (issafe(board,row,j)) {
            board[row][j]= 'Q';
            nQueens(board, row+1);
            board[row][j]='.'; // backtracking
                
            }
        }
    }

    //  check safety and return true
    public static boolean issafe(char board[][],int row,int col){
        // vertically up
        for(int i=row-1;i>=0;i--){
            if (board[i][col]=='Q') {
                return false;
            }
        }

        //  leftdiag up
        for(int i=row-1,j=col-1;i>=0 && j>=0 ;i--,j--){
            if (board[i][j]=='Q') {
                return false;
            }
        }

        //  righdiag up
        for (int i = row-1,j=col+1 ; i>=0 && j <board.length; i--,j++) {
            if (board[i][j]=='Q') {
                return false;
            }
        }
        return true;
    }

    //print board
    public static void printboard(char board[][]){
        System.out.println(".....chess board .....");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(" "+board[i][j]);
            }
            System.out.println();
        }
    }



    // find permutations
    public static void permutation(String str, String  ans){
        if (str.length()==0) {
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch =str.charAt(i);
    String newstr = str.substring(0, i) + str.substring(i+1);
            permutation(newstr, ans+ch);
}
}



    // find subsets
    public static void subsets(String str ,String ans ,int i){
        if (i==str.length()) {
            if (ans.length()==0) {
                System.out.println("null");
            }
            else {System.out.println(ans);}
            return;
        }

        // yes choice
        subsets(str,ans+str.charAt(i),i+1);
        // no choice
        subsets(str,ans,i+1);
    }




    // on arrays
    public static void changearr(int arr[],int i,int val){

        // base case
        if (i==arr.length) {
            printArr(arr);
            return;
        }

        // recursion
        arr[i]= val;
        changearr(arr, i+1, val+1);

        arr[i]= arr[i]-2; //backtracking step

    }

    // print array
    public static void printArr(int arr[]) {
    for(int i=0; i<arr.length; i++) {
        System.out.print(arr[i]+" ");
    }
    System.out.println();
}






}
