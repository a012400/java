package generic.threshold;

import java.util.ArrayList;
import java.util.List;

public class GenericList {

	public static void main(String[] args) {
		// 创建一个只想保存字符串的List集合
		List<String> strList = new ArrayList<String>();
		strList.add("疯狂Java讲义");
		strList.add("疯狂Android讲义");
		// 下面代码引发编译错误
		// strList.add(5);
		strList.forEach(str -> System.out.println(str.length()));
	}

}
