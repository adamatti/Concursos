import static org.junit.Assert.*;

import java.util.Hashtable;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

/**
 * gf-client.jar must be available in the classpath
 * http://stackoverflow.com/questions/5997504/eclipse-glassfish-3-client-error
 * @author Marcelo Adamatti
 *
 */
public class GlassFishTest {
	InitialContext ctx;
	public GlassFishTest() throws Exception{
		super();
		Hashtable<String,String> env = new Hashtable<String,String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        env.put(Context.URL_PKG_PREFIXES, "com.sun.enterprise.naming");
        env.put(Context.STATE_FACTORIES, "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

        env.put("org.omg.CORBA.ORBInitialHost", "localhost");
        env.put("org.omg.CORBA.ORBInitialPort", "3700");

		ctx = new InitialContext(env);
	}	
	@Test
	public void testJMS() throws Throwable {
		try{
			Queue queue = (Queue) ctx.lookup("samples/queue");
			QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("samples/JMSConnFactory");
			Connection conn = factory.createConnection();
			Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(queue);
			TextMessage txt = session.createTextMessage("Olá");			
			conn.start();			
			producer.send(txt);
			session.commit();
			producer.close();
			session.close();
			conn.close();
		} catch (Throwable t){
			t.printStackTrace();
			throw t;
		}
	}

}
