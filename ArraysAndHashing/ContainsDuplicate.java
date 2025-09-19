//https://leetcode.com/problems/contains-duplicate/description/
//TC - O(n)
//SC - O(n)

package ArraysAndHashing;

import java.util.HashSet;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        boolean result = containsDuplicate(nums);
        System.out.println("Array contains duplicate ? " + result);
    }

    public static boolean containsDuplicate(int[] nums) {

        //return Arrays.stream(nums).distinct().count() < nums.length;

        HashSet<Integer> hs = new HashSet<>();
        for(int i:nums){
            hs.add(i);
        }

        return !(hs.size()==nums.length);
    }

}
