package fifth_Search;

import sixth_Sort.SeqList;

public class SeqList2 extends SeqList{

	public SeqList2(int maxSize) {
		super(maxSize);
	}
	
	//顺序查找
	public int seqSearch(Comparable key) {
		int i=0;
		int n=curlen;
		while(i<n&&r[i].key.compareTo(key)!=0) {
			i++;
		}
		if(i<n) {
			return i;  //查找成功，返回元素下标，否则返回-1
		}else {
			return -1;
		}
	}
	
	//二分查找
	public int binarySearch(int low, int high, Comparable key) {
        int mid, result;
        if (low <= high) {
            mid = (low + high) / 2;   //中间位置，当前比较元素位置
            result = r[mid].key.compareTo(key);
            if (result > 0) {
                return binarySearch(low, mid - 1, key);                                //查找成功
            } else if (result < 0) {
                return binarySearch(mid + 1, high, key);
            } else {
                return mid;
            }
        }
        return -1;  //查找不成功
	}
	public int binarySearch(Comparable key) {
		return binarySearch(0,curlen-1,key);
	}
	
}
