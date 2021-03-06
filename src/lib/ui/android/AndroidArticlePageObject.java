package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject extends ArticlePageObject {
    static {
                title = "id:org.wikipedia:id/view_page_title_text";
                footerElement = "xpath://*[@text = 'View page in browser']";
                optionsButton = "xpath://android.widget.ImageView[@content-desc='More options']";
                optionsAddToMyListButton = "xpath://*[@text='Add to reading list']";
                gotItButton = "id:org.wikipedia:id/onboarding_button";
                myListName = "id:org.wikipedia:id/text_input";
                myListOkButton = "xpath://*[@text='OK']";
                closeMyListButton = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
                folderByNameTPL = "xpath://*[@text='{FolderName}']";
                subtitleBySubstringTPL = "xpath://*[@text='{SUBSTRING}']";
    }

    public AndroidArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }
}

