//TestListener.java

package com.demo.listener;




import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.demo.utility.JiraCreateIssue;
import com.demo.utility.JiraServiceProvider;

public class TestListener implements ITestListener {


    public void onTestFailure(ITestResult result) {

        boolean islogIssue = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraCreateIssue.class).isCreateIssue();

        if (islogIssue) {

//Provide proper Jira project URL ex: https://browsertack.atlassian.net 

//Jira User name ex: browserstack@gmail.com

//API token copy from Jira dashboard ex: lorelimpusm12uijk

//Project key should be, Short name ex: BS


            JiraServiceProvider JiraServiceProvider = new JiraServiceProvider("https://vythaku.atlassian.net",

                    "harshad.surve@aqmtechnologies.com", "9nrBRxnFK4sDPbHc2l5p0C44", "CCC");



            String issueDescription = "Failure Reason from Automation Testing\n\n" + result.getThrowable().getMessage()

                    + "\n";

            issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));




            String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName()

                    + " Failed in Automation Testing";

            

            JiraServiceProvider.createJiraIssue("Bug", issueSummary, issueDescription, "Automated Testing");

        }

    }

    public void onTestSkipped(ITestResult result) {

        // TODO Auto-generated method stub




    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        // TODO Auto-generated method stub


    }

    public void onStart(ITestContext context) {

        // TODO Auto-generated method stub


    }


    public void onFinish(ITestContext context) {

        // TODO Auto-generated method stub


    }


    public void onTestStart(ITestResult result) {

        // TODO Auto-generated method stub


    }


    public void onTestSuccess(ITestResult result) {

        // TODO Auto-generated method stub


    }

}
