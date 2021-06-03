package com.LeetCode.Array;

import java.util.*;

/**
 * @ClassName LeetCode_15
 * @Description TODO
 * @Author deleave
 * @Date 2021/6/3 19:41
 * @Version 1.0
 **/
public class LeetCode_15 {
    //暴力法
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length==0) return null;
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                for (int k=j+1;k<nums.length;k++){
                    if (nums[j]+nums[k]==-nums[i]){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        if (!isInList(lists,temp)){
                            continue;
                        }
                        lists.add(temp);
                    }

                }
            }
        }
        return lists;
    }

    private boolean isInList(List<List<Integer>> lists, List<Integer> temp) {
        Collections.sort(temp);
        for (int i=0;i<lists.size();i++){
            Collections.sort(lists.get(i));
            for (int j=0;j<lists.get(i).size();j++){
                if (!lists.get(i).get(j).equals(temp.get(j))){
                    return false;
                }
            }
        }
        return true;
    }

    //双指针遍历
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new LinkedList<>();
        for (int i=0;i<nums.length;i++){
            int low=i+1;
            int hight=nums.length-1;
            int sum=-nums[i];
            if (i==0||(i>0&&nums[i]!=nums[i-1])){
                while (low<hight){
                    if (nums[low]+nums[hight]==sum){
                        res.add(Arrays.asList(nums[i],nums[low],nums[hight]));
                        while (low<hight&&nums[low]==nums[low+1]) low++;
                        while (low<hight&&nums[hight]==nums[hight-1]) hight--;
                        low++;
                        hight--;
                    }else if (nums[low]+nums[hight]<sum) low++;
                    else hight--;
                }
            }
        }
        return res;

    }


    }
