package sixth_Sort;

public class KeyType implements Comparable<KeyType>{
	    public int key;//关键字
	    public KeyType(int key) {
	    	this.key=key;
	    }
	    
	    public String toString() {
	    	return key+" ";
	    }
	    public int compareTo(KeyType another) {
	    	int thisVal=this.key;
	    	int anotherVal=another.key;
	    	return(thisVal<anotherVal?  -1:(thisVal==anotherVal? 0:1));
	    }
}

