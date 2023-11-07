package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import stepdefinations.StepDefination;

public class Utils {
    public static RequestSpecification req;
    public static RequestSpecification reqLogin;
//    public RequestSpecification requestSpecification() throws IOException
//    {
//
//        if(req==null)
//        {
//            PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
//            req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addHeader("authorization", StepDefination.token)
//                    .addFilter(RequestLoggingFilter.logRequestTo(log))
//                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
//                    .setContentType(ContentType.JSON).build();
//            return req;
//        }
//        return req;
//
//    }

    public RequestSpecification requestSpecificationLogin() throws IOException
    {

        if(reqLogin==null)
        {
            PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
            reqLogin=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return reqLogin;
        }
        return reqLogin;

    }
    public String getJsonPath(Response response,String key)
    {
        String resp=response.asString();
        JsonPath   js = new JsonPath(resp);
        return js.get(key);
    }

    public static String getGlobalValue(String key) throws IOException
    {
        Properties prop =new Properties();
        FileInputStream fis =new FileInputStream("C:\\Users\\Windows 11\\IdeaProjects\\RestAssured\\global.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }
}
