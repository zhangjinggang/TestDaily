package algorithm;

/**
 * @author zjg
 * @description:
 * @date 2021/3/25 9:50
 */
public class 计数排序 {

    public static void main(String[] args) {
        int[] arr = {1, 6, 4, 68, 92, 4, 5, 7};
        countSort(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);
        System.out.println(arr[5]);
        System.out.println(arr[6]);
        System.out.println(arr[7]);
    }

    public static void countSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        int[] b = new int[arr.length]; // 存储数组    
        int[] count = new int[max - min + 1]; // 计数数组
        for (int num = min; num <= max; num++) {
            // 初始化各元素值为0，数组下标从0开始因此减min        
            count[num - min] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            count[num - min]++; // 每出现一个值，计数数组对应元素的值+1        
            // 此时count[i]表示数值等于i的元素的个数  
        }
        for (int i = min + 1; i <= max; i++) {
            count[i - min] += count[i - min - 1]; // 此时count[i]表示数值<=i的元素的个数  
        }
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i]; // 原数组第i位的值            
            int index = count[num - min] - 1; //加总数组中对应元素的下标            
            b[index] = num; // 将该值存入存储数组对应下标中            
            count[num - min]--; // 加总数组中，该值的总和减少1。  
        }
        // 将存储数组的值替换给原数组    
        for (int i = 0; i < arr.length; i++) {
            arr[i] = b[i];
        }
    }
}
