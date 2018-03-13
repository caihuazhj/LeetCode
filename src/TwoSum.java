<<<<<<< HEAD
import javax.sound.midi.Soundbank;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;
=======
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 *Example:
 *Given nums = [2, 7, 11, 15], target = 9,
 *
 *Because nums[0] + nums[1] = 2 + 7 = 9,
 *return [0, 1].
 * @author Administrator
 *
 */

public class TwoSum {
	
	public int[] twoSumByHashMap(int[] nums, int target) {
		Map<Integer, Integer> maps = new HashMap<>();
		int[] res = new int[2];
		for(int i = 0;i<nums.length;i++){
			maps.put(nums[i], i);
		}
		for(int i = 0;i<nums.length;i++){
			int temp = target - nums[i];
			if (maps.containsValue(temp) && maps.get(temp) != i) {
					res[0] = i;
					res[1] = maps.get(temp);
					return res;
			}
		}
		
		throw new IllegalArgumentException("No two sum solution");
	}
   	public static int[]  twoSum(int[] nums, int target) {

            int[] res = new int[2];
            for (int i=0;i<nums.length;i++){
                for (int j=i+1;j<nums.length;j++){
                    if(nums[i]+nums[j] == target){
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }

            return  res;
    }


    public static void main(String[] args) {
        int[] nums = {2,7,11,13};
        int target = 4;
//        twoSum(nums,target);
        Map<Integer,String> maps = new HashMap<>();

        maps.put(1,"first");
        maps.put(2,"secend");
        maps.put(3,"third");
        System.out.println(maps.containsValue("third"));
        System.out.println(maps.containsValue(2));
        System.out.println(maps.containsKey(4));
        System.out.println(maps.containsValue("for"));

    }

}
