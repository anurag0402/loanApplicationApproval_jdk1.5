package com.westbank.ws.process.loanapproval._2018._06;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2025-07-16T00:13:48.894+05:30
 * Generated source version: 3.2.4
 *
 */
@WebServiceClient(name = "LoanApproval",
                  targetNamespace = "urn:com:westbank:ws:process:LoanApproval:2018:06")
public class LoanApproval_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("urn:com:westbank:ws:process:LoanApproval:2018:06", "LoanApproval");
    public final static QName LoanApprovalPort = new QName("urn:com:westbank:ws:process:LoanApproval:2018:06", "LoanApprovalPort");
    static {
        WSDL_LOCATION = null;
    }

    public LoanApproval_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public LoanApproval_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LoanApproval_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public LoanApproval_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public LoanApproval_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public LoanApproval_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns LoanApproval
     */
    @WebEndpoint(name = "LoanApprovalPort")
    public LoanApproval getLoanApprovalPort() {
        return super.getPort(LoanApprovalPort, LoanApproval.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LoanApproval
     */
    @WebEndpoint(name = "LoanApprovalPort")
    public LoanApproval getLoanApprovalPort(WebServiceFeature... features) {
        return super.getPort(LoanApprovalPort, LoanApproval.class, features);
    }

}
