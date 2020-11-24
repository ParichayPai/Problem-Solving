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

    private btNode searchParent(btNode root, int ele){
        if(root == null){
            return null;
        }
        if((root.left != null && root.left.data == ele) || (root.right!= null && root.right.data == ele)){
            return root;
        }else{
            int currentNodeData = root.data;
            if(currentNodeData >= ele){
                return searchParent(root.left, ele);
            } else {
                return searchParent(root.right, ele);
            }
        }
    }

    private Integer singleChildDelete(int ele){
        btNode parent = searchParent(root, ele);
        boolean isDeleted = false;
        if(parent != null){
            if(parent.left != null && parent.left.data == ele){
                parent.left = null;
                isDeleted = true;

            }else if(parent.right != null && parent.right.data == ele){
                parent.right = null;
                isDeleted = true;
            }
        }
        return isDeleted ? ele : null;
    }

    private Integer noChildDelete(btNode parent, int ele){
        boolean isDeleted = false;
        if(parent != null){
            if(parent.left != null && parent.left.data == ele){
                parent.left = null;
            }else if(parent.right != null && parent.right.data == ele){
                parent.right = null;
            }
        }
        return ele;
    }

    public Integer deleteNode(int ele){
        btNode parent = searchParent(root, ele);
        if(parent != null){
            if(parent.left != null && parent.left.data == ele){
                if(parent.left.left == null && parent.left.right == null){
                    noChildDelete(parent, ele);
                }else if(!(parent.left.left != null && parent.left.right != null)){
                    singleChildDelete(ele);
                }else{
                    btNode inOrderSuccessor = findInOrderSuccessor(root, ele);
                    btNode inOrderSuccessorParent = searchParent(root, inOrderSuccessor.data);
                    swap(parent.left, inOrderSuccessor);
                    return handleDeleteForInOrderSuccessor(inOrderSuccessorParent, inOrderSuccessor);
                }
            }else if(parent.right != null && parent.right.data == ele){
                if(parent.right.left == null && parent.right.right == null){
                    noChildDelete(parent, ele);
                }
//                else if(!(parent.right.left != null && parent.left.right != null)){
//                    singleChildDelete(ele);
//                }else{
//
//                }
            }
        }
        return  null;
    }

    private int handleDeleteForInOrderSuccessor(btNode inOrderSuccessorParent, btNode inOrderSuccessor) {
        return 0;
    }

    private void swap(btNode left, btNode inOrderSuccessor) {
    }

    private btNode findInOrderSuccessor(btNode root, int ele) {
        return null;
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