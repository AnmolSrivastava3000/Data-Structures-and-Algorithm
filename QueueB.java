import java.util.*;

public class QueueB {

            // using array

    // static class Queue{
        
    //     static int arr[];
    //     static int size;
    //     static int rear;

    //     // for circular queue
    //     static int front;

    // Queue(int n){
    //     arr=new int[n];
    //     size=n;
    //     rear =-1;
    //     // for circular queue
    //     front=-1;
    // }

    // public static boolean isEmpty(){
    //     return rear==-1;
    // }

    // // for circular queue
    // public static boolean isfull(){
    //     return (rear+1)%size ==front;
    // }

    // // methods for circular queue
    
    // // add
    // public static void add(int data){
    //     if(isfull()){
    //         System.out.println("queue is full");
    //         return;
    //     }
    //     // for adding first element ,special case
    //     if(front ==-1){
    //         front ++; 
    //     }
    //     rear = (rear+1)% size;
    //     arr[rear]=data;
    // }

    // // remove 
    // public static int remove(){
    //     if(isEmpty()){
    //         System.out.println("empty queue");
    //         return -1;
    //     }

    //     int result=arr[front];
    //     if(rear==front){
    //         rear = front =-1;
    //     }
    //     else{
    //         front =(front+1)%size;
    //     }
    //     return result;
    // }

    
    // // peek
    // public static int peek(){
    //     if(isEmpty()){
    //         System.out.println("empty");return -1;
    //     }
    //     return arr[front];
    // }


        //using array 

    // // add
    // public static void add(int data){
    //     if(rear==size-1){
    //         System.out.println("queue is full");
    //         return;
    //     }

    //     rear =rear+1;
    //     arr[rear]=data;
    // }


    // // remove
    // public static int remove(){
    //     if(isEmpty()){
    //         System.out.println("empty queue");
    //         return -1;
    //     }

    //     int front =arr[0];
    //     for (int i = 0; i < arr.length-1; i++) {
    //         arr[i]=arr[i+1];
    //     }
    //     rear =rear-1;
    //     return front;

    // }

    // // peek
    // public static int peek(){
    //     if(isEmpty()){
    //         System.out.println("empty");return -1;
    //     }
    //     return arr[0];
    // }

    


    // }



    public static void main(String[] args) {


        // implementation for using array 
    // Queue q = new Queue(5);
    // q.add(1);
    // q.add(2);
    // q.add(3);
    // q.add(4);

    // while (!q.isEmpty()) {
    //     System.out.println(q.peek());
    //     q.remove();
    // }


        // cicular queue
    // Queue q = new Queue(3);
    // q.add(1);
    // q.add(2);
    // q.add(3);

    // System.out.println(q. remove());
    // q.add(4);
    // System.out.println(q.remove());
    // q.add(5);

    // while (!q.isEmpty()) {
    //     System.out.println(q.peek());
    //     q.remove();
    // }


        // using Java collection framework
        // here for all 3 operations ,tc is const O(1)


        // // Queue<Integer> q = new LinkedList<>(); // array deque
        // Queue<Integer> q = new ArrayDeque<>(); 
        // q.add(1);
        // q.add(2);
        // q.add(3);

        // while (!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }


        // queue using 2 stacks
        // with push implementation , where tc for add is O(n) 
        // Queue q = new Queue();
        // q.add(1);
        // q.add(2);
        // q.add(3);

        // while (!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }


        // stack using 2 queue
        // with pop implementation , where tc for remove ,peek is O(n) 

        // Stack s =new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        
        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        
            //first non repeating character in string
        // 
        // String str= "aabccxb";
        // firstnonrepeating(str);


            // interleave 2 halves of queue (even length)
            
        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // q.add(9);
        // q.add(10);

        // interleave(q);
        // // print
        // while (!q.isEmpty()) {
        //     System.out.println(q.remove());
        // }



            // queue reverse
        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);

        // reverse(q);
        // // print
        // while (!q.isEmpty()) {
        //     System.out.println(q.remove());
        // }


            // creating deque
            //  deque is interface in java collection framework
        // Deque<Integer> deque = new LinkedList<>();
        // deque.addFirst(1);
        // deque.addFirst(2);
        // deque.addFirst(3);
        // System.out.println(deque);
        // deque.addLast(4);
        // deque.addLast(5);
        // deque.addLast(6);
        // System.out.println(deque);
        
        // addLast() , addFirst() , removeFirst(),removeLast(),


            // stack using deque
        // Stack s =new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // System.out.println("peak is "+ s.peek());
        // System.out.println(s.pop());

            // queue using deque
            Queue q = new Queue();
            q.add(1);   
            q.add(2);
            q.add(3);

