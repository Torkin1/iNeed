package logic.contactuser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.beans.ContactInfo;
import logic.beans.ReadMessagesBean;
import logic.beans.WriteMessageBean;
import logic.beans.RetrieveContactInfoBean;
import logic.dao.DAOFactory;
import logic.dao.DAOMessage;
import logic.dao.DAOSupportedEntities;
import logic.dao.DAOUser;
import logic.dao.MessageNotFoundException;
import logic.dao.UserNotFoundException;
import logic.entity.Data;
import logic.entity.Message;
import logic.entity.User;

public class ContactUserController{
	
	Logger logger = Logger.getLogger(this.getClass().getName());
	private static ContactUserController instance = null;
	
	public static ContactUserController getInstance() {
		if(instance == null)
			instance = new ContactUserController();
		return instance;
	}
	
	private ContactUserController() {		
	}
	
	public void retrieveContactUserInfo(RetrieveContactInfoBean bean) {
		try {
			DAOUser daoUser = (DAOUser) DAOFactory.getReference().getDAOReference(DAOSupportedEntities.USER);
			User userToContact = new User();
			daoUser.loadUser(userToContact, bean.getUsername());
			bean.putInfo(ContactInfo.MAIL, userToContact.getEmail());
		} catch (UserNotFoundException e) {
			logger.log(Level.SEVERE, e.toString());
		}
	}
	
	public void writeMessage(WriteMessageBean contactBean) throws IllegalAccessException, InvocationTargetException {
		
		Message message = new Message();
		Data data = new Data();
		
		message.setData(data.buildDateAndHour().getTime());
		
		Method[] methodsBean = contactBean.getClass().getMethods();
		Method[] methodsEntity = message.getClass().getMethods();
		
		for(int i = 0; i < methodsBean.length; i++) {
			if(methodsBean[i].getName().contains("get")) {
				for(int j = 0; j < methodsEntity.length; j++) {
					if(methodsEntity[j].getName().contains("set" + methodsBean[i].getName().substring(3, 4).toUpperCase() + methodsBean[i].getName().substring(4))) {
						Object value = methodsBean[i].invoke(contactBean, (Object[]) null);
						methodsEntity[j].invoke(message, value);
					}
				}
			}
		}
		
		DAOMessage dao = (DAOMessage) DAOFactory.getReference().getDAOReference(DAOSupportedEntities.MESSAGE);
		dao.storeMessage(message);
	}
	
	public void readMessages(ReadMessagesBean contactBean) throws IllegalAccessException, InvocationTargetException {
		
		DAOMessage dao = (DAOMessage) DAOFactory.getReference().getDAOReference(DAOSupportedEntities.MESSAGE);
		List<Message> messagesList = new ArrayList<>();
		
		try{
			dao.loadMessage(contactBean.getUserSenderUsername(), contactBean.getUserReceiverUsername(), messagesList);
		}
		catch(MessageNotFoundException e) {
			logger.log(Level.SEVERE, "Message not found");
		}
				
		Message[] messageArray = new Message[messagesList.size()];
		messagesList.toArray(messageArray);
		this.selectionSortMessage(messageArray);
		messagesList = Arrays.asList(messageArray);
		
		contactBean.setAllMessages(messagesList);
		
	}
	
	private void selectionSortMessage(Message[] obj) {
		for(int i = 0; i < obj.length-1; i++) {
	        int minimo = i;
	        for(int j = i+1; j < obj.length; j++) {
	            if(obj[minimo].getData().compareTo(obj[j].getData()) > 0) {
	                minimo = j;
	            }
	        }
	        if(minimo!=i) { 
	            Message buffer = obj[minimo];
	            obj[minimo] = obj[i];
	            obj[i] = buffer;
	        }
		}
	}
}