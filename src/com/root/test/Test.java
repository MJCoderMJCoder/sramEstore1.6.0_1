package com.root.test;

import java.util.List;

import com.root.factory.Factory;
import com.root.pojo.Form;
import com.root.pojo.User;


public class Test {
	public static void main(String[] args) {
		boolean flag = Factory.getFormService().deleteForm("030024");
		System.out.println(flag);
	}
}
