package algorithm;


import java.util.Collections;
import java.util.LinkedList;

class BBnode{
	BBnode parent;//���ڵ�
	boolean leftChild;//����ӽ���־
	
	public BBnode(BBnode par,boolean left){
		parent=par;
		leftChild=left;
	}
}
class HeapNode implements Comparable{
	BBnode liveNode;//����
	double upperProfit;//���ļ�ֵ�Ͻ�
	double profit;//�������Ӧ�ļ�ֵ
	double weight;//�������Ӧ������
	int level;//�������Ӽ����������Ĳ����
	
	//���췽��
	HeapNode(BBnode node,double up,double pp,double ww,int lev){
		liveNode=node;
		upperProfit=up;
		profit=pp;
		weight=ww;
		level=lev;
	}
 
	@Override
	public int compareTo(Object x) {//��������
		double xs=((HeapNode) x).upperProfit;
		if(upperProfit>xs) return -1;
		if(upperProfit==xs) return 0;
		return 1;
	}
}
class Element implements Comparable{
	int id;//�������
	double d;//��λ������ֵ
	
	public Element(int id,double d, double theWeight){
		this.id=id;
		this.d=d;
	}
 
	@Override
	public int compareTo(Object o) {//��������
		double xs=((Element) o).d;
		if(d>xs) return -1;
		if(d==xs) return 0;
		return 1;
	}
	public boolean equals(Object o){
		return d==((Element) o).d;
	}
}
 
 
public class BBKnapsack {
	public double c;//��������
	public int n;//��Ʒ����
	public double[] w;//��Ʒ��������
	public double[] p;//��Ʒ��ֵ����
	public double cw;//��ǰ����
	public double cp;//��ǰ��ֵ
	public int[] bestx;//���Ž�
	public LinkedList<HeapNode> heap;//�������ȶ���
	
	//�Ͻ纯��bound����������Ӧ��ֵ���Ͻ�
	public double bound(int i){
		double cleft=c-cw;//ʣ������
		double b=cp;
		//����Ʒ��λ������ֵ�ݼ�˳��װ��ʣ������
		while(i<=n&&w[i]<=cleft){
			cleft-=w[i];
			b+=p[i];
			i++;
		}
		if(i<=n)
			b+=p[i]*cleft/w[i];
		return b;
	}
	
	public void addLiveNode(double up,double pp,double ww,int lev,BBnode par,boolean ch){
		BBnode b=new BBnode(par,ch);
		HeapNode node=new HeapNode(b,up,pp,ww,lev);
		heap.add(node);
		Collections.sort(heap);
	}
	public double bbKnapsack(){
		//��ʼ��
		BBnode enode=null;
		int i=1;
		double bestp=0.0;//��ǰ���Ž�
		double up=bound(1);//��ֵ�Ͻ�
		
		//�����Ӽ��ռ���
		while(i!=n+1){
			//��Ҷ�ڵ�
			//��鵱ǰ��չ��������ӽ��
			double wt=cw+w[i];
			if(wt<=c){//����ӽ�����
				if(cp+p[i]>bestp){
					bestp=cp+p[i];					
				}
				addLiveNode(up,cp+p[i],cw+w[i],i+1,enode,true);
			}
			
			up=bound(i+1);
			//��鵱ǰ��չ�����ж��ӽ��
			if(up>=bestp){//���������ܺ������Ž�
				addLiveNode(up,cp,cw,i+1,enode,false);
			}
			
			HeapNode node=heap.poll();
			enode=node.liveNode;
			cw=node.weight;
			cp=node.profit;
			up=node.upperProfit;
			i=node.level;
		}
		
		//���쵱ǰ���Ž�
		for(int j=n;j>0;j--){
			bestx[j]=(enode.leftChild)?1:0;
			enode=enode.parent;
		}
		return cp;
	}
	
	public double knapsack(double[] pp,double[] ww,double cc,int[] xx){
		c=cc;
		n=pp.length-1;
		double ps=0;//ͳ�����б����ļ�ֵ����
		double ws=0;//ͳ�����еı�������֮��
		Element[] q=new Element[n];
		for(int i=1;i<=n;i++){
			q[i-1]=new Element(i,pp[i]/ww[i], ws);
			ps+=pp[i];
			ws+=ww[i];
		}
		if(ws<=c){//������Ʒ֮��<=�������C,����ȫ����Ʒװ��
			for(int i=1;i<=n;i++){
				xx[i]=1;
			}
			return ps;
		}
		
		//����Ʒ��λ������ֵ����
		java.util.Arrays.sort(q);
		
		//��ʼ�����ݳ�Ա
		p=new double[n+1];
		w=new double[n+1];
		
		for(int i=1;i<=n;i++){
			p[i]=pp[q[i-1].id];
			w[i]=ww[q[i-1].id];
		}
		
		cw=0;
		cp=0;
		bestx=new int[n+1];
		
		heap=new LinkedList<HeapNode>(); 
		
		//����bbKnapsack����������Ž�
		double maxp=bbKnapsack();
		for(int i=1;i<=n;i++){
			xx[q[i-1].id]=bestx[i];
		}
		return maxp;
	}
	
	public static void main(String[] args) {
		double pp[]={0,2,1,4,3};
		double ww[]={0,1,4,2,3};
		double cc=8;
		int n=pp.length-1;
		int[] xx=new int[n+1];
		BBKnapsack b=new BBKnapsack();
		double maxp=b.knapsack(pp, ww, cc, xx);
		System.out.println("װ�뱳������Ʒ�ܼ�ֵ���Ϊ��"+maxp);		
		System.out.println("װ�����Ʒ�����Ϊ��");
		for(int i=1;i<=n;i++){
			System.out.println(i+":"+xx[i]);
		}
	}
}
 
/*
��������
װ�뱳������Ʒ�ܼ�ֵ���Ϊ��9.0
װ�����Ʒ�����Ϊ��
1:1
2:0
3:1
4:1
 */