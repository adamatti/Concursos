package samples;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * http://localhost:8080/Concursos/SampleWS/SampleWS?wsdl
 * http://ubuntu-vm:8080/SampleWS/SampleWS?WSDL
 * @author Marcelo Adamatti
 *
 */
@Stateless
@WebService(name="SampleWS",targetNamespace="http://SampleWS",serviceName="SampleWS")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class SampleWS {
	@WebMethod
	@WebResult(name = "sayHelloResult", partName = "sayHelloResult")
	public String sayHello(String to){
		return "Hello " + to;
	}
}
