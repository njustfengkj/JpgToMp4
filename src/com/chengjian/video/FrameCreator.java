package com.chengjian.video;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FrameCreator {
	public static BufferedImage images[];

	public static void CreateFrames(int mp4Size, int effects[],
			String picUrls_[]) {
		// String outputPath="";
		String jpgPath[] = new String[4];
		int length_ = picUrls_.length;
		// int picCount = 4;
		if (length_ == 1) {
			String temp = DownloadPic.download(picUrls_[0]);
			for (int i = 0; i < 4; i++) {
				jpgPath[i] = temp;
			}
		} else {
			for (int i = 0; i < 4; i++) {
				jpgPath[i] = DownloadPic.download(picUrls_[i]);
			}
		}
		// 把图片读入到内存中方面接下来的操作
		images = new BufferedImage[4];
		for (int i = 0; i < 4; i++) {
			try {
				File imgFile = new File(jpgPath[i]);
				images[i] = ImageIO.read(imgFile);
			} catch (IOException e) {
				System.out.println("image missing");
			}
		}
		// 根据效果序列进行帧生成
		if (mp4Size == 0)// 如果是要求时长6秒钟
		{
			// 先生成静态帧
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 9; k++) {
					// inputbig, "jpg", new
					// File("C:/imageSort/targetPIC/"+name));
					try {
						ImageIO.write(
								images[j],
								"jpg",
								new File(jpgPath[j].substring(0,
										jpgPath[j].lastIndexOf("."))
										+ "_" + k + ".jpg"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			for (int j = 0; j < 3; j++)// 根据效果序列生成变换帧			{
				switch (effects[j]) {
				case 0:// 旋转效果
					for (int k = 0; k < 12; k++) {
						// ImageIO.write(images[j],"jpg",new
						// File(jpgPath[j].substring(0,jpgPath[j].lastIndexOf("."))+"_"+k+".jpg"));
						try {
							int temp=9+21*j+k;
							ImageIO.write(
									RotateEffects.rotateImage(images[j], 30*(k+1)),
									"jpg",
									new File(jpgPath[j].substring(0,
											jpgPath[j].lastIndexOf("."))
											+ "_" + temp + ".jpg"));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					break;
				case 1://縮放效果
					for (int k = 0; k < 12; k++) {
						// ImageIO.write(images[j],"jpg",new
						// File(jpgPath[j].substring(0,jpgPath[j].lastIndexOf("."))+"_"+k+".jpg"));
						try {
							int temp=9+21*j+k;
							ImageIO.write(
									ScaleEffects.resizeImage(images[j], (int)(images[j].getWidth()*(0.917f-0.083f*k)),(int)(images[j].getHeight()*(0.917f-0.083f*k))),
									"jpg",
									new File(jpgPath[j].substring(0,
											jpgPath[j].lastIndexOf("."))
											+ "_" + temp + ".jpg"));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					break;

				default:
					break;
				}
			}

		} 
		else// 如果要求时长是9秒钟
		{
			for (int j = 0; j < 4; j++)// 生成静态帧
			{
				for (int k = 0; k < 9; k++) {
					// inputbig, "jpg", new
					// File("C:/imageSort/targetPIC/"+name));
					try {
						ImageIO.write(
								images[j],
								"jpg",
								new File(jpgPath[j].substring(0,
										jpgPath[j].lastIndexOf("."))
										+ "_" + k + ".jpg"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}

		// return outputPath;
	}

}
