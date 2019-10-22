package test.steps;

import org.testng.Assert;
import test.Interactions.DefaultInterations;
import test.jsons.UtilsJsons;
import test.modelo.BoardResponse;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Create_BoardSteps {

	String key = "50322bf66cfbc3865f0a5398cf430724";
	String invalidKey = "InvalidKey";
	String token = "fb2253fc938002037c4aa86c4897be02dde7b964555112c25d332585a1600185";
	DefaultInterations boardInteracions = new DefaultInterations();
	BoardResponse objBodyBoard = new BoardResponse();
	String ResponseCreate = "";
	UtilsJsons utilsJsons = new UtilsJsons();
	String baseUrl = "https://api.trello.com/1/boards/";

	@Given("^that I own the key and the token$")
	public void that_I_own_the_key_and_the_token() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^execute endpoint <\"([^\"]*)\">$")
	public void execute_endpoint(String baseUrl) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String myJsonBody = utilsJsons.GetCreateBoardJson();
		ResponseCreate = boardInteracions.GetResponseCreateABord(myJsonBody, 200, key, baseUrl);

		objBodyBoard = (BoardResponse) boardInteracions.ConvertJsonToObject(ResponseCreate, BoardResponse.class);
	}

	@Then("^api will create a board for the user$")
	public void api_will_create_a_board_for_the_user() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("TESTE01", objBodyBoard.getName().toString(), "Erro to insert board");
	}

	@When("^execute endpoint <\"([^\"]*)\"> with invalid token$")
	public void execute_endpoint_with_invalid_token(String baseUrl) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String myJsonBody = utilsJsons.GetCreateBoardinvalidTokenJson();

		ResponseCreate = boardInteracions.GetResponseCreateABord(myJsonBody, 401, key, baseUrl);

	}

	@Then("^api will not create a board for the user$")
	public void api_will_not_create_a_board_for_the_user() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("invalid token", ResponseCreate.toString());
	}

	@When("^execute endpoint <\"([^\"]*)\"> with invalid key$")
	public void execute_endpoint_with_invalid_key(String baseUrl) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String myJsonBody = utilsJsons.GetCreateBoardJson();

		ResponseCreate = boardInteracions.GetResponseCreateABord(myJsonBody, 401, invalidKey, baseUrl);
	}

	@Then("^api will not create a board for the user and show the message <\"([^\"]*)\">$")
	public void api_will_not_create_a_board_for_the_user_and_show_the_message(String message) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(message, ResponseCreate.toString());
	}
	
	@After("@Board")
	public void DeleteBoardsToCard() {

			try {
				
				ResponseCreate = boardInteracions.DeleteResponseABoard(objBodyBoard.getId().toString(), 200, key, token,
						baseUrl);

				objBodyBoard = (BoardResponse) boardInteracions.ConvertJsonToObject(ResponseCreate, BoardResponse.class);
			
				
			}catch(Exception e ) {
				
				
				
			}
		
		
		}
		

	}

