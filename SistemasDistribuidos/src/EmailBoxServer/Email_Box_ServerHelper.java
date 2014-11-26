package EmailBoxServer;

/**
 * EmailBoxServer/Email_Box_ServerHelper.java . Generated by the IDL-to-Java
 * compiler (portable), version "3.2" from
 * br/com/emailmanager/corba/EmailBoxServer.idl Quarta-feira, 26 de Novembro de
 * 2014 10h30min08s BRST
 */

abstract public class Email_Box_ServerHelper {
	private static String _id = "IDL:EmailBoxServer/Email_Box_Server:1.0";

	public static void insert(org.omg.CORBA.Any a,
			EmailBoxServer.Email_Box_Server that) {
		org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
		a.type(type());
		write(out, that);
		a.read_value(out.create_input_stream(), type());
	}

	public static EmailBoxServer.Email_Box_Server extract(org.omg.CORBA.Any a) {
		return read(a.create_input_stream());
	}

	private static org.omg.CORBA.TypeCode __typeCode = null;

	synchronized public static org.omg.CORBA.TypeCode type() {
		if (__typeCode == null) {
			__typeCode = org.omg.CORBA.ORB.init().create_interface_tc(
					EmailBoxServer.Email_Box_ServerHelper.id(),
					"Email_Box_Server");
		}
		return __typeCode;
	}

	public static String id() {
		return _id;
	}

	public static EmailBoxServer.Email_Box_Server read(
			org.omg.CORBA.portable.InputStream istream) {
		return narrow(istream.read_Object(_Email_Box_ServerStub.class));
	}

	public static void write(org.omg.CORBA.portable.OutputStream ostream,
			EmailBoxServer.Email_Box_Server value) {
		ostream.write_Object((org.omg.CORBA.Object) value);
	}

	public static EmailBoxServer.Email_Box_Server narrow(
			org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		else if (obj instanceof EmailBoxServer.Email_Box_Server)
			return (EmailBoxServer.Email_Box_Server) obj;
		else if (!obj._is_a(id()))
			throw new org.omg.CORBA.BAD_PARAM();
		else {
			org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)
					._get_delegate();
			EmailBoxServer._Email_Box_ServerStub stub = new EmailBoxServer._Email_Box_ServerStub();
			stub._set_delegate(delegate);
			return stub;
		}
	}

	public static EmailBoxServer.Email_Box_Server unchecked_narrow(
			org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		else if (obj instanceof EmailBoxServer.Email_Box_Server)
			return (EmailBoxServer.Email_Box_Server) obj;
		else {
			org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)
					._get_delegate();
			EmailBoxServer._Email_Box_ServerStub stub = new EmailBoxServer._Email_Box_ServerStub();
			stub._set_delegate(delegate);
			return stub;
		}
	}

}
