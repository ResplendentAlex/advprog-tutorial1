package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.util.List;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {
    /**
     * The port number assigned to the running application during test execution.
     * Set automatically during each test run bby Spring Framework's test context.
     */
    @LocalServerPort
    private int serverPort;

    /**
     * The base URL for testing. Default to {@code http://localhost}.
     */
    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void pageTitle_isCorrect(ChromeDriver driver) throws Exception {
        // Exercise
        driver.get(baseUrl);

        WebElement productListButton = driver.findElement(By.className("btn-primary"));
        productListButton.click();

        WebElement createProductButton = driver.findElement(By.className("btn-primary"));
        createProductButton.click();

        String title = driver.getTitle();

        // Verify
        assertEquals("Create New Product", title);
    }

    @Test
    void createProductPage_isCorrect(ChromeDriver driver) throws Exception {
        // Exercise
        driver.get(baseUrl);

        WebElement productListButton = driver.findElement(By.className("btn-primary"));
        productListButton.click();

        WebElement createProductButton = driver.findElement(By.className("btn-primary"));
        createProductButton.click();

        List<WebElement> inputElements = driver.findElements(By.tagName("input"));

        // Verify
        assertEquals(2, inputElements.size());
    }

    @Test
    void createProduct_isCorrect(ChromeDriver driver) throws Exception {
        // Exercise
        driver.get(baseUrl);

        WebElement productListButton = driver.findElement(By.className("btn-primary"));
        productListButton.click();

        String pageTitle1 = driver.getTitle();
        assertEquals("Product List", pageTitle1);

        WebElement createProductButton = driver.findElement(By.className("btn-primary"));
        createProductButton.click();

        String pageTitle2 = driver.getTitle();
        assertEquals("Create New Product", pageTitle2);

        String productName = "Sampo Cap Bambang";
        String productQuantity = "100";

        WebElement productNameInput = driver.findElement(By.id("nameInput"));
        productNameInput.sendKeys(productName);
        WebElement productQuantityInput = driver.findElement(By.id("quantityInput"));
        productQuantityInput.sendKeys(productQuantity);

        WebElement submitButton = driver.findElement(By.className("btn-primary"));
        submitButton.click();

        String pageTitle3 = driver.getTitle();
        assertEquals("Product List", pageTitle3);

        List<WebElement> newProductRow = driver.findElements(By.tagName("tr"));
        assertEquals(2, newProductRow.size());

        WebElement productNameOnList = driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]", productName)));
        WebElement productQuantityOnList = driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]", productQuantity)));

        // Verify
        assertNotNull(productNameOnList);
        assertNotNull(productQuantityOnList);
    }
}
