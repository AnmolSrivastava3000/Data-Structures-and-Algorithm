import java.util.*;

import javax.management.QueryEval;

public class BinaryTreesB {

    public static class Node{
        int data;
        Node right ;
        Node left;

        Node(int data){
            this.data = data;
            this.left =null;
            this.right=null;
        }
    }

    static class BinaryTree{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode =new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }

    } 



    public static void main(String[] args) {
        

        // build tree preorder -tc-O(n)

        // int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        // BinaryTree tree=new BinaryTree();
        // Node root=tree.buildTree(nodes);
        // System.out.println(root.data);

        // pre order traversal
        // preorder(root);

        // in order traversal
        // inorder(root);

        // post order traversal
        // postorder(root);

        //    level order traversal
        // levelorder(root);

        // Node root = new Node(1);
        //  root.left = new Node(2);
        //  root.right = new Node(3);
        //  root.left.left = new Node(4);
        //  root.left.right = new Node(5);
        // // root.right.left = new Node(6);  
        // root.right.right = new Node(7);
        

         // height calcn 
        // System.out.println(height(root));

        // count of nodes
        // System.out.println(count(root));

        //sum of nodes
        // System.out.println(sum(root));

        // diameter of a tree(approach 1)
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // // root.right.left = new Node(6);  
        // root.right.right = new Node(7);

        // System.out.println(diameter(root));

        // approach 2 
        // System.out.println(diameter2(root).diam);


            // subtree of another tree
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // // root.right.left = new Node(6);  
        // root.right.right = new Node(7);

        // Node subroot = new Node(2);
        // subroot.left = new Node(4);
        // subroot.right  = new Node(5);

        // System.out.println(issubtree(root, subroot));

        // Top view of a tree (code) 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);  
        root.right.right = new Node(7);

        // Topview(root);

        // kth level of tree 
        // Klevel(root,1,2);
        

        // lowest common ancestor

        // System.out.println(lca(root, 4, 7).data);

        // lca approach 2 
        // System.out.println(lca2(root, 4, 5).data);

        // min distance between 2 nodes
        // System.out.println(mindist(root, 4, 5));

        // kth ancestor of node
        // kancestor(root, 4, 1);

        // transform to sum tree
        transform(root);
        //  now print 
        preorderoftransform(root);


    }





        // transform to sum tree
        public static int transform(Node root){
            if (root ==null) {
                return 0;
            }
            int leftchild =transform(root.left);
            int rightchild =transform(root.right);
           

            int data =root.data;
            int newleft = root.left ==null? 0: root.left.data;
            int newright= root.right==null? 0: root.right.data;
            root.data = newleft+ leftchild+newright+rightchild;
            return data;
        }

        // function show we can print tree ,//here using pre -order traversal
        // pre order traversal
        public static void preorderoftransform(Node root){
            if (root==null) {
                return;
            }
            System.out.print(" "+root.data+ " ");
            preorder(root.left);
            preorder(root.right);
        }


        // kth ancestor of node

        //  now this code will keep running even after kth ancestor found so asked gemini
        // he give helpful answer to this problem ,good job by us
        private static Node foundKthAncestor = null;
        // this will track the kth ancestor ,print statement

        public static int kancestor(Node root,int n ,int kth){
            if(root == null){
                return -1;
            }
            if(root.data==n){
                return 0;
            }

            // personal change by to optimise the function
            if (foundKthAncestor != null) {
            return 0; // Propagate the "found" signal up the call stack
        }

            int leftdist = kancestor(root.left, n, kth);
            int rightdist = kancestor(root.right, n, kth);
            
            if(leftdist ==-1 && rightdist ==-1){
                return -1;
            }
            int max = Math.max(leftdist, rightdist);
            if(max+1==kth){
                System.out.println(root.data);
                foundKthAncestor = root;
            }
            return max+1;
        }


    // min distance between 2 nodes

    public static int mindist(Node root,int n1,int n2){
        Node lca = lca2(root, n1, n2);
        int dist1 =lcadist(lca, n2);
        int dist2 = lcadist(lca, n2);
        return dist1+dist2;
    }

        public static int lcadist(Node root,int n){
            if(root==null){
                return -1;
            }
            if(root.data==n){
                return 0;
            }
            int leftdist = lcadist(root.left, n);
            int rightdist = lcadist(root.right, n);

            if(leftdist ==-1 && rightdist ==-1){
                return -1;
            }
            else if(leftdist==-1){
                return rightdist+1;
            }   
            else{
                return leftdist+1;
            }

        }




        // Lowest common ancestor (approach 2)
        public static Node lca2(Node root,int n1,int n2){
            if (root ==null) {
                return root;
            }
            if(root.data ==n1 || root.data==n2){
                return root;
            }
            Node leftlca = lca2(root.left,n1,n2);
            Node rightlca = lca2(root.right, n1, n2);

            // leftlca =val rightlca = null
            if(rightlca == null){
                return leftlca;
            }
            if(leftlca ==null){
                return rightlca;
            }
            return root;
        }


    // Lowest common ancestor (approach 1)  //tc -O(n) ,sc-O(n)
    public static Node lca(Node root ,int n1,int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);
        int i=0;
        for(;i<path1.size()&&i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        // last equal node -> (i-1)th
        Node lca = path1.get(i-1);
        return lca;
    }


    public static boolean getPath(Node root, int n ,ArrayList<Node> path){
        
        if (root ==null) {
            return false;
        }

        path.add(root);
        if(root.data ==n){
            return true;
        }

        boolean foundleft = getPath(root.left, n, path);
        boolean foundright = getPath(root.right, n, path);

        if(foundleft || foundright){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }



    // kth level of tree . 
    public static void Klevel ( Node root , int level,int k ){
        if(root==null){
            return;
        }
        if(level ==k){
            System.out.print(root.data+" ");return;
        }
        Klevel(root.left,level+1,k);
        Klevel(root.right,level+1,k);

    }

        // Top view of a tree
    public static void Topview(Node root){
        // level order
        Queue<info> q = new LinkedList<>();
        HashMap<Integer,Node> map  = new HashMap<>();
        
        int min = 0 , max =0;
        q.add(new info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }

            else{
                if(!map.containsKey(curr.hd)){ // first time my 
                // horizontal distn occurred
                map.put(curr.hd, curr.node);
            }
            if(curr.node.left !=null){
                q.add(new info(curr.node.left, curr.hd-1));
                min = Math.min(min, curr.hd-1);
            }
            if (curr.node.right !=null) {
                q.add(new info(curr.node.right , curr.hd+1));
                max =Math.max(max, curr.hd+1);
            }
            }
        }
        for(int i =min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }

    static class info{
        Node node;
        int hd; // horizontal distance 

        // constructor
        public info(Node node , int hd){
            this.node = node;
            this.hd = hd;
        }
    }



    // subtree of another tree
    public static boolean issubtree(Node root ,Node subroot){
        if(root ==null){
            return false;
        }
        if(root.data == subroot.data){
            if(isIdentical(root,subroot)){
                return true;
            }
        }
        return issubtree(root.left, subroot) || issubtree(root.right, subroot);
    }

    public static boolean isIdentical(Node node, Node subroot){
        if(node ==null && subroot ==null){
            return true;
        }
        else if(node == null || subroot ==null || node.data !=subroot.data){
            return false;
        }
        if(!isIdentical(node.left, subroot.left)){
            return false;
        }
        if(!isIdentical(node.right, subroot.right)){
            return false;
        }
        return true;
    }


    // //  to find diameter of tree // 2nd approach
    // O(n) tc , O(h) -sc  ,where h is height of tree  

    // static class  info {
    // int diam;
    // int ht;

    // // constructor
    //     public info(int diam ,int ht){
    //         this.diam = diam;
    //         this.ht = ht;
    //     }
        
    // }

    // public static info diameter2(Node root){
    //     if (root ==null) {
    //         return new info(0,0);
    //     }
    //     info leftinfo = diameter2(root.left);
    //     info rightinfo = diameter2(root.right);
        
    //     int diam = Math.max(leftinfo.diam,Math.max(rightinfo.diam,leftinfo.ht + rightinfo.ht+1));
    //     int ht = Math.max(leftinfo.ht , rightinfo.ht)+1;
    //     return new info(diam,ht);
    // }



    // //  to find diameter  // first approach
    // // O(N^2) using funcn height 
    // public static int diameter(Node root){
    //     if (root==null) {
    //         return 0;
    //     }
    //     int leftdiam = diameter(root.left);
    //     int leftht =height(root.left);
    //     int rightdiam = diameter(root.right);
    //     int rightht = height(root.right);

    //     int selfdiam = leftht + rightht +1;
    //     return Math.max(selfdiam, Math.max(leftdiam,rightdiam));
    // }


    //  funcn to cal sum  of nodes
    public static int sum(Node root){
        if(root==null){
            return 0;
        }
        int lc= sum(root.left);
        int rc= sum(root.right);
        return lc+rc+root.data;
    }


    // funcn to cal count of trees
    public static int count(Node root){
        if(root==null){
            return 0;
        }
        int lc= count(root.left);
        int rc= count(root.right);
        return lc+rc+1;
    }



    // funcn to cal height of tree
    public static int height (Node root){
        if(root==null){
            return 0;
        }
        int lh= height(root.left);
        int rh= height(root.right);
        return Math.max(lh, rh)+1;
    }


    // level order traversal
    public static void levelorder(Node root){
        if(root==null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode =q.remove();
            if (currNode==null) {
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{q.add(null);
                }
            }
            else{
                System.out.print(currNode.data+" ");
                if (currNode.left!=null) {
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }

        }



    }


     //post order traversal  - O(n)
    public static void postorder(Node root){
        if(root==null){
            //if want to print -1 ,use next line of code
            // System.out.print(-1+" ");
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
        
    }



    // in order traversal = O(n)
    public static void inorder(Node root){
        if(root==null){
            //if want to print -1 ,use next line of code
            // System.out.print(-1+" ");
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }


    //pre order traversal  - O(n)
    public static void preorder(Node root){
        if(root==null){
            //if want to print -1 ,use next line of code
            // System.out.print(-1+" ");
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }









}
