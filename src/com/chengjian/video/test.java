package com.chengjian.video;

import java.io.File;
import java.io.IOException;

public class test {

	public static void main(String[] args) {
		try {
			Process process = Runtime.getRuntime().exec("cmd /c ping baidddu.com");
			process.waitFor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(check("c:\\jpg\\*.jpg"));
		
		
	}
	
	public static boolean check(String outVideo) {
		 
		File file = new File(outVideo);
		if (file.exists())
			return true;
		return false;

}

}
