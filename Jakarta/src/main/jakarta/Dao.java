package main.jakarta;


import com.jakarta.Script;

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

    public void setData(int data) {
        this.data = data;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    Script script = new Script(20, 30);
}
