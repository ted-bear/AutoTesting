package homework1;

import com.codeborne.selenide.Condition;
import org.junit.Test;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import java.io.*;

public class GoogleTest {

    @Test
    public void userCanSearch() throws IOException {
//        Properties properties = readPropertiesFile("src.main.resources");

        open("http://ok.ru");
        OkLoginPage results = new OkLoginPage();
        results.getEmail().setValue("teddi2x2@gmail.com");
        results.getPassword().setValue("cxm62qdRIEO");
        results.getButtonToLogIn().click();
        OkProfilePage profile = new OkProfilePage();
        profile.getProfileName().shouldHave(Condition.text("Егор Топорков"));
//        results.getResult(0).shouldHave(text("Selenide: concise UI tests in Java"));
    }

    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
}
