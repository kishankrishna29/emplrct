import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class hcm7 extends base4
{

	@Test(dataProvider = "login")
	public void reg(String appname,String slttxt,String vals) throws InterruptedException, IOException
	{
		Actions act = new Actions(driver);
		
		driver.get("http://192.168.2.245:8181/interviewer");
		
		driver.findElement(By.xpath("//*[@id='interviewlist_filter']/label/input")).sendKeys(appname);
		
		System.out.println("Applicant Name is ::"+" "+appname);
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='interviewlist']/tbody/tr/td[9]/input")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"ofctcid\"]")).sendKeys("10.55");

		Select slt = new Select(driver.findElement(By.xpath("//*[@id='schedulestatusid']")));
		slt.selectByVisibleText(slttxt);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='commentid']")).sendKeys(vals);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='schedulestatusid']")).click();
		
		driver.findElement(By.xpath("//*[@id='updateid']")).click();
		Thread.sleep(3000);
	
		driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button[2]")).click();
	

		Thread.sleep(5000);
	}

	@DataProvider
	public Object[][] login() throws BiffException, IOException 
	{
		  Object [][]data= getExcelDat();
		  
		  return data;

	}
	private Object[][] getExcelDat() throws BiffException, IOException
	{
			FileInputStream fi= new FileInputStream("D:\\selenium\\rct files\\applicant_wg.xls");
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
