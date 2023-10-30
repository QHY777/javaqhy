package shangjisi;

public class TriangleInterface implements ShapeInterface {
	float line1;
    float line2;
    float line3;
    //构造方法
    public TriangleInterface(){

    }

    public TriangleInterface(float line1,float line2 ,float line3){
        this.line1 =line1;
        this.line2 =line2;
        this.line3 =line3;
    }

    @Override
    public float getCircumference() {
        return line1+line2+line3;
    }

    @Override
    public float getArea() {
        //海伦公式
        float s = (line1 + line2 + line3)/2;
        return (float)(Math.pow(s*(s - line1)*(s - line2)*(s - line3),0.5));
    }
}
