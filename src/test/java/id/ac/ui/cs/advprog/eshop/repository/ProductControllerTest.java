package id.ac.ui.cs.advprog.eshop.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.openqa.selenium.Alert;
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

public class ProductControllerTest {
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
    void setUp() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void testOpenCreateProductPage(ChromeDriver driver) throws Exception {
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
    void testCreateProduct(ChromeDriver driver) throws Exception {
        // Exercise
        driver.get(baseUrl);

        WebElement productListButton = driver.findElement(By.className("btn-primary"));
        productListButton.click();

        WebElement createProductButton = driver.findElement(By.className("btn-primary"));
        createProductButton.click();

        String productName = "Sampo Cap Bambang";
        String productQuantity = "100";

        WebElement productNameInput = driver.findElement(By.id("nameInput"));
        productNameInput.sendKeys(productName);
        WebElement productQuantityInput = driver.findElement(By.id("quantityInput"));
        productQuantityInput.sendKeys(productQuantity);

        WebElement submitButton = driver.findElement(By.className("btn-primary"));
        submitButton.click();

        WebElement productNameOnList = driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]", productName)));
        WebElement productQuantityOnList = driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]", productQuantity)));

        // Verify
        assertNotNull(productNameOnList);
        assertNotNull(productQuantityOnList);
    }

    @Test
    void testOpenEditProductPage(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);

        WebElement productListButton = driver.findElement(By.className("btn-primary"));
        productListButton.click();

        WebElement createProductButton = driver.findElement(By.className("btn-primary"));
        createProductButton.click();

        String productName = "Sampo Cap Bambang";
        String productQuantity = "100";

        WebElement productNameInput = driver.findElement(By.id("nameInput"));
        productNameInput.sendKeys(productName);
        WebElement productQuantityInput = driver.findElement(By.id("quantityInput"));
        productQuantityInput.sendKeys(productQuantity);
        WebElement submitButton = driver.findElement(By.className("btn-primary"));
        submitButton.click();

        WebElement editProductButton = driver.findElement(By.id("editButton"));
        editProductButton.click();

        String newProductName = "Sampo Cap Asep";
        String newProductQuantity = "50";

        WebElement newProductNameInput = driver.findElement(By.id("nameInput"));
        newProductNameInput.clear();
        newProductNameInput.sendKeys(newProductName);
        WebElement newProductQuantityInput = driver.findElement(By.id("quantityInput"));
        newProductQuantityInput.clear();
        newProductQuantityInput.sendKeys(newProductQuantity);
        WebElement newSubmitButton = driver.findElement(By.className("btn-primary"));
        newSubmitButton.click();

        WebElement productNameOnList = driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]", newProductName)));
        WebElement productQuantityOnList = driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]", newProductQuantity)));

        // Verify
        assertNotNull(productNameOnList);
        assertNotNull(productQuantityOnList);
    }

    @Test
    void testDeleteProduct(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);

        WebElement productListButton = driver.findElement(By.className("btn-primary"));
        productListButton.click();

        WebElement createProductButton = driver.findElement(By.className("btn-primary"));
        createProductButton.click();

        String productName = "Sampo Cap Bambang";
        String productQuantity = "100";

        WebElement productNameInput = driver.findElement(By.id("nameInput"));
        productNameInput.sendKeys(productName);
        WebElement productQuantityInput = driver.findElement(By.id("quantityInput"));
        productQuantityInput.sendKeys(productQuantity);
        WebElement submitButton = driver.findElement(By.className("btn-primary"));
        submitButton.click();

        WebElement deleteProductButton = driver.findElement(By.id("deleteButton"));
        deleteProductButton.click();

        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.accept();

        List<WebElement> newProductRow = driver.findElements(By.tagName("tr"));
        assertEquals(2, newProductRow.size());
    }

}
