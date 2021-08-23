package mesh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class V3 {

	public static boolean[] solution(String[] infos, String[] actions) {
		
		final String LOGIN = "LOGIN";
		final String ADD = "ADD";
		final String ORDER = "ORDER";
		
		String currentId = null;
		List<String> currentCart = new ArrayList<>();
		List<Boolean> returnList = new ArrayList<>();
		
		Map<String, String> infoMap = new HashMap<>();
		List<Action> actionList = new ArrayList<>();
		
		for(int i = 0; i < infos.length; i++) {
			infoMap.put(infos[i].split(" ")[0], infos[i].split(" ")[1]);
		}
		
		for(int i = 0; i < actions.length; i++) {
			String keyword = actions[i].split(" ")[0];
			switch(keyword){
			case LOGIN:
				actionList.add(new Action("LOGIN",actions[i].substring(6)));
				break;
			case ADD:
				actionList.add(new Action("ADD",actions[i].substring(4)));
				break;
			case ORDER:
				actionList.add(new Action("ORDER",actions[i].substring(5)));
				break;
			}
		}
		
		for(Action currentAction : actionList) {
			switch(currentAction.getInput()){
			case LOGIN:
				if(Objects.isNull(currentId)) {
					if(loginCheck(infoMap,currentAction.getValue())) {
						String loginId = currentAction.getValue().split(" ")[0];
						if(loginId.equals(currentId)) {
							returnList.add(false);
						}else {
							currentId = loginId;
							returnList.add(true);
						}
					}else {
						returnList.add(false);
					}
				}else {
					returnList.add(false);
				}
				break;
			case ADD:
				if(Objects.isNull(currentId)) {
					returnList.add(false);
				}else {
					returnList.add(true);
					currentCart.add(currentAction.getValue());
				}
				break;
			case ORDER:
				if(currentCart.size() == 0) {
					returnList.add(false);
				}else {
					returnList.add(true);
					currentCart.clear();
				}
				break;
			}
		}
		
		
		System.out.println("infos map : " + infoMap);
		System.out.println("action list : " + actionList);
		System.out.println("return list : " + returnList);
		boolean[] answer = new boolean[returnList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = returnList.get(i);
		}
		return answer;
	}
	public static boolean loginCheck(Map<String, String> info, String idpwd) {
		String inputId = idpwd.split(" ")[0];
		String inputPwd = idpwd.split(" ")[1];
		if(info.containsKey(inputId)) {
			if(info.get(inputId).equals(inputPwd)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

}


class Action{
	private String input;
	private String value;
	public Action(String input, String value) {
		this.input = input;
		this.value = value;
	}
	@Override
	public String toString() {
		return "Action [input=" + input + ", value=" + value + "]";
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}