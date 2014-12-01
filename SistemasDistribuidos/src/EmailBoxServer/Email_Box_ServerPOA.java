package EmailBoxServer;


/**
* EmailBoxServer/Email_Box_ServerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from br/com/emailmanager/corba/EmailBoxServer.idl
* Segunda-feira, 1 de Dezembro de 2014 12h44min22s BRST
*/

public abstract class Email_Box_ServerPOA extends org.omg.PortableServer.Servant
 implements EmailBoxServer.Email_Box_ServerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("saveEmail", new java.lang.Integer (0));
    _methods.put ("getEmails", new java.lang.Integer (1));
    _methods.put ("deleteEmail", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // EmailBoxServer/Email_Box_Server/saveEmail
       {
         int userId = in.read_long ();
         String toEmail = in.read_string ();
         String messageEmail = in.read_string ();
         this.saveEmail (userId, toEmail, messageEmail);
         out = $rh.createReply();
         break;
       }

       case 1:  // EmailBoxServer/Email_Box_Server/getEmails
       {
         int userId = in.read_long ();
         String date = in.read_string ();
         EmailBoxServer.Email $result[] = null;
         $result = this.getEmails (userId, date);
         out = $rh.createReply();
         EmailBoxServer.EmailsHelper.write (out, $result);
         break;
       }

       case 2:  // EmailBoxServer/Email_Box_Server/deleteEmail
       {
         int emailId = in.read_long ();
         this.deleteEmail (emailId);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:EmailBoxServer/Email_Box_Server:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Email_Box_Server _this() 
  {
    return Email_Box_ServerHelper.narrow(
    super._this_object());
  }

  public Email_Box_Server _this(org.omg.CORBA.ORB orb) 
  {
    return Email_Box_ServerHelper.narrow(
    super._this_object(orb));
  }


} // class Email_Box_ServerPOA
