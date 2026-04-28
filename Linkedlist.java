// this was 2nd time studying LL

import java.security.PublicKey;

public class Linkedlist {

    public static class  Node {
        int data; // data type
        Node next; // reference variable/obj
        
        // constructor
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    
    }

    // creating head n tail , as their are only 1 thus static
    public static Node head; 
    public static Node tail;
    public static int size;

    // Methods
    public void addfirst(int data){ // non static
        
        // step 1 creat new node
        Node newNode= new Node(data);
        size++;
        
        if(head == null){
            head = tail = newNode;
            return;
        }
        

        // step 2 - new node next = head
        newNode.next =head; // link

        // step 3 - head = new node
        head = newNode;
    }

    public void addlast(int data){
        Node newNode = new Node(data);
        size++;
        
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

        //print mtd O(n)
        public void print(){
            if(head == null){
                System.out.println("ll is empty"); return;
            }
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data+" ");
                temp= temp.next;
            }System.out.println();
        }


        public void add(int idx,int data){
            if(idx == 0){
                addfirst(data);
                return;
            }
            Node newNode = new Node(data);
            Node temp = head;
            size++;
            int i =0;

            while (i<idx-1) {
                temp=temp.next;
                i++;
            }

            // i = idx-1 ; temp -> prev
            newNode.next = temp.next;
            temp.next = newNode;
        }

        public int removefirst(){
            if(size == 0){
                System.out.println("ll is empty");
                return Integer.MIN_VALUE;
            }
            else if(size==1){
                int  val = head.data;
                head = tail= null;
            }
            int val = head.data;
            head = head.next;
            // size --;
            return val;
        }



        // remove last
        public int removelast(){
            if(size==0){
                System.out.println("ll is empty");
                return Integer.MIN_VALUE;
            }
            else if(size==1){
                int val = head.data;
                head=tail=null;
                size=0;
                return val;
            }
            // prev : i = size-2; 2nd last
            Node prev =head;
            for(int i =0;i<size-2;i++){
                prev=prev.next;
            }
            int val=prev.next.data; // or tail.data
            prev.next =null;
            size--;
            tail=prev;
            return val;
        }


// iteraative serch
public static int itrsearch(int key){
    Node temp = head;
    int i=0;
    while (temp != null) {
    if(temp.data == key){// key found
        return i;}
        temp = temp.next;
        i++;        
    }
    return -1;// key not found 
}

    // recursive search
    public static int helper(Node head, int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next, key);
        if(idx==-1){
            return-1;
        }
        return idx+1;

    }
public static int recursearch(int key){
    return helper(head,key);
}

    // reverse a link linked
    public void reverse(){
        Node prev= null;
        Node curr =tail =  head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next =prev;
            prev= curr;
            curr= next;
        }
        head = prev;
    }

    // nth node from end 
    public void deleteNthfromend(int n){
        // cal size
        int sz =0;
        Node temp = head;
        while(temp!=null){
            temp =temp.next;
            sz++;
        }
        if(n ==sz){
            head = head.next; // remove 1st 
        return;
        }
        // sz-n
        int i=1;
        Node prev = head;
        int itofind = sz-n;
        while (i<itofind) {
            prev = prev.next;
            i++;
            
        }
        prev.next = prev.next.next;
        return;

    }


    // slow fast approach
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next !=null){
            slow = slow.next; //+1
            fast = fast.next.next; // +2
        }
        return slow; //slow is mid node
    }

    public boolean checkpal(){
        if(head == null || head.next ==null){
            return true;
        }
        // step-1 - find mid
        Node midNode= findMid(head);
        // step 2 -reverse 2nd half
        Node prev= null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next =prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; // right half head
        Node left = head;
        //step 3 - check left half and right half
        while (right !=null) {
            if(left.data !=right.data){
                return false;
            }
            left= left.next;
            right = right.next;
        }
        return true;
    
    }

    // iscycle
    public static boolean iscycle(){
        Node slow = head;
        Node fast = head;
        while(fast!= null && fast.next !=null){
            slow = slow.next; // +1
            fast  = fast.next.next ; //+2
            if(slow == fast){
                return true; // exists
            }
        }
        return false; // cycle doesn't exist
    }

    //
    public static void removecycle(){
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false ;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;
            if(fast==slow){
                cycle = true;
                break;
            }
        }
        if (cycle==false) {
                return;
        }
        // find meeting point
        slow =head;
        Node prev = null;
        while (slow!=fast) {
            prev= fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle-> last.next =null   
        // here i asked gemini , how prev affect original ll , becoz ->prev is reference to the original ll , not copy of it . 
        prev.next= null;
    }


    public static void main(String1 args[]){
        Linkedlist ll = new Linkedlist();
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);8

        // adding first
        // ll.print();
        // ll.addfirst(1);
        // ll.addfirst(2);
        
        // //adding last
    

        // ll.addlast(2);
        // ll.addlast(1);
        
        // // ll.print();
        // ll.addlast(3);
        // ll.addlast(4);
        
        //print
        // ll.print();

        // adding in middle
        // ll.add(2,9);
        // ll.print();

        // size 
        // System.out.println(size);

        // remove first
        // ll.removefirst();
        // ll.print();
        // remove last
        // ll.removelast();
        // ll.print();
        // System.out.println(size);

        // itersearch O(n)
        // System.out.println(itrsearch(10));
        // System.out.println(itrsearch(3));

        // recursive serch sc-O(n) , tc - O(n)
        // System.out.println(recursearch(2));
        // System.out.println(recursearch(10));

        // reverse
        // ll.print();
        // ll.reverse();
        // ll.print();

        // remove nth from end
        // ll.print();
        // ll.deleteNthfromend(3);
        // ll.print();
        

        // palidrome
        // ll.addfirst(2);
        // ll.addfirst(1); //1-2-2-1
        // System.out.println(ll.checkpal());
        // ll.addfirst(2);
        // System.out.println(ll.checkpal());


        // CCYCLE CHECK
        // head= new Node(1);
        // head.next = new Node(2);
        // head.next.next=new Node (3);
        // // head.next.next.next=head;
        // System.out.println(iscycle());


        // cycle remove
        head= new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next=new Node(3);
        head.next.next.next=temp;
        // 1-2-3-2
        System.out.println(iscycle());
        removecycle();
        System.out.println(iscycle());
        
    }
}












            // this was first time studying this 


