package test.steps;

import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.Interactions.DefaultInterations;
import test.jsons.UtilsJsons;
import test.modelo.BoardResponse;
import test.modelo.ListResponse;

public class Update_CardSteps {

	String key = "50322bf66cfbc3865f0a5398cf430724";
	String invalidKey = "InvalidKey";
	String token = "fb2253fc938002037c4aa86c4897be02dde7b964555112c25d332585a1600185";
	DefaultInterations boardInteracions = new DefaultInterations();
	BoardResponse objBodyBoard;
	ListResponse objBodyList;
	BoardResponse objBodyfindBoar;
	ListResponse objBodyUpdateCard;
	ListResponse objBodyCard;
	String ResponseCreate = "";
	String ResponseCreateCard = "";
	String ResponseUpdateCard = "";
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
		objBodyUpdateCard = new ListResponse();

	}

	@Given("^I have a board created for the update a card$")
	public void i_have_a_board_created_for_the_update_a_card() throws Throwable {

		// Create Board
		String myJsonBody = utilsJsons.GetCreateBoardJson();

		ResponseCreate = boardInteracions.GetResponseCreateABord(myJsonBody, 200, key, baseUrl);

		objBodyBoard = (BoardResponse) boardInteracions.ConvertJsonToObject(ResponseCreate, BoardResponse.class);

		// Create List to Board
		String myJsonBodyList = utilsJsons.GetCreateListJson(objBodyBoard);

		ResponseCreate = boardInteracions.GetResponseCreateAList(myJsonBodyList, 200, key, baseUrlList);

		objBodyList = (ListResponse) boardInteracions.ConvertJsonToObject(ResponseCreate, ListResponse.class);

		// Create Card
		String myJsonBodyCard = utilsJsons.GetCreateCardJson(objBodyBoard, objBodyList);

		ResponseCreateCard = boardInteracions.GetResponseCreateACard(myJsonBodyCard, 200, key, baseUrlCard);

		objBodyCard = (ListResponse) boardInteracions.ConvertJsonToObject(ResponseCreateCard, ListResponse.class);

	}

	@When("^execute endpoint <\"([^\"]*)\"> to card update$")
	public void execute_endpoint_to_card_update(String endpoint) throws Throwable {

		// Update Card
		String myJsonBodyUpdateCard = utilsJsons.GetUpdateCardJson(objBodyBoard, objBodyList);

		ResponseUpdateCard = boardInteracions.GetResponseUpdateACard(myJsonBodyUpdateCard, 200,
				objBodyCard.getId().toString(), key, token, endpoint);

		objBodyUpdateCard = (ListResponse) boardInteracions.ConvertJsonToObject(ResponseUpdateCard, ListResponse.class);

	}

	@Then("^api will update a card for the user$")
	public void api_will_update_a_card_for_the_user() throws Throwable {

	}

	@Then("^the name of card is change to <\"([^\"]*)\">$")
	public void the_name_of_card_is_change_to(String cardName) throws Throwable {

		Assert.assertEquals(objBodyUpdateCard.getName(), cardName);

	}

	@Then("^the desc of card is change to <\"([^\"]*)\">$")
	public void the_desc_of_card_is_change_to(String descName) throws Throwable {

		Assert.assertEquals(objBodyUpdateCard.getDesc(), descName);

	}

	@Given("^that I have an invalid id card$")
	public void that_I_have_an_invalid_id_card() throws Throwable {
		objBodyCard = new ListResponse();
		// Write code here that turns the phrase above into concrete actions
		objBodyCard.setId("i");
	}

	@When("^execute endpoint <\"([^\"]*)\"> to card update with invalid id card$")
	public void execute_endpoint_to_card_update_with_invalid_id_card(String arg1) throws Throwable {

		// Update Card
		String myJsonBodyUpdateCard = utilsJsons.GetUpdateCardJson(objBodyBoard, objBodyList);

		ResponseUpdateCard = boardInteracions.GetResponseUpdateACard(myJsonBodyUpdateCard, 400,
				objBodyCard.getId().toString(), key, token, baseUrlCard);
	}

	@Then("^api will not update a card for the user$")
	public void api_will_not_update_a_card_for_the_user() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^the message of response is <\"([^\"]*)\">$")
	public void the_message_of_response_is(String messageError) throws Throwable {

		Assert.assertEquals(ResponseUpdateCard.toString(), messageError);
	}

	@Given("^that I have an invalid key$")
	public void that_I_have_an_invalid_key() throws Throwable {

	}

	@When("^execute endpoint <\"([^\"]*)\"> to card update with invalid key$")
	public void execute_endpoint_to_card_update_with_invalid_key(String arg1) throws Throwable {

		// Update Card
		String myJsonBodyUpdateCard = utilsJsons.GetUpdateCardJson(objBodyBoard, objBodyList);

		ResponseUpdateCard = boardInteracions.GetResponseUpdateACard(myJsonBodyUpdateCard, 401, "123", invalidKey,
				token, baseUrlCard);

	}

	@Given("^that I have an invalid token$")
	public void that_I_have_an_invalid_token() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^execute endpoint <\"([^\"]*)\"> to card update with invalid token$")
	public void execute_endpoint_to_card_update_with_invalid_token(String arg1) throws Throwable {

		// Update Card
		String myJsonBodyUpdateCard = utilsJsons.GetUpdateCardJson(objBodyBoard, objBodyList);

		ResponseUpdateCard = boardInteracions.GetResponseUpdateACard(myJsonBodyUpdateCard, 401, "123", key, "123",
				baseUrlCard);
	}

	@Given("^I have a board created for the update a card without changing anything$")
	public void i_have_a_board_created_for_the_update_a_card_without_changing_anything() throws Throwable {

		// Create Board
		String myJsonBody = utilsJsons.GetCreateBoardJson();

		ResponseCreate = boardInteracions.GetResponseCreateABord(myJsonBody, 200, key, baseUrl);

		objBodyBoard = (BoardResponse) boardInteracions.ConvertJsonToObject(ResponseCreate, BoardResponse.class);

		// Create List to Board
		String myJsonBodyList = utilsJsons.GetCreateListJson(objBodyBoard);

		ResponseCreate = boardInteracions.GetResponseCreateAList(myJsonBodyList, 200, key, baseUrlList);

		objBodyList = (ListResponse) boardInteracions.ConvertJsonToObject(ResponseCreate, ListResponse.class);

		// Create Card
		String myJsonBodyCard = utilsJsons.GetCreateCardJson(objBodyBoard, objBodyList);

		ResponseCreateCard = boardInteracions.GetResponseCreateACard(myJsonBodyCard, 200, key, baseUrlCard);

		objBodyCard = (ListResponse) boardInteracions.ConvertJsonToObject(ResponseCreateCard, ListResponse.class);
	}

	@When("^execute endpoint <\"([^\"]*)\"> to card update  without changing anything$")
	public void execute_endpoint_to_card_update_without_changing_anything(String arg1) throws Throwable {
		// Update Card
		String myJsonBodyUpdateCard = "";

		ResponseUpdateCard = boardInteracions.GetResponseUpdateACard(myJsonBodyUpdateCard, 200,
				objBodyCard.getId().toString(), key, token, baseUrlCard);

		objBodyUpdateCard = (ListResponse) boardInteracions.ConvertJsonToObject(ResponseUpdateCard, ListResponse.class);

	}

	@After("@UpdateCard")
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
