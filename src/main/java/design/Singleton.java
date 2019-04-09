package design;

public class Singleton {
	
	private Singleton() {}

	// 版本一
	private static volatile Singleton singleton = null;
		
	public static Singleton getSingleton() {
		if (singleton == null) { // 尽量避免重复进入同步块
			synchronized (Singleton.class) { // 同步.class，意味着对同步类方法调用
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
	
	// 版本二
	public static Singleton getSingleton2() {
		return Holder.singleton;
	}

	private static class Holder {
		private static Singleton singleton = new Singleton();
	}
	
}

