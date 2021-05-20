package kht2199;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("SameParameterValue")
public class StringAddCalculator {

	private static final String TOKEN_REGEX = "[,:]";

	private static final Pattern TOKEN_PATTERN = Pattern.compile("//(.)\n(.*)");

	public static int splitAndSum(String text) {
		if (!checkValidationInputText(text)) {
			return 0;
		}

		String[] tokens = parseTokensByMatcher(TOKEN_PATTERN, text);
		if (tokens == null) {
			tokens = text.split(TOKEN_REGEX);
		}

		Integer[] intTokens = stringToInt(tokens);
		for (Integer token : intTokens) {
			checkValidationToken(token);
		}

		return accumulate(intTokens);
	}

	private static String[] parseTokensByMatcher(Pattern pattern, String text) {
		Matcher matcher = pattern.matcher(text);
		if (!matcher.find()) {
			return null;
		}
		checkValidationMatcherGroupCount(matcher);
		return matcher.group(2).split(matcher.group(1));
	}

	private static void checkValidationMatcherGroupCount(Matcher matcher) {
		int groupCount = matcher.groupCount();
		if (groupCount != 2) {
			throw new RuntimeException("invalid group count. " + groupCount);
		}
	}

	private static int accumulate(Integer[] values) {
		int sum = 0;
		for (Integer integer : values) {
			sum += integer;
		}
		return sum;
	}

	/**
	 *
	 * @param token 토큰
	 * @throws RuntimeException token 검증 실패시 발생.
	 */
	private static void checkValidationToken(Integer token) throws RuntimeException {
		if (token < 0) {
			throw new RuntimeException("token is less than 0." + token);
		}
	}

	/**
	 *
	 * @param text input text
	 * @return input text 유효성 검증
	 */
	private static boolean checkValidationInputText(String text) {
		if (text == null) {
			return false;
		}

		return !text.isEmpty();
	}

	private static Integer[] stringToInt(String[] string) {
		Integer[] result = new Integer[string.length];
		for (int index = 0; index < string.length; index++) {
			result[index] = Integer.parseInt(string[index]);
		}
		return result;
	}
}