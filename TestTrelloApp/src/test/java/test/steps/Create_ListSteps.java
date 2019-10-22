package test.steps;

import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.Interactions.DefaultInterations;
import test.jsons.UtilsJsons;
import test.modelo.BoardResponse;
import test.modelo.ListResponse;

public class Create_ListSteps {

	String key = "50322bf66cfbc3865f0a5398cf430724";
	String invalidKey = "InvalidKey";
	String token = "fb2253fc938002037c4aa86c4897be02dde7b964555112c25d332585a1600185";
	DefaultInterations boardInteracions = new DefaultInterations();
	BoardResponse objBodyBoard = new BoardResponse();
	ListResponse objBodyList = new ListResponse();
	BoardResponse objBodyfindBoard = new BoardResponse();
	String ResponseCreate = "";
	Create_BoardSteps create_BoardSteps = new Create_BoardSteps();
	String baseUrl = "https://api.trello.com/1/boards/";
	String baseUrlList = "https://api.trello.com/1/list/";
	UtilsJsons utilsJsons = new UtilsJsons();

	@Given("^I have a board created for the list$")
	public void i_have_a_board_created_for_the_list() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String myJsonBody = utilsJsons.GetCreateBoardJson();
		ResponseCreate = boardInteracions.GetResponseCreateABord(myJsonBody, 200, key, baseUrl);

		objBodyBoard = (BoardResponse) boardInteracions.ConvertJsonToObject(ResponseCreate, BoardResponse.class);

		Assert.assertEquals("TESTE01", objBodyBoard.getName().toString(), "Erro to insert board");
	}

	@When("^execute endpoint <\"([^\"]*)\"> to list$")
	public void execute_endpoint_to_list(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String myJsonBodyList = utilsJsons.GetCreateListJson(objBodyBoard);
		ResponseCreate = boardInteracions.GetResponseCreateAList(myJsonBodyList, 200, key, baseUrlList);
		objBodyList = (ListResponse) boardInteracions.ConvertJsonToObject(ResponseCreate, ListResponse.class);

		// Assert.assertEquals("TESTE01", objBodyBoard.getName().toString(), "Erro to
		// insert board");
	}

	@Then("^api will create a List for the user$")
	public void api_will_create_a_List_for_the_user() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@After("@List")
	public void DeleteBoardsToCard() {
		if (objBodyBoard.getId().toString() != "123") {

			ResponseCreate = boardInteracions.DeleteResponseABoard(objBodyBoard.getId().toString(), 200, key, token,
					baseUrl);

			objBodyBoard = (BoardResponse) boardInteracions.ConvertJsonToObject(ResponseCreate, BoardResponse.class);
		
		}

	}
	 

}
