package EmailBoxServer;

/**
* EmailBoxServer/Email_Box_ServerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from br/com/emailmanager/corba/EmailBoxServer.idl
* Quarta-feira, 26 de Novembro de 2014 10h30min08s BRST
*/

public final class Email_Box_ServerHolder implements org.omg.CORBA.portable.Streamable
{
  public EmailBoxServer.Email_Box_Server value = null;

  public Email_Box_ServerHolder ()
  {
  }

  public Email_Box_ServerHolder (EmailBoxServer.Email_Box_Server initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = EmailBoxServer.Email_Box_ServerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    EmailBoxServer.Email_Box_ServerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return EmailBoxServer.Email_Box_ServerHelper.type ();
  }

}
