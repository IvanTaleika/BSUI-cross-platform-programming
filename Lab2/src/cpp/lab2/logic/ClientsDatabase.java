//package cpp.lab2.logic;
//
//
//import cpp.lab2.Subscriber;
//
//import java.util.LinkedList;
//
///**
// * @author xefza
// * @version 1.0
// * @created 03-Apr-2018 17:46:47
// */
//public class ClientsDatabase {
//
//    private LinkedList<Client> clients;
//    private Client currentClient;
//    private LinkedList<Subscriber> subscribers;
//    public Client m_Client;
//    public Subscriber m_Subscriber;
//
//    public ClientsDatabase() {
//
//    }
//
//
//    /**
//     * @param name
//     * @param money
//     */
//    public void addAndSwitch(String name, double money) {
//        //TODO: is it correct
//        Client client = new Client(name,money);
//        clients.add(client);
//        switchClient(client);
//    }
//
//    public LinkedList<Client> getClientList() {
//        return clients;
//    }
//
//    /**
//     * @param orderName
//     * @param amount
//     */
//    public void makeOrder(String orderName, int amount) {
////TODO: use Company method
//    }
//
//    /**
//     * @param money
//     */
//    public void setMoney(double money) {
//        currentClient.setMoney(money);
//
//    }
//
//    /**
//     * @param client
//     */
//    public void switchClient(Client client) {
//        currentClient = client;
//        for(Subscriber subscriber : subscribers){
//            //TODO: is I should parse here?
//            subscriber.updateClientInfo(/*type*/,client.getName(),/*money*/));
//        }
//    }
//
//
//}