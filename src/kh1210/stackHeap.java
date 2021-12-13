package kh1210;
import java.util.List;
import java.util.ArrayList;

public class stackHeap {

	public static void main(String[] args) {
		int age = 32;
		String name = "Yu";
		List<String> skills = new ArrayList<>();
		skills.add("java");
		skills.add("js");
		skills.add("c++");

		test(skills);

		for (String s : skills) {
			System.out.println(s);

		}

	}

	public static void test(List<String> list) {
		String mySkill = list.get(0);
		list.add("python");
	}
}
