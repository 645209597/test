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
		Object counter = new Object(); // ֻ��Object���͵Ķ����ڵ�һ��gc��Ż�������ö�����
		ReferenceQueue refQueue = new ReferenceQueue<>();
		PhantomReference<Object> p = new PhantomReference<>(counter, refQueue);
		counter = null;
		System.gc();
		try {
		    // Remove ��һ����������������ָ�� timeout������ѡ��һֱ����
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
		//����������
		//SoftReference<MyObject> softRef=new SoftReference<MyObject>(obj);
		//ȥ��ǿ����
		obj=null;
		Thread.sleep(1000);
		int i=1;
		while(true){
			System.out.println("��"+i+++"��gc");
			System.gc();
			Thread.sleep(1000);
		}
	}

}
