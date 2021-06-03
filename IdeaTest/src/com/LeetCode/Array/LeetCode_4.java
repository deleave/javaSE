package com.LeetCode.Array;

/**
 * @ClassName LeetCode_4
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/19 10:31
 * @Version 1.0
 **/
public class LeetCode_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums3 = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else
                return nums2[n / 2];
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums3[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums3[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums3[count++] = nums1[i++];
            } else {
                nums3[count++] = nums2[j++];
            }
        }
        if (count % 2 == 0) {
            return (nums3[count / 2 - 1] + nums3[count / 2]) / 2.0;
        } else {
            return nums3[count / 2];
        }
    }

    //优化
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len=m+n;
        int aStart=0,bStart=0;
        int cur=-1,pre=-1;
        for (int i=0;i<len/2;i++){
            pre=cur;
            if (aStart<m&&(bStart>=n||nums1[aStart]<nums2[bStart])){
                cur=nums1[aStart++];
            }else {
                cur=nums2[bStart++];
            }
        }
        if (len%2==0){
            return (pre+cur)/2.0;
        }else {
            return cur;
        }

    }
}