
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class hcm3 extends base3

{
	
@Test(dataProvider = "login")
public void reg(String id, String pd) throws InterruptedException, IOException
{
	Actions act = new Actions(driver);
	WebElement uname = driver.findElement(By.xpath("//*[@id='employeecode']"));
	act.sendKeys(uname,id).build().perform();
	WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
	act.sendKeys(pwd,pd).build().perform();
	driver.findElement(By.xpath("//*[@id='loginid']/h4")).click();
	driver.get("http://192.168.2.140:8282/thcm/permissionform");
	driver.findElement(By.xpath("//*[@id='applybtnid']")).click();
	Thread.sleep(2000);
//	driver.findElement(By.xpath("//*[@id='datepicker']")).click();
//	List<WebElement>Calendar_Days_Table_RowCells = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a"));
//	System.out.println("dates displaying as "+" "+Calendar_Days_Table_RowCells.size());
//	Select slt = new Select(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]")));
//	slt.selectByVisibleText(year);
//	Select slt2 = new Select(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[1]")));
//	slt2.selectByVisibleText(mnth);
//	Thread.sleep(3000); 
//	System.out.println("dates displaying as "+" "+Calendar_Days_Table_RowCells.size());
//	
//	for (int i = 0; i < Calendar_Days_Table_RowCells.size(); i++) 
//	{ 
//		String Date_val = Calendar_Days_Table_RowCells.get(i).getText();
//		System.out.println(Date_val);
//		
//			if (Date_val.equals(date)) 
//			{
//				Calendar_Days_Table_RowCells.get(i).click();
//				Thread.sleep(4000);
//				
//				WebElement mnt_pt = driver.findElement(By.xpath("//*[@id='PermissionTypeid']"));
//				Select slt3 = new Select(mnt_pt);
//				slt3.selectByVisibleText("Monthly Permission");
//				
//				WebElement p_nxt_d = driver.findElement(By.xpath("//*[@id='ddlpermissionextendstonextday']"));
//				Select slt4 = new Select(p_nxt_d);
//				slt4.selectByVisibleText("Yes");
//				
//				WebElement nr_per = driver.findElement(By.xpath("//*[@id='NonReturnablePermission']"));
//				Select slt5 = new Select(nr_per);
//				slt5.selectByVisibleText("Yes");
//				
//				WebElement resn = driver.findElement(By.xpath("//*[@id='reason']"));
//				act.sendKeys(resn,"Test permission Apply").build().perform();
//				Thread.sleep(2000);
//				
				
//				driver.findElement(By.id("btnsave")).click();
//				Thread.sleep(2000);
//				driver.findElement(By.xpath("/html/body/div[11]/div/div/div[2]/button[2]")).click();
//				Thread.sleep(2000);
//		}
//	}
	
		driver.findElement(By.xpath("//*[@id='timeinid']")).click();
		WebElement text_frm = driver.findElement(By.xpath("/html/body/div[10]/table/tbody/tr[2]/td[1]/input"));
		act.sendKeys(text_frm,"01").sendKeys(Keys.TAB).sendKeys("00").sendKeys(Keys.TAB).sendKeys("PM").sendKeys(Keys.TAB).build().perform();
		
		driver.findElement(By.xpath("//*[@id='timeoutid']")).click();
		WebElement text_to = driver.findElement(By.xpath("/html/body/div[10]/table/tbody/tr[2]/td[1]/input"));
		act.sendKeys(text_to,"03").sendKeys(Keys.TAB).sendKeys("00").sendKeys(Keys.TAB).sendKeys("PM").sendKeys(Keys.TAB).build().perform();
				
}

@DataProvider
public Object[][] login() throws BiffException, IOException 
{
	  Object [][]data= getExcelDat();
	  
	  return data;

}
private Object[][] getExcelDat() throws BiffException, IOException
{
		FileInputStream fi= new FileInputStream("D:\\Leo_Projects\\HCM\\HCM_perdata.xls");
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