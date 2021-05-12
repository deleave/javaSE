package com.LeetCode.树;


import java.util.LinkedList;
import java.util.List;

interface Solusion{
    public TreeNode increasingBST(TreeNode root);

}

public class LeetCode_897 implements Solusion{
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        inorder(root,res);
        TreeNode dummyNode=new TreeNode(-1);
        TreeNode curNode=dummyNode;
        for (int n: res
             ) {
//            新建只有右节点的二叉搜索树
            curNode.right=new TreeNode(n);
            curNode=curNode.right;
        }
        return dummyNode.right;//父节点
    }
//    中序遍历 将节点值放入链表
    private   void inorder(TreeNode root,List<Integer> list){
        if (root == null) return ;
            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);

    }

}
//只保存上一节点
// curNode为上一节点
// 每次执行 ：
// 1.将上一节点的左节点置为null  pre.left=null;
// 2.将上一节点右节点置为root    pre.right=root;
// 3.将上一节点赋值为正在遍历的节点  pre=root;
class LeetCode_897_second implements Solusion{
    private TreeNode curNode;
    public TreeNode increasingBST(TreeNode root){
        TreeNode dummyNode=new TreeNode(-1);
        //curNode为上一节点
         curNode=dummyNode;
        inorder(root);
        return dummyNode.right;
    }
    private   void inorder(TreeNode root){
        if (root == null) return ;
        inorder(root.left);
        root.left=null;
        root.right=root;
        curNode =root;
        inorder(root.right);
    }

}
