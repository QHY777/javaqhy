package third_String_Matrix;

public class SeqString implements IString{
		    
	        private char[] strvalue;  //字符数组，存放字符串值
	        private int curlen;   //串的长度
	        
	        //构造方法
	        public SeqString() {
	        	strvalue=new char[0];
	        	curlen=0;
	        }
	        //构造方法2，以字符串构造串对象
	        public SeqString(String str) {
	        	char[] tempcharArray=str.toCharArray();
	        	strvalue=tempcharArray;
	        	curlen=tempcharArray.length;
	        }
	        //构造方法3，以字符数组构造对象
	        public SeqString(char[] charArray) {
	       	this.strvalue=new char[charArray.length];
	       	for(int i=0;i<charArray.length;i++) {
	       		this.strvalue[i]=charArray[i];
	       	}
	       	curlen=charArray.length;
	        }
	        
			//置空
			public void clear() {
				this.curlen=0;	
			}
		
			//判断是否为空
			public boolean isEmpty() {
				return curlen==0;
			}
		
			//返回字符串长度
			public int length() {
				return curlen;
			}
		
			//返回字符串中序号为index字符
			public char charAt(int index) {
				if(index<0||index>=curlen) {
					throw new StringIndexOutOfBoundsException(index);
				}
				return strvalue[index];
			}
			
			//将字符串中序号为index的字符设置为ch
		    public void setCharAt(int index, char ch) {
		        if ((index < 0) || (index >= curlen)) {
		            throw new StringIndexOutOfBoundsException(index);
		        }
		        strvalue[index] = ch;
		    }

		 
			//扩充字符串存储空间容量,扩充到newSpace大小
			public void allocate(int newSpace) {
				char[] temp=strvalue;
				strvalue=new char[newSpace];
				for(int i=0;i<temp.length;i++) {
					strvalue[i]=temp[i];
				}
			}
			//返回串中序号从begin至end-1的子串
			public IString substring(int begin, int end) {
				if(begin<0) {
					throw new StringIndexOutOfBoundsException("起始位置不得小于0");
				}
				if(end>curlen) {
					throw new StringIndexOutOfBoundsException("结束位置不能大于串的当前长度");
				}
				if(begin>end) {
					throw new StringIndexOutOfBoundsException("开始位置不得大于结束位置");
				}
				if(begin==0&&end==curlen) {
					return this;
				}else {
					char[]buffer=new char[end-begin];
					for(int i=0;i<buffer.length;i++) {
						buffer[i]=this.strvalue[i+begin];
					}
					return new SeqString(buffer);
				}
			}
		
			//在当前串的第offset前面插入串str，0<=offset<=curlen
			public IString insert(int offset, IString str) {
				if((offset<0||(offset>this.curlen))) {
					throw new StringIndexOutOfBoundsException("插入位置不合法");
				}
				int len=str.length();
				int newCount =this.curlen+len;
				if(newCount>strvalue.length) {
					allocate(newCount);      //空间不足，扩充
				}
				for(int i=this.curlen-1;i>=offset;i--) {
					strvalue[i+len]=strvalue[i];   //offset位置以及后面字符后移len
				}
				for(int i=0;i<len;i++) {
					strvalue[i+offset]=str.charAt(i);   //将字符串插入
				}
				this.curlen=newCount;
				return this;
			}
		
			//串的删除，删除从begin到end-1子串
			public IString delete(int begin, int end) {
				if(begin<0) {
					throw new StringIndexOutOfBoundsException("起始位置不可小于零");
				}
				if(end>curlen) {
					throw new StringIndexOutOfBoundsException("结束位置不能大于串的长度curlen");
				}
				if(begin>end) {
					throw new StringIndexOutOfBoundsException("开始位置不可大于结束位置");
				}
				for(int i=0;i<curlen-end;i++) {
					strvalue[begin+i]=strvalue[end+i];   //将end至串尾的字符前移到从begin开始位置
				}
				this.curlen=this.curlen-(end-begin);
				return this;
			}
		   
			//添加指定串到当前串的串尾
			public IString concat(IString str) {
				return insert(curlen,str);
			}
			public int compareTo(IString str) {
				return compareTo((SeqString)str);
			}
			
			//将字符c连接到到当前串尾
		    public IString concat(char c) {
		        int newCount = curlen + 1;
		        if (newCount > strvalue.length) {
		            allocate(newCount);
		        }
		        strvalue[curlen++] = c;
		        return this;
		    }

			//串的比较操作
			public int compareTo(SeqString str) {
				int len1=curlen;
				int len2=str.curlen;
				int n=Math.min(len1, len2);
				char[] s1=strvalue;
				char[] s2=str.strvalue;
				int k=0;
				while(k<n) {
					char ch1=s1[k];
					char ch2=s2[k];
					if(ch1!=ch2) {
						return ch1-ch2;     //返回第一个不相等字符的数值差
					}
					k++;
				}
				return len1-len2;     //返回两个串长度的差
			}
		
			//子串定位
			public int indexOf(IString str, int begin) {
				// TODO Auto-generated method stub
				return indexOf_BF((SeqString)str,begin);
			}
			/*模式匹配的Brute-Force 算法
		    返回模式串t在主串中从start开始的第一次匹配位置，匹配失败时返回－1。*/
		    public int indexOf_BF(SeqString t, int start) {
		        if (this != null && t != null && t.length() > 0 && this.length() >= t.length()) {  //当主串比模式串长时进行比较
		            int slen, tlen, i = start, j = 0;    //i表示主串中某个子串的序号
		            slen = this.length();
		            tlen = t.length();
		            while ((i < slen) && (j < tlen)) {
		                if (this.charAt(i) == t.charAt(j)) //j为模式串当前字符的下标
		                {
		                    i++;
		                    j++;
		                } //继续比较后续字符
		                else {
		                    i = i - j + 1;        //继续比较主串中的下一个子串
		                    j = 0;                //模式串下标退回到0
		                }
		            }
		            if (j >= t.length()) //一次匹配结束，匹配成功
		            {
		                return i - tlen;         //返回子串序号
		            } else {
		                return -1;
		            }
		        }
		        return -1;                     //匹配失败时返回-1
		    }
		    public void display() {
		    	System.out.print("当前字符串为：");
		    	for(int i=0;i<curlen;i++) {
		    		System.out.print(strvalue[i]);
		    	}
		    }


            
	     
}
