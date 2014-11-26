package br.com.emailmanager.corba;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import EmailBoxServer.Email_Box_Server;
import EmailBoxServer.Email_Box_ServerHelper;

public class EmailBox {

	public static void main(String[] args) {
		 try{
		    
		      ORB orb = ORB.init(args, null);
		  
		      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		      rootpoa.the_POAManager().activate();

		    
		      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(new EmailBoxPOA());
		      Email_Box_Server href = Email_Box_ServerHelper.narrow(ref);
			 
		      org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

		      String name = "Email_Box_Server";
		      NameComponent path[] = ncRef.to_name( name );
		      ncRef.rebind(path, href);

		      System.out.println("Servidor aguardando requisicoes ....");
		     
		      orb.run();
		    } catch (Exception e) {
		        System.err.println("ERRO: " + e);
		        e.printStackTrace(System.out);
		    }
		    System.out.println("Encerrando o Servidor.");

	}	

}
