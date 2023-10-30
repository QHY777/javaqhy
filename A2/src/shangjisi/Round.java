package shangjisi;

public class Round extends Shape {
     float radius;
     public Round(String DESCRIPTION,float radius) {
    	 super(DESCRIPTION);
    	 this.radius=radius;
     }
    @Override
    public float getCircumference() {
    	return (float) (2*Math.PI*radius);
    }
    @Override
    public float getArea() {
    	return (float)(Math.PI*Math.pow(this.radius, 2));
    }

}
