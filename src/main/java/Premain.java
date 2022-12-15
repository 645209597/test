//package agent;
//
//import java.lang.instrument.Instrumentation;
//import java.lang.instrument.UnmodifiableClassException;
//import java.net.URISyntaxException;
//
//public class Premain { 
//	
//    public static void premain(String agentArgs, Instrumentation inst) 
//    		throws ClassNotFoundException, UnmodifiableClassException { 
//        inst.addTransformer(new Transformer()); 
//        
//		try {
//			System.out.println(Premain.class.getResource("Premain.class").toURI().toString());
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
//        
//    } 
//    
//}
