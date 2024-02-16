package stepdefs;

import lombok.extern.log4j.Log4j2;
import org.mvss.karta.framework.annotations.ContextBean;
import org.mvss.karta.framework.annotations.StepDefinition;
import org.mvss.karta.framework.web.PageException;
import w3s.HTMLIntroductionPage;
import w3s.HomePage;
import w3s.LearnHTMLHomePage;
import w3s.W3SchoolsApp;
import java.io.IOException;

@Log4j2
public class SampleUIStepDefinition {

    @StepDefinition("the W3Schools site is launched in the browser") //
    public void the_w3schools_site_is_launched_in_the_browser(@ContextBean(W3SchoolsApp.W_3_SCHOOLS_APP) W3SchoolsApp w3SchoolsApp)
            throws PageException {
        w3SchoolsApp.init();
    }

    @StepDefinition("close W3Schools page")
    public void close_the_admin_console(@ContextBean(W3SchoolsApp.W_3_SCHOOLS_APP) W3SchoolsApp w3SchoolsApp) throws PageException {
        w3SchoolsApp.close();
    }

    @StepDefinition("take W3Schools screenshot")
    public void take_admin_console_screenshot(@ContextBean(W3SchoolsApp.W_3_SCHOOLS_APP) W3SchoolsApp w3SchoolsApp) throws IOException {
        w3SchoolsApp.getDriver().takeSnapshot("Screenshot-");
    }

    @StepDefinition("Learn HTML button from Home page is clicked")
    public void learn_html_button_from_home_page_is_clicked(@ContextBean(W3SchoolsApp.W_3_SCHOOLS_APP) W3SchoolsApp w3SchoolsApp)
            throws PageException {
        HomePage homePage = (HomePage) w3SchoolsApp.getCurrentPage();
        homePage.clickOnLearnHTML();
    }

    @StepDefinition("HTML introduction link from Learn HTML Home page is clicked")
    public void html_introduction_link_from_learn_html_home_page_is_clicked(@ContextBean(W3SchoolsApp.W_3_SCHOOLS_APP) W3SchoolsApp w3SchoolsApp)
            throws PageException {
        LearnHTMLHomePage learnHTMLHomePage = (LearnHTMLHomePage) w3SchoolsApp.getCurrentPage();
        learnHTMLHomePage.goToHTMLIntroductionPage();
    }

    @StepDefinition("Learn HTML home link from HTML introduction page is clicked")
    public void learn_html_home_link_from_html_introduction_page_is_clicked(@ContextBean(W3SchoolsApp.W_3_SCHOOLS_APP) W3SchoolsApp w3SchoolsApp)
            throws PageException {
        HTMLIntroductionPage htmlIntroductionPage = (HTMLIntroductionPage) w3SchoolsApp.getCurrentPage();
        htmlIntroductionPage.goToLearnHTMLHome();
    }

    @StepDefinition("W3 Schools home button from Learn HTML Home page is clicked")
    public void w3_schools_home_button_from_learn_html_home_page_is_clicked(@ContextBean(W3SchoolsApp.W_3_SCHOOLS_APP) W3SchoolsApp w3SchoolsApp)
            throws PageException {
        LearnHTMLHomePage learnHTMLHomePage = (LearnHTMLHomePage) w3SchoolsApp.getCurrentPage();
        learnHTMLHomePage.goToW3SchoolsHome();
    }

    @StepDefinition("fluent navigation on W3 Schools site is demonstrated")
    public void fluent_navigation_on_w3_schools_site_is_demonstrated(@ContextBean(W3SchoolsApp.W_3_SCHOOLS_APP) W3SchoolsApp w3SchoolsApp)
            throws PageException {
        assert ((HomePage) w3SchoolsApp.init()).clickOnLearnHTML().goToHTMLIntroductionPage().goToLearnHTMLHome().goToW3SchoolsHome()
                .clickOnLearnHTML().goToHTMLIntroductionPage().goToW3SchoolsHome().validate();
    }

}
