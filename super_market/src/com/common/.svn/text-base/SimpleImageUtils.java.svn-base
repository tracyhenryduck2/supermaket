package com.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.alibaba.simpleimage.ImageFormat;
import com.alibaba.simpleimage.ImageRender;
import com.alibaba.simpleimage.SimpleImageException;
import com.alibaba.simpleimage.render.ScaleParameter;
import com.alibaba.simpleimage.render.ScaleRender;
import com.alibaba.simpleimage.render.WriteRender;

import org.apache.commons.io.IOUtils;


public class SimpleImageUtils {

	public static void resizeImage(String srcPath, String destPath, int height, int width) {
		InputStream input = null;
		ImageRender sr = null;
		try {
			ScaleParameter param = new ScaleParameter(height, width);
			input = new FileInputStream(srcPath);
			sr = new ScaleRender(input, param);
			write(sr,destPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (sr != null) {
				try {
					sr.dispose();
				} catch (SimpleImageException e) {
					e.printStackTrace();
				}
			}
			IOUtils.closeQuietly(input);
		}
	}
 
	private static void write(ImageRender sr, String destPath) {
		OutputStream output = null;
		ImageRender wr = null;
		try {
			output = new FileOutputStream(new File(destPath));
			wr = new WriteRender(sr, output, ImageFormat.JPEG);
			wr.render();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (wr != null) {
				try {
					wr.dispose();
				} catch (SimpleImageException e) {
					e.printStackTrace();
				}
			}
			IOUtils.closeQuietly(output);
		}
	}

	public static void main(String[] args) {
		SimpleImageUtils.resizeImage("c:/1435246662995939191.gif", "c:/1435246662995939191_200.jpg", 270, 160);
		//ImageRender rr = new ImageRender();
//		SimpleImageUtils si = new SimpleImageUtils();
//		try {
//			si.testScaleRenderInputStreamScaleParameter();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
