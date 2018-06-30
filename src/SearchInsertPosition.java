import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import javax.sound.midi.Soundbank;

/**
 * 35. Search Insert Position
 *
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 *
 *
 */
public class SearchInsertPosition {

    public  int searchInsert(int[] nums, int target){
        int low = 0;
        int high = nums.length;
        int mid ;
        while (low < high){
            mid = low + (high-low)/2;
            if (target==nums[mid]){
                return  mid;
            }else if(target>nums[mid]){
                low = mid + 1;
            }else if(target <nums[mid]){
                high = mid - 1;
            }
        }
//        System.out.println(nums[mid]);
        if(target>nums[low]){
            return low+1;
        }else{
            return low;
        }

    }
    public int add(int a,int b){
        try {
            return a+b;
        }
        catch (Exception e) {
            System.out.println("catch语句块");
        }
        finally{
            System.out.println("finally语句块");
        }
        return 0;
    }

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition  = new SearchInsertPosition();
        int[] nums = {1,3,5,7,8,10};
        int target = 9;
//        System.out.println(searchInsertPosition.searchInsert(nums,target));
        System.out.println("和是："+searchInsertPosition.add(9, 34));

    }
}
