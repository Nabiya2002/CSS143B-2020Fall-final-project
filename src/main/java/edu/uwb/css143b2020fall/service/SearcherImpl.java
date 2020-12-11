package edu.uwb.css143b2020fall.service;

import org.springframework.stereotype.Service;

import java.util.*;

/*
DO NOT CHANGE
 */

@Service
public class SearcherImpl implements Searcher {
    public List<Integer> search(String keyPhrase, Map<String, List<List<Integer>>> index) {
        List<Integer> result = new ArrayList<>();

        // check if keyPhrase is empty, if index is null or if index's size is 0 then return empty result
        if (keyPhrase.isEmpty() || index == null || index.size() == 0) {
            return result;
        }

        //step 0: split keyPhrase into words by space
        String[] phrases = keyPhrase.trim().split(" ");

        //step 1: get documents that contain all the words in the phrase
        Map<Integer, List<List<Integer>>>
                documentsContainingWords = getDocumentsContainingWords(index, phrases);

        // update documents locations
        doLocationMath(documentsContainingWords);

        // Remove the documents that are not the part of the results
        cleanupDocuments(phrases, documentsContainingWords);

        return new ArrayList<>(documentsContainingWords.keySet());
    }

    private void cleanupDocuments(String[] phrases, Map<Integer, List<List<Integer>>> documentsContainingWords) {

        Iterator<Map.Entry<Integer, List<List<Integer>>>> iterator = documentsContainingWords.entrySet().iterator();

        // removes the documents that doesn't have the whole phrase
        while (iterator.hasNext()) {
            List<List<Integer>> wordLocations = iterator.next().getValue();

            // If locations List is less than the phrase length, that means that
            // some words in the phrase doesn't exists in any document
            // and if it is a multiple lists then
            if (wordLocations.size() < phrases.length || wordLocations.size() > 1
                    && !matchFound(wordLocations, phrases.length)) {
                iterator.remove();
            }
        }
    }

    private void doLocationMath(Map<Integer, List<List<Integer>>> documentsContainingWords) {
        Iterator<Map.Entry<Integer, List<List<Integer>>>> iterator = documentsContainingWords.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, List<List<Integer>>> entry = iterator.next();
            List<List<Integer>> wordLocations = entry.getValue();
            List<List<Integer>> updatedWordLocations = new ArrayList<>();

            for (int i = 0; i < wordLocations.size(); i++) {
                List<Integer> location = wordLocations.get(i);
                List<Integer> l = new ArrayList<>();
                // for each document update word position based on index - i
                for (int j = 0; j < location.size(); j++) {
                    l.add(location.get(j) - i);
                }
                updatedWordLocations.add(l);
            }
            entry.setValue(updatedWordLocations);
        }
    }


    private boolean matchFound(List<List<Integer>> wordLocations, int phraseCount) {

        List<Integer> location = wordLocations.get(0);
        int count = 0;
        for (int i = 0; i < location.size(); i++) {
            int locationIndex = location.get(i);

            for (int j = 0; j < wordLocations.size(); j++) {
                if (wordLocations.get(j).contains(locationIndex)) {
                    count++;
                }
            }
        }
        return count >= phraseCount;
    }


    private Map<Integer, List<List<Integer>>> getDocumentsContainingWords
            (final Map<String, List<List<Integer>>> index, String[] phrases) {

        Map<Integer, List<List<Integer>>> finalDocuments = new HashMap<>();

        for (String phrase : phrases) {
            if (index.containsKey(phrase)) {
                //get list of documents containing phrase
                Map<Integer, List<Integer>> documents = getListOfDocs(index.get(phrase));
                for (Map.Entry<Integer, List<Integer>> document : documents.entrySet()) {

                    // Add a new document if it doesn't exists
                    finalDocuments.putIfAbsent(document.getKey(), new ArrayList<>());

                    List<List<Integer>> value = finalDocuments.get(document.getKey());
                    value.add(document.getValue());
                    // add to the list
                    finalDocuments.put(document.getKey(), value);
                }
            }
        }
        return finalDocuments;
    }

    private Map<Integer, List<Integer>> getListOfDocs(List<List<Integer>> lists) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        int documentId = 0;
        for (List<Integer> list : lists) {
            if (list.size() > 0) {
                result.put(documentId, list);
            }
            documentId++;
        }
        return result;
    }
}