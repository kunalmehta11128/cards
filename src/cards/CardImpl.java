package cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CardImpl implements CardIntf {

	@Override
	public boolean checkSequence(String cards) {

		List<String> cardList = new ArrayList<>(Arrays.asList(cards.split(",")));

		// convert J -> 11, Q -> 12, K -> 13 A -> 1
		Set<String> cardSet = convert(cardList);

		// check condition 2
		Boolean Contion2 = checkCondition2(cardSet);
		if (Boolean.FALSE.equals(Contion2))
			return Boolean.FALSE;

		// check condition 1
		Boolean Contion1 = checkContion1(cardSet);
		if (Boolean.TRUE.equals(Contion1))
			return Boolean.TRUE;

		Set<Long> spadeSet = new TreeSet<>();
		Set<Long> heartSet = new TreeSet<>();
		Set<Long> dimandSet = new TreeSet<>();
		Set<Long> clubSet = new TreeSet<>();

		// Separated spade,heart,dimand,club values and remove S,H,D,C and #
		for (String string : cardSet) {

			Character firstChar = string.charAt(0);
			Character secondLastChar = string.charAt(string.length() - 2);
			Character lastChar = string.charAt(string.length() - 1);

			if (firstChar.toString().equalsIgnoreCase(Constants.SPADE)) {

				if (secondLastChar.equals(Constants.HASH))
					spadeSet.add(Long.parseLong(lastChar.toString().trim()));
				else
					spadeSet.add(Long.parseLong(secondLastChar.toString().trim() + lastChar.toString().trim()));

			} else if (firstChar.toString().equalsIgnoreCase(Constants.HEART)) {

				if (secondLastChar.equals(Constants.HASH))
					heartSet.add(Long.parseLong(lastChar.toString().trim()));
				else
					heartSet.add(Long.parseLong(secondLastChar.toString().trim() + lastChar.toString().trim()));

			} else if (firstChar.toString().equalsIgnoreCase(Constants.DIMAND)) {

				if (secondLastChar.equals(Constants.HASH))
					dimandSet.add(Long.parseLong(lastChar.toString().trim()));
				else
					dimandSet.add(Long.parseLong(secondLastChar.toString().trim() + lastChar.toString().trim()));

			} else if (firstChar.toString().equalsIgnoreCase(Constants.CLUB)) {

				if (secondLastChar.equals(Constants.HASH))
					clubSet.add(Long.parseLong(lastChar.toString().trim()));
				else
					clubSet.add(Long.parseLong(secondLastChar.toString().trim() + lastChar.toString().trim()));

			}

		}

		List<Long> spadeList = new ArrayList<>(spadeSet);
		List<Long> heartList = new ArrayList<>(heartSet);
		List<Long> dimandList = new ArrayList<>(dimandSet);
		List<Long> clubList = new ArrayList<>(clubSet);

		// condition check is sequence or not
		for (int i = 0; i < spadeList.size() - 2; i++) {
			if (spadeList.get(i).equals((spadeList.get(i + 1)) - 1)
					&& spadeList.get(i + 1).equals((spadeList.get(i + 2)) - 1)
					&& spadeList.get(i + 2).equals((spadeList.get(i)) + 2))
				return true;
		}
		for (int i = 0; i < heartList.size() - 2; i++) {
			if (heartList.get(i).equals((heartList.get(i + 1)) - 1)
					&& heartList.get(i + 1).equals((heartList.get(i + 2)) - 1)
					&& heartList.get(i + 2).equals((heartList.get(i)) + 2))
				return true;
		}
		for (int i = 0; i < dimandList.size() - 2; i++) {
			if (dimandList.get(i).equals((dimandList.get(i + 1)) - 1)
					&& dimandList.get(i + 1).equals((dimandList.get(i + 2)) - 1)
					&& dimandList.get(i + 2).equals((dimandList.get(i)) + 2))
				return true;
		}
		for (int i = 0; i < clubList.size() - 2; i++) {
			if (clubList.get(i).equals((clubList.get(i + 1)) - 1)
					&& clubList.get(i + 1).equals((clubList.get(i + 2)) - 1)
					&& clubList.get(i + 2).equals((clubList.get(i)) + 2))
				return true;
		}
		return false;
	}

	private Boolean checkCondition2(Set<String> cardSet) {
		if (cardSet.contains(Constants.SPADE_1) && cardSet.contains(Constants.SPADE_2)
				&& cardSet.contains(Constants.SPADE_13))
			return Boolean.FALSE;
		else if (cardSet.contains(Constants.HEART_1) && cardSet.contains(Constants.HEART_2)
				&& cardSet.contains(Constants.HEART_13))
			return Boolean.FALSE;
		else if (cardSet.contains(Constants.DIMAND_1) && cardSet.contains(Constants.DIMAND_2)
				&& cardSet.contains(Constants.DIMAND_13))
			return Boolean.FALSE;
		else if (cardSet.contains(Constants.CLUB_1) && cardSet.contains(Constants.CLUB_2)
				&& cardSet.contains(Constants.CLUB_13))
			return Boolean.FALSE;

		return Boolean.TRUE;
	}

	private Boolean checkContion1(Set<String> cardSet) {
		if (cardSet.contains(Constants.SPADE_1) && cardSet.contains(Constants.SPADE_12)
				&& cardSet.contains(Constants.SPADE_13))
			return Boolean.TRUE;
		else if (cardSet.contains(Constants.HEART_1) && cardSet.contains(Constants.HEART_12)
				&& cardSet.contains(Constants.HEART_13))
			return Boolean.TRUE;
		else if (cardSet.contains(Constants.DIMAND_1) && cardSet.contains(Constants.DIMAND_12)
				&& cardSet.contains(Constants.DIMAND_13))
			return Boolean.TRUE;
		else if (cardSet.contains(Constants.CLUB_1) && cardSet.contains(Constants.CLUB_12)
				&& cardSet.contains(Constants.CLUB_13))
			return Boolean.TRUE;

		return Boolean.FALSE;
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
