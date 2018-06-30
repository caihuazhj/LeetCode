/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0){
            return false;
        }
        int[] temp = new int[matrix.length];
        for (int i =0;i<matrix.length;i++){
            temp[i] = matrix[i][0];
//            System.out.println(temp[i]);
        }
        int low = 0;
        int high = temp.length-1;
        //第一层 确定在哪个数组中
        while (low <= high){
            int mid = low +(high-low)/2;
            if (target==temp[mid]){
                return true;
            }
            if(target > temp[mid]){
                low = mid +1;
            }
            if(target < temp[mid]){
                high = mid -1;
            }
        }

        int[] temp1 = new int[matrix[0].length];
        if(target >temp[high]){
            temp1 = matrix[high];

            int low1 = 0;
            int high1 = temp1.length;
            //第一层 确定在哪个数组中
            while (low1 <= high1){
                int mid = low1 +(high1-low1)/2;
                if (target==temp1[mid]){
                    return true;
                }
                if(target > temp1[mid]){
                    low1 = mid +1;
                }
                if(target < temp1[mid]){
                    high1 = mid -1;
                }
            }
        }


        if (target < temp[high]){
            temp1 = matrix[high-1];
            System.out.println(temp1.length);
            System.out.println("前一个数组");
            int low2 = 0;
            int high2 = temp1.length;
            while (low2 <= high2){
                int mid = low2 +(high2-low2)/2;
                if (target==temp1[mid]){
                    return true;
                }
                if(target > temp1[mid]){
                    low2 = mid +1;
                }
                if(target < temp1[mid]){
                    high2 = mid -1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Searcha2DMatrix searcha2DMatrix = new Searcha2DMatrix();
        int[][] matrix ={{1,3,5,7},{10, 11, 16, 20},{23, 30, 34, 50}};
        int target = 0;
        System.out.println(searcha2DMatrix.searchMatrix(matrix,target));

    }
}
