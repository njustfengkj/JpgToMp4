package com.chengjian.video;

import java.io.File;
import java.io.IOException;

public class NoneEffects {
	/**
	 * 
	 * @param PicUrls
	 * 传入图片地址数组
	 * @param time
	 * type = 0 为6秒 ；type = 1 为 9秒
	 */
public void noneEffects(String[] picUrls_ ,String musicPath,String outVideo,int time){
	//当传入地址为一个时，需要将后面三个填充为第一个
	 String picUrls[] = new String[4];
	 int length_ = picUrls_.length;
	 int length = 4;
	 if(length_ == 1){
		 String temp = DownloadPic.download(picUrls_[0],1);
		 for(int i = 0; i < 4; i++){
			 picUrls[i] = temp;
		 }
	 }else{
		 for(int i = 0; i < 4; i++){
			 //picUrls保存下载好的图片的本地路径
			 picUrls[i] = DownloadPic.download(picUrls_[i],i);
		 }
	 }
	 
	 
	 //一次性合成
	 
	 double t = 0;
	 if(time == 0)
		  t = 0.5;
	 else
		 t = 0.33;
String command = "ffmpeg -i c:/jpg/%d.jpg -i "+ musicPath +" -r " + t + " " + outVideo;
try {
	Runtime.getRuntime().exec("cmd /c start " + command);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
while(!check(outVideo)){
	System.out.println("等待合成");
}
try {
	Runtime.getRuntime().exec("cmd /c rd /q/s c:\\jpg");
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

public static boolean check(String outVideo) {
	 
	File file = new File(outVideo);
	if (file.exists())
		return true;
	return false;

}
}
