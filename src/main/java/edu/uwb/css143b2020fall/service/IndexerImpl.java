package edu.uwb.css143b2020fall.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IndexerImpl implements Indexer {
    public Map<String, List<List<Integer>>> index(List<String> docs) {
        Map<String, List<List<Integer>>> indexes = new HashMap<>();

        //All unique words are set in a HashSet
        for (String doc : docs) {
            // get unique words so that the same words are not indexed more than once
            Set<String> words = getUniqueWord(doc);

            for (String word : words) {
                List<List<Integer>> positions = new ArrayList<>();
                // go through all the documents while adding positions to the positions list
                for (int j = 0; j < docs.size(); j++) {
                    // getting the word's position from the documents and adding to the position list
                    List<Integer> position = getWordPosition(word, docs.get(j));
                    positions.add(position);
                }
                // add words and positions (key & value) to indexes HashMap
                indexes.put(word, positions);
            }
        }
        return indexes;
    }

    //adds unique words to a hashset so that the same word is not indexed twice
    private Set<String> getUniqueWord(String doc) {
        Set<String> result = new HashSet<>();

        String[] words = doc.trim().split(" ");
        for (String word : words) {
            if (word.length() > 0) {
                result.add(word);
            }
        }
        return result;
    }

    // get the position of a word in a document and add to a list to get its position in a document
    private List<Integer> getWordPosition(String word, String doc) {
        List<Integer> list = new ArrayList<>();

        // Trim and split doc and add it to an array to iterate through
        String[] docArray = doc.trim().split(" ");
        int index = 0;
        // goes through the docArray and checks if word in doc is the same as the word
        for (String w : docArray) {
            if (word.equals(w)) {
                list.add(index);
            }
            if (w.length() > 0) {
                index++;
            }
        }
        return list;
    }
}