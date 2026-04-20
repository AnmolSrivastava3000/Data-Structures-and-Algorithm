import java.util.*;


public class Greedyalgo {
    




    public static void main(String[] args) {
        

        //     // activity selection
        //     int start[] ={1,3,0,5,8,5};
        //     int end[] = {2,4,6,7,9,9};


        //     // sorting
        // int activities[][ ]=new int[start.length][3];
        // for(int i=0;i<start.length;i++){
        //     activities[i][0]=i;
        //     activities[i][1]=start[i];
        //     activities[i][2]=end[i];
        // }
        

        // // Comparator is used sorting 2d arrays
        //lambda function for sorting 
        // Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));
        // // nlogn -tc


        // // end time basis sorted
        // int max =0;
        // ArrayList<Integer> ans =new ArrayList<>();

        // // 1st activity
        // max =1;
        
        // // sorting 
        // ans.add(activities[0][0]);

        // // ans.add(0);
        // int lastend=activities[0][2];
        // for(int i=1;i<end.length;i++){
        //     if(activities[i][1]>=lastend){
        //         // activity select
        //         max++;
        //         ans.add(activities[i][0]);
        //         lastend =activities[i][2];
        //     }
        // }

        // System.out.println("max activities = " + max);
        // for(int i=0;i<ans.size();i++){
        //     System.out.print(" A"+ ans.get(i) );
        // }
        


    //         // Fractional knapsack
    //     int val []={60,100,120};
    //     int weight[]={10,20,30};
    //     int w= 50;

    //     double ratio[][]=new double[val.length][2];
    //     // 0th col-idx ; 1st col -ratio

    //     for(int i=0;i<val.length;i++){
    //         ratio[i][0]=i;
    //         ratio[i][1]=val[i]/(double)weight[i];
    //     }

    //     //lambda function for sorting 
    //     Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
    //     // due to ascending order ,run loop opposite

    //     int capacity =w;
    //     int finalval=0;
    //     for (int i = ratio.length-1; i >=0; i--) {
    //         int idx=(int)ratio[i][0];
    //         if(capacity>=weight[idx]){
    //             finalval += val[idx];
    //             capacity -=weight[idx];
    //         }else{
    //             // include the size a/c to how much capacity left
    //             finalval += (ratio[i][1]*capacity);
    //             capacity=0;
    //             break;
    //         }
    //     }

    //     System.out.println("final value - "+finalval);


        // min absolute difference pairs 
        // int a [] ={1,2,3};
        // int b[]= {2,3,5};

        // Arrays.sort(a);
        // Arrays.sort(b);

        // int difference=0;

        // for(int i=0;i<a.length;i++){
        //     difference+=Math.abs(b[i]-a[i]);
        // }
        // System.out.println("min absolute difference is "+difference);


        //     // max length of chain of pairs
        // int pairs[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};

        // Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));

        // int chainlen=1;
        // int chainend=pairs[0][1];//first pair

        // // now findingmax length similar as activity selection
        // for (int i = 1; i < pairs.length; i++) {
        //     if(chainend<pairs[i][0]){
        //         chainlen++;
        //         chainend = pairs[i][1];
        //     }
        // }


        // System.out.println("max length of chains="+chainlen);


            // Indian coins (change)
        // Integer coins[]={1,2,5,10,20,50,100,500,2000};
        // int eg =121;

        // // sort
        // Arrays.sort(coins,Comparator.reverseOrder());
        // int countofcoins=0;
        // ArrayList<Integer> ans = new ArrayList<>();

        // for (int i = 0; i < coins.length; i++) {
        //     if(coins[i]<=eg){
        //         while (coins[i]<=eg) {
        //             eg = eg-coins[i];
        //             countofcoins++;
        //             ans.add(coins[i]);
        //         }
        //     }
        // }


        // System.out.println("total (min) coins used "+countofcoins);

        //   for (int i = 0; i < ans.size(); i++) {
        //     System.out.print(" "+ans.get(i));
        // }System.out.println();


              // job sequencing problem
        //there is deadline but ,each job takes 1 unit time
        
        // sort the job ,than approach with max profit 

        

        // int jobsinfo[][]={{4,20},{1,10},{1,40},{1,10}};

        // ArrayList<Job> jobs=new ArrayList<>();

        // for (int i = 0; i < jobsinfo.length; i++) {
        //     jobs.add(new Job(i,jobsinfo[i][0],jobsinfo[i][1]));
        // }

        // Collections.sort(jobs,(obj1,obj2)-> obj2.profit-obj1.profit);
        // // asceding order of profit
        // //lambda function

        // ArrayList<Integer> seq = new ArrayList<>();
        // int time=0;
        // for(int i=0;i<jobs.size();i++){
        //     Job curr=jobs.get(i);
        //     if(curr.deadline>time){
        //         time ++;
        //         seq.add(curr.id);
        //     }
        // }

        // // print
        // System.out.println("max job = "+seq.size());
        // for (int i = 0; i < seq.size(); i++) {
        //     System.out.print(" "+seq.get(i));
        // }System.out.println();


                // chocola problem 
        int n =4 , m=6;
        Integer costver[] = {2,1,3,1,4}; //m-1
        Integer costhor[] = {4,1,2}; // n-1

        Arrays.sort(costver,Collections.reverseOrder());
        Arrays.sort(costhor,Collections.reverseOrder());
        //decsending

        int h=0 , v=0;
        int hp=1, vp=1; // pieces
        int cost=0; 

        while (h<costhor.length && v<costver.length) {
            
        }



    }



         // job sequencing problem
        
        static class Job{
            int deadline ;
            int profit;
             int id ; //O(a) ,1(b) , 2(c)

            //constructor
            public Job(int i ,int d, int p){
                id= i;
                deadline =d;
                profit =p;
            }


         }














}
