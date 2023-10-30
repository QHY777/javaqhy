package blue;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		int[] nums= {1,4,3,2};
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
        int result=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0) {
            	System.out.println("i："+i+"   nums[i]: "+nums[i]);
            	result+=nums[i];
            }
                
        }
        System.out.println(result);

		
	}
	
		
	
}
	
