package test.steps;

import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.Interactions.DefaultInterations;
import test.jsons.UtilsJsons;
import test.modelo.BoardResponse;
import test.modelo.ListResponse;

public class Create_CardSteps {

	String key = "50322bf66cfbc3865f0a5398cf430724";
	String invalidKey = "InvalidKey";
	String token = "fb2253fc938002037c4aa86c4897be02dde7b964555112c25d332585a1600185";
	DefaultInterations boardInteracions = new DefaultInterations();
	BoardResponse objBodyBoard;
	ListResponse objBodyList;
	BoardResponse objBodyfindBoar;
	ListResponse objBodyCard;
	String ResponseCreate = "";
	String ResponseCreateCard = "";
	Create_BoardSteps create_BoardSteps = new Create_BoardSteps();
	String baseUrl = "https://api.trello.com/1/boards/";
	String baseUrlList = "https://api.trello.com/1/list/";
	String baseUrlCard = "https://api.trello.com/1/cards/";
	UtilsJsons utilsJsons = new UtilsJsons();

	@Before("@Card")
	public void InstCard() {
		objBodyBoard = new BoardResponse();
		objBodyList = new ListResponse();
		objBodyfindBoar = new BoardResponse();
		objBodyCard = new ListResponse();

	}

	@Given("^I have a board created for the card$")
	public void i_have_a_board_created_for_the_card() throws Throwable {

		// Create Board
		String myJsonBody = utilsJsons.GetCreateBoardJson();

		ResponseCreate = boardInteracions.GetResponseCreateABord(myJsonBody, 200, key, baseUrl);

		objBodyBoard = (BoardResponse) boardInteracions.ConvertJsonToObject(ResponseCreate, BoardResponse.class);

		// Create List to Board
		String myJsonBodyList = utilsJsons.GetCreateListJson(objBodyBoard);

		ResponseCreate = boardInteracions.GetResponseCreateAList(myJsonBodyList, 200, key, baseUrlList);

		objBodyList = (ListResponse) boardInteracions.ConvertJsonToObject(ResponseCreate, ListResponse.class);

	}

	@When("^execute endpoint <\"([^\"]*)\"> to card$")
	public void execute_endpoint_to_card(String endpoint) throws Throwable {

		String myJsonBodyCard = utilsJsons.GetCreateCardJson(objBodyBoard, objBodyList);

		ResponseCreateCard = boardInteracions.GetResponseCreateACard(myJsonBodyCard, 200, key, endpoint);

		objBodyCard = (ListResponse) boardInteracions.ConvertJsonToObject(ResponseCreateCard, ListResponse.class);
	}

	@Then("^api will create a card for the user$")
	public void api_will_create_a_card_for_the_user() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^the status code will be <\"([^\"]*)\">$")
	public void the_status_code_will_be(String arg1) throws Throwable {

	}

	@Given("^that I pass a non-existent id list$")
	public void that_I_pass_a_non_existent_id_list() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		objBodyList.setId("123");
		objBodyBoard.setId("123");

	}

	@When("^execute endpoint <\"([^\"]*)\"> to card with id List invalid$")
	public void execute_endpoint_to_card_with_id_List_invalid(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String myJsonBodyCard = utilsJsons.GetCreateCardJson(objBodyBoard, objBodyList);

		ResponseCreateCard = boardInteracions.GetResponseCreateACard(myJsonBodyCard, 400, key, baseUrlCard);
	}

	@Then("^the API will not create a card for the user\\.$")
	public void the_API_will_not_create_a_card_for_the_user() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^the message response will be <\"([^\"]*)\">$")
	public void the_message_response_will_be(String messageError) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(ResponseCreateCard, messageError);

	}

	@Given("^that I pass a invalid key for the api$")
	public void that_I_pass_a_invalid_key_for_the_api() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		objBodyList.setId("123");
		objBodyBoard.setId("123");
		String myJsonBodyCard = utilsJsons.GetCreateCardJson(objBodyBoard, objBodyList);

		ResponseCreateCard = boardInteracions.GetResponseCreateACard(myJsonBodyCard, 401, invalidKey, baseUrlCard);
	}

	@When("^execute endpoint <\"([^\"]*)\"> to card with invalid key$")
	public void execute_endpoint_to_card_with_invalid_key(String messageError) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Given("^that I pass a invalid token for the api$")
	public void that_I_pass_a_invalid_token_for_the_api() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		objBodyList.setId("123");
		objBodyBoard.setId("123");
		String myJsonBodyCard = utilsJsons.GetCreateCardInvalidTokenJson(objBodyBoard, objBodyList);
		ResponseCreateCard = boardInteracions.GetResponseCreateACard(myJsonBodyCard, 401, key, baseUrlCard);
	}

	@When("^execute endpoint <\"([^\"]*)\"> to card with invalid token$")
	public void execute_endpoint_to_card_with_invalid_token(String messageError) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Given("^I didn't pass an id list in the body of the request$")
	public void i_didn_t_pass_an_id_list_in_the_body_of_the_request() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		objBodyList.setId("123");
		objBodyBoard.setId("123");
		String myJsonBodyCard = utilsJsons.GetCreateCardWithoutIdListJson(objBodyBoard, objBodyList);
		ResponseCreateCard = boardInteracions.GetResponseCreateACard(myJsonBodyCard, 400, key, baseUrlCard);
	}

	@When("^execute endpoint <\"([^\"]*)\"> to card without id List$")
	public void execute_endpoint_to_card_without_id_List(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@After("@Card")
	public void DeleteBoardsToCard() {
		try {
			if (objBodyBoard.getId().toString() != "123") {
				ResponseCreate = boardInteracions.DeleteResponseABoard(objBodyBoard.getId().toString(), 200, key, token,
						baseUrl);

				objBodyBoard = (BoardResponse) boardInteracions.ConvertJsonToObject(ResponseCreate,
						BoardResponse.class);
			}
		} catch (Exception e) {

		}

	}

}
