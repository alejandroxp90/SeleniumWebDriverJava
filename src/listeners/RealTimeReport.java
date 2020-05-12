package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class RealTimeReport implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test iniciando..." + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test ha pasado..." + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test ha fallado..." + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test se ha omitido..." + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Iniciando ejecucion del Test..." + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test ha finalizado..." + context.getName());
    }
}
