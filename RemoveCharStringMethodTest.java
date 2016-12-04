package com.apple;

import java.util.regex.PatternSyntaxException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RemoveCharStringMethodTest {
	
	RemoveChar rc = new RemoveChar();
	
	@Test(description="stringProblem test with positive test data", 
			groups="positive",dataProvider="getPositiveTestData" , dataProviderClass = RemoveCharIterateTest.class)
	
	public void charReplaceAllTest(String testString, char testChar, String expected) {
		
		String actual;
		
		rc.setOrgWord(testString);
		
		rc.setOrgChar(testChar);
		
		actual = rc.removeCharV1(rc.getOrgWord(), rc.getOrgChar());
		
		System.out.println("Org Word is: \"" + rc.getOrgWord() + 
				"\", Char to remove is \'" + rc.getOrgChar() + 
				"\', String Method: replaceAll - Updated word : " + actual);
		
		Assert.assertEquals(actual.equals(expected), true);
	}
	
	
	@Test(description="stringProblem with negative test data", 
			groups="negative",dataProvider="getNegativeTestData")
	
	public void charReplaceAllNegativeTest(String testString, char testChar, String expected) {
		
		String actual = "";
		boolean pass = false;
		
		rc.setOrgWord(testString);
		
		rc.setOrgChar(testChar);
		try {
			actual = rc.removeCharV1(rc.getOrgWord(), rc.getOrgChar());
		} catch ( PatternSyntaxException err) {
			if(testChar == '*' || testChar == '?'){
				System.out.println("PatternSyntaxException is thrown which is expected");
				pass = true;
				
			} else {
				throw new PatternSyntaxException(err.getDescription(), err.getPattern(), err.getIndex());
			}
		}
		
		System.out.println("Org Word is: \"" + rc.getOrgWord() + 
				"\", Char to remove is \'" + rc.getOrgChar() + 
				"\', String Method: replaceAll - Updated word : " + actual);
		
		if(actual == null) {
			Assert.assertNull(expected);
		} else if(!pass){			
			Assert.assertEquals(actual.equals(expected), true);
		}
	}	
	
	@AfterClass
	public void anyCleanup() {
		System.out.println(" ----Complete ---- 2. Find a method in the String class that can solve this in one line");
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
			{"a-=][';/.,?><+_!@#$%^&*()~:",'.',""},
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
					+ "}",'.',""}
			};
	}
  
}
