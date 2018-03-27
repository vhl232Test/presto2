import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class ClassForTests implements ITestListener {
	public void onTestStart(ITestResult result) {
		System.out.println("test nachalsa");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("test proiden " +result);
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("vse ploho "+result);
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("test propushen "+result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("huinya kakae to");
	}

	public void onStart(ITestContext context) {
		System.out.println("zapusheno");

	}

	public void onFinish(ITestContext context) {
		System.out.println("zaconcheno");
	}
}
