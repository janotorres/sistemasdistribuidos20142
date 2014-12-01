
package br.com.emailmanager.webservice.cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.emailmanager.webservice.cliente package. 
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

    private final static QName _GetAuthenticateUserResponse_QNAME = new QName("http://webservice.emailmanager.com.br/", "getAuthenticateUserResponse");
    private final static QName _GetAuthenticateUser_QNAME = new QName("http://webservice.emailmanager.com.br/", "getAuthenticateUser");
    private final static QName _SaveNewUser_QNAME = new QName("http://webservice.emailmanager.com.br/", "saveNewUser");
    private final static QName _AuthenticateResponse_QNAME = new QName("http://webservice.emailmanager.com.br/", "authenticateResponse");
    private final static QName _SaveNewUserResponse_QNAME = new QName("http://webservice.emailmanager.com.br/", "saveNewUserResponse");
    private final static QName _SendEmailResponse_QNAME = new QName("http://webservice.emailmanager.com.br/", "sendEmailResponse");
    private final static QName _Authenticate_QNAME = new QName("http://webservice.emailmanager.com.br/", "authenticate");
    private final static QName _SendEmail_QNAME = new QName("http://webservice.emailmanager.com.br/", "sendEmail");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.emailmanager.webservice.cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendEmail }
     * 
     */
    public SendEmail createSendEmail() {
        return new SendEmail();
    }

    /**
     * Create an instance of {@link Authenticate }
     * 
     */
    public Authenticate createAuthenticate() {
        return new Authenticate();
    }

    /**
     * Create an instance of {@link SendEmailResponse }
     * 
     */
    public SendEmailResponse createSendEmailResponse() {
        return new SendEmailResponse();
    }

    /**
     * Create an instance of {@link SaveNewUserResponse }
     * 
     */
    public SaveNewUserResponse createSaveNewUserResponse() {
        return new SaveNewUserResponse();
    }

    /**
     * Create an instance of {@link AuthenticateResponse }
     * 
     */
    public AuthenticateResponse createAuthenticateResponse() {
        return new AuthenticateResponse();
    }

    /**
     * Create an instance of {@link SaveNewUser }
     * 
     */
    public SaveNewUser createSaveNewUser() {
        return new SaveNewUser();
    }

    /**
     * Create an instance of {@link GetAuthenticateUser }
     * 
     */
    public GetAuthenticateUser createGetAuthenticateUser() {
        return new GetAuthenticateUser();
    }

    /**
     * Create an instance of {@link GetAuthenticateUserResponse }
     * 
     */
    public GetAuthenticateUserResponse createGetAuthenticateUserResponse() {
        return new GetAuthenticateUserResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuthenticateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.emailmanager.com.br/", name = "getAuthenticateUserResponse")
    public JAXBElement<GetAuthenticateUserResponse> createGetAuthenticateUserResponse(GetAuthenticateUserResponse value) {
        return new JAXBElement<GetAuthenticateUserResponse>(_GetAuthenticateUserResponse_QNAME, GetAuthenticateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuthenticateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.emailmanager.com.br/", name = "getAuthenticateUser")
    public JAXBElement<GetAuthenticateUser> createGetAuthenticateUser(GetAuthenticateUser value) {
        return new JAXBElement<GetAuthenticateUser>(_GetAuthenticateUser_QNAME, GetAuthenticateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveNewUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.emailmanager.com.br/", name = "saveNewUser")
    public JAXBElement<SaveNewUser> createSaveNewUser(SaveNewUser value) {
        return new JAXBElement<SaveNewUser>(_SaveNewUser_QNAME, SaveNewUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.emailmanager.com.br/", name = "authenticateResponse")
    public JAXBElement<AuthenticateResponse> createAuthenticateResponse(AuthenticateResponse value) {
        return new JAXBElement<AuthenticateResponse>(_AuthenticateResponse_QNAME, AuthenticateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveNewUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.emailmanager.com.br/", name = "saveNewUserResponse")
    public JAXBElement<SaveNewUserResponse> createSaveNewUserResponse(SaveNewUserResponse value) {
        return new JAXBElement<SaveNewUserResponse>(_SaveNewUserResponse_QNAME, SaveNewUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.emailmanager.com.br/", name = "sendEmailResponse")
    public JAXBElement<SendEmailResponse> createSendEmailResponse(SendEmailResponse value) {
        return new JAXBElement<SendEmailResponse>(_SendEmailResponse_QNAME, SendEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Authenticate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.emailmanager.com.br/", name = "authenticate")
    public JAXBElement<Authenticate> createAuthenticate(Authenticate value) {
        return new JAXBElement<Authenticate>(_Authenticate_QNAME, Authenticate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.emailmanager.com.br/", name = "sendEmail")
    public JAXBElement<SendEmail> createSendEmail(SendEmail value) {
        return new JAXBElement<SendEmail>(_SendEmail_QNAME, SendEmail.class, null, value);
    }

}
