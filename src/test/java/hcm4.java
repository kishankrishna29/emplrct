
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class hcm4 extends base4

{
	
@Test(dataProvider = "login")
public void reg(String appname, String hiqlfc, String mbl, String email, String txp, String cexp, String corg, String cpost, String cctc, String ectc, String cwlctn, String skil) throws InterruptedException, IOException
{
	Actions act = new Actions(driver);
	driver.get("http://192.168.2.245:8181/applicant_registration");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"vacanyInfoTblId\"]/tbody/tr/td[1]/input")).click();
	driver.findElement(By.xpath("//*[@id=\"btnproceed\"]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"txtapplicantname\"]")).sendKeys(appname);
	driver.findElement(By.xpath("//*[@id=\"txtqualification\"]")).sendKeys(hiqlfc);
	driver.findElement(By.xpath("//*[@id=\"txtmobilenumber\"]")).sendKeys(mbl);
	driver.findElement(By.xpath("//*[@id=\"txtemail\"]")).sendKeys(email);
	driver.findElement(By.xpath("//*[@id=\"txttotalworkingexp\"]")).sendKeys(txp);
	driver.findElement(By.xpath("//*[@id=\"txtcurrentcompanyworkingexp\"]")).sendKeys(cexp);
	driver.findElement(By.xpath("//*[@id=\"txtcurrentorganization\"]")).sendKeys(corg);
	driver.findElement(By.xpath("//*[@id=\"txtcurrentposition\"]")).sendKeys(cpost);
	driver.findElement(By.xpath("//*[@id=\"txtcurrentCTC\"]")).sendKeys(cctc);
	driver.findElement(By.xpath("//*[@id=\"txtExpectedCTC\"]")).sendKeys(ectc);
	driver.findElement(By.xpath("//*[@id=\"txtcurrentworkinglocation\"]")).sendKeys(cwlctn);
	driver.findElement(By.xpath("//*[@id=\"txtkeyskills\"]")).sendKeys(skil);
	driver.findElement(By.xpath("//*[@id=\"resume\"]")).click();
	
	Thread.sleep(3000);
	Runtime.getRuntime().exec("C:\\Users\\cpui04\\git\\emplrct\\SM_DR_Upload_doc.exe");
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//*[@id=\"ddlsource_chzn\"]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"ddlsource_chzn\"]/div/div/input")).sendKeys("Web Portal");
	act.sendKeys(Keys.ENTER).build().perform();
	
	driver.findElement(By.xpath("//*[@id=\"btnsave\"]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button[2]")).click();
	Thread.sleep(3000);

	
}

@DataProvider
public Object[][] login() throws BiffException, IOException 
{
	  Object [][]data= getExcelDat();
	  
	  return data;

}
private Object[][] getExcelDat() throws BiffException, IOException
{
		FileInputStream fi= new FileInputStream("D:\\selenium\\rct files\\applicant.xls");
		Workbook wb= Workbook.getWorkbook(fi);
		Sheet sh= wb.getSheet("data");
		String[][] arexceldada = new String[sh.getRows()][sh.getColumns()];
		for (int i = 0; i < sh.getRows(); i++) 
		{
			for (int j = 0; j < sh.getColumns(); j++) 
			{
				arexceldada[i][j]=sh.getCell(j, i).getContents();
			}
		}
		return arexceldada;
	}

}