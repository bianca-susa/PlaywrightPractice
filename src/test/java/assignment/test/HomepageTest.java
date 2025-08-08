package assignment.test;

import assignment.pages.HeaderPage;
import assignment.pages.HomePage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomepageTest {
    private static Playwright playwright;
    private static Browser browser;
    private Page page;
    private HomePage homePage;

    @BeforeEach
    public void setUp()
    {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        page = browser.newPage();
        homePage = new HomePage(page);
    }

    @Test
    public void newProductsTest()
    {
        homePage.navigate();
        assert homePage.getNewProductsCount() == 5;
    }

    @AfterEach
    public void teardown()
    {
        browser.close();
        playwright.close();
    }
}
