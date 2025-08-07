package assignment;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTests extends TestSetup{

    @BeforeEach
    void navigateToLogin()
    {
        page.navigate("http://qa3magento.dev.evozon.com/customer/account/login/");
    }

    @Test
    void validLogin()
    {
        page.setDefaultTimeout(100000);

        Locator email = page.locator("#email");
        assertThat(email).isVisible();
        assertThat(email).isEditable();
        assertThat(email).isEnabled();
        assertThat(email).isEmpty();

        Locator password = page.locator("#pass");
        assertThat(password).isVisible();
        assertThat(password).isEditable();
        assertThat(password).isEnabled();
        assertThat(password).isEmpty();

        email.fill("email@email.com");
        assertThat(email).hasValue("email@email.com");
        password.fill("abcdef123");
        assertThat(password).hasValue("abcdef123");

        Locator loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
        assertThat(loginButton).isVisible();
        assertThat(loginButton).isEnabled();

        loginButton.click();
        System.out.println("Clicked login button");

        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/customer/account/");
    }

    @Test
    void invalidLogin()
    {
        Locator email = page.locator("#email");
        assertThat(email).isVisible();
        assertThat(email).isEditable();
        assertThat(email).isEnabled();
        assertThat(email).isEmpty();

        Locator password = page.locator("#pass");
        assertThat(password).isVisible();
        assertThat(password).isEditable();
        assertThat(password).isEnabled();
        assertThat(password).isEmpty();

        email.fill("email@email.com");
        assertThat(email).hasValue("email@email.com");
        password.fill("abc123");
        assertThat(password).hasValue("abc123");

        Locator loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
        assertThat(loginButton).isVisible();
        assertThat(loginButton).isEnabled();

        loginButton.click();
        System.out.println("Clicked login button.");

        Locator error = page.locator(".error-msg");
        assertThat(error).isVisible();
        assertThat(error).hasText("Invalid login or password.");

    }

    @Test
    void emptyEmailLogin()
    {
        Locator email = page.locator("#email");
        assertThat(email).isVisible();
        assertThat(email).isEditable();
        assertThat(email).isEnabled();
        assertThat(email).isEmpty();

        Locator password = page.locator("#pass");
        assertThat(password).isVisible();
        assertThat(password).isEditable();
        assertThat(password).isEnabled();
        assertThat(password).isEmpty();

        Locator loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
        assertThat(loginButton).isVisible();
        assertThat(loginButton).isEnabled();

        loginButton.click();

        assertThat(email).containsClass("validation-failed");
    }

    @Test
    void emptyPasswordLogin()
    {
        Locator email = page.locator("#email");
        assertThat(email).isVisible();
        assertThat(email).isEditable();
        assertThat(email).isEnabled();
        assertThat(email).isEmpty();

        Locator password = page.locator("#pass");
        assertThat(password).isVisible();
        assertThat(password).isEditable();
        assertThat(password).isEnabled();
        assertThat(password).isEmpty();

        email.fill("email@email.com");
        assertThat(email).hasValue("email@email.com");

        Locator loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
        assertThat(loginButton).isVisible();
        assertThat(loginButton).isEnabled();

        loginButton.click();

        Locator error = page.locator(".error-msg");
        assertThat(error).isVisible();
        assertThat(error).hasText("Login and password are required.");
    }


}
