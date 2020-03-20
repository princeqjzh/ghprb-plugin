package org.jenkinsci.plugins.ghprb.extools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public final class LoadUnitTestResult {
    private static final Logger LOGGER = Logger.getLogger(LoadUnitTestResult.class.getName());

    private LoadUnitTestResult() {

    }

    public static String loadMessageFromFile() {
        String encoding = "UTF-8";
        File file = new File(System.getProperty("user.home") + File.separator + "UnitTestResult.txt");
        String testResult = null;
        try {
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    testResult = lineTxt;
                    LOGGER.info("Test result = " + testResult);
                    break;
                }
                read.close();
            } else {
                LOGGER.info("The file " + file.getAbsolutePath() + " doesn't exist!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return testResult;
    }
}
