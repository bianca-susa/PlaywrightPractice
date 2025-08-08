//package assignment;
//
//import com.microsoft.playwright.Locator;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.options.AriaRole;
//import org.junit.jupiter.api.Test;
//
//import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
//
//public class SearchTests extends TestSetup {
//
//    @Test
//    void search()
//    {
//        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/");
//
//        Locator searchField = page.locator("#search");
//        assertThat(searchField).isVisible();
//        assertThat(searchField).isEnabled();
//        assertThat(searchField).isEditable();
//        searchField.clear();
//        assertThat(searchField).isEmpty();
//        searchField.fill("woman");
//        assertThat(searchField).hasValue("woman");
//
//        Locator submitButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
//        assertThat(submitButton).isVisible();
//        assertThat(submitButton).isEnabled();
//        submitButton.click();
//
//        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/catalogsearch/result/?q=woman");
//    }
//
//}
