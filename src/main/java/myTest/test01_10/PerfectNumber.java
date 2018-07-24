package myTest.test01_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class PerfectNumber {
	/*
	 * 如果一个数等于其因数之和，则其为perfect number. 求1000以内的全部并打印。
	 * 
	 * 转换成求1个完数。 继续转换成求全部的因数。 因数的大小范围？ 1是最小的，最大的是不超过原数的一半。
	 */
	@Test
	public void test01() throws Exception {
		showAllPerfectNumber((i)->{
			int sum = 0;
			for(int j = 1;j<=i/2;j++){
				if(i%j==0){
					sum+=j;
				}
			}
			return sum==i;
		});
	}

	private void showAllPerfectNumber(MyCondition< Integer> condition) throws Exception {
		// TODO 自动生成的方法存根
		System.out.println("想输出什么范围内的完数，请输入范围的上限！");
		int n = Integer.parseInt(
				new BufferedReader(new InputStreamReader(System.in)).readLine());
		for(int i = 1;i<=n;i++){
			if(condition.is(i))
				System.out.println(i);
		}
		
	}
}
