package EmailBoxServer;

/**
* EmailBoxServer/EmailHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from br/com/emailmanager/corba/EmailBoxServer.idl
* Segunda-feira, 1 de Dezembro de 2014 19h27min30s BRST
*/

public final class EmailHolder implements org.omg.CORBA.portable.Streamable
{
  public EmailBoxServer.Email value = null;

  public EmailHolder ()
  {
  }

  public EmailHolder (EmailBoxServer.Email initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = EmailBoxServer.EmailHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    EmailBoxServer.EmailHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return EmailBoxServer.EmailHelper.type ();
  }

}
