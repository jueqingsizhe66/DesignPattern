package com.image;

import java.io.File;
import java.io.FilenameFilter;

public class ImageFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		if (name != null && name.toLowerCase().endsWith(".tif")) {
			return true;
		} else if (name != null && name.toLowerCase().endsWith(".png")) {
			return true;
		} else if (name != null && name.toLowerCase().endsWith(".jpg")) {
			return true;
		} else {
			return false;
		}
	}
}
