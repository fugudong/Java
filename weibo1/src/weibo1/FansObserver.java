package weibo1;

import java.util.Observable;
import java.util.Observer;

public class FansObserver implements Observer{

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(arg instanceof Integer)
		{
			System.out.println("������ " + arg + "����˿");
		}
	}
	
}
