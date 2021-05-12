package com.LeetCode.树;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        int res=0;
        for (int i=0;i<list.size();i++){
            if (list.get(i)>=low&&list.get(i)<=high){
                res+=list.get(i);
            }
        }
        return res;

    }
    private   void inorder(TreeNode root, List<Integer> list){
        if (root == null) return ;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);

    }
    public int rangeSumBST_1(TreeNode root, int low, int high) {
        if (root==null) return 0;
        if (root.val>high) {
         return    rangeSumBST(root.left,low,high);
        }
        else if (root.val<low){
          return   rangeSumBST(root.right,low,high);
        }
        else{
            return root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
        }
    }
}
