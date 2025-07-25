package com.westbank.ws.client.callbackloancontract;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2025-07-15T14:03:43.664+05:30
 * Generated source version: 3.2.4
 *
 */
@WebServiceClient(name = "CallbackLoanContract",
                  targetNamespace = "urn:com:westbank:ws:client:CallbackLoanContract")
public class CallbackLoanContract_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("urn:com:westbank:ws:client:CallbackLoanContract", "CallbackLoanContract");
    public final static QName CallbackLoanContractPort = new QName("urn:com:westbank:ws:client:CallbackLoanContract", "CallbackLoanContractPort");
    static {
        WSDL_LOCATION = null;
    }

    public CallbackLoanContract_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CallbackLoanContract_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CallbackLoanContract_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public CallbackLoanContract_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CallbackLoanContract_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CallbackLoanContract_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns CallbackLoanContract
     */
    @WebEndpoint(name = "CallbackLoanContractPort")
    public CallbackLoanContract getCallbackLoanContractPort() {
        return super.getPort(CallbackLoanContractPort, CallbackLoanContract.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CallbackLoanContract
     */
    @WebEndpoint(name = "CallbackLoanContractPort")
    public CallbackLoanContract getCallbackLoanContractPort(WebServiceFeature... features) {
        return super.getPort(CallbackLoanContractPort, CallbackLoanContract.class, features);
    }

}
