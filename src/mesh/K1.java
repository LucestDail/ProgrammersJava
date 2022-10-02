package mesh;

import java.text.*;  
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        ArrayList<Integer> returnValueArray = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate localDateToday = LocalDate.parse(today, formatter);
        HashMap<String, Integer> hashMapTerm = new HashMap<String,Integer>();

        for(String term : terms){
            String targetTerm = term.split(" ")[0];
            int targetMonth = Integer.parseInt(term.split(" ")[1]);
            hashMapTerm.put(targetTerm, targetMonth);
        }
        
        int index = 0;
        
        for(String privacy : privacies){
            index++;
            String privacyDate = privacy.split(" ")[0];
            LocalDate date = LocalDate.parse(privacyDate, formatter);
            String privacyTerm = privacy.split(" ")[1];
            LocalDate addedPrivacyDate = date.plusMonths(hashMapTerm.get(privacyTerm));
            if(addedPrivacyDate.isAfter(localDateToday)){
                returnValueArray.add(index);
            }
        }

        
        int[] answer = new int[returnValueArray.size()];
        
        for(int i = 0; i < returnValueArray.size(); i++){
            answer[i] = returnValueArray.get(i);
        }
        
        return answer;
    }
}