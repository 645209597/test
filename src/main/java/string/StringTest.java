package string;

public class StringTest {

	public static void main(String[] args) {
		String s0 = "abc";
		String s1 = "abc";
		String s2 = new String("abc");
		String s3 = s2.intern();
		String s4 = "a" + "b" + "c";
		String s7 = "a" + "b" + "c" + "d";
		String s8 = "abcd";
		System.out.println(s0 == s1);
		System.out.println(s0 == s2); // false
		System.out.println(s0 == s3);
		System.out.println(s0 == s4);
		System.out.println(s7 == s8); // true
		
		char c = 65535; // 两个字节，16位，不可存负数
		byte b = 127; // 一个字节，8位，可存负数
		
		String s5 = new String("12") + new String("34");
		s5.intern(); // jdk7和jdk8的处理方式不同，字符串常量池分别在方法区的PermGen Space（永久代）和堆中）
		             // 永久代在JDK8 中被 MetaSpace（元数据区）替代了
		String s6 = "1234";
		System.out.println(s5 == s6); // true
				
		System.out.println((3 << 1) + 2); // AbstractStringBuilder.newCapacity
		System.out.println(Integer.MAX_VALUE);
		char[] cs = new char[Integer.MAX_VALUE + 1];
	}

}
