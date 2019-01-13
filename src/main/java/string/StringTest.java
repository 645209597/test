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
		
		char c = 65535; // �����ֽڣ�16λ�����ɴ渺��
		byte b = 127; // һ���ֽڣ�8λ���ɴ渺��
		
		String s5 = new String("12") + new String("34");
		s5.intern(); // jdk7��jdk8�Ĵ���ʽ��ͬ���ַ��������طֱ��ڷ�������PermGen Space�����ô����Ͷ��У�
		             // ���ô���JDK8 �б� MetaSpace��Ԫ�������������
		String s6 = "1234";
		System.out.println(s5 == s6); // true
				
		System.out.println((3 << 1) + 2); // AbstractStringBuilder.newCapacity
		System.out.println(Integer.MAX_VALUE);
		char[] cs = new char[Integer.MAX_VALUE + 1];
	}

}
