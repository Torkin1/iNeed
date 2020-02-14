package test.dao;

import org.junit.Assert;
import org.junit.Test;

import logic.dao.AdNotFoundException;
import logic.dao.DAOAd;
import logic.dao.DAOFactory;
import logic.entity.Ad;
import logic.entity.RequestAd;
import logic.entity.User;

public class TestDaoAd {
/*	
	@Test
	public void testStoreAndLoadAd() throws AdNotFoundException {
		
		Ad storedAd = new Ad();
		storedAd.setId(4);
		
		DAOAd daoAd = (DAOAd) DAOFactory.getReference("Ad").getDAOReference();
		
		daoAd.storeAd(storedAd);
		Ad loadedAd = new Ad();
		daoAd.loadAd(loadedAd, 4);
		
		Assert.assertEquals(storedAd.getId(), loadedAd.getId());
	}
*/
	@Test
	public void testStoreAndLoadAdUser() throws AdNotFoundException {
		
		
		User user = new User();
		user.setUsername("Pippo");
		user.setPassw("Pluto123");
		user.setEmail("cioa@gmaai.co");
		user.setCity("Roma");
		
		String title = "Cerco posto letto";
		String body = "Cerco qualcuno disponibile ad offrire un posto letto per il 17/02/2020";

		Ad storedAd = new RequestAd();
		storedAd.setOwnerUsername(user.getUsername());
		storedAd.setTitle(title);
		storedAd.setBody(body);
		storedAd.setId(100);
		
		DAOAd daoAd = (DAOAd) DAOFactory.getReference().getDAOReference("Ad");
		
		int storedId = daoAd.storeNewAd(storedAd);
		Ad loadedAd = new RequestAd();
		daoAd.loadAd(loadedAd, storedId);
		
		Assert.assertEquals(storedAd.getOwnerUsername(), loadedAd.getOwnerUsername());
	}
}
