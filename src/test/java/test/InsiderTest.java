package test;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class InsiderTest extends  BaseTest{

    HomePage homePage;
    CareersPage careersPage;
    QualityAssurancePage qualityAssurancePage;
    AllOpenPositionPage allOpenPositionPage;
    LeverAppFormPage leverAppFormPage;


    @Test
    @Description("Insider Test Cases")
    public void test() throws InterruptedException {
        //initializeBrowser("chrome");
        homePage= new HomePage(driver);
        careersPage =new CareersPage(driver);
        qualityAssurancePage=new QualityAssurancePage(driver);
        allOpenPositionPage=new AllOpenPositionPage(driver);
        leverAppFormPage=new LeverAppFormPage(driver);

        homePage.getInsiderPage()
                .acceptCookies()
                .isInsiderMainPageOpened()
                .clickCareersButton();

        careersPage.verifyCareersPageOpened()
                .checkIfBlocksOfCareerPageLoaded()
                .clickSeeAllTeams()
                .clickQualityAssurance();
        qualityAssurancePage.clickAllQAJobs();
        allOpenPositionPage.clickFilterLocationDropdown()
                .selectLocationForIstanbul()
                .selectDepartmentForQualityAssurance()
                .checkJobList()
                        .selectApplyNow()
                                .checkIsOpenedLeverApplicationPage();












    }

}
