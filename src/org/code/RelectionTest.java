package org.code;

import java.lang.reflect.Field;

public class RelectionTest {

	public static void main(String[] args) {
		TreeNode root = new TreeNode (1);
		Field[] fields = root.getClass().getFields();
		for(Field field : fields) {
			System.out.println(field.getName() + " " + field.getType().getTypeName());
		}
	}

}
