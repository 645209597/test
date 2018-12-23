package ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

import org.junit.Test;

public class TestPhantomRef {

	ReferenceQueue<MyObject> phantomQueue=null;
	
	public class CheckRefQueue extends Thread{
		
		@Override
		public void run(){
			while(true){
				if(phantomQueue!=null){
						Reference<MyObject> obj;
						try {
							obj = (Reference<MyObject>) phantomQueue.remove();
							System.out.println("Object for PhantomReference is "+obj.get());
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		}
	}
	
	@Test
	public void test() throws InterruptedException {
		Object counter = new Object(); // 只有Object类型的对象在第一次gc后才会加入引用队列中
		ReferenceQueue refQueue = new ReferenceQueue<>();
		PhantomReference<Object> p = new PhantomReference<>(counter, refQueue);
		counter = null;
		System.gc();
		try {
		    // Remove 是一个阻塞方法，可以指定 timeout，或者选择一直阻塞
		    Reference<Object> ref = refQueue.poll();
		    if (ref != null) {
		        System.out.println("refQueue.remove");
		    }
		} catch (Exception e) {
		}
		
		MyObject obj=new MyObject();
		phantomQueue = new ReferenceQueue<MyObject>();  
		PhantomReference<MyObject> phantomRef=new PhantomReference<MyObject>(obj,phantomQueue);
		System.out.println("Phantom Get: " + phantomRef.get());
		new CheckRefQueue().start();
		//存在软引用
		//SoftReference<MyObject> softRef=new SoftReference<MyObject>(obj);
		//去除强引用
		obj=null;
		Thread.sleep(1000);
		int i=1;
		while(true){
			System.out.println("第"+i+++"次gc");
			System.gc();
			Thread.sleep(1000);
		}
	}

}
