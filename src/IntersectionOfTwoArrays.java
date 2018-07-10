
import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 *
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<Integer> nums3 = new ArrayList<>();
        for (int i=0;i<n1;i++){
            for (int j=0;j<n2;j++){
                if (nums1[i]==nums2[j]){
                    if(!(nums3.contains(nums1[i]))){
                        nums3.add(nums1[i]);
                    }

                }
            }
        }
        int[] arr = new int[nums3.size()];
        for (int k=0;k<nums3.size();k++){
            arr[k] = nums3.get(k);
        }
        return arr;

    }
    //考虑到输出数组的唯一性，可以将nums1中的数值放到Set中
    //考虑到输出结果没有顺序要求，输出结果也可以用set接收
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        for(int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }

        int[] result = new int[res.size()];
        int i = 0;
        for (int n : res) {
            result[i++] = n;
        }

        return result;
    }
    //
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer,Integer> hash = new HashMap();
        List<Integer> myList = new ArrayList();

        //判定重复值
        for(int i=0;i<nums1.length;i++){
            if(!hash.containsKey(nums1[i])){
                hash.put(nums1[i],1);
            }else{
                hash.put(nums1[i],(hash.get(nums1[i]))+1);
            }
        }

        for(int i=0;i<nums2.length;i++){
            if(hash.containsKey(nums2[i])){
                if(hash.get(nums2[i])>0){//如果有重复值 添加到list中 并且将hash中重复出现的次数减一
                    hash.put(nums2[i],(hash.get(nums2[i]))-1);
                    myList.add(nums2[i]);
                }
            }
        }


        int[] arr = new int[myList.size()];

        for(int i = 0; i < myList.size(); i++) {
            if (myList.get(i) != null) {
                arr[i] = myList.get(i);
            }
        }
        return arr;
    }


    public static void main(String[] args) {

        int[] nums1 = {1};
        int[] nums2 = {1,1};
        System.out.println(Arrays.toString(intersect(nums1,nums2)));
    }
}
