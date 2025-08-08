package assignment.test;

import assignment.pages.HeaderPage;
import assignment.pages.LoginPage;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HeaderTest {
    private static Playwright playwright;
    private static Browser browser;
    private Page page;
    private HeaderPage headerPage;

    @BeforeEach
    public void setUp()
    {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        page = browser.newPage();
        headerPage = new HeaderPage(page);
    }

    @Test
    public void searchTest()
    {
        String input = "a";
        headerPage.navigate();
        headerPage.search(input);

        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/catalogsearch/result/?q=" + input);
    }

    @Test
    public void accountButtonTest()
    {
        headerPage.navigate();
        headerPage.clickAccountButton();

        assert headerPage.isHeaderVisible();
    }

    @Test
    public void logoTest()
    {
        headerPage.navigate();
        headerPage.clickLogo();

        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/");
    }

    @AfterEach
    public void teardown()
    {
        browser.close();
        playwright.close();
    }
}
