
public class doublyll {

    // revision 20 10 25 , happy diwali
    public class Node {
        int data;
        Node next;
        Node prev;

        // constructor
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // don't use static ,incase you need more than one ll 
    public  Node head;
    public  Node tail;
    public  int size;


        // add
    public void  addfirst(int data){
        // obj creation
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head =tail = newNode;
            return;
        }
        newNode.next =head;
        head.prev = newNode;
        head =newNode;

    }

    // print 
    // don't use static ,incase you need more than one ll 

    // static mtd can only access static members of class ,this is insightfull


    public  void print(){
        // What the compiler sees:
// Node temp = this.head; // 'this' refers to the current object 
// The main method is different because it is declared as static. As a static method, it cannot access non-static instance variables directly because it doesn't belong to a specific object.
// Instead, it accesses head indirectly by first creating an object and then calling an instance method on that object:
        Node temp = head;
        while (temp !=null) {
            System.out.print(temp.data+ "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }



    // remove first
    public int removefirst(){
        if(head ==null){
            System.out.println("dll is empty");
        }
        
        // single size
        if(size ==1){
            int val = head.data;
            head = tail =null;size--;
            return val;
        }

        int val= head.data;
        head = head.next;
        head.prev = null;size--;
        return val;
    }

    // reverse a dll
    public void reverse(){
        Node curr =head;
        Node prev = null;
        Node next;
        while (curr !=null) {
            next =curr.next;
            curr.next =prev;
            // for doubly ll
            curr.prev =next;
            prev = curr;
            curr =next;
        }
    }


    // add last
    
    public void addlast(int data){
        size++;
        Node newNode = new Node(data);
        if(head ==null){
            head =tail =newNode;
            return;
        }


        // Node prev1 =head;

        // while (prev1.next !=null) {
        //     prev1 = prev1.next;
        // }
        // prev1.next =newNode;
        // newNode.prev= prev1;
        // tail =newNode;
        

        // efficient
        tail.next = newNode; 
        newNode.prev = tail;
        tail = newNode;

    }




    //remove last
    public int removelast(){
        int val;
        if(head ==null){
            System.out.println( "dll is empty");return -1;
        }
        
        // single size
        if(size ==1){
            val = head.data;
            head = tail =null;size--;
            return val;
        }

    size --;
    val = tail.data;

    Node prev1 = tail.prev;
    prev1.next = null;
    tail.prev = null;
    tail = prev1;
        return val;
    }






public static void main(String[] args) {
    doublyll dll = new doublyll();
    dll.addfirst(0);
    dll.addfirst(1);
    dll.addfirst(2);
    dll.addfirst(3);
    dll.addfirst(4);
    dll.addfirst(5);

    dll.print();

    // System.out.println(dll.size);
    dll.removefirst();
    // System.out.println(dll.size);
    dll.print();
    dll.removelast();
    dll.print();

    
}










            //NOT USEFULL 


    // public static void main(String[] args) {
        

    // //creating doubly ll
    // DoubleLL dll = new DoubleLL();

    
    // }


    // // creating 
    // public static Node head;
    // public static Node tail;
    // public static int size;

    // public class Node{
    //     int data;
    //     Node next;
    //     Node prev;

    //     public Node(int data){
    //         this.data=data ;
    //         this.next=null;
    //         this.prev= null;
    //     }
    // }

    // // add first 
    // public void addFirst(int data){
    //     Node newNode =new Node(data);
    //     size++;
    //     if(head==null){
    //         head=tail=newNode;
    //         return;
    //     }
    //     newNode.next=head;
    //     head.prev=newNode;
    //     head=newNode;

    // }

    // // print 
    // public void print(){
    //     Node temp=head;
    //     while(temp!=null){
    //         System.out.println(temp.data +"<->");
    //         temp=temp.next;
    //     }
    // }


    // // remove first





    // // remove and add last is Homework , remember



}
