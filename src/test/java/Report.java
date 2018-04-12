

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ClassForTests.class,ForTestReports.class})
public class Report {
	@Test
	public void test1(){
		Assert.assertTrue(true);
	}
	@Test
	public void test2(){
		Assert.assertTrue(false);
	}

	@Test(dependsOnMethods="test2")
	public void test3(){}

}
