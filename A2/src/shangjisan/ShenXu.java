package shangjisan;

public class ShenXu {


    static void sortArray(int[] data) {
    	int i,j,k,temp;
    for(i=0;i<data.length;i++) {
    		k=i;
    	for(j=i+1;j<data.length;j++)
    		{if(data[j]<data[k]) { k=j;}
    	}
    	if(k!=i) {temp=data[i];data[i]=data[k];data[k]=temp;
    }
	}
    }
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
   
    int[] a= {1,25,36,22,111,2,3,5,8,7};
    sortArray(a);
     for(int x:a) { 
    	System.out.print(x+" ");
     }
}
}
