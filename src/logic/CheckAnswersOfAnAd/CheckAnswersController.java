package logic.CheckAnswersOfAnAd;

public class CheckAnswersController implements CheckAnswersControllerInterface{
	
	private static CheckAnswersController instance;
	
	public static CheckAnswersController getInstance() {
		if(instance == null) {
			instance = new CheckAnswersController();
		}
		return instance;
	}
	
	private CheckAnswersController() {
	}
	
	public Answers AnswersList(){
		CheckAnswersBean bean = CheckAnswersBean.getInstance();
		int id = bean.getId();
		return AnswersDao.listOfAnswers(id);
	}
}