package com.test.json;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.JsonPathException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by sakhtar on 25/06/2015.
 */
public class JsonPathTest {

    public Map getFragment(){
        try {
            String content = FileUtils.readFileToString(new File("C:\\projects\\learning\\javaTestScripts\\src\\main\\resources\\consignment.json"));
            Map read = JsonPath.read(content, "consignment.deliveryVendor.vendorIntegration.fullResponse");
            return read;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public String getFromData(Map data, String path) {
        Object read = "";
        try {
            read = JsonPath.read(data, path);
        } catch (JsonPathException e) {
            System.out.println("Json Path is not valid: " + e);
        }
        if (read instanceof List) {
            if (((List) read).size() > 0) {
                read = ((List) read).get(0);
            } else {
                read = "";
            }
        }
        return read.toString();
    }

    public static void main(String[] args) {
        JsonPathTest jsonPathTest = new JsonPathTest();
        Map read = jsonPathTest.getFragment();
        String test = jsonPathTest.getFromData(read, "xmlResponse.sitePCH.libelle");
        System.out.println(test);


//        StringBuilder sb = new StringBuilder();
//        sb.append("Site depot: ");
//        sb.append([label].getFromData([label].getExternalResponse(), "xmlResponse.sitePCH.libelle"));
//        sb.append("\r\n");
//        sb.append([label].getFromData([label].getExternalResponse(), "xmlResponse.sitePCH.adresse.line2"));
//        sb.append("\r\n");
//        sb.append([label].getFromData([label].getExternalResponse(), "xmlResponse.sitePCH.adresse.postalCode"));
//        sb.append(" ");
//        sb.append([label].getFromData([label].getExternalResponse(), "xmlResponse.sitePCH.adresse.city"));
//        sb.append("\r\n");
//        return sb.toString();
    }
}
