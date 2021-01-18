package HomeWorkString;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskAlgoritm {
    public String getResult(String string) {
        String stringWithoutPunctuation = getStringWithoutPunctuationToLowerCase(string);
        String[] wordsSort = getArrayOfWordsSortedAlphabetically(stringWithoutPunctuation);
        int[] countRepeats = countRepeats(stringWithoutPunctuation, wordsSort);
        int countNotZero = countNotZero(countRepeats);
        String[] unicWordsWithCountOfRepeats = getUnicWordsWithCountOfRepeats(wordsSort, countRepeats,
                countNotZero);
        String[] wordsWithStartedLetter = getWordsWithStartedLetterBeforeWords(unicWordsWithCountOfRepeats);
        return getStringOfWordsStartedWithSameLetters(wordsWithStartedLetter);
    }
    public String getStringWithoutPunctuationToLowerCase(String string) {
        System.out.println(string.replaceAll("[\\W&&[^\\s]]", "").toLowerCase());
        return string.replaceAll("[\\W&&[^\\s]]", "").toLowerCase();
    }
    public String[] getArrayOfWordsSortedAlphabetically(String string) {
        String[] arr = string.split(" ");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public int[] countRepeats(String string, String[] wordsSort) {
        int[] countRepeats = new int[wordsSort.length];
        StringBuilder sb = new StringBuilder(" " + string + " ");
        for (int i = 0; i < wordsSort.length; i++) {
            Pattern pattern = Pattern.compile(" " + wordsSort[i] + " ");
            Matcher matcher = pattern.matcher(sb);
            int point = 0;
            int count = 0;
            while (matcher.find(point)) {
                sb.delete(matcher.start() + 1, matcher.end() - 1);
                point = matcher.end() - wordsSort[i].length();
                count++;
            }
            countRepeats[i] = count;
        }
        System.out.println(Arrays.toString(countRepeats));
        return countRepeats;
    }
    public int countNotZero(int[] countRepeats) {
        int countNotZero = 0;
        for (int i = 0; i < countRepeats.length; i++) {
            if (countRepeats[i] != 0) {
                countNotZero++;
            }
        }
        System.out.println(countNotZero);
        return countNotZero;
    }
    public String[] getUnicWordsWithCountOfRepeats(String[] wordsSort, int[] countRepeats, int countNotZero) {
        String[] result = new String[countNotZero];
        int countResult = 0;
        for (int i = 0; i < wordsSort.length; i++) {
            if (countRepeats[i] != 0) {
                result[countResult] = wordsSort[i] + " - " + countRepeats[i];
                countResult++;
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
    public String[] getWordsWithStartedLetterBeforeWords(String[] wordsWithCount) {
        String[] result = new String[wordsWithCount.length];
        for (int i = 0; i < wordsWithCount.length; i++) {
            result[i] = String.valueOf(wordsWithCount[i].charAt(0)).toUpperCase() + ": " + wordsWithCount[i];
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
    public String getStringOfWordsStartedWithSameLetters(String[] wordsWithStartedLetter) {
        char letter = ' ';
        for (int i = 0; i < wordsWithStartedLetter.length; i++) {
            letter = wordsWithStartedLetter[i].charAt(0);
            for (int k = i + 1; k < wordsWithStartedLetter.length; k++) {
                if (letter == wordsWithStartedLetter[k].charAt(0)) {
                    wordsWithStartedLetter[k] = wordsWithStartedLetter[k].replaceFirst("[A-Z]: ",
                            "   ");
                }
            }
        }
        System.out.println(Arrays.toString(wordsWithStartedLetter));
        return Arrays.toString(wordsWithStartedLetter).replaceAll(", ", "\n")
                .replaceFirst("\\[", "").replaceAll("]", "");
    }
}