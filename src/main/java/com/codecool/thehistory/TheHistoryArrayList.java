package com.codecool.thehistory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Arrays;
import java.util.Iterator;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        text = text.replaceAll("/[^a-zA-Z0-9\\s]+/g", "");
        wordsArrayList.addAll(Arrays.asList(text.split(" ")));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        Iterator<String> iterator = wordsArrayList.iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            if(next.equals(wordToBeRemoved)) {
                iterator.remove();
            }
        }

    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        ListIterator<String> iterator = this.wordsArrayList.listIterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            if(next.equals(from)) {
                iterator.set(to);
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        for (int i = 0; i < wordsArrayList.size(); i++) {
            if (wordsArrayList.size() - i >= fromWords.length) {
                ArrayList<String> subListToCheck = new ArrayList<String>(wordsArrayList.subList(i, i + fromWords.length));
                String[] subArrayToCheck = new String[subListToCheck.size()];
                subArrayToCheck = subListToCheck.toArray(subArrayToCheck);
                if (Arrays.equals(fromWords, subArrayToCheck)) {
                    for (int j = 0; j < fromWords.length; j++) {
                        wordsArrayList.remove(i);
                    }
                    for (int k = 0; k < toWords.length; k++) {
                        wordsArrayList.add(i + k, toWords[k]);
                    }
                    i += toWords.length - 1;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
