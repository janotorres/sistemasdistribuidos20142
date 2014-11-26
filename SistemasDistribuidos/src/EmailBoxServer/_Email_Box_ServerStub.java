package EmailBoxServer;


/**
* EmailBoxServer/_Email_Box_ServerStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from br/com/emailmanager/corba/EmailBoxServer.idl
* Quarta-feira, 26 de Novembro de 2014 10h30min08s BRST
*/

public class _Email_Box_ServerStub extends org.omg.CORBA.portable.ObjectImpl implements EmailBoxServer.Email_Box_Server
{

  public void saveEmail (int userId, String toEmail, String messageEmail)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("saveEmail", true);
                $out.write_long (userId);
                $out.write_string (toEmail);
                $out.write_string (messageEmail);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                saveEmail (userId, toEmail, messageEmail        );
            } finally {
                _releaseReply ($in);
            }
  } // saveEmail

  public EmailBoxServer.Email[] getEmails (int userId, String date)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getEmails", true);
                $out.write_long (userId);
                $out.write_string (date);
                $in = _invoke ($out);
                EmailBoxServer.Email $result[] = EmailBoxServer.EmailsHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getEmails (userId, date        );
            } finally {
                _releaseReply ($in);
            }
  } // getEmails

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:EmailBoxServer/Email_Box_Server:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _Email_Box_ServerStub
