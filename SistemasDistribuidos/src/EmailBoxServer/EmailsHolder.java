package EmailBoxServer;


/**
* EmailBoxServer/EmailsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from br/com/emailmanager/corba/EmailBoxServer.idl
* Segunda-feira, 1 de Dezembro de 2014 12h44min21s BRST
*/

public final class EmailsHolder implements org.omg.CORBA.portable.Streamable
{
  public EmailBoxServer.Email value[] = null;

  public EmailsHolder ()
  {
  }

  public EmailsHolder (EmailBoxServer.Email[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = EmailBoxServer.EmailsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    EmailBoxServer.EmailsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return EmailBoxServer.EmailsHelper.type ();
  }

}
