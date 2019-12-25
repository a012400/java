package java_collections.collections_tools_class;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UnmodifiableTest {

	public static void main(String[] args) {
		// 创建一个空的、不可改变的List对象
		List unmodifiableList = Collections.emptyList();
		// 创建一个只有一个元素，且不可改变的Set对象
		Set unmodifiableSet = Collections.singleton("疯狂Java讲义");
		// 创建一个普通的Map对象
		Map scores = new HashMap();
		scores.put("语文", 80);
		scores.put("Java", 82);
		// 返回普通的Map对象对应的不可变版本
		Map unmodifiableMap = Collections.unmodifiableMap(scores);
		// 下面任意一行都将引发UnsupportedOperationException异常
		unmodifiableList.add("测试元素");
		unmodifiableSet.add("测试元素");
		unmodifiableMap.put("语文", 90);
	}

}
