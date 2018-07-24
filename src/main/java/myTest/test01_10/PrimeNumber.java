package myTest.test01_10;

import org.junit.Test;

public class PrimeNumber {
	@Test
	public void test01(){
		System.out.println(PrimeNumber.findPrimeNumber(101, 200));
	}
	
	public static int findPrimeNumber(int start,int end){
		/*
		 * 找到该范围的全部PrimeNumber->判断一个数是否是PrimeNumber
		 * 问题继续转换->是否存在整数(非1非本身)能整除该数
		 * 查找的范围？
		 * 如果存在则有a*b=c;可知Math.min(a,b)<=Math.sqrt(c)
		 * 也就是说明如果从2找到Math.sqrt(c)还找不到能整除的数，则一定找不到。
		*/
		if(start>end || start<=1)
			return -1;
		int count = 0;
		for(int i = start;i<=end;i++){
			if(isPrimeNumber(i)){
				System.out.println(i);
				count++;
			}
		}
		return count;
	}

	private static boolean isPrimeNumber(int i) {
		// TODO 自动生成的方法存根
		for (int j = 2; j <= Math.sqrt(i); j++) {
			if(i%j==0)
				return false;			
		}
		return true;
	}
}
