package com.anxxp.composite;

import java.util.Iterator;
import java.util.List;

public interface Component {
	void addFile(Component file);
	
	void removeFile(Component file);
	
	void removeFolder(Component folder);
	
	void display();
	
	Component addFolder(Component folder);
	
	List<Component> getFiles();
	
	List<Component> getFolders();
	
	Iterator<Component> iterator();
	
	
}
