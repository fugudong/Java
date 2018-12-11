package weibo1;

import java.util.Observable;
import java.util.Observer;

public class User extends Observable{
	
	private int name_id;
	
	private int fans;
	
	public int getName_id() {
		return name_id;
	}

	public void setName_id(int name_id) {
		this.name_id = name_id;
	}

	public int getFans() {
		return fans;
	}

	public void setFans(int fans) {
		this.fans = fans;
	}
	
	//ÐÞ¸Ä·ÛË¿Êý
	public void fans(int name_id,int fan)
	{
		Operate op = new Operate();
		int fans = op.CounterByLogger(name_id);
		fans = fan;
		op.fans(name_id, fans);
		setChanged();
		notifyObservers(fans);
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