package com.epam.zhanassyl.textparser;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by zhanassyl on 29.07.2016.
 */
public class SearchUniqueWord {
    public String applyFunctianality(Text text) {
        ArrayList<String> firstSentenceWords = new ArrayList<String>();
        boolean isFirstSentence = true;
        Iterator<PartOfText> parts = text.getParts();
        while (parts.hasNext()) {
            PartOfText part = parts.next();
            if (part instanceof Sentence) {
                Iterator<PartOfSentence> partsOfSentence = part.getPartsOfSentence().iterator();
                if (isFirstSentence) {
                    while (partsOfSentence.hasNext()) {
                        firstSentenceWords.addAll(partsOfSentence.next().getWords());
                    }
                    isFirstSentence = false;
                } else {
                    while (partsOfSentence.hasNext()) {
                        Iterator<String> words = partsOfSentence.next().getWords().iterator();
                        while (words.hasNext()) {
                            String currWord = words.next();
                            if (firstSentenceWords.contains(currWord)) {
                                firstSentenceWords.remove(currWord);
                            }
                        }
                    }
                }
            }
        }
        return (firstSentenceWords.size() > 0) ? firstSentenceWords.get(0) : null;
    }


}