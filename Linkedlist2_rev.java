
            // ll thorough JCF ,
            // and doubly linked list



public class Linkedlist2_rev {

        // doubly ll
        public class Node {
            int data;
            Node prev;
            Node next;

            public Node(int data){
                this.data =data;
                this.prev =null;
                this.next= null;
            }
        }

        static Node head;
        static Node tail;
        static int size;

        public void addfirst(int data){
            Node newnNode =new Node(data);
            
            if (head==null) {
                head =tail =newnNode;
                size++;
                return;
            }

            newnNode.next= head;
            head.prev =newnNode;
            head = newnNode;
            size++;
            
        }   

        public void print(){
            Node temp =head;
            while (temp !=null) {
                System.out.print(" "+temp.data);
                temp =temp.next;
            }
            System.out.println(" null");
        }

        public void removefirst(){
            if (size==0) {
                System.out.println("ll is empty");
                return;
            }
            if (size==1) {
                System.out.println(head.data);
                head =tail = null;
                size--;
                return;
            }
            System.out.println("head data is "+head.data);
            head =head.next;
            head.prev =null;
            size--;
        }

        public void addlast(int data){
            Node newnNode =new Node(data);
            
            if (head==null) {
                head =tail =newnNode;
                size++;
                return;
            }

        tail.next = newnNode;
        newnNode.prev =tail;
        tail =newnNode;
        size++;
        }

        public void removelast(){
            if (size==0) {
                System.out.println("empty ll ");
                return;
            }
            if (size==1) {
                System.out.print(head.data+" ll has one element");
                size--;
                head =tail =null;
                return;
            }
            System.out.println(tail.data+" removed last");
            tail =tail.prev;
            tail.next=null;
            size--;
        }

        public void reverse(){
            if (size==0) {
                System.out.println("empty ll");
                return;
            }
            if (size==1) {
                System.out.println("ll has one element");
                return;
            }
            Node curr =tail = head;
            Node prev = null;
            Node next;
            while (curr!=null) {
                next =curr.next;
                curr.next =prev;
                curr.prev = next;

                prev= curr;
                curr =next;
            }
            head =prev;
        }



    public static void main(String[] args) {


            // doubly linked list
        Linkedlist2_rev dll = new Linkedlist2_rev();
        dll.addfirst(3);
        dll.addfirst(2);
        dll.addfirst(1);
        // dll.print();
        // System.out.println(size);
        // dll.removefirst();
        // dll.print();

        // for last 
        dll.addlast(4);
        dll.addlast(5);
        // dll.print();
        // dll.removelast();
        // dll.print();

        // reverse dll
        dll.print();
        dll.reverse();
        dll.print();




                        // linked list through java collection framework

        // // create -
        // LinkedList<Integer> ll = new LinkedList<>();

        // // add
        // ll.add(1);
        // ll.addLast(4);
        // ll.addFirst(0);

        // System.out.println(ll);

        // ll.removeFirst();
        // System.out.println(ll);



    }






}
