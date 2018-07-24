package myTest.test01_10;

import org.junit.Test;

public class UndeadRabbit {
	/*
	 * 假设一对兔子，从出生第三个月开始生一对，并且不会死亡。
	 * 如果在一月份刚出生了1对兔子，该兔子和其后代总数量和月份间的函数关系。
	*/
	
	
	/*
	 * 兔子的规律为1，1，2，3，5，8，13，21，...。
	 * 把求n的问题转换成n-1和n-2的问题，然后在n==1和n==2时拦截解决问题。
	 * 
	 * 2点不足：
	 * 	规律不是推导得到，而是使用暴力获得。->没有美感的同时不可靠。
	 * 纵然当n==99...99时依然符合，也无法保证n+1时也会正确。
	 * 
	 * 	假定规律是正确的，问题也没有彻底解决。使用递归导致不断有方法进入栈，而栈的容量
	 * 是有极限的。
	*/
	@Test
	public void try01(){
		System.out.println(UndeadRabbit.getNumber01(8));
	}
	public static int getNumber01(int month){
		if(month==1 || month==2)
			return 1;
		return getNumber01(month-1)+getNumber01(month-2);
	}
	
	/*
	 * 针对方法1中的不足进行引进。
	 * 使用循环减少方法的入栈来解决栈的容易不足。
	*/
	@Test
	public void try02(){
		System.out.println(UndeadRabbit.getNumber02(8));
	}
	public static int getNumber02(int month){
		//使用循环，就要把从1月到month月看成1个总过程。
		/*
		 * 只要把总过程中的某一小过程和相邻过程间的关系模拟好。
		*/
		//i表示当前月份，x：2个月前的总数,y：1个月前的总数,z：当月的总数。
		for (int i=1,x=0,y=0,z=1; i <=month; i++) {
				if(i==1)
					continue;
				x=y;//本月的x等于上月的y
				y=z;//本月的y等于上月的z
				z=x+y;//本月的z等于本月的x+本月的y	
				if(i==month)
					return z;
		}
		return -1;
	}
	@Test
	public void try03(){
		System.out.println(UndeadRabbit.getNumber03(8));
	}

	public static int getNumber03(int month){
		if(month==1 || month==2)
			return 1;
		else
		return getNumber03(month-1)+getNumber03(month-2);
	}
	/*
	 * n月的兔子总量可以看成n-1月的加上n月新出生的部分。
	 * 问题是n月新出生的部分是多少？
	 * n-1月的全部兔子除去过小的不能生产的部分兔子(在n-1月出生的没有能力在n月生产)
	 * 问题是n-1月新出生的部分是多少？
	 * getNumber03(month-1)-getNumber03(month-2)
	 * 
	 * getNumber03(month-1)+getNumber03(month-1)-（getNumber03(month-1)-getNumber03(month-2)）
	 * 
	 * 证明了规律是正确的，并非是特例。
	*/
}
