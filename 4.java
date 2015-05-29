//cry

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        boolean even = ((m + n) % 2 == 0) ? true : false;
        int k = (even) ? (m + n) / 2 - 1 : (m + n) / 2;
        if(m == 0) {
            return singleKth(nums2, k, even);
        }
        if(n == 0) {
            return singleKth(nums1, k, even);
        }
        if(m == 1 && n == 1) {
            return (nums1[0] + nums2[0]) / 2.0;
        }
        if(nums1[0] > nums2[k]) {
        	int a = (k + 1 == n) ? nums1[0] : Math.min(nums1[0], nums2[k + 1]);
        	return (!even) ? nums2[k] : (nums2[k] + a) / 2.0;
        }
        {
        	int a = (k - m < 0) ? nums2[0] : nums2[k - m];
        	if(nums1[m - 1] < a) {
        		a = (k - m < 0) ? nums1[m - 1] : nums2[k - m];
            	return (!even) ? a : (nums2[k - m + 1] + a) / 2.0;
            }
        }
        int l = 0, r = m - 1;
        while(l < r) {
            int mm = (l + r) / 2;
            int nn = k - mm;
            int a = (mm > 0) ? nums1[mm - 1] : Integer.MIN_VALUE;
            int b = (nn > 0) ? nums2[nn - 1] : Integer.MIN_VALUE;
            if(a > nums2[nn]) {
                r = mm;
            } else if(nums1[mm] < b){
                l = mm + 1;
            } else {
                l = mm;
                r = mm;
            }
        }
        int a = 0;
        int b = 0;
        int aa = nums1[l];
        int aa2 = (l < m - 1) ? nums1[l + 1] : Integer.MAX_VALUE;
        int bb = nums2[k - l];
        int bb2 = (k - l < n - 1) ? nums2[k - l + 1] : Integer.MAX_VALUE;
        if(aa < bb) {
            a = aa;
            if(bb < aa2) {
                b = bb;
            } else {
                b = aa2;
            }
        } else {
            a = bb;
            if(aa < bb2) {
                b = aa;
            } else {
                b = bb2;
            }
        }
        if(!even) {
            return a;
        } else {
            return (a + b) / 2.0;
        }
        
        
        
    }
    
    
    private double singleKth(int[] nums, int k, boolean even) {
        return (!even) ? nums[k] : (nums[k] + nums[k + 1]) / 2.0;
    }
}
