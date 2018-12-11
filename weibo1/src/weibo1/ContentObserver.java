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
					System.out.println("通知观察者 " + name + "，删除一条微博，ID为：" + Integer.parseInt(content.trim()));
					
				}
				else
				{
					System.out.println("通知观察者 " + name + "，增加一条微博，内容为：" + content);
				}
			}
	}

}
