package shangjisi;


public class RectangleInterface implements ShapeInterface{
    int length;
    int width;

    //构造方法
    public RectangleInterface() {
    }

    public RectangleInterface(int length, int width) {
        this.length = length;
        this.width = width;
    }
    @Override
    public float getCircumference() {
        return (this.length+this.width)*2;
    }
    @Override
    public float getArea() {
        return this.length*this.width;
    }
}
