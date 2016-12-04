package com.apple;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RemoveCharIterateTest {
	RemoveChar rc = new RemoveChar();
	
	@Test(description="stringProblem test with positive test data", 
			groups="positive",dataProvider="getPositiveTestData")
	
	public void charIterateTest(String testString, char testChar, String expected) {
		String actual;
		
		rc.setOrgWord(testString);
		
		rc.setOrgChar(testChar);
		
		actual = rc.removeCharV2(rc.getOrgWord(), rc.getOrgChar());
		
		System.out.println("Org Word is: \"" + rc.getOrgWord() + 
				"\", Char to remove is \'" + rc.getOrgChar() + 
				"\', Iterate Method Updated word : " + actual);
		
		Assert.assertEquals(actual.equals(expected), true);
	}
	
	
	@Test(description="stringProblem with negative test data", 
			groups="negative",dataProvider="getNegativeTestData")
	
	public void charIterateNegativeTest(String testString, char testChar, String expected) {
		
		String actual;
		
		rc.setOrgWord(testString);
		
		rc.setOrgChar(testChar);
		
		actual = rc.removeCharV2(rc.getOrgWord(), rc.getOrgChar());
		
		System.out.println("Org Word is: \"" + rc.getOrgWord() + 
				"\", Char to remove is \'" + rc.getOrgChar() + 
				"\', Iterate Method Updated word : " + actual);
		
		if(actual == null) {
			Assert.assertNull(expected);
		} else {
			Assert.assertEquals(actual.equals(expected), true);
		}
		
	}
	
	@AfterClass
	public void anyCleanup() {
		System.out.println(" ----Complete ---- 1. Iterate through the String, one character at a time");
	}
	
	@DataProvider(name="getPositiveTestData")
	
	public Object[][] getPositiveTestData() {
		return new Object[][]{
			{"Testing",'g',"Testin"},
			{"Test Data", 'a',"Test Dt"},
			{"testng",'t',"esng"}
			};
	}
	
	@DataProvider(name="getNegativeTestData")
	
	public Object[][] getNegativeTestData() {
		return new Object[][]{	
			{"Java",' ',"Java"},
			{null,' ',null},
			{"",' ',""},
			{"1234567890000000000",'0',"123456789"},
			{"aaaaaaaaaaaaaaaaaaaa\\aaaaaaaaaaaaaaaaaaaaaa"
					+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
					+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
					+ "aaaaaaaaaaaaaaaaaaaaaaaaaaa",'a',"\\"},
			{"This is some text to test stringProblem",'@',"This is some text to test stringProblem"},
			{"!@#$%^&*()_+~",'@',"!#$%^&*()_+~"},
			{"abcdefghijklmnopqrstuvwxyz1234567890-=][';/.,?><+_!@#$%^&*()~:",'*',"abcdefghijklmnopqrstuvwxyz1234567890-=][';/.,?><+_!@#$%^&()~:"},
			{"a-=][';/.,?><+_!@#$%^&*()~:",'.',"a-=][';/,?><+_!@#$%^&*()~:"},
			{"Is it really a test?",'?',"Is it really a test"},
			{"public void charIterateNegativeTest(String testString, char testChar, String expected) {"
					+ "String actual;"
					+ "rc.setOrgWord(testString);"
					+ "rc.setOrgChar(testChar);"
					+ "actual = rc.removeCharV2(rc.getOrgWord(), rc.getOrgChar());"
					+ "System.out.println(\"Org Word is: \"\" + rc.getOrgWord() +"
					+ "\"\\\", Char to remove is \'\" + rc.getOrgChar() +"
					+ "\"\', Iterate Method Updated word : \" + actual);"
					+ "if(actual == null) {"
					+ "Assert.assertNull(expected);"
					+ "} else {"
					+ "Assert.assertEquals(actual.equals(expected), true);"
					+ "}"
					+ "}",'.',"public void charIterateNegativeTest(String testString, char testChar, String expected) {"
					+ "String actual;"
					+ "rcsetOrgWord(testString);"
					+ "rcsetOrgChar(testChar);"
					+ "actual = rcremoveCharV2(rcgetOrgWord(), rcgetOrgChar());"
					+ "Systemoutprintln(\"Org Word is: \"\" + rcgetOrgWord() +"
					+ "\"\\\", Char to remove is \'\" + rcgetOrgChar() +"
					+ "\"\', Iterate Method Updated word : \" + actual);"
					+ "if(actual == null) {"
					+ "AssertassertNull(expected);"
					+ "} else {"
					+ "AssertassertEquals(actualequals(expected), true);"
					+ "}"
					+ "}"}
			};
	}
}
