package myTest.test01_10;

import org.junit.Test;

public class NarcissusNumber {
	@Test
	public void test01(){
		printAllNarcissus(100,999,(i)->{
			int sum = 0,t=i;
			while(i>0){
				sum+=Math.pow((i%10), 3);
				i/=10;
			}
			return t==sum;
		});
	}
	
	public static void printAllNarcissus(int start,int end,MyCondition<Integer> condition){
		for (int i = start; i <= end; i++) {
			if(condition.is(i))
			System.out.println(i);
		}
	}
	/*
	 * 找到所有的花->找到1朵花->明确找的规则
	 * 找的规则:
	 * 从末尾拿1位，求3次幂，然后加到和上。
	 * 把数除去末尾。
	 * 不断重复，直到数为0.
	 * 比较和和原数。
	*/
	
	
	
	@Test
	public void test02(){
		NarcissusNumber.printAllNarcissusByTheEasyWay(100, 999);
	}
	public static void printAllNarcissusByTheEasyWay(int start,int end){
		for(int i=1;i<=9;i++){
			for(int j=0;j<=9;j++){
				for(int k=0;k<=9;k++){
					int number = i*100+j*10+k*1;//从千百个位的值到原数
					if(start<=number&&number<=end){
						if(number==(Math.pow(i, 3)+Math.pow(j, 3)+Math.pow(k, 3)))
							System.out.println(number);
					}
				}
			}
		}
	}
	/*
	 * 更简单的方法：
	 * 	如果，能直接获得每位数的值就不用靠%和/了。
	 * 因此，对于数的获得不能像之前一样，直接从开始到结束的范围遍历来获得了。
	 * 可以把一个三位数的生成看成是明确3个值的过程。
	 * 明确千百个位的值。
	 * 每个值的明确都使用一个循环，总共3个循环就模拟了一个人明确千百个位的值来找到1个数的过程。
	 * 现在，我们直接是获得了3个值，无论是去找到原数，还是求水仙数和都非常方便！
	*/
}
