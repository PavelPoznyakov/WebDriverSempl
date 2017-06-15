package selenium.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.NoSuchElementException;

public class SearchResultsPage extends BasePage {

    @FindBy(css="#content")
    private WebElement contentElement;

    @FindBys(@FindBy(css = "div[class*='yt-lockup-tile yt-lockup-video']"))
    private List<WebElement> videoElements;


    public SearchResultsPage(){
        super(true);
    }

    public SearchResultsPage(boolean openPageByUrl) {
        super(openPageByUrl);
    }

    @Override
    protected void openPage() {
        //do nothing
    }

    @Override
    public boolean isPageOpened() {
        try {
            return contentElement.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean hasResults() {
        return !videoElements.isEmpty();
    }
}