package weibo1;

import java.util.Observable;
import java.util.Observer;

public class ContentObserver implements Observer{
	
	private String content;
	private String name;
	
	public ContentObserver(String name){
        this.name = name;
    }

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
			if(arg instanceof String)
			{
				content = (String) arg;
				if(content.charAt(0)==' ')
				{
					System.out.println("֪ͨ�۲��� " + name + "��ɾ��һ��΢����IDΪ��" + Integer.parseInt(content.trim()));
					
				}
				else
				{
					System.out.println("֪ͨ�۲��� " + name + "������һ��΢��������Ϊ��" + content);
				}
			}
	}

}
