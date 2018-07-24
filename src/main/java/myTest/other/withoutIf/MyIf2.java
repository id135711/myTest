package myTest.other.withoutIf;

public class MyIf2 {
	
	public static boolean myIf2(boolean flag,MyWork myWork){
		try{
			boolean restlt = flag&&(new MyWork(){
				public void work(){
					
				}
				public boolean work(MyWork myWork){
					myWork.work();
					return true;
				}
			}.work(myWork));
			return restlt;
		}catch(Exception e){
			return false;
		}
	}
	
}
