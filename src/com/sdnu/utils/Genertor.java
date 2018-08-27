package com.sdnu.utils;

import java.io.File;

public class Genertor {
	public static String genClildDir(String root,String filename){
		int hashCode = filename.hashCode();
		int dir1 = hashCode&0xf;
		int dir2 = (hashCode&0xf0)>>4;
		String dir = dir1+File.separator+dir2;
		File f = new File(root,dir);
		if(!f.exists())
			f.mkdirs();
		return dir;
	}
}
