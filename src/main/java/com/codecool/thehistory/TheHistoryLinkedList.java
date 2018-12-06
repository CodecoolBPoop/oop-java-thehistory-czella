package com.codecool.thehistory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Arrays;
import java.util.Iterator;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList.addAll(Arrays.asList(text.split(" ")));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        for (Iterator<String> iter = wordsLinkedList.iterator(); iter.hasNext();) {
            String word = iter.next();
            if (word.equals(wordToBeRemoved)) {
                iter.remove();
            }
        }
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return this.wordsLinkedList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        ListIterator<String> iterator = this.wordsLinkedList.listIterator();
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
        for (int i = 0; i < wordsLinkedList.size(); i++) {
            if (wordsLinkedList.size() - i >= fromWords.length) {
                LinkedList<String> subListToCheck = new LinkedList<>(wordsLinkedList.subList(i, i + fromWords.length));
                String[] subArrayToCheck = new String[subListToCheck.size()];
                subArrayToCheck = subListToCheck.toArray(subArrayToCheck);
                if (Arrays.equals(fromWords, subArrayToCheck)) {
                    for (int j = 0; j < fromWords.length; j++) {
                        wordsLinkedList.remove(i);
                    }
                    for (int k = 0; k < toWords.length; k++) {
                        wordsLinkedList.add(i + k, toWords[k]);
                    }
                    i += toWords.length - 1;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);// last space char
        System.out.println(sb);
        return sb.toString();
    }

}
