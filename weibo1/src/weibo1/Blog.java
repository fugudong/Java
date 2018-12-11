package weibo1;

import java.util.Observable;
import java.util.Observer;

public class Blog extends Observable{
	
	private int id;
	
	private String title;
	
	private String content;
	
	private int logger;
	
	private String date;
	
	private int counter;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLogger() {
		return logger;
	}

	public void setLogger(int logger) {
		this.logger = logger;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public void addContent(String title,String content,int logger) {
		this.content = content;
		Operate op = new Operate();
		op.addBlog(title,content,logger);
		setChanged();
		notifyObservers(content);
	}
	
	
	public void read(int id)
	{
		Operate op = new Operate();
		int counter = op.CounterByID(id);
        System.out.println("get counter"+counter);
		counter++;
		op.UpdateCounter(id, counter);
		setChanged();
		notifyObservers(counter);
	}
		
	public void delete(int id)
	{
		Operate op = new Operate();
		op.deleteBlog(id);
		setChanged();
		notifyObservers(" "+id);
	}

	@Override
	public synchronized void addObserver(Observer arg0) {
		// TODO Auto-generated method stub
		super.addObserver(arg0);
	}

	@Override
	public synchronized int countObservers() {
		// TODO Auto-generated method stub
		return super.countObservers();
	}

	@Override
	public synchronized void deleteObserver(Observer arg0) {
		// TODO Auto-generated method stub
		super.deleteObserver(arg0);
	}

	@Override
	public synchronized void deleteObservers() {
		// TODO Auto-generated method stub
		super.deleteObservers();
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		super.notifyObservers();
	}

	@Override
	public void notifyObservers(Object arg0) {
		// TODO Auto-generated method stub
		super.notifyObservers(arg0);
	}

	@Override
	protected synchronized void setChanged() {
		// TODO Auto-generated method stub
		super.setChanged();
	}

}
