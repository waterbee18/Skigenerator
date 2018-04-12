package guesski.model;

public class Vector {
    private double dx;
    private double dy;
    private double length;
    private double angle;

    public Vector(double dx,double dy){
        this.dx = dx;
        this.dy = dy;
        angle = Math.atan(dy/dx);
        length = Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
        updateFromD();
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
        updateFromD();
    }

    public double getOrientation(){
        return angle;
    }

    public double length(){
        return length;
    }

    public void setLength(double length){
        this.length = length;
        this.dx = Math.cos(angle)*length;
        this.dy = Math.sin(angle)*length;
    }

    public void invertX(){
        this.dx*=-1;
        updateFromD();
    }


    public Vector invertY(){
        this.dy*=-1;
        updateFromD();
        return this;
    }

    public void add(Vector vector){
        this.setDx(this.dy+vector.getDx());
        this.setDy(this.dy+vector.getDy());
    }

    public void minus(Vector vector){
        this.setDx(this.dx-vector.getDx());
        this.setDy(this.dy-vector.getDy());
    }

    public void minus(double length){
        this.length -= length;
        updateFromLenth();
    }

    public Vector clone(){
        return new Vector(dx,dy);
    }

    public static double multiply(Vector vector1, Vector vector2){
        return vector1.getDx()*vector2.getDx()+vector1.getDy()*vector2.getDy();
    }

    public static Vector scalarMultiply(Vector v, double scalar){
        return new Vector(v.getDx()*scalar,v.getDy()*scalar);
    }

    public static Vector orthogonalProjection(Vector projected, Vector target){
        double product = multiply(projected,target);
        return scalarMultiply(target,(product/Math.pow(target.length(),2)));
    }

    public static Vector add(Vector v1, Vector v2){
        return new Vector(v1.getDx()+v2.getDx(), v1.getDy()+v2.getDy());
    }

    public static Vector add(Vector... vectors){
        double ex = 0;
        double ey = 0;
        for (Vector v: vectors){
            ex+=v.getDx();
            ey+=v.getDy();
        }
        return new Vector(ex,ey);
    }
    public static Vector toLength(Vector vector, double lenght){
        return new Vector(Math.cos(vector.getOrientation())*lenght,Math.sin(vector.getOrientation())*lenght);
    }

    public static Vector inverted(Vector v){
        return new Vector(v.getDx()*-1,v.getDy()*-1);
    }

    public static Vector invertY(Vector v){
        return new Vector(v.getDx(),v.getDy()*-1);
    }

    private void updateFromD(){
        angle = Math.atan(dy/dx);
        length = Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
    }

    private void updateFromLenth(){
        dx = Math.cos(angle)*length;
        dy = Math.sin(angle)*length;
    }
}
