package com.chengjian.video;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import org.jim2mov.core.DefaultMovieInfoProvider;
import org.jim2mov.core.ImageProvider;
import org.jim2mov.core.Jim2Mov;
import org.jim2mov.core.MovieInfoProvider;
import org.jim2mov.utils.MovieUtils;

public class JpgToAvi {

	/**
	 * @param args
	 */

	public static void main(String[] args) throws Exception {
		// jpgs目录放置jpg图片,图片文件名为(1.jpg,2.jpg...)
		final File[] jpgs = new File("C:\\pic\\").listFiles();

//		// 对文件名进行排序(本示例假定文件名中的数字越小,生成视频的帧数越靠前)
//		Arrays.sort(jpgs, new Comparator<File>() {
//			public int compare(File file1, File file2) {
//				String numberName1 = file1.getName().replace(".jpg", "");
//				String numberName2 = file2.getName().replace(".jpg", "");
//				return new Integer(numberName1) - new Integer(numberName2);
//			}
//		});

		DefaultMovieInfoProvider dmip = new DefaultMovieInfoProvider("Newdst.mp4");
		dmip.setFPS(0.5f); // 设置每秒帧数
		dmip.setNumberOfFrames(jpgs.length); // 总帧数
		dmip.setMWidth(1440);
		dmip.setMHeight(860);

		new Jim2Mov(new ImageProvider() {
			public byte[] getImage(int frame) {
				try {
					// 设置压缩比
					return MovieUtils.convertImageToJPEG((jpgs[frame]), 1.0f);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
		}, dmip, null).saveMovie(MovieInfoProvider.TYPE_AVI_MJPEG);
	}
}
