
package br.com.emailmanager.webservice.cliente;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.emailmanager.webservice.cliente.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "AuthenticationServer", targetNamespace = "http://webservice.emailmanager.com.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AuthenticationServer {


    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod(operationName = "EnviarEmail")
    @RequestWrapper(localName = "EnviarEmail", targetNamespace = "http://webservice.emailmanager.com.br/", className = "br.com.emailmanager.webservice.EnviarEmail")
    @ResponseWrapper(localName = "EnviarEmailResponse", targetNamespace = "http://webservice.emailmanager.com.br/", className = "br.com.emailmanager.webservice.EnviarEmailResponse")
    public void enviarEmail(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "autenticar", targetNamespace = "http://webservice.emailmanager.com.br/", className = "br.com.emailmanager.webservice.Autenticar")
    @ResponseWrapper(localName = "autenticarResponse", targetNamespace = "http://webservice.emailmanager.com.br/", className = "br.com.emailmanager.webservice.AutenticarResponse")
    public void autenticar(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

}