package com.qa.Helper.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	private int count = 0;
	private static int maxTry = 3;

	@Override
	public boolean retry(ITestResult result) {
		if (!result.isSuccess()) { // Check if test not succeed
			if (count < maxTry) {
				count++;
				result.setStatus(ITestResult.FAILURE); // Mark test as failed
				return true; // For rerun the test case
			} else {
				result.setStatus(ITestResult.FAILURE); // Count reached mark it as failures
			}
		} else {
			result.setStatus(ITestResult.SUCCESS); // test is succeed no need to run
		}
		return false; // For close not retry return false
	}
}
