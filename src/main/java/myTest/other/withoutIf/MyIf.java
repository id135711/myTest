package myTest.other.withoutIf;

public class MyIf {
	
	private boolean flag;
	private Doit doit;
	
	public MyIf(boolean flag, Doit doit) {
		super();
		this.flag = flag;
		this.doit = doit;
	}
	
	public boolean myif(){
		boolean result = flag&&(doit.doit());
		return result;
	}
	
}
