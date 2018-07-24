package myTest.test11_20;

import org.junit.Test;

public class PermutationAndCombination {
	@Test
	public void test01(){
		showAllCombinationCount();
		showCountByPermutationAndCombination();
	}
	/*
	 * 从0，1，2...8，9共计10个数字进行排列组合，求无重复数字组成的不重复的三位数有多少个？
	 * 机器的解法依靠运算能力暴力破解。
	 * 获得所有的3位数然后遍历判断是否是无重复数字组成的。
	 * 获得所有的3位数转换成获得1个3位数转换成明确3个值。
	*/
	public void showAllCombinationCount(){
		int count = 0;
		for(int i = 1;i<=9;i++){
			for(int j = 0;j<=9;j++){
				for(int k = 0;k<=9;k++){
					if(i!=j&&i!=k&&j!=k){
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
	/*
	 * 如果，是一个人来解决问题，会使用排列组合的知识，利用技巧解决。
	*/
	public void showCountByPermutationAndCombination(){
		System.out.println(9*9*8);
	}
}
