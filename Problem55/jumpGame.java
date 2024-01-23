class jumpGame {
    /**
     * You are given an int[] array called "nums". You are initially positioned at the array's first index, and each element in the array represents your
     * maximum jump length. Return true if you can reach the last index, or false otherwise.
     * 
     * example: {2,3,0,5}
     * example should work because instead of jumping 2 spaces onto 0, u can instead take 1 space and land on 3. from there, u can land onto 5 and return true
     * 
     * example: {3,2,1,0,4}
     * example should NOT work because there is no way to reach the last index, so the method should return true
     * 
     * Constraints:
     *      1 <= nums.length <= 10^4
     *      0 <= nums.length <= 10^5
     */
    public static boolean canJump(int[] nums) {
        //base case: if first element is 0 and it isn't the only element in an array, return false
        if (nums[0] == 0 && nums.length > 1) return false;

        //base case: if no 0 elements found anywhere in array, return true (problem's constraints say only positive integers are allowed)
        int counter = 0;
        for(int i=0;i<nums.length;i++) {
            if (nums[i] > 0) counter++;
        }
        if (counter == nums.length) return true;

        //solution: using greedy approach, we will work backwards starting from last index
        int lastPosition = nums.length-1;

        for(int i = nums.length-2; i >= 0; i--) { 
            //if we can prove that nums[i] can jump to current last position, we reassign last position to i
            //if not, we check for another possible step to jump to current last position, i-- 
            if (i + nums[i] >= lastPosition) lastPosition = i;
        }

        //if lastPosition becomes 0, answer is true because we've found at least one path from start to finish of array
        return lastPosition == 0;
    }

    public static void main (String arg[]) {
        int[] nums1 = new int[] {2,3,0,5};
        int[] nums2 = new int[] {2,1,0,9};
        int[] nums3 = new int[] {1,1,2,3,2,1,0,0,1,3};
        int[] nums4 = new int[] {1,1,2,5,2,1,0,0,1,3};
        System.out.println(canJump(nums1));
        System.out.println(canJump(nums2));
        System.out.println(canJump(nums3));
        System.out.println(canJump(nums4));
    }
}
