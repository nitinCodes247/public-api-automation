package com.nitin.openf1.testdata;

import org.testng.annotations.DataProvider;

public class DriverTestData {
    @DataProvider(name = "valid-driver-test")
    public Object[][] validDriverTestData(){
        return new Object[][]{
                {1,9158},
                {5, 9223}
        };
    }
}
