import java.util.*;
    public class Advancepattern{

    public static void main(String1 args[]){
    
    // palindromicpatternwithnumbers(5);
    // numberpyramid(5);
    // diamond(4);
    // solidrhombhus(5);
    // hollowrhombus(5);
    // butterfly(4);
    // zero_one_triangle(5);
    // hollowrect(4,5);
    // inverted_rotated_half_pyramid(7);
    // System.out.print("he");
    
    }




public static void palindromicpatternwithnumbers(int n){
for(int i =1;i<=n;i++){
// spaces
    for(int j=1;j<=(n-i);j++){
        System.out.print(" ");
    }
// descending
    for(int j=i;j>=1;j--){
        System.out.print(j);
    } 
// ascending
    for(int j=2;j<=i;j++){
        System.out.print(j);
    }
    System.out.println();

}

}




public static void numberpyramid(int n){
    for(int i =1;i<=n;i++){
        for(int j=1;j<=(n-i);j++){
            System.out.print(" ");
    }
    for(int j=1;j<=i;j++){
            System.out.print(i+" ");
    }
    System.out.println();
}}


public static void diamond(int n){
// for first half
    for(int i =1;i<=n;i++){
        for(int j =1;j<=(n-i);j++){
            System.out.print(" ");
        }
        for(int j=1;j<=(2*i)-1;j++){
            System.out.print("*");
        }
        System.out.println();
    }
    // for 2nd half
    for(int i =n;i>=1;i--){
        for(int j =1;j<=(n-i);j++){
            System.out.print(" ");
        }
        for(int j=1;j<=(2*i)-1;j++){
            System.out.print("*");
        }
        System.out.println();
    }

}



public static void hollowrhombus(int n){
    for(int i =1;i<=n;i++){
        for(int j =1;j<=(n-i);j++){
            System.out.print(" ");
        }
        for(int j =1;j<=n;j++){
            if(i == 1 || i == 5 || j == 1 || j == 5){
                System.out.print("*");
            }
            else System.out.print(" ");
        }
        System.out.println();
    }
}




public static void solidrhombhus(int n){
    for(int i=1;i<=n;i++){
        for(int j=1;j<=(n-i);j++){
            System.out.print(" ");
        }
        for(int j=1;j <= n;j++){
            System.out.print("*");
        }
        System.out.println();
    }
}



public static void butterfly(int n){
    for(int i =1;i<=n;i++){
        for(int j=1;j<=i;j++){
            System.out.print("*");
        }
        for(int j =1;j<=2*(n-i);j++){
            System.out.print(" ");
        }
        for(int j=1;j<=i;j++){
            System.out.print("*");
        }
        System.out.println();
    }

for(int i =n;i>=1;i--){
        for(int j=1;j<=i;j++){
            System.out.print("*");
        }
        for(int j =1;j<=2*(n-i);j++){
            System.out.print(" ");
        }
        for(int j=1;j<=i;j++){
            System.out.print("*");
        }
        System.out.println();
    }
}

    


public static void zero_one_triangle(int n){
    for(int i=1;i<=n;i++){
        for(int j =1;j<=i;j++){
            if((i + j )% 2 == 0){
                System.out.print("1");
            }
            else System.out.print("0");
        }
        System.out.println();
    }
}




public static void inverted_rotated_half_pyramid(int n){
for(int i =1;i<=n;i++){
for(int j =1;j <=n-i;j++){
    System.out.print(" ");
}
for(int j=1;j<=i;j++){
    System.out.print("*");
}
System.out.println();}
}





public static void hollowrect(int totrows ,int totcol){
for(int i=1 ;i<=totrows;i++){
    for(int j=1;j <=totcol;j++){
        if(i == 1 || i == totrows || j==1 || j == totcol){
            System.out.print("*");
        }
        else{
            System.out.print( " ");
        } 
    }
System.out.println();
}
}
}

