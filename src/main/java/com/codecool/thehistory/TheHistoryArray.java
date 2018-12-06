package com.codecool.thehistory;

import java.util.Arrays;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        this.wordsArray = text.split(" ");
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more informatio
        int newLength = wordsArray.length;
        for(int i = 0; i < wordsArray.length; i++)
        {
            if(wordsArray[i].equals(wordToBeRemoved))
            {
                newLength--;
            }
        }
        String[] result = new String[newLength];
        int count = 0;
        for(int i = 0; i < wordsArray.length; i++)
        {
            if(!wordsArray[i].equals(wordToBeRemoved)) {
                result[count] = wordsArray[i];
                count++;
            }
        }
        System.out.println(wordsArray.length - result.length);
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return this.wordsArray.length;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        Arrays.fill(wordsArray, null);
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(from)) {
                wordsArray[i] = to;
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        /**"replace replace me replace me me me replace me me"*/
        int newLength = wordsArray.length;
        if (toWords.length > fromWords.length) {
            for (int i = 0; i < wordsArray.length; i++) {
                if (Arrays.equals(fromWords, Arrays.copyOfRange(wordsArray, i, i + fromWords.length))) {
                    newLength += toWords.length - fromWords.length;
                    i += (fromWords.length - 1);
                }
            }
        }
        if (fromWords.length > toWords.length) {
            for (int i = 0; i < wordsArray.length; i++) {
                if (Arrays.equals(fromWords, Arrays.copyOfRange(wordsArray, i, i + fromWords.length))) {
                    newLength -= fromWords.length - toWords.length;
                    i += (fromWords.length - 1);
                }
            }
        }
        String[] result = new String[newLength];
        int count = 0;
        for (int i = 0; i < wordsArray.length; i++) {
            if (Arrays.equals(fromWords, Arrays.copyOfRange(wordsArray,i,i+fromWords.length))) {
                for (int j = 0; j < toWords.length; j++) {
                    result[count] = toWords[j];
                    count++;
                }
                i += (fromWords.length - 1);
            } else {
                result[count] = wordsArray[i];
                count++;
            }
        }
        this.wordsArray = result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
};
