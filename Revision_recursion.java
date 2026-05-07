public class Revision_recursion {
    

    //n to 1
    public static void nto1(int n){
        if(n ==1){
            System.out.println(n);return;
        }
        System.out.println(n);
        nto1(n-1);
        // return n;
    }


    // factorial
    public static int fact(int n){
        if(n ==1){
            return n;
            // System.out.println(n);return;
        }
        int facto=n *fact(n-1);
        System.out.println(" "+ facto);
        return facto;
        // return n;
    }

    // fibonacci
    // public static int fib(int n){
    //     if(n ==1 || n==0){
    //         return n;
    //         // System.out.println(n);return;
    //     }
    //     int facto=fib(n-1)+fib(n-2);
    //     System.out.println(" "+ facto);
    //     return facto;
    //     // return n;
    // }

    // sorted array 
    // public static boolean sortcheck(int arr[],int length){

    //         if(length-2 == 0){
    //         if(arr[length -2]<arr[length-1]){
    //             return true;
    //         }else {return false;}
    //         }
    //         if(arr[length-2]>arr[length-1])return false;
    //         return sortcheck(arr, length-1);
    //         // return true;
    //     }


    // first occurence
    public static int firstocc(int arr[],int i ,int key){
        if(i==arr.length)return -1;

        if(arr[i]==key){return i;}
        return firstocc(arr, i+1, key);
        
        
    }

    // last occrrence
    public static int lastocc(int arr[],int i ,int key){
        if(i==arr.length)return -1;
        int isfound = lastocc(arr, i+1, key);
        // maam way is very weird to solve ,but interesting ,;
        if(isfound == -1 && arr[i]==key){
            isfound =i;
        }
        return isfound;
        
    }

    // power x to n
    public static int power(int x ,int n){
        if(n==0){
            return 1;
        }
        int result = x*power(x,n-1);
        return result;
    }

    // optimised
    public static int optpower(int x ,int n){
        if(n==0){
            return 1;
        }
        int answer = optpower(x, n/2);
        int lol= answer * answer ;
        // n is odd
        if(n%2 !=0){
            lol = x *lol;
        }
        return lol;
    }

    //recursion part 2
    // remove duplicate
    public static void remove(String str, int i,StringBuilder sb,boolean map[]){
        if (i==str.length()) {
            System.out.println(sb);
            return;
        }
        char c= str.charAt(i);
        if(map[c-'a']==true){
            remove(str, i+1, sb, map);
        }
        else{
            map[c-'a'] = true;
            // sb =sb.append(str.charAt(i));
            remove(str, i+1,sb.append(c), map);
        }
    }


        // tiliing problem
        public static int tiling(int n){
            if (n==1 || n==0) {
                return 1;
            }
            int tot = tiling(n-1) +tiling(n-2);
            return tot;
        }



            // friends pairing problem

// That's an excellent approach! The function you've provided, `pairing(n)`, solves the **Friends Pairing Problem**, which asks for the number of ways **$n$ friends** can remain single or be paired up.

// To understand this solution from **instinct** (the fundamental logic of the problem), we'll focus on the **first friend** and the choices they have. This is the core strategy for building recursive solutions.

// ---

// ## 🤔 **Instinctive Thinking: The Friends Pairing Problem**

// The goal is to find $P(n)$, the total number of ways to pair up $n$ friends. We base our decision on what the **first friend (Friend #1)** does. 

// ### 1. **Focus on the First Friend (Friend #1)**

// Friend #1 has only two mutually exclusive choices:

// ### **Choice A: Friend #1 Remains Single (Alone)**

// * **Action:** Friend #1 decides to stay alone.
// * **Result:** Since Friend #1 is now accounted for, we are left with **$n-1$** remaining friends (Friend #2 through Friend #n) who still need to be paired up among themselves.
// * **Ways:** The number of ways to arrange the remaining $n-1$ friends is simply **$P(n-1)$**.

// $$\mathbf{\text{Ways}_A = P(n-1)}$$

// ---

// ### **Choice B: Friend #1 Gets Paired (With Someone)**

// * **Action:** Friend #1 decides to pair up with one of the other $n-1$ remaining friends.
// * **Step 1: Choose a Partner:** Friend #1 can choose any of the **$n-1$** other people as their partner.
//     * This gives us **$(n-1)$** options for pairing.
// * **Step 2: Solve the Rest:** Once Friend #1 and their chosen partner are paired, they are permanently accounted for.
//     * This leaves us with **$n-2$** friends who still need to be paired up among themselves.
//     * The number of ways to arrange the remaining $n-2$ friends is **$P(n-2)$**.
// * **Ways:** We multiply the number of partner choices by the ways the rest can be arranged.

// $$\mathbf{\text{Ways}_B = (n-1) \times P(n-2)}$$

// ---

// ## 💻 **Connecting Instinct to Your Code**

// The **Total Ways $P(n)$** is the sum of the ways for all possible choices: $\text{Ways}_A + \text{Ways}_B$.

// $$\mathbf{P(n) = P(n-1) + (n-1) \times P(n-2)}$$

// Your code snippet directly implements this formula:

// | Your Code Variable | Mathematical Term | Represents |
// | :--- | :--- | :--- |
// | `a1 = pairing(n-1);` | $\mathbf{P(n-1)}$ | **Choice A:** Friend #1 is **Single**. |
// | `a2 = pairing(n-2);` | $\mathbf{P(n-2)}$ | Part of **Choice B:** The remaining $n-2$ friends are paired. |
// | `int pair = a2 * (n-1);` | $\mathbf{(n-1) \times P(n-2)}$ | **Choice B:** Friend #1 is **Paired** with one of the $n-1$ options. |
// | `int sum = pair + a1;` | $\mathbf{P(n-1) + (n-1) \times P(n-2)}$ | The **Total** number of ways. |

// ### **The Base Cases**

// The base cases provide the necessary starting values to stop the recursion:

// | $n$ | Problem | Result $\mathbf{P(n)}$ | Your Code |
// | :--- | :--- | :--- | :--- |
// | **$n=1$** | 1 friend | **1** (Must stay single) | `return n;` (returns 1) |
// | **$n=2$** | 2 friends | **2** (Single-Single OR Paired) | `return n;` (returns 2) |

// This approach of focusing on the **first element/person/item** and listing its exhaustive choices is the most reliable way to derive recursive formulas for counting problems like this.



    public static int pairing(int n){
        if(n ==1 || n==2)return n;
        int a1=pairing(n-1);
        int a2=pairing(n-2);
        int pair=a2*(n-1);
        int sum = pair+ a1;
        return sum;
    }

        //binary string with non consecutive one's
        public static void printbinstring(int n , int lastplace,String str){
            // base case
            if(n==0){
                System.out.println(str);return;
            }

            // kaam
            printbinstring(n-1, 0, str+"0");
            if(lastplace==0){
                printbinstring(n-1, 1, str+"1");
            }

        }


        // recursion practice question
        // q1
        public static void printkeyindex(int arr[],int key,int ind){
            if(ind==arr.length){
                return;
            }
            if(arr[ind]==key){
                System.out.println("key is at "+ind);
            }
            printkeyindex(arr, key, ind+1);
        }

        // q2
        public static void printdigit(int no,String str){
            String arr[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
            if(no==0){
                System.out.println(str);return;}

            int a=no%10;
            str= arr[a]+" "+str;
            printdigit(no/10, str);
        }

        //  q3
        public static int lengthofstring(String str){
            if(str.length()==0){
                return 0;
            }
            return lengthofstring(str.substring(1))+1;
        }
        // palindrome in substring
        //  actually code is not about palindrome ,nor the question ask about palindrome ,it just about first and last character which end with same letter 
        // mistake by me 
        public static int palindromeinsubstring(String str, int i , int j, int n){
            if(n==1){
                return 1;
            }
            if (n<=0) {
                return 0;
            }
            int res  = palindromeinsubstring(str, i+1, j, n-1)
            +palindromeinsubstring(str, i, j-1, n-1)
            -palindromeinsubstring(str, i+1,j-1,n-2);
        
        if(str.charAt(i)==str.charAt(j)){
            res++;
        }
        return res;
        }

        // iterative approach for q4
        // this code is wrong in the sense, it find first and last same character ,not palindrome .
public static int countContiguousSubstrings(String s) {
                int count = 0;
                int n = s.length();
                
                for (int i = 0; i < n; i++) {
                    for (int j = i; j < n; j++) {
// Check if the first and last characters of the substring match
                        if (s.charAt(i) == s.charAt(j)) {
                            count++;
                        }
                    }
                }
                return count;
            }


        // q5 tower of hanoi
        public static void toh(int n,String src,String helper,String dest){
            // if(n==0){System.out.println("chal be chutiya");return;}
            if(n==1){
                System.out.println("transfer disk "+n+" from "+src+" to "+dest);a++;
            return;}

            toh(n-1,src,dest,helper);
            System.out.println("transfer disk "+n+" from "+src+" to "+dest);a++;

            toh(n-1,helper,src,dest);
            // System.out.println("transfer disk "+n+" from "+src+" to "+dest);
        }

        public static int a =0;


        // Tiling Problem
        public static int tilingproblem(int n){
            // base 
            if(n==0||n==1){
                return 1;
            }
            
            // kaam
            // vertical choice
            int fnm1=tilingproblem(n-1);

            // horizontal choice
            int fnm2=tilingproblem(n-2);
            int totways=fnm1+fnm2;
            return totways;
        }



    public static void main(String[] args) {
    
        // recursion practice question
        

        // q1
        // int arr[]={1,2,4,3,2,2,6,7};
        // printkeyindex(arr,2,0);
        
        // q2
        // printdigit(19470, "");

        // q3
        // System.out.println(lengthofstring("acde"));

        // q4
        // String str="abcab";

        // iterative approach
        // System.out.println(countContiguousSubstrings(str));
        
        // recursive approach
        // System.out.println(palindromeinsubstring(str, 0,str.length()-1 , str.length()));;


        // q5 tower of hanoi
        toh(3,"S","H","D");
        System.out.println("a is"+a);






// binary string with non consecutive one's
        // printbinstring(3 , 0,"");
        

        // friends pairing problem
        // System.out.println(pairing(1));
        // System.out.println(pairing(2));
        // System.out.println(pairing(3));
        // System.out.println(pairing(4));
        // System.out.println(pairing(5));
        // System.out.println(pairing(6));


        // tiling problem
        // System.out.println(tiling(4));





                    //recursion part 2 

        
        // remove duplicate
        // String str="appnnc";
        // StringBuilder sb = new StringBuilder() ;
        
        // boolean map[]=new boolean[26]; 
        // remove(str,0,sb,map);



        
    // optimised        //power x to n
        // System.out.println(optpower(2,6));



        //power x to n
        // System.out.println(power(2,10));


        // int arr[ ]= {2,5,6,7,5,8,8,8};

        // last occ
        // System.out.println(lastocc(arr,0,5));; 


        // first occ
        // System.out.println(firstocc(arr,0,8));;


         // sorted arraay check
        // System.out.println(sortcheck(arr, arr.length));


        // sorted array check



        // fibnoacii
        // System.out.println(fib(7));


    // factorail
    // int n=fact(5);System.out.println(n+" is the answer");


        // nto1
        // nto1(5);

        


        // System.out.println(2);



    }







}
