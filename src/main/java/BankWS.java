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


    /**
     * Test findClientById with Postman
     *
     * URL : http://localhost:9000/BankWS?wsdl
     * TYPE : POST
     * Requête :
     * <?xml version="1.0" encoding="UTF-8"?>
     * <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
     *     <SOAP-ENV:Header/>
     *     <S:Body>
     *         <ns2:findClientById xmlns:ns2="http://java.main/">
     *         	<id>1</id>
     *         </ns2:findClientById>
     *     </S:Body>
     * </S:Envelope>
     */

    @WebMethod(operationName = "findClientById")
    public Client findClientById(@WebParam(name = "id") int id) {
        return this.clientController.getClient(id);
    }


    /**
     * Test getAllClients with Postman
     *
     * URL : http://localhost:9000/BankWS?wsdl
     * TYPE : POST
     * Requête :
     * <?xml version="1.0" encoding="UTF-8"?>
     * <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
     *     <SOAP-ENV:Header/>
     *     <S:Body>
     *         <ns2:getAllClients xmlns:ns2="http://java.main/">
     *         </ns2:getAllClients>
     *     </S:Body>
     * </S:Envelope>
     */

    @WebMethod(operationName = "getAllClients")
    public String getAllClients() {

        return this.clientController.getClients();
    }

    /**
     * Test createBankBranch with Postman
     *
     * URL : http://localhost:9000/BankWS?wsdl
     * TYPE : POST
     * Requête :
     * <?xml version="1.0" encoding="UTF-8"?>
     * <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
     *     <SOAP-ENV:Header/>
     *     <S:Body>
     *         <ns2:createBankBranch xmlns:ns2="http://java.main/">
     *             <name>Test</name>
     *             <adress>Paris</adress>
     *             <compte>Bob compte</compte>
     *         </ns2:createBankBranch>
     *     </S:Body>
     * </S:Envelope>
     */

    @WebMethod(operationName = "createBankBranch")
    public String createBankBranch(@WebParam(name = "adress") String adress, @WebParam(name = "compte") String compte) {
        return this.bankBranchController.addBank(adress, compte);
    }


    /**
     * Test deleteAccount with Postman
     *
     * URL : http://localhost:9000/BankWS?wsdl
     * TYPE : POST
     * Requête :
     * <?xml version="1.0" encoding="UTF-8"?>
     * <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
     *     <SOAP-ENV:Header/>
     *     <S:Body>
     *         <ns2:deleteAccount xmlns:ns2="http://java.main/">
     *         	<id>1</id>
     *         </ns2:deleteAccount>
     *     </S:Body>
     * </S:Envelope>
     */

    @WebMethod(operationName = "deleteAccount")
    public String deleteAccount(@WebParam(name = "id") int id) {
        return this.accountController.removeAccount(id);
    }


    /**
     * Test hello with Postman
     *
     * URL : http://localhost:9000/BankWS?wsdl
     * TYPE : POST
     * Requête :
     * <?xml version="1.0" encoding="UTF-8"?>
     * <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
     *     <SOAP-ENV:Header/>
     *     <S:Body>
     *         <ns2:hello xmlns:ns2="http://java.main/">
     *             <name>test</name>
     *         </ns2:hello>
     *     </S:Body>
     * </S:Envelope>
     */

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";

    }
}