        System.out.println("peek = "+q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());


    }


                // queue using deque
        static class Queue {
        Deque<Integer> deque = new LinkedList<>();

        public void add(int data){
            deque.addLast(data);
        }
        public int remove(){
           return deque.removeFirst();
        }
            
        public int peek(){
            return deque.getFirst();
        }
        }


        // stack using deque
        // static class Stack{
        //     Deque<Integer> deque = new LinkedList<>();
        //     public void push(int data){
        //         deque.addLast(data);
        //     }

        //     public int pop(){
        //         return deque.removeLast();
        //     }

        //     public int peek(){
        //         return deque.getLast();
        //     }

        // }



        // reverse queue

        // public static void reverse(Queue<Integer> q){
        //     Stack<Integer> s = new Stack<>();
        //     while (!q.isEmpty()) {
        //         s.push(q.remove());
        //     }

        //     while(!s.isEmpty()){
        //         q.add(s.pop());
        //     }

        // }


        // interleave 2 halves of queue
        // public static void interleave(Queue<Integer> q){
        
        // Queue<Integer> firsthalf = new LinkedList<>();
        // int size = q.size();
        // // becoz size is going to change dynamically in queue

        // for(int i =0;i<size/2;i++){
        //     firsthalf.add(q.remove());
        // }

        // while (!firsthalf.isEmpty()) {
        //     q.add(firsthalf.remove());
        //     q.add(q.remove());
        // }

        // }


            //first non repeating character in string
        // 
        // public static void firstnonrepeating(String str){
        //     int freq[] = new int[26];
        //     Queue<Character> q = new LinkedList<>();
                


        //     for(int i =0;i<str.length();i++){
        //         char ch =  str.charAt(i);
        //         q.add(ch);
        //         freq[ch-'a']++ ;

        //         while (!q.isEmpty()&&freq[q.peek()-'a']>1) {
        //             q.remove();
        //         }

        //         if(q.isEmpty()){
        //             System.out.print(-1+" ");
        //         }
        //         else{
        //             System.out.print(q.peek()+" ");
        //         }
        //     }
        //     System.out.println();
        // }




    //    //stack using 2 queue
        // static class Stack{

        //     static Queue<Integer> q1 = new LinkedList<>();
        //     static Queue<Integer> q2 = new LinkedList<>();

        //     public static boolean isEmpty(){
        //         return q1.isEmpty() && q2.isEmpty();
        //     }

        //     public static void push(int data){
        //         if(!q1.isEmpty()){
        //             q1.add(data);
        //         }
        //         else q2.add(data);
        //     }

        //     public static int pop(){
        //         if(isEmpty()){
        //             System.out.println("empty stack");
        //         }
        //         int top =-1;
        //         // case1 
        //         if(!q1.isEmpty()){
        //             while (!q1.isEmpty()) {
        //                 top= q1.remove();
        //                 if(q1.isEmpty()){
        //                     break;
        //                 }
        //                 q2.add(top);
        //             }}
        //             // case 2 
        //             else{
        //                 while(!q2.isEmpty()){
        //                     top = q2.remove();
        //                     if(q2.isEmpty()){
        //                         break;
        //                     }
        //                     q1.add(top);
        //                 }
        //             }
        //             return top;
                
        //     }

        //      public static int peek(){
        //         if(isEmpty()){
        //             System.out.println("empty stack");
        //         }
        //         int top =-1;
        //         // case1 
        //         if(!q1.isEmpty()){
        //             while (!q1.isEmpty()) {
        //                 top= q1.remove();
        //                 q2.add(top);
        //             }}
        //             // case 2 
        //             else{
        //                 while(!q2.isEmpty()){
        //                     top = q2.remove();
        //                     q1.add(top);
        //                 }
        //             }
        //             return top;
                

        //     }





        // }



    // queue using 2 stacks

    // static class Queue{
    //     static Stack<Integer> s1 = new Stack<>();
        
    //     static Stack<Integer> s2= new Stack<>();

    //     public static boolean isEmpty(){
    //         return s1.isEmpty();
    //     }

    //     // add
    //     public static void add(int data){
    //         while(!s1.isEmpty()){
    //             s2.push(s1.pop());
    //         }
    //         s1.push(data);
    //         while(!s2.isEmpty()){
    //             s1.push(s2.pop());
    //         }
    //     }

    //     // remove
    //     public static int remove(){
    //         if(s1.isEmpty()){
    //             System.out.println("is empty");return-1;
    //         }
    //         return s1.pop();
    //     }

    //     // peek
    //     public static int peek(){
    //         if(s1.isEmpty()){
    //             System.out.println("empty ");return-1;
    //         }
    //         return s1.peek();
    //     }



    
    
    // }






}