// public class Linkedlist {

//     public static class Node{
//         int data;
//         Node next;
//         public Node(int data){
//             this.data = data;
//             this.next = null;
            
//         }
//     }
//     public static Node head;
//     public static Node tail;
//     public static int size;

//     public static void addfirst(int data){
//         // step 1 - create new node
//         Node newNode = new Node(data);
//         size++;
//         if(head == null){
//             head = tail = newNode;return;
//         }
//         //step 2 - newnode next = head
//         newNode.next = head; // link
//         // step 3 - head = newnode
//         head = newNode;
//     }

//     public void addlast(int data){
//         Node newNode = new Node(data);
//         size++ ;
//         if(head == null){
//             head = tail = newNode;
//             return;
//         }
//         tail.next = newNode;
//         tail= newNode;

//     }

//     public void print(){
//         if (head==null){
//             System.out.print("null  ");
//             return;
//         }
//         Node temp = head;
//         while(temp != null){
//             System.out.print(temp.data+"->");
//             temp = temp.next;
//         }
//         System.out.println();
//     }

//     public static void add(int idx ,int data){
//         if(idx == 0){
//             addfirst(data);
//             return;
//         }
//         Node newNode = new Node(data);
//         size++;
//         Node temp = head;
//         int i =0 ;
//         while (i <idx-1) {
//             temp = temp.next;
//             i++;
//         }
//         // i = idx - 1, temp -> prev
//         newNode.next = temp.next;
//         temp.next = newNode;
//     }

//     public int removefirst(){
//         if(size == 0){
//             return Integer.MIN_VALUE;
//         }
//         else if (size == 1){
//             int val = head.data;
//             head = tail = null;
//             size = 0;
//             return val;
//         }
//         int val =head.data;
//         head =head.next;size--;
//         return val;
//     }

//     public int removelast(){
//         if(size ==0){
//             System.out.println("ll is empty");
//             return Integer.MIN_VALUE;
//         }
//         else if(size ==1){
//             int val = head.data;
//             head =tail = null;
//             size =0;
//             return val;
//         }
//         Node prev=head;
//         // prev : i : idx = size - 2
//         for(int i =0;i<size-2;i++){
//             prev= prev.next;
//         }
//         int val = prev.next.data; // tail.data
//         prev.next=null;
//         tail =prev;
//         size --;
//         return val;
//     }

//     public int itrsearch(int key){// O(n)
//         Node temp = head;
//         int i =0;
//         while(temp !=null){
//             if(temp.data == key){
//                 return i;
//             }
//             temp = temp.next;
//             i++;
//             while (temp !=null){
//                 if(temp.data == key){
//                     return i;
//                 }
//                 temp = temp.next;
//                 i++;
//             }
//         }
//         return -1;
//     }

//         public int helper (Node head, int key){ 
//             // tc - O(n) ,sc - O(n);
//             //actual recursion 
//             if(head ==null){
//                 return -1;
//             }
//             if(head.data ==key){
//                 return 0;
//             }
//             int idx = helper(head.next, key);
//             if(idx == -1){
//                 return -1;
//             }
//             return idx +1;
//         }
//     public int recursearch(int key){
//         return helper(head,key);
//     }

//     public void reverse(){
//         Node prev = null;
//         Node curr =tail = head;
//         Node next;

//         while (curr != null) {
//             next = curr.next;
//             curr.next= prev;
//             prev = curr;
//             curr = next;
            
//         }
//         head = prev;
//     }

//     public static void main(String[] args){
//     Linkedlist ll = new Linkedlist();
//         // ll.print();
//         ll.addfirst(2);
//         ll.addfirst(1);
//         // ll.print();
//         ll.addlast(3);
//         ll.addlast(4);
//         ll.add(2,9);
//         // ll.print();

//         // remove first
//         // ll.removefirst();
//         // ll.print();

//         // ll.removelast();
//         ll.print();
//         ll.reverse();
//         ll.print();


//         // ll.head = new Node(1);
//         // ll.head.next= new Node(2);
//         // System.out.println("  size is "+size);

//         // // search linear
//         // System.out.println("\n" +ll.recursearch(3));
//         // System.out.println(ll.recursearch(10));
//     }
// }





                //  6 1 24 // this is 2nd revision 
                //  no running the code just practic /* 
            




//                 public static class Node{
//                     int data;
//                     Node next;
//                     public Node(int data){
//                         this.data= data;
//                         this.next = null;
//                     }
//                 }


//             public static void addfirst(int data){    
//                 Node newNode = new Node(data); 
//             if(head == null){
//                 head = tail= newNode;
            
//             return;}
//             newNode.next= head;
//             head = newNode;
            
            
//             } 
        
//             public void addlast(int data)

    
// {
//     Node newNode = new Node(data);
//     if(head==null){
//         head =tail= newNode;
//         return;
//     }
//     tail.next= newNode;
//     tail = newNode;






// }




            
            // */  
