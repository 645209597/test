package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandlerTest {

	public static void main(String[] args) {
		ReadFile boss = new Boss();
		 
        InvocationHandler handler = new Secretary(boss);
 
        ReadFile secretary = (ReadFile) Proxy.newProxyInstance(
                boss.getClass().getClassLoader(),
                boss.getClass().getInterfaces(),
                handler);
        
        secretary.read();
	}

}

interface ReadFile {
    public void read();
}

class Boss implements ReadFile {
	 
    @Override
    public void read() {
        System.out.println("Boss reading files.");
    }
 
}

class Secretary implements InvocationHandler {
	 
    private Object object;
    
    public Secretary(Object object) {
        this.object = object;
    }
 
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(object, args);
        System.out.println("Secretary reading files.");
        return result;
    }
 
}