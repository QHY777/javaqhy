package zuoye;

/*习题2-3 改写二分搜索算法
设a[ 0:n一1]是已排好序的数组。请改写二分搜索算法，使得当搜索元素x不在数组中时，
返回小于x的最大元素位置i主和大于x的最小元素位置j。
当搜索元素在数组中时，i和j相同,均为工在数组中的位置。
*/
public class BinarySearch {

	public String binarySearch(int[] a,int x,int n) {
		int left=0;
		int right=n-1;  
		int middle = 0;
		while(left<=right) {   //确定middle最终位置
			middle =(left+right)/2;
			if(x==middle) {       
				return "i=j="+middle;
			}
			if(x>a[middle]) {
				left=middle+1;
			}else {
				right=middle-1;
			}
		}
		
		
		if(a[middle]<x) {    //最后middle比x小
			if(x>a[n-1]) {          //x比所有数大
				return "小于x最大元素位置i:"+(n-1)+"大于x最小元素位置j不存在";
			}
			return "小于x最大元素位置i:"+middle+"大于x最小元素位置j:"+(middle+1);
		}else {        //最后middle比x大
			if(x<a[0]) {       //x比所有数小
				return "小于x最大元素位置i不存在"+"大于x最小元素位置j:"+0;
			}
			return "小于x最大元素位置i:"+(middle-1)+"大于x最小元素位置j:"+middle;
		}
		
		
	}
}
