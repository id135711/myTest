package myTest.test01_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class TestGetSum {
	@Test
	public void test01() throws Exception{
		printSum();
	}
	/*
	 * 把整个大任务分成2部分求表达式和求和。
	 * s=0+a+aa+aaa+...=?
	 * 求表达式分解成求单个加数。
	 * 求和先提取因式为a，转换成求当a是1时的和
	 * 确认每位的值。第1位是n个1，第2位是n-1个1，...第i位是n-i+1个1.
	 * 累加每位对和的贡献。
	*/
	public void printSum() throws Exception{
		System.out.println("请输入每位的值和加数的总量，以space分隔！");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int a = Integer.parseInt(strs[0]);
		int n = Integer.parseInt(strs[1]);
		
		String expression = getExpression(a,n);
		int sum = getSum(a,n);
		System.out.println(expression+" = "+sum);
	}
	/*
	 * 负责求和，统计每位的值然后乘以相应位数对应的10的幂，把每位的贡献累加。
	*/
	private int getSum(int a, int n) {
		// TODO 自动生成的方法存根
		int sum = 0;
		for (int i = 1; i <=n; i++) {
			sum+=1*(n-i+1)*Math.pow(10, i-1);		
		}
		return sum*a;
	}
	/*
	 * 负责表达式，获得每个加式把n个加式依次相加。
	*/
	private String getExpression(int a, int n) {
		// TODO 自动生成的方法存根
		StringBuilder sb = new StringBuilder("s=0");
		for(int i = 1;i<=n;i++){
			sb.append(getSingleExpression(a,i));
		}
		return sb.toString();
	}
	/*
	 * 为调用者返回当前下标对应的单一表达式。
	*/
	private Object getSingleExpression(int a, int i) {
		// TODO 自动生成的方法存根
		StringBuilder sb = new StringBuilder("+");
		for (int j = 0; j < i; j++) {
			sb.append(a);
		}
		return sb.toString();
	}
}
