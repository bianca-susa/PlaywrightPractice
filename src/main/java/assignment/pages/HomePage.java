package assignment.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;
    private Locator newProductsList;

    public HomePage(Page page)
    {
        this.page = page;
        this.newProductsList = page.locator("ul.products-grid.products-grid--max-5-col-widget > li");
    }

    public void navigate()
    {
        page.navigate("http://qa3magento.dev.evozon.com/");
    }

    public int getNewProductsCount()
    {
        return newProductsList.count();
    }
}
