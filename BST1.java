


public class BST1 {

        static class Node{
            int data;
            Node left;
            Node right;

            Node(int data){
                this.data = data;
            }
        }

        // inserting bst 
        public static Node insert(Node root ,int val){
            if(root ==null){
                root = new Node(val);
                return root;
            }
            if(root.data >val){
                // left subtree
                root.left =insert(root.left, val);
            }
            else{
                // right subtree
                root.right = insert(root.right, val);
            }
            return root;
        }

        public static void inorder(Node root){
            if(root ==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    
    public static void main(String[] args) {
        
        // building a bst
        int values [] = {5,1,3,4,2,7};
        Node root = null;

        for(int i=0;i<values.length;i++){
            root = insert(root , values[i]);
        }

        // inorder(root);
        // System.out.println();

        // searching in bst
        // if(search(root, 6)){
        //     System.out.println("found ");
        // }
        // else System.out.println("not found");

        // delete a bst 
        inorder(root);
        System.out.println();
        delete(root, 4);
        inorder(root);


    }


    // delete - 
    public static Node delete(Node root , int val){
        if (root.data<val) {
            root.right = delete(root.right, val);
        }
        else if(root.data>val){
            root.left = delete(root.left, val);
        }
        else{ //finally found the data
            // case 1 - leaf node
            if(root.left ==null&& root.right ==null){
                return null;
            }
            // case -2 single child
            if (root.left ==null) {
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            // case 3 -both children 
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while (root.left !=null) {
            root = root.left;
        }
        return root;
    }

    // searchign in bst 
    // tc - O(H)
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }

        if (root.data == key) {
            
            return true;
        }

        if(root.data>key){
            return search(root.left, key);
        }
        else return search(root.right, key);

    }











}
