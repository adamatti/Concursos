package samples.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class SampleInterceptor {
	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception{
		System.out.println("*** BEFORE INTERCEPTION ***");
		Object object = ctx.proceed();
		System.out.println("*** AFTER INTERCEPTION ***");
		return object;
	}
}
