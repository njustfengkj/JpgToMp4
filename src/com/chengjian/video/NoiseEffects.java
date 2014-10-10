package com.chengjian.video;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class NoiseEffects {

//	public String outVideo;
//	public static double seconds;
//
//	// 噪音效果
//	public void NoiseEffect(String picUrl, double seconds, String outVideo) {
//		this.outVideo = outVideo;
//		this.seconds = seconds;
//		try {
//			ThreadA threadA = new ThreadA(picUrl);
//			ThreadB threadB = new ThreadB(outVideo);
//			ThreadC threadC = new ThreadC();
//
//			threadA.start();
//			while (!check(1)) {
//				System.out.println("等待ts生成完毕");
//			}
//			threadB.start();
//			while (!check(2)) {
//				System.out.println("等待outvideo生成完毕");
//			}
//			threadC.start();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//
//	public boolean check(int type) {
//		switch (type) {
//		 
//		case 1:
//			for (int i = 0; i <= 8; i++) {
//				File file = new File("c:\\" + i + ".ts");
//				if (!file.exists())
//					return false;
//				continue;
//			}
//			return true;
//		case 2:
//			File file = new File(outVideo);
//			if (file.exists())
//				return true;
//			return false;
//
//		}
//		return false;
//
//	}
//
//	// classA:生成Mp4视频
//	// classB生成ts流
//	// classC合并成mp4视频
//	// classD删除mp4和ts视频
//	static class ThreadA extends Thread {
//		String picUrl;
//
//		public ThreadA(String picUrl) {
//			this.picUrl = picUrl;
//		}
//
//		@Override
//		public void run() {
//			try {
//
//				for (int i = 0; i <= 9; i++) {
//
//					String command = "ffmpeg -i " + picUrl + " -vf noise="
//							+ (100 - i * 10) + ":" + (i * 10) + " -y -r "+ 2.5/seconds +" c:\\"
//							+ i + ".ts";
//
//					Runtime.getRuntime().exec("cmd /c start " + command);
//
//				}
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}
//	}
//
//	// 合并
//	static class ThreadB extends Thread {
//		String outVideo;
//
//		public ThreadB(String outVideo) {
//			this.outVideo = outVideo;
//		}
//
//		@Override
//		public void run() {
//			try {
//
//				String command = "ffmpeg -i \"concat:";
//				for (int j = 0; j < 9; j++) {
//					command = command + "c:\\" + j + ".ts|";
//				}
//				command = command + "c:\\9.ts\" " + outVideo;
//				Runtime.getRuntime().exec("cmd /c start " + command);
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}
//	}
//
//	// 刪除
//	static class ThreadC extends Thread {
//
//		@Override
//		public void run() {
//			try {
//
//				for (int j = 0; j <= 9; j++) {
//
//					Runtime.getRuntime().exec("cmd /c del c:\\" + j + ".ts");
//
//				}
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}
//	}
}
