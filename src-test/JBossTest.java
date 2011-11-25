import static org.junit.Assert.*;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class JBossTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testJDBC() throws Throwable {
		try {
			Hashtable<String, String> prop = new Hashtable<String,String>();
			prop.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			prop.put(Context.PROVIDER_URL,"jnp://localhost:1099");
			prop.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interface");
			Context ctx = new InitialContext(prop);
		} catch (Throwable t){
			t.printStackTrace();
			throw t;
		}
	}

}
