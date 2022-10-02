package mesh;

import java.util.*;

public class SolutionK2 {
	static String[][] table = new String[5][5];
	static ArrayList<ArrayList<String>> mergeLists = new ArrayList<ArrayList<String>>();
    public static String[] solution(String[] commands) {
    	ArrayList<String> returnValue = new ArrayList<>();
        for(String command : commands){
        	String[] commandArray = command.split(" ");
            switch(commandArray[0]){
                case "UPDATE":
                	if(isNumeric(commandArray[1]) && isNumeric(commandArray[2])) {
                		int rValue = stoi(commandArray[1]);
                		int cValue = stoi(commandArray[2]);
                		table[rValue][cValue] = commandArray[3];
                	}else {
                		changeValue(commandArray[1], commandArray[2]);
                	}
                	break;
                case "MERGE":
                	int rValue1 = stoi(commandArray[1]);
            		int cValue1 = stoi(commandArray[2]);
            		int rValue2 = stoi(commandArray[3]);
            		int cValue2 = stoi(commandArray[4]);
                	merge(rValue1, cValue1, rValue2, cValue2);
                	break;
                case "UNMERGE":
                	int rValue = stoi(commandArray[1]);
            		int cValue = stoi(commandArray[2]);
            		unmerge(rValue, cValue);
                	break;
                case "PRINT":
            		int rPrintValue = stoi(commandArray[1]);
            		int cPrintValue = stoi(commandArray[2]);
                	returnValue.add(printValue(rPrintValue, cPrintValue));
                	break;
                default:
                	break;
            }
        }
        printTable();
        return convertArrayListToArray(returnValue);
    }
    
    private static void merge(int rValueStart, int cValueStart, int rValueEnd, int cValueEnd) {
    	ArrayList<String> mergeList = new ArrayList<>();
    	int rMin = rValueStart > rValueEnd ? rValueEnd : rValueStart;
    	int rMax = rValueStart < rValueEnd ? rValueEnd : rValueStart;
    	int cMin = cValueStart > cValueEnd ? cValueEnd : cValueStart;
    	int cMax = cValueStart < cValueEnd ? cValueEnd : cValueStart;
    	String tableValue1 = table[rValueStart][cValueStart];
    	String tableValue2 = table[rValueStart][cValueStart];
    	String inputValue = null;
    	if(tableValue1 != null && tableValue2 != null) {
    		inputValue = tableValue1;
    	}else if(tableValue1 != null && tableValue2 == null) {
    		inputValue = tableValue1;
    	}else if(tableValue1 == null && tableValue2 != null) {
    		inputValue = tableValue2;
    	}
    	for(int i = rMin; i < rMax; i++) {
    		for(int j = cMin; j < cMax; j++) {
    			mergeList.add(i + "," + j);
    			table[i][j] = inputValue;
    		}
    	}
    	mergeLists.add(mergeList);
    }
    
    private static void unmergeRelated(int rValue, int cValue) {
    	ArrayList<String> targetMergeList = new ArrayList<String>();
    	String rcPoint = rValue + "," + cValue;
    	for(int i = 0; i < mergeLists.size(); i++) {
    		for(int j = 0; j < mergeLists.get(i).size(); i++) {
    			if(mergeLists.get(i).get(j).equals(rcPoint)) {
    				targetMergeList = mergeLists.get(i);
    			}
    		}
    	}
    	String inputvalue = table[rValue][cValue];
    	for(String mergeItem : targetMergeList) {
    		int mergeItemR = stoi(mergeItem.split(",")[0]);
    		int mergeItemC = stoi(mergeItem.split(",")[1]);
    		table[mergeItemR][mergeItemC] = null;
    	}
    	table[rValue][cValue] = inputvalue;
    }
    
    private static void unmerge(int rValue, int cValue) {
    	String currentValue = table[rValue][cValue];
    	unmergeRelated(rValue, cValue);
    	table[rValue][cValue] = currentValue;
    }
    
    private static String[] convertArrayListToArray(ArrayList<String> stringArrayList) {
    	
    	String[] returnStringArray = new String[stringArrayList.size()];
    	for(int i = 0; i < stringArrayList.size(); i++) {
    		returnStringArray[i] = stringArrayList.get(i);
    	}
    	return returnStringArray;
    }
    
    private static String printValue(int rValue, int cValue) {
    	if(table[rValue][cValue] == null) {
    		return "EMPTY";
    	}else {
    		return table[rValue][cValue];
    	}
    }
    
    
    
    private static void changeValue(String beforeValue, String afterValue) {
    	for(int i = 0; i < table.length; i++) {
    		for(int j = 0; j < table[i].length; j++) {
    			if(table[i][j] != null && table[i][j].equals(beforeValue)) {
    				table[i][j] = afterValue;
    			}
    		}
    	}
    }
    
	private static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	private static Integer stoi(String str) {
		try {
			return Integer.parseInt(str) - 1;
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	private static void printTable() {
		for(int i = 0; i < table.length; i++) {
			for(int j = 0; j < table[i].length; j++) {
				System.out.print(table[i][j]);
				System.out.print(",\t\t\t");
			}
			System.out.println();
		}
	}
}