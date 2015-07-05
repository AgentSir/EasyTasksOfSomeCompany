package Test_1_ExchangeValues;

/**
 *  Exchanger serves for swap values of two variable without using a third variable
 */

public class Exchanger {
    private int x;
    private int y;

    //Swapping two numbers used logic operation XOR
    public void exchangeValues(){
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
    }

    public Exchanger(int x, int y){
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Test drive
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger(4, 2);
        exchanger.exchangeValues();
        System.out.println("x = " + exchanger.getX() + ", y = " + exchanger.getY());
    }
}
