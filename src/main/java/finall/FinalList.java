package finall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinalList {

	public static void main(String[] args) {
		 final List<String> strList = new ArrayList<>();
		 strList.add("Hello");
		 strList.add("world");  
		 List<String> unmodifiableStrList = Arrays.asList("hello", "world");
		 unmodifiableStrList.add("again");
	}

}
