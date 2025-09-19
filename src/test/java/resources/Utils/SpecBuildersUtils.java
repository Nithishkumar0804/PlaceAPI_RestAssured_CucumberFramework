package resources.Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class SpecBuildersUtils {
    static RequestSpecification reqSpec;
    ResponseSpecification resSpeq;
    RequestSpecification req;
    Response response;
    PrintStream log;

    public RequestSpecification requestSpecification() throws IOException {
        if (reqSpec == null) {
            log = new PrintStream(new File("Logging.text"));
            reqSpec = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUri"))
                    .addFilter(new RequestLoggingFilter(log)).addFilter(new ResponseLoggingFilter(log))
                    .addQueryParam("key", "qaclick123")
                    .setContentType(ContentType.JSON).build();
            return reqSpec;
        }
        return reqSpec;
    }

    public static String getGlobalValue(String key) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/Global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        return prop.getProperty(key);
    }

    public String getJsonValueFromKey(Response response, String key) {
        String responseString = response.asString();
        JsonPath js = new JsonPath(responseString);
        return js.get(key).toString();
    }

}
