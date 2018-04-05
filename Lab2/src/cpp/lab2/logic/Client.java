package cpp.lab2.logic;


/**
 * @author xefza
 * @version 1.0
 * @created 03-Apr-2018 17:46:47
 */
public class Client {

    private double money;
    private String name;
//	public Company m_Company;

    public Client(String name, double money) {
        this.name = name;
        this.money = money;
    }


    public double getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    /**
     * @param name
     * @param amount
     */
    public void makeOrder(String name, int amount) {

    }

    /**
     * @param cost
     */
    public void pay(double cost) {

    }

    /**
     * @param money
     */
    public void setMoney(double money) {

    }

}