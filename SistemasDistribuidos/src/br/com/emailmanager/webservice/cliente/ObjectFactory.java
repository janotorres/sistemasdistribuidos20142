
package br.com.emailmanager.webservice.cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.emailmanager.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EnviarEmailResponse_QNAME = new QName("http://webservice.emailmanager.com.br/", "EnviarEmailResponse");
    private final static QName _EnviarEmail_QNAME = new QName("http://webservice.emailmanager.com.br/", "EnviarEmail");
    private final static QName _Autenticar_QNAME = new QName("http://webservice.emailmanager.com.br/", "autenticar");
    private final static QName _AutenticarResponse_QNAME = new QName("http://webservice.emailmanager.com.br/", "autenticarResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.emailmanager.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EnviarEmail }
     * 
     */
    public EnviarEmail createEnviarEmail() {
        return new EnviarEmail();
    }

    /**
     * Create an instance of {@link EnviarEmailResponse }
     * 
     */
    public EnviarEmailResponse createEnviarEmailResponse() {
        return new EnviarEmailResponse();
    }

    /**
     * Create an instance of {@link Autenticar }
     * 
     */
    public Autenticar createAutenticar() {
        return new Autenticar();
    }

    /**
     * Create an instance of {@link AutenticarResponse }
     * 
     */
    public AutenticarResponse createAutenticarResponse() {
        return new AutenticarResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.emailmanager.com.br/", name = "EnviarEmailResponse")
    public JAXBElement<EnviarEmailResponse> createEnviarEmailResponse(EnviarEmailResponse value) {
        return new JAXBElement<EnviarEmailResponse>(_EnviarEmailResponse_QNAME, EnviarEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.emailmanager.com.br/", name = "EnviarEmail")
    public JAXBElement<EnviarEmail> createEnviarEmail(EnviarEmail value) {
        return new JAXBElement<EnviarEmail>(_EnviarEmail_QNAME, EnviarEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Autenticar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.emailmanager.com.br/", name = "autenticar")
    public JAXBElement<Autenticar> createAutenticar(Autenticar value) {
        return new JAXBElement<Autenticar>(_Autenticar_QNAME, Autenticar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutenticarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.emailmanager.com.br/", name = "autenticarResponse")
    public JAXBElement<AutenticarResponse> createAutenticarResponse(AutenticarResponse value) {
        return new JAXBElement<AutenticarResponse>(_AutenticarResponse_QNAME, AutenticarResponse.class, null, value);
    }

}
