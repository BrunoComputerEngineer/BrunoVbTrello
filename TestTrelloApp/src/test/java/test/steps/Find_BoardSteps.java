package test.steps;

import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.Interactions.DefaultInterations;
import test.jsons.UtilsJsons;
import test.modelo.BoardResponse;

public class Find_BoardSteps {

	String key = "50322bf66cfbc3865f0a5398cf430724";
	String invalidKey = "InvalidKey";
	String token = "fb2253fc938002037c4aa86c4897be02dde7b964555112c25d332585a1600185";
	DefaultInterations boardInteracions = new DefaultInterations();
	BoardResponse objBodyBoard = new BoardResponse();
	BoardResponse objBodyfindBoard = new BoardResponse();
	String ResponseCreate = "";
	Create_BoardSteps create_BoardSteps = new Create_BoardSteps();
	String baseUrl = "https://api.trello.com/1/boards/";
	UtilsJsons utilsJsons = new UtilsJsons();
	
	
	@Given("^I have a board created and id$")
	public void i_have_a_board_created_and_id() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String myJsonBody = utilsJsons.GetCreateBoardJson();
		ResponseCreate = boardInteracions.GetResponseCreateABord(myJsonBody, 200, key, baseUrl);

		objBodyBoard = (BoardResponse) boardInteracions.ConvertJsonToObject(ResponseCreate, BoardResponse.class);

		Assert.assertEquals("TESTE01", objBodyBoard.getName().toString(), "Erro to insert board");
	}

	@When("^execute endpoint <\"([^\"]*)\"> with method GET$")
	public void execute_endpoint_with_method_GET(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		ResponseCreate = boardInteracions.GetResponseFindABoard(objBodyBoard.getId().toString(), 200, key, token,
				baseUrl);

		objBodyfindBoard = (BoardResponse) boardInteracions.ConvertJsonToObject(ResponseCreate, BoardResponse.class);

	}

	@Then("^api will Find a board for the user$")
	public void api_will_Find_a_board_for_the_user() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(objBodyBoard.getId().toString(), objBodyfindBoard.getId().toString());

	}

	@When("^execute endpoint <\"([^\"]*)\"> with method GET with invalid id board$")
	public void execute_endpoint_with_method_GET_with_invalid_id_board(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		ResponseCreate = boardInteracions.GetResponseFindABoard("invalidIdBoard", 400, key, token, baseUrl);
	}

	@Given("^I have a invalid id board$")
	public void i_have_a_invalid_id_board() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^api will not find a board for the user and show the message <\"([^\"]*)\">$")
	public void api_will_not_find_a_board_for_the_user_and_show_the_message(String message) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(message, ResponseCreate.toString());
	}

	@When("^execute endpoint <\"([^\"]*)\"> with method GET with invalid key$")
	public void execute_endpoint_with_method_GET_with_invalid_key(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		ResponseCreate = boardInteracions.GetResponseFindABoard(objBodyBoard.getId().toString(), 401, "123", token,
				baseUrl);
	}

	@When("^execute endpoint <\"([^\"]*)\"> with method GET with invalid token$")
	public void execute_endpoint_with_method_GET_with_invalid_token(String strg) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		ResponseCreate = boardInteracions.GetResponseFindABoard(objBodyBoard.getId().toString(), 401, key, "123",
				baseUrl);
	}

	@After("@find")
	public void DeleteFindBoards() {

		if (objBodyBoard.getId() != null) {
			ResponseCreate = boardInteracions.DeleteResponseABoard(objBodyBoard.getId().toString(), 200, key, token,
					baseUrl);

			objBodyBoard = (BoardResponse) boardInteracions.ConvertJsonToObject(ResponseCreate, BoardResponse.class);
		}

	}

}
