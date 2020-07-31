package cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CardImpl implements CardIntf {

	@Override
	public boolean checkSequence(String cards) {

		List<String> cardList = new ArrayList<>(Arrays.asList(cards.split(",")));

		Set<String> cardSet = convert(cardList);
		
		
		if(cardSet.contains(Constants.SPADE_1) && cardSet.contains(Constants.SPADE_2) && cardSet.contains(Constants.SPADE_13)) {
			return Boolean.FALSE;
		} else if(cardSet.contains(Constants.HEART_1) && cardSet.contains(Constants.HEART_2) && cardSet.contains(Constants.HEART_13)) {
			return Boolean.FALSE;
		} else if(cardSet.contains(Constants.DIMAND_1) && cardSet.contains(Constants.DIMAND_2) && cardSet.contains(Constants.DIMAND_13)) {
			return Boolean.FALSE;
		} else if(cardSet.contains(Constants.CLUB_1) && cardSet.contains(Constants.CLUB_2) && cardSet.contains(Constants.CLUB_13)) {
			return Boolean.FALSE;
		}
		
		

		if(cardSet.contains(Constants.SPADE_1) && cardSet.contains(Constants.SPADE_12) && cardSet.contains(Constants.SPADE_13)) {
			return Boolean.TRUE;
		} else if(cardSet.contains(Constants.HEART_1) && cardSet.contains(Constants.HEART_12) && cardSet.contains(Constants.HEART_13)) {
			return Boolean.TRUE;
		} else if(cardSet.contains(Constants.DIMAND_1) && cardSet.contains(Constants.DIMAND_12) && cardSet.contains(Constants.DIMAND_13)) {
			return Boolean.TRUE;
		} else if(cardSet.contains(Constants.CLUB_1) && cardSet.contains(Constants.CLUB_12) && cardSet.contains(Constants.CLUB_13)) {
			return Boolean.TRUE;
		}
		
		
		Set<Long> finalSet = new TreeSet<>(); 
		
		for (String string : cardSet) {
			
		
		Character firstChar = string.charAt(0);
		Character secondLastChar = string.charAt(string.length()-2);
		Character lastChar = string.charAt(string.length()-1);
			
		if(secondLastChar.equals(Constants.HASH))
			finalSet.add(Long.parseLong(lastChar.toString().trim()));
		else 
			finalSet.add(Long.parseLong(secondLastChar.toString().trim() + lastChar.toString().trim()));
		
		
		}
		
		
		List<Long> finalList = new ArrayList<>(finalSet); 
		
		for (int i = 0; i < finalList.size()-2; i++) {
			
			
			if(finalList.get(i).equals((finalList.get(i+1))-1) && finalList.get(i+1).equals((finalList.get(i+2))-1) && finalList.get(i+2).equals((finalList.get(i))+2)) {
				return true;
				
			}
			
			
			
		}
		
		
		return false;
	}

	private Set<String> convert(List<String> cardList) {
		Set<String> stringSet = new TreeSet<>();

		for (String string : cardList) {

			if (string.equalsIgnoreCase(Constants.SPADE_A)) {
				stringSet.add(Constants.SPADE_1);
			} else if (string.equalsIgnoreCase(Constants.SPADE_J)) {
				stringSet.add(Constants.SPADE_11);
			} else if (string.equalsIgnoreCase(Constants.SPADE_Q)) {
				stringSet.add(Constants.SPADE_12);
			} else if (string.equalsIgnoreCase(Constants.SPADE_K)) {
				stringSet.add(Constants.SPADE_13);
			} else if (string.equalsIgnoreCase(Constants.HEART_A)) {
				stringSet.add(Constants.HEART_1);
			} else if (string.equalsIgnoreCase(Constants.HEART_J)) {
				stringSet.add(Constants.HEART_11);
			} else if (string.equalsIgnoreCase(Constants.HEART_Q)) {
				stringSet.add(Constants.HEART_12);
			} else if (string.equalsIgnoreCase(Constants.HEART_K)) {
				stringSet.add(Constants.HEART_13);
			} else if (string.equalsIgnoreCase(Constants.DIMAND_A)) {
				stringSet.add(Constants.DIMAND_1);
			} else if (string.equalsIgnoreCase(Constants.DIMAND_J)) {
				stringSet.add(Constants.DIMAND_11);
			} else if (string.equalsIgnoreCase(Constants.DIMAND_Q)) {
				stringSet.add(Constants.DIMAND_12);
			} else if (string.equalsIgnoreCase(Constants.DIMAND_K)) {
				stringSet.add(Constants.DIMAND_13);
			} else if (string.equalsIgnoreCase(Constants.CLUB_A)) {
				stringSet.add(Constants.CLUB_1);
			} else if (string.equalsIgnoreCase(Constants.CLUB_J)) {
				stringSet.add(Constants.CLUB_11);
			} else if (string.equalsIgnoreCase(Constants.CLUB_Q)) {
				stringSet.add(Constants.CLUB_12);
			} else if (string.equalsIgnoreCase(Constants.CLUB_K)) {
				stringSet.add(Constants.CLUB_13);
			} else {
				stringSet.add(string);
			}

		}

		return stringSet;
	}

}
