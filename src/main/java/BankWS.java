package main.java;

import main.java.controller.AccountController;
import main.java.controller.BankBranchController;
import main.java.controller.ClientController;
import main.java.model.Client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(serviceName = "BankWS")
public class BankWS {
    private ClientController clientController = new ClientController();
    private BankBranchController bankBranchController = new BankBranchController();
    private AccountController accountController = new AccountController();

    public static void main(String[] argv) {
        Object implementor = new BankWS();
        String address = "http://localhost:9000/BankWS";
        Endpoint.publish(address, implementor);
        System.out.println("Web Service started");
    }

    @WebMethod(operationName = "findClientById")
    public Client findClientById(@WebParam(name = "id") int id) {
        return this.clientController.getClient(id);
    }

    @WebMethod(operationName = "getAllClients")
    public String getAllClients() {

        return this.clientController.getClients();
    }

    @WebMethod(operationName = "createBankBranch")
    public String createBankBranch(@WebParam(name = "adress") String adress, @WebParam(name = "compte") String compte) {
        return this.bankBranchController.addBank(adress, compte);
    }

    @WebMethod(operationName = "deleteAccount")
    public String deleteAccount(@WebParam(name = "id") int id) {
        return this.accountController.removeAccount(id);
    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";

    }
}
