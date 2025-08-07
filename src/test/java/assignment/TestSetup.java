package assignment;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestSetup {
    static Playwright playwright;
    static Browser browser;
    Page page;

    @BeforeAll
    static void setupClass()
    {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @BeforeEach
    void setupTest()
    {
        BrowserContext context = browser.newContext();
        page = context.newPage();
        page.navigate("http://qa3magento.dev.evozon.com/");
    }

    @AfterEach
    void teardownAll()
    {
        page.close();
    }

}
