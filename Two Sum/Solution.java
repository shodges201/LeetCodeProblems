import java.util.*;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer index = map.get(target-nums[i]);
            if(index != null){
                return new int[] {i, index};
            }
            map.put(nums[i], i);   
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void printArray(int[] intArray){
        System.out.print("[");
        for(int i = 0; i < intArray.length; i++){
            System.out.print(intArray[i]);
            System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        int[] intArray = {2, 7, 11, 15};
        printArray(twoSum(intArray, 18));
        printArray(twoSum(intArray, 9));

    }
}