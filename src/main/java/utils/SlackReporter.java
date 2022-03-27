package utils;

import java.util.ArrayList;

public class SlackReporter {

    static String jsonString="";

    static ArrayList<String> failedTestList = new ArrayList<>();

    public static void testResultOutput(){
        for (String str : failedTestList) {
            jsonString = jsonString + str + "\\n";
        }
    }

    public static String returnLongOP(){
        //return jsonString+"\"";
        return jsonString+"\\n"+"******Automation_Execution_Ended******\"";
    }

}
