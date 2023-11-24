package com.solvd.utility;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ReadDataFromCSV {

    public static final Logger LOGGER = LogManager.getLogger(ReadDataFromCSV.class);

    public static Object[][] readCsv(String path) {
        Object res[][] = null;
        try {
            CSVParser parser = new CSVParser(new FileReader(path), CSVFormat.DEFAULT);
            List<CSVRecord> list = parser.getRecords();
            res = new Object[list.size()][];
            int i = 0;
            for (CSVRecord record:list) {
                res[i] = new Object[record.size()];
                int j = 0;
                for (String str:record) {
                    res[i][j++] = str;
                }
                i++;
            }
        }
        catch (IOException e) {
            LOGGER.error(e);
        }
        return res;
    }

    @Test(testName = "unit test for this service")
    public static void test() {
        Object[][] object = readCsv("src/test/resources/data/weak_passwords.csv");
        SoftAssert softAssert = new SoftAssert();
        for (Object[] objects:object) {
            System.out.println(objects[0]);
        }
        softAssert.assertEquals(object[0][0],"1");
        softAssert.assertEquals(object[1][0],"2");
        softAssert.assertEquals(object[2][0],"Pass12");
        softAssert.assertEquals(object[3][0],"345");
        softAssert.assertEquals(object[4][0]," Passworddddd");
    }
}
