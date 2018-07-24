package myTest.test01_10;

import org.junit.Test;

public class FreeFallingBody {
	@Test
	public void test01(){
		showDistance(100,2,0.5);
	}
	/*
	 * 把求整个路径的任务转换成求单次撞击贡献的路程然后求和。
	 * 单次的路程等于2倍的高度。
	 * 转换成求高度，和初始高度有系数关系。
	*/
	
	public static void showDistance(int start,int count,double coefficient){
		double distance = 0.0;
		for(int i = 1;i<=count;i++){
			if(i==1)
				distance+=start;
			else
				distance+=2*getHeight(start,count,coefficient);
		}
		System.out.println(
				"第"+count+"次相撞时经过了"+distance+"米"+"，当前撞击前的高度是"+getHeight(start,count,coefficient)+"米。");
	}

	private static double getHeight(int start, int count, double coefficient) {
		// TODO 自动生成的方法存根
		return start*Math.pow(coefficient, count-1);
	}
}
