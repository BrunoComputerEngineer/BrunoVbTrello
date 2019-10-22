package test.jsons;

import test.modelo.BoardResponse;
import test.modelo.ListResponse;

public class UtilsJsons {

	public String GetCreateBoardJson() {
		String myJsonBody = "{\"name\": \"TESTE01\",\"token\": \"fb2253fc938002037c4aa86c4897be02dde7b964555112c25d332585a1600185\"}";
		return myJsonBody;
	}
	
	public String GetCreateBoardinvalidTokenJson() {
		String myJsonBody = "{\"name\": \"TESTE01\",\"token\": \"InvalidToken\"}";
		return myJsonBody;
	}

	public String GetCreateListJson(BoardResponse objBodyBoard) {
		String myJsonBodyList = "{\r\n" + "    \"name\": \"CreateList\",\r\n" + "    \"pos\": 65535,\r\n"
				+ "    \"closed\": false,\r\n" + "    \"idBoard\": \"" + objBodyBoard.getId().toString() + "\",\r\n"
				+ "    \"token\": \"fb2253fc938002037c4aa86c4897be02dde7b964555112c25d332585a1600185\"\r\n" + "}";
		return myJsonBodyList;
	}

	public String GetCreateCardJson(BoardResponse objBodyBoard, ListResponse objBodyList) {
		String myJsonBodyCard = "{\r\n" + "    \"name\": \"teste10\",\r\n" + "    \"idList\": \""
				+ objBodyList.getId().toString() + "\",\r\n" + "    \"closed\": false,\r\n" + "    \"idBoard\": \""
				+ objBodyBoard.getId().toString() + "\",\r\n"
				+ "    \"token\": \"fb2253fc938002037c4aa86c4897be02dde7b964555112c25d332585a1600185\"\r\n" + "}";

		return myJsonBodyCard;
	}

	public String GetCreateCardInvalidTokenJson(BoardResponse objBodyBoard, ListResponse objBodyList) {
		String myJsonBodyCard = "{\r\n" + "    \"name\": \"teste10\",\r\n" + "    \"idList\": \""
				+ objBodyList.getId().toString() + "\",\r\n" + "    \"closed\": false,\r\n" + "    \"idBoard\": \""
				+ objBodyBoard.getId().toString() + "\",\r\n" + "    \"token\": \"123\"\r\n" + "}";

		return myJsonBodyCard;
	}

	public String GetCreateCardWithoutIdListJson(BoardResponse objBodyBoard, ListResponse objBodyList) {
		String myJsonBody = "{\"name\": \"TESTE01\",\"token\": \"fb2253fc938002037c4aa86c4897be02dde7b964555112c25d332585a1600185\"}";
		return myJsonBody;
	}

	public String GetUpdateCardJson(BoardResponse objBodyBoard, ListResponse objBodyList) {
		String myJsonBodyCard = "{\"name\": \"UpdateCardName\",\"desc\": \"UpdateCardDesc\"}";

		return myJsonBodyCard;
	}

}
