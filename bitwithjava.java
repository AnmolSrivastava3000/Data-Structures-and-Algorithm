public class bitwithjava {


    // clear range of bits
    public static void bitm(int n,int last ,int initial){
        int a=(~0)<<(last+1);
        // System.out.println(a);
        int b = ((1<<initial)-1);
        int bitmask= a | b;
        int val = bitmask & n;
        System.out.println(val);
    }




    public static void main(String[] args) {



        //convert to upper case
        for(char ch ='A' ;ch<='Z';ch++){
            System.out.println((char)(ch | ' '));
        }

        // faster exponentiation 
        int a =3 ;  //no
        int n= 4;  //power
        int ans=1;
        while(n>0){     // sara khel power shift karne ka hai
            if ((n & 1)!=0) {//check lsb
                ans= ans *a ;
                
            }
            a = a*a;
            n = n>>1;
        }
        // System.out.println(ans);







        // //count set in no 
        // int n=7;int count=0 ;
        // while (n>0) {
        //     if ((n & 1) == 1) {
        //         count++;
        //     }
        //     n=n>>1;
        // }
        // System.out.println(count);
        





        // power of 2 check
        // int n =4;
        // if((n & (n-1)) == 0){
        //     System.out.println("hell yeah");
        // }
        // else System.out.println("oh no");

        // int n =100;
        // System.out.println(~7);


        // range change
        // bitm(10,4 ,2 );


        // odd even 
        // oddeven(4);



    }


    public static void oddeven(int n){
        int bitmask=1;
        if((n & bitmask)==0){
            System.out.println((1<<2) -1);
        }else System.out.println("odd");
    }
    





}
