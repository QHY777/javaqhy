package shangjisi;

public abstract class Shape {
	//抽象类
	  String DESCRIPTION;
      public abstract  float getCircumference();
      public abstract  float getArea();
      public Shape() {
      }
      public Shape(String DESCRIPTION) {
    	  this.DESCRIPTION=DESCRIPTION;
      }
}
      
