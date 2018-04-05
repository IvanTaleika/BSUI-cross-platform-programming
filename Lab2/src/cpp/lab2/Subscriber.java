package cpp.lab2;


import java.util.LinkedList;

/**
 * @author xefza
 * @version 1.0
 * @created 03-Apr-2018 17:46:47
 */
public interface Subscriber {

    /**
     * @param clientType
     * @param name
     * @param money
     */
    public void updateClientInfo(String clientType, String name, String money);

    /**
     * @param orders
     */
    public void updateClientOrders(LinkedList<String> orders);

}