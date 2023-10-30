package shangjisi;

public class Rectangular extends Shape{
    int length;
    int width;

    //构造方法
    public Rectangular() {
    }

    public Rectangular(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Rectangular(String DESCRIPTION, int length, int width) {
        super(DESCRIPTION);
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
