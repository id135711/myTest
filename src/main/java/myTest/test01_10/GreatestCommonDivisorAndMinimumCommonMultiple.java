package myTest.test01_10;

import org.junit.Test;

public class GreatestCommonDivisorAndMinimumCommonMultiple {
	@Test
	public void test(){
		GreatestCommonDivisorAndMinimumCommonMultiple.
		printGreatestCommonDivisorAndMinimumCommonMultiple(123, 147);
	}
	/*
	 * 从2个数来获得GreatestCommonDivisor和MinimumCommonMultiple？
	 * 
	 *GreatestCommonDivisor肯定不比2个数中的最小值大。然后不比1小。
	 * 
	 *MinimumCommonMultiple不会大于2个数的乘积。然后不比2个数的最大值小。
	*/
	public static void printGreatestCommonDivisorAndMinimumCommonMultiple(int a,int b){
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		for(int i = min;i>=1;i--){
			if(a%i==0&&b%i==0){
				System.out.println(a+"和"+b+"的GreatestCommonDivisor is"+i);
				break;
			}		
		}
		for(int i = max;;i++){
			if(i%a==0&&i%b==0){
				System.out.println(a+"和"+b+"的MinimumCommonMultiple is"+i);
				break;
			}
		}
	}
	
	/*
	 * 上面是计算机的暴力解决方法。
	 * 如果是一个人会怎么解决呢？
	 * 人会把2个数都进行Factorization。
	 * 然后从因数们中找到最多的重复因数，然后把这部分因数相乘得到GreatestCommonDivisor。
	 * 从因数中找到不重复的因数，按其次数求幂，然后把重复的部分取更大的次数相乘。
	 * 
	 * 获得1个数的所有最小因数，在此次的测试中已经有写过了。
	 * 
	 * 怎么取得重复部分和其次数？
	 * 定义一个map<因数，对应的次数>，遍历存放因数的数组，对每个元素都尝试从map中去获得资料。
	 * 如果为null，表示第1个该种因数，使value=1;否则，使value+=1。
	 * 如此，获得了一个存放了1个数的因数和因数的个数的map。
	 * 同理，可以获得另一个数的相应map。
	 * 定义第3个map，使用第一个map来遍历，在过程中以其key去从第二个map和第一个map的相应的value值。
	 * 如果，都非null，取大的次数存入第3个map。
	 * 如此，获得了保存2个数的共同因数和共同因数的最小次数的map,GreatestCommonDivisor解决了。
	 * 
	 * 从因数中找到不重复的因数？
	 * 在前面的基础上已经非常简单了，使用第1和第3个map来找到第1个数中的独有因数。同理，找到第2个因数的独有因数。
	 * 2个来源的独有因数和共有的因数和它们的次数都获得了，求幂然后相乘就解决了。
	 * 
	 * 
	 * 突然想到一个更方便的方法求MinimumCommonMultiple
	 * 一个数可看成独有因数和共有因数(次数比另一个中的少)和共有因数(次数比另一个中的多)所组成
	 * 另一个数可看成独有因数和共有因数(次数比另一个中的少)和共有因数(次数比另一个中的多)所组成
	 * 而2个数的最小公倍数可以看成：
	 * (来自前者)独有因数和(来自后者)独有因数和共有因数(2个数中的最大的次数)
	 * 
	 * 所以直接相乘2数和最小公倍数间比多了共有因数(次数比另一个中的少)的部分，只要直接相乘2数然后除去重复的部分就得到最小公倍数。
	 * 
	 * 结论：
	 * 最小公倍数*最大公约数==2原数之积
	*/
}
