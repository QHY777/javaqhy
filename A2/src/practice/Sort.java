package practice;

public  class Sort{
	//从小到大排序方法
	protected static <T extends Comparable<T>> void selectionSort(T[] list){
    	int min;
    	T tmp;
    	for(int i = 0; i < list.length-1; i ++){
    		min = i;
    		for( int j = i+1 ; j < list.length; j ++){
    			if(list[j].compareTo(list[min]) < 0){
    				min = j;
    			}
    		}
    		tmp = list[i];
    		list[i] = list[min];
    		list[min] = tmp;
    	}
}
	public static void main(String[] args) {
		String[] list= {"a","c","b","abc","ab"};//字符串数组
		Integer[] a= {1,2,5,4,9,7};             //整形数组
		Sort.<Integer>selectionSort(a);     //排序
		Sort.<String>selectionSort(list);
		for(int i=0;i<a.length;i++){             //输出
			System.out.print(a[i]+" ");
		}
		System.out.println();
		for(int i=0;i<list.length;i++){
			System.out.print(list[i]+" ");
		}
	}
}
