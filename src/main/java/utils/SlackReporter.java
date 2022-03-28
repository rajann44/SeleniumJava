package utils;

import org.testng.ITestContext;

import java.io.IOException;
import java.util.ArrayList;

public class SlackReporter {

    static String jsonString="";

    static ArrayList<String> failedTestList = new ArrayList<>();

    public static String testResultOutputAndReturnLongOP(){
        for (String str : failedTestList) {
            // New line added after each test method name.
            jsonString = jsonString + str + "\\n";
        }
        return jsonString;
    }

    public static int totalFailedCount(){
        return failedTestList.size();
    }

    public static void sendMessageToSlack(ITestContext context){
        if(SlackReporter.totalFailedCount()>=1){
            long milliseconds = context.getEndDate().getTime() - context.getStartDate().getTime();
            long minutes = (milliseconds / 1000) / 60;
            long seconds = (milliseconds / 1000) % 60;
            try {
                HttpHandler.makePostRequest(System.getenv("SLACK_WEBHOOK_URL")
                        ,"{\"text\":\""
                                +"---------------------------------------------------------------------"
                                +"\\n"+"Total Test Run: "+context.getAllTestMethods().length+" | Failures: " +SlackReporter.totalFailedCount()
                                +" | Execution Time: "+ minutes+"min "+seconds+"sec "
                                +"\\n"+"---------------------------------------------------------------------"
                                +"\\n"+ SlackReporter.testResultOutputAndReturnLongOP()
                                +"\\n"+"---------------------------------------------------------------------"
                                +"\"}"
                );
            } catch (IOException e) {
                e.printStackTrace();
            }}
    }

}
