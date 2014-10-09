package com.chengjian.video;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DownloadPic{
    public static void main(String args[]){
       
       for(int i = 0;i< 4;i++){
        
        	System.out.println(download("http://i2.dpfile.com/2006-03-15/26040_b.jpg",i));
       } 
    }
    
    
    
    
    
    
    
    public static String download(String strUrl){
    	 
    	 String  name = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//    	 String outPath="C:/jpg/";
    	 Random random = new Random(100);
//    	 outPath=outPath+random.nextInt()*random.nextInt()+"/";
         String path = "C:/jpg/"+random.nextInt()*random.nextInt()+"/";
         File dir = new File(path);
         if(!dir.exists())
              dir.mkdir();
    	 path += name + ".jpg";
       
       URL url = null;
       try {
              url = new URL(strUrl);
       } catch (MalformedURLException e2) {
             e2.printStackTrace();
             return null;
       }

       InputStream is = null;
        try {
            is = url.openStream();
        } catch (IOException e1) {
            e1.printStackTrace();
            return null;
        }

        OutputStream os = null;
        try{
            os = new FileOutputStream(path);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while((bytesRead = is.read(buffer,0,8192))!=-1){
            os.write(buffer,0,bytesRead);
       }
       }catch(FileNotFoundException e){
           e.printStackTrace();
           return null;
       } catch (IOException e) {
           e.printStackTrace();
           return null;
      }
        return path;
    }
    
    
    
    public static String download(String strUrl,int name){
   	 
   	  
        String path = "C:/jpg/";
        File dir = new File(path);
        if(!dir.exists())
             dir.mkdir();
   	 path += name+1 + ".jpg";
      
      URL url = null;
      try {
             url = new URL(strUrl);
      } catch (MalformedURLException e2) {
            e2.printStackTrace();
            return null;
      }

      InputStream is = null;
       try {
           is = url.openStream();
       } catch (IOException e1) {
           e1.printStackTrace();
           return null;
       }

       OutputStream os = null;
       try{
           os = new FileOutputStream(path);
           int bytesRead = 0;
           byte[] buffer = new byte[8192];
           while((bytesRead = is.read(buffer,0,8192))!=-1){
           os.write(buffer,0,bytesRead);
      }
      }catch(FileNotFoundException e){
          e.printStackTrace();
          return null;
      } catch (IOException e) {
          e.printStackTrace();
          return null;
     }
       return path;
   }
}