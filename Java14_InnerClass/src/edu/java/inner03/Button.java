package edu.java.inner03;

public class Button {
	// public staic 내부 인터페이스
	// 내부 인터페이스는 반드시 static이어야 함. 선언할 때 static은 생략 가능.
	public interface OnClickListener {
		void onClick(); // public abstract 생략.
	}
	
	//field
	private String btnName;
	private OnClickListener Listener;
	
	// constructor
	public Button(String btnName) { 
		this.btnName = btnName;
		
	}
	
	//method
	public void setOnClickListener (OnClickListener l ) {
		this.Listener = l;
	}
	
	public void click() {
		System.out.println(btnName + "버튼: ");
		Listener.onClick();
	}
}
