package logic.publishanad;

import logic.dao.DAOFactory;
import logic.dao.DAOSupportedEntities;
import logic.entity.Ad;
import logic.entity.AdFactory;
import logic.entity.Ads;
import logic.entity.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import logic.beans.PublishAnAdBean;
import logic.dao.DAOAd;

public class PublishAnAdController {
	
	private static PublishAnAdController instance;
	
	public static PublishAnAdController getInstance() {
		if(instance == null)
			instance = new PublishAnAdController();
		return instance;
	}
	
	private PublishAnAdController() {
	}
	
	public int createAd(PublishAnAdBean publishAdBean) throws IllegalAccessException, InvocationTargetException {
		
		Ad ad = null;
		for (Ads t : Ads.values()) {
			if (t.getName().compareTo(publishAdBean.getType()) == 0) {
				ad = AdFactory.getReference().typePost(t);
				break;
			}
		}
		
		Method[] methodsBean = publishAdBean.getClass().getMethods();
		Method[] methodsEntity = ad.getClass().getMethods();
		
		for(int i = 0; i < methodsBean.length; i++) {
			if(methodsBean[i].getName().contains("get")) {
				for(int j = 0; j < methodsEntity.length; j++) {
					if(methodsEntity[j].getName().contains("set" + methodsBean[i].getName().substring(3, 4).toUpperCase() + methodsBean[i].getName().substring(4))
							&& !(methodsEntity[j].isSynthetic() || methodsBean[i].isSynthetic())) {
						Object value = methodsBean[i].invoke(publishAdBean, (Object[]) null);
						methodsEntity[j].invoke(ad, value);
					}
				}
			}
		}
		
		Data data = new Data();
		ad.setData(data.buildDate());	
		
		DAOAd dao = (DAOAd) DAOFactory.getReference().getDAOReference(DAOSupportedEntities.AD);
		return dao.storeNewAd(ad);
	}
}

