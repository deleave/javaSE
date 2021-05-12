package com.LeetCode.树;
//二叉搜索树的中序遍历操作
// 采用了双指针的方法 计算节点val与前节点val的差值，保留最小值
public class LeetCode_783 {
    private TreeNode prenode=null;
    private int result=-1;
    public int minDiffInBST(TreeNode root) {
      dfs(root);
      return  result;
    }
    public void dfs(TreeNode treeNode){
        if (treeNode==null)
            return;
        dfs(treeNode.left);
        if (prenode!=null){
            result=Math.min(treeNode.val-prenode.val,result);
        }
        prenode=treeNode;
        dfs(treeNode.right);
    }

}
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
