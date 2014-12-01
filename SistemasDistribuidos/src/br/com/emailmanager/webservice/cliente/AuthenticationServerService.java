
package br.com.emailmanager.webservice.cliente;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AuthenticationServerService", targetNamespace = "http://webservice.emailmanager.com.br/", wsdlLocation = "http://localhost:2222/Authentication?wsdl")
public class AuthenticationServerService
    extends Service
{

    private final static URL AUTHENTICATIONSERVERSERVICE_WSDL_LOCATION;
    private final static WebServiceException AUTHENTICATIONSERVERSERVICE_EXCEPTION;
    private final static QName AUTHENTICATIONSERVERSERVICE_QNAME = new QName("http://webservice.emailmanager.com.br/", "AuthenticationServerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:2222/Authentication?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        AUTHENTICATIONSERVERSERVICE_WSDL_LOCATION = url;
        AUTHENTICATIONSERVERSERVICE_EXCEPTION = e;
    }

    public AuthenticationServerService() {
        super(__getWsdlLocation(), AUTHENTICATIONSERVERSERVICE_QNAME);
    }

    public AuthenticationServerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), AUTHENTICATIONSERVERSERVICE_QNAME, features);
    }

    public AuthenticationServerService(URL wsdlLocation) {
        super(wsdlLocation, AUTHENTICATIONSERVERSERVICE_QNAME);
    }

    public AuthenticationServerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, AUTHENTICATIONSERVERSERVICE_QNAME, features);
    }

    public AuthenticationServerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AuthenticationServerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AuthenticationServer
     */
    @WebEndpoint(name = "AuthenticationServerPort")
    public AuthenticationServer getAuthenticationServerPort() {
        return super.getPort(new QName("http://webservice.emailmanager.com.br/", "AuthenticationServerPort"), AuthenticationServer.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AuthenticationServer
     */
    @WebEndpoint(name = "AuthenticationServerPort")
    public AuthenticationServer getAuthenticationServerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservice.emailmanager.com.br/", "AuthenticationServerPort"), AuthenticationServer.class, features);
    }

    private static URL __getWsdlLocation() {
        if (AUTHENTICATIONSERVERSERVICE_EXCEPTION!= null) {
            throw AUTHENTICATIONSERVERSERVICE_EXCEPTION;
        }
        return AUTHENTICATIONSERVERSERVICE_WSDL_LOCATION;
    }

}
