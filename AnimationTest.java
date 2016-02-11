package Animation;
import static org.junit.Assert.*;

import org.junit.Test;

public class AnimationTest {
	
	public static boolean compareStringArrays (String[] strArray1, String[] strArray2){
		if (strArray1.length != strArray2.length){
			return false;
		}
		
		boolean isEqual = true;
		for (int i = 0; i< strArray1.length; i++){
			if (!strArray1[i].equals(strArray2[i])){
				isEqual = false;
				break;
			}
		}
		
		return isEqual;
	}
	
	public static void printStringArray (String[] strArray){
		for (int i = 0; i< strArray.length; i++){
			System.out.println(strArray[i]);
		}		
	}
		
	@Test
	public void test1() {
		String[] solution = { "..X....",
							  "....X..",
							  "......X",
							  "......." };
		
		Animation a = new Animation();
		String[] generated = a.animate(2, "..R....");
		
		boolean isEqual = compareStringArrays(generated, solution);
	    assertTrue(isEqual);
	}
	
	@Test
	public void test2() {
		String[] solution = { "XX..XXX",
							  ".X.XX..",
							  "X.....X",
							  "......." };
		
		Animation a = new Animation();
		String[] generated = a.animate(3, "RR..LRL");
		
		boolean isEqual = compareStringArrays(generated, solution);
	    assertTrue(isEqual);
	}
	
	@Test
	public void test3() {
		String[] solution = { "XXXX.XXXX",
							  "X..X.X..X",
							  ".X.X.X.X.",
							  ".X.....X.",
							  "........." };
		
		Animation a = new Animation();
		String[] generated = a.animate(2, "LRLR.LRLR");
		
		boolean isEqual = compareStringArrays(generated, solution);
	    assertTrue(isEqual);
	}
	
	@Test
	public void test4() {
		String[] solution = { "XXXXXXXXXX",
		  					  ".........." };
		
		Animation a = new Animation();
		String[] generated = a.animate(10, "RLRLRLRLRL");
		
		boolean isEqual = compareStringArrays(generated, solution);
	    assertTrue(isEqual);
	}
	
	@Test
	public void test5() {
		String[] solution = {"..."};
		
		Animation a = new Animation();
		String[] generated = a.animate(1, "...");
		
		boolean isEqual = compareStringArrays(generated, solution);
	    assertTrue(isEqual);
	}
	
	@Test
	public void test6() {
		String[] solution = { "XXXX.XX.XXX.X.XXXX.",
							  "..XXX..X..XX.X..XX.",
							  ".X.XX.X.X..XX.XX.XX",
							  "X.X.XX...X.XXXXX..X",
							  ".X..XXX...X..XX.X..",
							  "X..X..XX.X.XX.XX.X.",
							  "..X....XX..XX..XX.X",
							  ".X.....XXXX..X..XX.",
							  "X.....X..XX...X..XX",
							  ".....X..X.XX...X..X",
							  "....X..X...XX...X..",
							  "...X..X.....XX...X.",
							  "..X..X.......XX...X",
							  ".X..X.........XX...",
							  "X..X...........XX..",
							  "..X.............XX.",
							  ".X...............XX",
							  "X.................X",
							  "..................." };
		
		Animation a = new Animation();
		String[] generated = a.animate(1, "LRRL.LR.LRR.R.LRRL.");
		
		boolean isEqual = compareStringArrays(generated, solution);
	    assertTrue(isEqual);
	}

}
