package logic.dao;


import java.lang.reflect.InvocationTargetException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOFactory {
	
	String type1 = "Serialize";
//	Singleton Factory
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	private static DAOFactory ref = null;
	private DAOFactory() {}
	
	public static DAOFactory getReference() {
		
		if (ref == null) {
			ref = new DAOFactory();
		}
		return ref;
	}
	
	private String readDBType() {
		
		
		return type1;
	}
	
	public Object getDAOReference(DAOSupportedEntities entity) {
		
//		@ return : reference to DAOUSer object
		
		try {
			return Class.forName(this.getClass().getPackage().getName() + "." + "DAO" + entity.getEntityName() + this.readDBType()).getMethod("getReference", (Class<?>[]) null).invoke((Object) null, (Object[])null);
		} 
		catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException | ClassNotFoundException e) {
			
			logger.log(Level.SEVERE, e.toString());
			return null;
		}
	}
}