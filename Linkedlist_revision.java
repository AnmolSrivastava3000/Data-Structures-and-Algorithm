import java.util.LinkedList;

import org.w3c.dom.Node;

public class Linkedlist_revision {

    public static class Node{
        int data;
        Node next;

        public Node (int data){
            this.data = data;
            this.next =null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // add first O(1)
    public void addfirst(int data){
        //step1 =create new node
        Node newNode = new Node(data);
        size++;
        
        if (head==null) {
            head =tail=newNode;
            return;
        }
        // newnode next =head
        newNode.next= head;

        // head = newnode
        head =newNode;
    }


    // add last 
    public void addlast(int data){

        Node newNode = new Node(data);
        size++;
        if (head==null) {
            head =tail =newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // print 
    public void print(){
        Node temp = head;
        while (temp !=null) {
            System.out.print(temp.data+" ");
            temp =temp.next;
        }
        System.out.println();
    }

    // add in middle 
    public void add(int data, int ind){
        if (ind ==0) {
            addfirst(data);return;
        }
        Node newNode = new Node(data);
        size++;

        Node temp =head;
        int i =0;
        while (i<ind-1) {
            temp =temp.next;i++;
        }
        newNode.next = temp.next;
        temp.next =newNode;

    }

    // remove first
    public void removefirst(){
        if (head ==null) {
            System.out.println("ll is empty");return;
        }
        if (size==1) {

            System.out.println("head is "+head.data);
            head =null;size--;
            return;
        }

        System.out.println("head is "+head.data);
        head=head.next;
        size--;
    }

    public void removelast(){
        if (size==0) {
            System.out.println("ll is empty");
        }
        if (size==1) {
            System.out.println(head.data+" ll now empty");
            head=tail=null;
            return;
        }
        System.out.println("last element is " + tail.data);
        Node temp =head;
        while(temp.next.next !=null) {
            temp=temp.next;
        }
        tail =temp;
        temp.next =null;
        size--;
        return;
    }

    // search (iterative)
    public void searchitr(int key){
        Node temp = head;
        int ind=0;
        while (temp!=null) {
            if (key==temp.data) {
            System.out.print(temp.data+" is at index "+ind);
            return;
            }
            ind++;
        temp =temp.next;
        }System.out.println("no key");
    }

    // recursive search
    public void recursearch(int key, Node temp,int i){
        if (temp ==null) {
            System.out.println("no key in ll");
            return;
        }
        if (temp.data==key) {
            System.out.println("key is at "+i);
            return;
        }
        recursearch(key, temp.next, i+1);
    }

    // reverse a ll
    public void reverse(){
        
        if (size==0 || size==1) {
            return;
        }

    Node curr=tail =head;
    Node next ;
    Node prev =null;
    while (curr!=null) {
        next=curr.next;
        curr.next =prev;
        prev=curr;
        curr =next;
    }

    head =prev;
    }

    // nth node from end
    public void nth(int ind){
        if (ind==size) {
            head=head.next;
            size--;
            return;
        }
        int i=1;
        Node temp =head;
        while (i<size-ind) {
            temp =temp.next;i++;
        }
        temp.next =temp.next.next;
        size--;

    }



    // check if ll is palindrome
    public static Node findmid(Node head){
        Node slow = head;
        Node fast =head;
        while (fast !=null && fast.next !=null) {
            fast = fast.next.next;
            slow =slow.next;
        }
        return slow;
    }



    public static void checkpal(){
        if (head ==null || head.next ==null) {
            System.out.println("ll is palindrome");
            return;
        }

        // step1 -find mid
        Node mid =findmid(head);

        Node prev =null;
        Node curr = mid;
        Node next;
        while (curr !=null) {
            next =curr.next;
            curr.next =prev;
            prev= curr;
            curr=next;
        }
        Node right =prev;  // right half head
        Node left =head;

        while (right !=null) {
            if (left.data !=right.data) {
                System.out.println("not a palindrome ");return;
            }
            left=left.next;
            right =right.next;
        }
        System.out.println("ll is palindrome");

    }

    // detecting cycle in ll 
    public static void detectcycle(){
        Node slow =head;; Node fast=head;
        Node temp =head;
        while (fast !=null && fast.next !=null) {
            slow = slow.next;
            fast =fast.next.next;
                if (slow ==fast) {
                System.out.println("ll is cycle");
                return;
            }
        }
        System.out.println("NO CYCLE");
    }

    // remove cycle
    public static void removecycle(){
        // detect cycle
        Node slow =head;
        Node fast=head;
        boolean cycle =false;
        while (fast !=null && fast.next !=null) {
            slow = slow.next;
            fast =fast.next.next;
                if (slow ==fast) {
                System.out.println("ll is cycle");
                cycle =true;
                break;
            }
    }

    if (!cycle) {
        System.out.println("no cycle ");return;
    }

    // edge case
    if (slow == head) {
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = null;
        return;
    }

    // find meeting point
    slow =head;
    Node prev = null;
    while (slow!=fast) {
        prev =fast;
        slow = slow.next;
        fast = fast.next;
    }

    // remove cycle
    prev.next =null;
    }


        // merge sort 

    public static Node getmid(Node temp){
        Node temp1 = temp.next; // for even condition in merge sort of ll 
        Node temp2 = temp;
        while (temp1 != null && temp1.next !=null ) {
            temp1 = temp1.next.next;
            temp2 = temp2.next;
        }
        return temp2;
    }

    public static Node mergesort(Node head){
        if (head ==null || head.next ==null) {
            return head;
        }

        Node mid = getmid(head);
        Node righthead = mid.next;
        mid.next =null;
        Node newleft = mergesort(head);
        Node newright = mergesort(righthead);

        return merge(newleft,newright);

    }

    public static Node merge(Node nl ,Node nr){
        Node mergedll= new Node(-1);
        Node temp = mergedll;
        while (nl !=null && nr !=null) {
            if (nl.data<=nr.data) {
                temp.next = nl;
                nl =nl.next;
            }
            else{
                temp.next = nr;
                nr = nr.next;
            }
            temp = temp.next;
        }
        while (nl !=null) {
            temp.next =nl;
            nl = nl.next;
            temp = temp.next;
        }
        while (nr !=null) {
            temp.next =nr;
            nr = nr.next;
            temp = temp.next;
        }
        return mergedll.next;
    }


        // zig zag
        public static Node mid_zigzag(Node temp){
            Node slow = temp;
            Node fast= temp.next; // its imp for both odd ,even cases ,with zig zag you need 2nd half of node 
            while (fast !=null && fast.next !=null ) {
                slow= slow.next;
                fast= fast.next.next;
            }
            return slow;
        }


        public static Node zigzag(Node head){
            if (head ==null || head.next ==null) {
                return head;
            }
            Node mid = mid_zigzag(head);
            Node righthalf = mid.next;
            mid.next =null;
            
            // reverse righthalf
            Node prev= null;
            Node curr= righthalf;
            Node next;
            while (curr!=null) {
                next= curr.next ;
                curr.next =prev;
                prev=curr;
                curr=next;
            }
            righthalf =prev;

            // merging 2 halfs
            Node nextl ; Node nextr;
            Node lh=head; Node rh = righthalf;

            while (lh !=null &&rh !=null) {
                nextl= lh.next;
                lh.next=rh;
                nextr = rh.next;
                rh.next = nextl;
                
                // updating
                lh =nextl;
                rh = nextr;
            }
            return head;
        }

        // 



    public static void main(String[] args) {


            // practice questions
        


    //                 // zig zag
    // head = new Node(1);
    // head.next = new Node(2);
    // head.next.next = new Node(3);
    // head.next.next.next = new Node(4);
    // head.next.next.next.next = new Node(5);

    //     Node answer =  zigzag(head);
    //     while (answer !=null) {
    //         System.out.print(answer.data+" ");
    //         answer =answer.next;
    //     }
    //     System.out.println();



       // Creating an unsorted list: 4 -> 1 -> 3
    // head = new Node(4);
    // head.next = new Node(1);
    // head.next.next = new Node(3);
        


        // // merge sort
        // Node answer =  mergesort(head);
        // while (answer !=null) {
        //     System.out.print(answer.data+" ");
        //     answer =answer.next;
        // }
        // System.out.println();



        // detectcycle();
        // removecycle();
        // detectcycle();



                                // here ll 2 ends ,below is ll 1 ,

                                // this is ll 1 ,


        // Linkedlist_revision ll = new Linkedlist_revision();
        // // ll.head =new Node(1);
        // // ll.head.next = new Node(2);

        // ll.addfirst(2);
        // ll.addfirst(3);
        // ll.addlast(3);
        // ll.addlast(3);
        // ll.add(9, 2);

        // ll.print(); 
        // System.out.println(size);

        // ll.removefirst();
        // ll.removelast();
        // ll.print();
        

        // search
        // ll.searchitr(9);System.out.println();
        // ll.recursearch(9, head, 0);

        // // reverse
        // ll.reverse();
        // ll.print();

        // nth index from last = size-n+1; , ffor that use
        // i<size-n ,you reach at index before nth from last
        // ll.print();
        // ll.nth(2);
        // ll.print();

        // palindrome
        // checkpal();


                // after LL part2 , merge sort se



    }




}
