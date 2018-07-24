package myTest.other.withoutIf;

public class Doit {
	private MyWork myWork;

	public Doit(MyWork myWork) {
		super();
		this.myWork = myWork;
	}

	public Doit() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public boolean doit(){
		try{
			myWork.work();
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
}
