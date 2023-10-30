package practice;

public class Book{
    private String name; //书名
    private String author; //作者
    private String category; //分类
    private boolean state; //状态  true代表没借出  false代表已借出

    //构造函数

    public Book(String name,String author,String category,boolean state){
        this.author = author;
        this.name = name;
        this.category = category;
        this.state = state;
    }
    public static Book[] books = new Book[]{  //默认定义书籍

            new Book("西游记","吴承恩","名著",true),
            new Book("红楼梦","曹雪芹","名著",true),
            new Book("三国演义","罗贯中","名著",true),
            new Book("倚天屠龙记","金庸","武侠",true),
            new Book("神雕侠侣","金庸","武侠",true),
            new Book("斗破苍穹","天蚕土豆","玄幻",true),
            new Book()
    };
    
  public Book(int i) { 
       Book.books = new Book[i];  
    }
    
    


public  Book() {  //默认100本书
       this(100);
   }
    //属性的获取和设置
    public String getName() { 
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public boolean getState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}

