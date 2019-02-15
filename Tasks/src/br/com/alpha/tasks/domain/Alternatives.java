package br.com.alpha.tasks.domain;

public class Alternatives implements IDomain{
	private String text;
	private boolean checked;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
