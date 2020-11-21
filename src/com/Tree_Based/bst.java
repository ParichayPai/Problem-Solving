package com.Tree_Based;

public class bst {
    private static btNode root = null;

    public boolean searchRecursively(btNode root, int ele){
        if(root == null){
            return false;
        }else{
            int currentNodeData = root.data;
            if(currentNodeData >= ele){
                return searchRecursively(root.left, ele);
            } else {
                return searchRecursively(root.right, ele);
            }
        }
    }

    public boolean searchNode(int ele){
        return searchRecursively(root, ele);
    }

    private void recursiveInsert(btNode root, int ele){
        if(root == null){
            root = new btNode(ele);
        }else {
            int currentNodeData = root.data;
            if(currentNodeData >= ele){
                recursiveInsert(root.left, ele);
            } else {
                recursiveInsert(root.right, ele);
            }
        }
    }

    public void insertNode(int ele){
        recursiveInsert(root, ele);
    }

    private void inOrderTRecursive(btNode root){
        if(root == null){
            return;
        }
        inOrderTRecursive(root.left);
        System.out.println(root.data);
        inOrderTRecursive(root.right);
    }

    public void inOrderT(btNode root){
        inOrderTRecursive(root);
    }

    private void preOrderTRecursive(btNode root){
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        preOrderTRecursive(root.left);
        preOrderTRecursive(root.right);
    }

    public void preOrderT(btNode root){
        preOrderTRecursive(root);
    }

    private void postOrderTRecursive(btNode root){
        if(root == null) {
            return;
        }
        postOrderTRecursive(root.left);
        postOrderTRecursive(root.right);
        System.out.println(root.data);
    }

    public void postOrderT(btNode root){
        postOrderTRecursive(root);
    }

    public int deleteNode(int ele){
        return 0;
    }


}

class btNode{
    public int data;
    public btNode left;
    public btNode right;

    btNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}