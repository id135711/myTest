package myTest.test01_10;

import java.util.ArrayList;

import org.junit.Test;

public class Factorization {
	@Test
	public void test01(){
		printFactorization(101424);
		printFactorization(-101424);
	}
	/*
	 * 将一个数进行Factorization。
	 * 如果是一个人会怎么做？
	 * 分解成2个小的数，然后不停重复该步骤，直到不能分解。
	 * 
	 * 怎么分解成2个小的数？
	 * 显然，当其中的1个数是为最小的因数时，我们只需去处理余下的数就行，减小了一半的任务量。
	 * 现在问题是拿到最小的因数了？
	 * 从2开始到原数的范围循环查找。
	 * 如果，存在最小的因数a，则有a*b=c->a<=Math.sqrt(c)。
	 * 从2到Math.sqrt(c)的范围查找，如果找到对另一个更大的因数赋给原数进行重复操作。
	 * 如果没有找到，显然此时的最小因数是原数的自身。
	 * 
	 * 如果，多次进行此类运算，我们应该可以在类内部定义一个属性，整形数组来保存一些最小的素数，如2，3，5，7，11等等。
	 * 如此，可以不用从2到Math.sqrt(c)的范围查找，直接从整形数组中依次拿出最小的素数进行测试是否符合。
	 * 毕竟，从2到Math.sqrt(c)的范围查找时，会对非常多的明显不可能的数进行判断，比如4，6，8，9，10等等绝不可能
	 * 是原数的最小因数。
	 * 而现在，我只是需要对一个数进行Factorization,就不定义数组了。
	*/
	public void printFactorization(int number){
		StringBuilder result;
		if(number==0)
			return;
		if(number<0){
			result = new StringBuilder(number+" = -1");
			number = Math.abs(number);
		}else
			result = new StringBuilder(number+" = 1");
		ArrayList<Integer> list = new ArrayList<Integer>();
		int minPrime = 2;
		while((minPrime=findMinPrime(number,minPrime))!=number){
			list.add(minPrime);
			number/=minPrime;
		}
		list.add(minPrime);
		for (Integer integer : list) {
			result.append("*"+integer);
		}
		System.out.println(result.toString());
	}
	private int findMinPrime(int number,int minPrime) {
		// TODO 自动生成的方法存根
		for (int i = minPrime; i <=Math.sqrt(number); i++) {
			if(number%i==0)
			return i;
		}
		return number;
	}
	/*
	 * 突然，想到我们找最小因数时，将一个原数分成最小因数和更大的一个因数。
	 * 更大的一个因数的最小因数一定不比原数的最小因数小，毕竟，如果更小，因为原数的因数包含其分解后的因数的因数，所以更大的一个因数的最小因数
	 * 也是原数的因数，而原数的因数都不比原数的最小因数小。这自行矛盾了。
	 * 
	 * 所以，可以得出结论：一个原数分解成最小因数和更大的一个因数后，对其更大的一个因数进行相同的操作得到的
	 * 原数的更大的一个因数的最小因数会不比原数的最小因数小。
	 * 
	 * 利用这个结论可以对查找最小因数的方法进行优化！
	 * 将上次的查找到的最小因数作为参数值传给方法形参，然后方法内部的查找范围从
	 * 原来的		int i = 2; i <=Math.sqrt(number); i++
	 * 变化成现在的	int i = minPrime; i <=Math.sqrt(number); i++
	*/
	
}
