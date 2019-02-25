/**
 * Created by amour on 05.03.2018.
 */
public class Segment {

    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double length;
    public Segment(double x1,double y1,double x2,double y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.length = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int compareTo(Segment element2) {
        if(this.getLength() > element2.getLength()){
            return 1;
        }else {
            return -1;
        }
    }
}
