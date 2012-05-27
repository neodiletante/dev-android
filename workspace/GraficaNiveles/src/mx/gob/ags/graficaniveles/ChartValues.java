package mx.gob.ags.graficaniveles;

public class ChartValues {
	private int id;
	private int val;
	private String title;
	public ChartValues(){}
	
	public ChartValues(int id, int val, String title){
		this.id = id;
		this.val = val;
		this.title = title;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	

}
