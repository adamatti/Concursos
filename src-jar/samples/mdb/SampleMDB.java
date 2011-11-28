package samples.mdb;

import java.sql.Connection;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDrivenContext;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.sql.DataSource;
@MessageDriven(
	mappedName="samples/queue"
/*
	,activationConfig={
		@ActivationConfigProperty(
			propertyName="destinationType", 
			propertyValue="javax.jms.Queue"),
        @ActivationConfigProperty(
        	propertyName="destination", 
        	propertyValue="samples/queue")
	}
*/
)
@Interceptors
({samples.interceptor.SampleInterceptor.class})
public class SampleMDB implements MessageListener {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	@Resource(mappedName="samples/hsqldb")
	private DataSource dataSource;
	@Resource
	private MessageDrivenContext context;
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void onMessage(Message arg0) {
		logger.info("Msg received");	
	}
	@PostConstruct
	public void postConstruct()	{
		logger.info("POST CONSTRUCT");
	}
	@PreDestroy
	public void preDestroy(){
		logger.info("PRE DESTROY");
	}
/*
	@PostActivate
	public void postActivate(){
		logger.info("POST ACTIVATE");
	}
	@PrePassivate
	public void prePassivate(){
		logger.info("PRE PASSIVATE");
	}
*/
}
