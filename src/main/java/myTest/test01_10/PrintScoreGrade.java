package myTest.test01_10;

import org.junit.Test;

public class PrintScoreGrade {
	@Test
	public void test01(){
		for(int score = 50;score<=110;score+=10)
		PrintScoreGrade.printGradeByScore(score);
	}

	private static void printGradeByScore(int score) {
		// TODO 自动生成的方法存根
		System.out.println(score+" : "+
		((score>100)?"同学，你醒醒，这是查单门课的等级不是总分！"
			:((score>=90)?"A"
					:((score>=80)?"B"
					:((score>=60)?"c"
							:"不合格"))))
	
				);
	}
}
