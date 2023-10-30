package shangjisi;

public class RoundInterface implements ShapeInterface {
	float radius;
    public RoundInterface(float radius) {
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
