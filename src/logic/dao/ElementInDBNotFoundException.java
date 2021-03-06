package logic.dao;

import java.io.FileNotFoundException;

public class ElementInDBNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6963788673942381902L;
	private final String path;
	
	public ElementInDBNotFoundException(String path, FileNotFoundException cause) {
		super("file " + path + " not found", cause);
		this.path = path;
	}
	
	public String getPath() {
		return this.path;
	}

}
