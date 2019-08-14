package myobserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author www72
 * Date 2019/8/13 11:41
 * @Description
 */
public class Subject {
	
	private int state;
	
	private List<Observer> observerList = new ArrayList<>();
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		if(state == this.state){
			return;
		}
		this.state = state;
		notifyAllObserver();
	}
	
	public void attach(Observer observer){
		observerList.add(observer);
	}
	public void notifyAllObserver(){
		observerList.stream().forEach(Observer::update);
	}
}
