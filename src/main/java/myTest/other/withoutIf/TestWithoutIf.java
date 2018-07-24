package myTest.other.withoutIf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class TestWithoutIf {
	
	static boolean flag = false;
	static final String INPUT = "without if";
	
	static{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			flag = br.readLine().equalsIgnoreCase(INPUT);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	@Test
	public void mytest01(){
		if(flag)
			System.out.println(INPUT+"from test01!");
	}
	
	@SuppressWarnings("unused")
	@Test
	public void mytest02(){
		boolean temp = flag&&(new Object(){
			public boolean doit(){
				System.out.println(INPUT+"from test02!");
				return true;
			}
		}.doit());
	}
	
	@SuppressWarnings("unused")
	@Test
	public void mytest03(){
		boolean temp = flag&&(new Doit(
				()->{
					System.out.println(INPUT+"from test03 by lambda!");
				}
				).doit());
	}
	
	@Test
	public void mytest04(){
		new MyIf(flag,new Doit(
				()->{
					System.out.println(INPUT+"from test04 by MyIf!");
				}
				)).myif();
	}
	
	@Test
	public void mytest05(){
		MyIf2.myIf2(flag, ()->{
			System.out.println(INPUT+"from test04 by MyIf2!");
		});
	}
	
	
	/*
	 * 使用&&和||时，突然想到其断路效果对于表达式右边的部分而言不就是根据表达式左边部分来决定是否执行。
	 * 
	 * 如此，产生了一个想法，为何不直接把if的执行语句放到if的条件语句的后面呢？！
	 * 
	 * if(条件语句)
	 * 	执行语句;
	 * 
	 * 等价于
	 * 
	 * 条件语句&&执行语句
	 * 
	 * if(！条件语句)
	 * 	执行语句;
	 * 
	 * 等价于
	 * 
	 * 条件语句||执行语句
	 * 
	 * 如此，可以不使用语言提供的if标识符，而自己定义一个类借用&&或者||来模拟if标识符！
	 * 条件语句&&执行语句	和	(！条件语句)||执行语句	又是等效果的，出于习惯决定使用&&来模拟if标识符。
	 * 
	 * 自定义一个MyIf类来模拟if标识符的效果：
	 * 需要什么？
	 * 
	 * 1.给予MyIf类，条件语句和执行语句
	 * 
	 * 通过成员属性还是方法形参的方式传值？
	 * 我希望1个MyIf类对象可以执行不同的任务，所以需要的数据应该是会经常变动的，所以直接通过方法形参的方式传值来明确每次都会变化的条件语句和执行语句。
	 * 最终，发现方法没有使用到成员属性，所以索性定义成静态方法，直接通过类来调用。
	 * 
	 * 传递条件语句？
	 * 直接定义一个boolean类型的形参来接收方法调用者提供的条件表达式的值。
	 * 
	 * 传递执行语句？
	 * 我们可以传递一个基本类型的值，也可以传递一个引用类型的值，但是没有办法传递一个函数或者代码片段。
	 * 但是，可以把需要传递的函数或者代码片段放到一个类的对象中，然后把这个类的对象的引用传递给形参。
	 * 定义一个接口MyWork,其中的work函数才是想要传递的东西，但是出于语法的限制，只能传递包含了work函数的接口的实现类引用。
	 * 
	 * 又出现了一个问题？！
	 * 语法限制我们在使用&&来连接时必须是连接的boolean类型：
	 * 
	 * 2个解决方法：
	 * 
	 * 1：直接在work函数中返回一个没有意义的true
	 * 代价，每回使用MyIf类的方法提供形参时，提供接口的实现类的代码中要多写一句返回true。
	 * 
	 * 2：在work函数中还是返回一个void，我们在MyIf类的方法中把接收到MyWork实现类包装一下，增加上返回值后调用包装后的MyWork中的work函数。
	 * 好处，不用手动加返回true的语句。
	 * 
 * 		try{
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

	 * 
	 * 
	 * 最终版本：
	 * 类MyIf2的静态方法myIf2().
	 * 其2个参数，参数0是boolean类型等同于if标识符的条件语句;参数1是1个接口MyWork的实现类等同于if标识符的执行语句。
	 * 其函数的返回值，true表示执行语句被执行而且没有发生异常，false表示没有执行或者执行时出现了异常。
	 * 
	 * 余下的问题：
	 *使用if标识符可以直接使用if语句所在的域的数据
	 *而，当前版本的MyIf2中使用的接口MyWork中的方法work是无参的。
	 *
	 *解决的办法;
	 *1：将接口MyWork中的方法work的参数改成
	 *可变参数Object ...	或者ArrayList等。
	 *
	 *2：保留当前的接口MyWork中的方法work，不对其改动，因为对其改动会又需要对调用到它的其他类进行改动。
	 *不通过形参的方式传值。
	 *可以自己定义一个类来在不同数据域间传值！
	 *这个类需要的功能：保存数据，取出数据，删除数据。
	 *
	 *想要传值，显然先要能保存数据。
	 *所以，这个类需要1个成员属性来保存不同域间想要共享的数据。显然使用1个map是合适的，数据的变量名作键，数据的值作值。
	 *
	 *发现其他的2个功能都已经被map给完成了。
	 *
	 *现在的问题在于如何在不同数据域间都能找到这个类的成员属性map来对数据进行共享。
	 *显然，把其成员属性map设计成static，如此不同数据域间都能通过类名找到这个map了。
	 *
	 *余下问题中的余下问题：
	 *数据共享的问题看似解决了，但是没有。
	 *想要共享数据，需要我们自己向这个类的属性map里面存取数据，如果能自己主动存取就好了。
	 *
	 *自行从map里面存取数据中的取部分，如果我们在起变量名时在需要共享的部分进行统一。要共享的哪些数据在不同的数据域中同名。
	 *当程序需要1个数据时，如果发现其为null，能主动到map里面按变量名取数据(因为变量名在不同的数据域中是同名)，就好了。
	 *
	 *但是，哪些数据要程序自行向map里面存呢？
	*/
}
