package FRAMEWORK;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.opencsv.CSVWriter;

public class UtilScreenshotAndReport {

	public ExtentHtmlReporter htmlReport;
	public static ExtentReports extent;
	public static ExtentTest test;
	static String year;
	static String time;

	public String takeScreenShot(WebDriver driver, String TestCase_No) throws IOException {

		ScreenshotPathFormat();
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		ConnectDataSheet.destFileScrnshot = System.getProperty("user.dir") + File.separator + "Screenshot"
				+ File.separator + year + File.separator + time + File.separator + TestCase_No + ".png";
		FileUtils.copyFile(srcFile, new File(ConnectDataSheet.destFileScrnshot));
		return ConnectDataSheet.destFileScrnshot;
	}

	public void ScreenshotPathFormat() {
		Date date = new Date();
		SimpleDateFormat tm = new SimpleDateFormat("yyyy-MM-dd");
		year = tm.format(date);
		SimpleDateFormat tm1 = new SimpleDateFormat("HH_mm_ss");
		time = tm1.format(date);
	}

	public void extentReport() throws IOException {
		ScreenshotPathFormat();
		String htmlFile = "students.html";
		String destFile = System.getProperty("user.dir") + File.separator + "ExtentReport" + File.separator + year
				+ File.separator + time;
		new File(destFile).mkdirs();
		htmlReport = new ExtentHtmlReporter(destFile + "File.separator" + htmlFile);

		htmlReport.config().setDocumentTitle("Automation Report");// Title of the report
		htmlReport.config().setReportName("Functional Report");// Name of the report
		htmlReport.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.setSystemInfo("Comapny Name", "APMOSYS");
		extent.setSystemInfo("Project Name", "ISHINE");
		extent.setSystemInfo("Test Lead", "Prabhat Padhy");
		extent.attachReporter(htmlReport);
		extent.setSystemInfo("OS", "Window11");
		extent.setSystemInfo("Tester Name", "Biswajit");
		extent.setSystemInfo("Browser", ConnectToMainController.Browser);

	}

	public static void testcaseInfo(String Description) {
		test.log(Status.INFO, Description);
	}

	public static void testCaseCreate(String tc) {
		test = extent.createTest(tc);
	}

	public void passTestCase(WebDriver driver, String TestCase_No, String Description) throws IOException {
		test.log(Status.INFO, MarkupHelper.createLabel(Description, ExtentColor.GREEN));
		test.log(Status.PASS, "",
				MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, TestCase_No)).build());
	}

	public void failTestCase(WebDriver driver, String TestCase_No, String Neg_Description) throws IOException {
		test.log(Status.INFO, MarkupHelper.createLabel(Neg_Description, ExtentColor.RED));
		test.log(Status.FAIL, "",
				MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, TestCase_No)).build());
	}

	public void ExtentFlush() {
		extent.flush();
	}

	/////// CSV FILE CREATE///////////////////////////

	String csvFile = "students.csv";
	String destFile;

	public void CsvFileCreate() throws IOException {

		Date date = new Date();
		SimpleDateFormat tm = new SimpleDateFormat("yyyy-MM-dd");
		String year = tm.format(date);
		SimpleDateFormat tm1 = new SimpleDateFormat("HH_mm_ss");
		String time = tm1.format(date);
		destFile = System.getProperty("user.dir") + File.separator + "CSVFile" + File.separator + year + File.separator
				+ time;
		new File(destFile).mkdirs();

	}

	public void WriteCSVFile(String Si_No, String TestCase_No, String Status, String Screenshot_Path)
			throws IOException {

		FileWriter fileWriter = new FileWriter(destFile + File.separator + csvFile, true);
		CSVWriter cw = new CSVWriter(fileWriter);
		String line1[] = { Si_No, TestCase_No, Status, Screenshot_Path };

		// Writing data to the csv file
		cw.writeNext(line1);
		// close the file
		cw.close();
	}

}
