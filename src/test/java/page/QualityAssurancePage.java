package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QualityAssurancePage extends  BasePage{


    public static By allQAJobsButtonLocator=By.xpath("//a[normalize-space()='See all QA jobs']");

    public QualityAssurancePage(WebDriver driver) {
        super(driver);
    }

    public AllOpenPositionPage  clickAllQAJobs(){
        click(allQAJobsButtonLocator);
        return  new AllOpenPositionPage(driver);
    }
}
