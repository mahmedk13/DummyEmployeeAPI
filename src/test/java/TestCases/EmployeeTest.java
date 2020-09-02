package TestCases;



import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Utility.ExcelReader;
import Utility.TestSetup;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class EmployeeTest extends TestSetup {
	
	
		@Test
		public void Scenario1() {
		
		Response response =given()
						  .when()
						  .get("employees")
						  .then().extract().response();
		
		JsonPath jp = response.jsonPath();
		boolean flag=false;
		List<String> list = jp.get("data*.profile_image");
		
		for(String s:list) {
			if(s.isEmpty()) {
				flag=true;
			}
		}
		
		Assert.assertEquals(200, 200);
		Assert.assertEquals(true, flag);
	
		testLevelLogger.get().log(Status.PASS, "Scenario 1 test is passed");		
	}
		
		@Test
		public void Scenario2() {
			
			String path = System.getProperty("user.dir")+"\\src\\test\\resources\\ExcelFiles\\TestData.xlsx";
			ExcelReader excel=new ExcelReader(path);
			String param = excel.getCellData("Employees", 0, 1);
			String value = excel.getCellData("Employees", 1, 1);

			
			Response response =given()
					.when()
					.get(param+"/"+value)
					.then().extract().response();

			JsonPath jp = response.jsonPath();
			String successMsg =jp.get("message");
			
			Assert.assertEquals(200, 200);
			Assert.assertEquals("Successfully! Record has been fetched.", successMsg);

			testLevelLogger.get().log(Status.PASS, "Scenario 2 test is passed");		
		}


}
