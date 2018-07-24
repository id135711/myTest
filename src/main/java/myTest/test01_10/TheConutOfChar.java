package myTest.test01_10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.junit.Test;

public class TheConutOfChar {
	/*
	 * 1.获得一串字符串，然后遍历之
	 * 2.分类的规则
	 * 	字母的编码会在会在65-90 98-123之间
	 * 	尝试转换成数字，没异常是数字，否则是非数字。
	 * 	和" "比较
	 * 	其他是汉字和特殊字符。
	 * 
	 * 怎么区分汉字？
	 * 对编码表的知识不多，不清楚汉字的编码范围，暂时放弃。
	*/
	@Test
	public void test01() throws Exception{
		showCountByType();
	}
	
	public void showCountByType() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int charCount = 0;
		int numberCount = 0;
		int spaceCount = 0;
		int otherCount = 0;
		for(int i = 0;i<str.length();i++){
			char temp = str.charAt(i);
			if((temp>=65&&temp<=90)||(temp>=98&&temp<=123)){
				charCount++;
			}else if(" ".equals(temp+"")){
				spaceCount++;
			}else{
				try{
					Integer.parseInt(temp+"");
					numberCount++;
				}catch (Exception e) {
					// TODO: handle exception
					otherCount++;
				}
			}
		}
		System.out.println("charCount:"+charCount+
				",numberCount"+numberCount+",spaceCount"+spaceCount+
				",otherCount"+otherCount);
		br.close();
	}
}
