package main.jakarta;




public class Dao {
    private int data;
    private int money;

    public Dao(int data, int money){
        this.data = data;
        this.money = money;
    }

    public int getData() {
        return data;
    }

    public int getMoney() {
        return money;
    }
}
