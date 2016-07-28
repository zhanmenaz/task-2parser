package com.epam.zhanassyl.textparser;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by zhanassyl on 29.07.2016.
 */
public class SwapingFirstLast extends Functionality{
    public Text applyFunctianality(Text text){
        Iterator<PartOfText> parts = text.getParts();
        while(parts.hasNext()){
            PartOfText part;
            if((part = parts.next()) instanceof Sentence){
                int size = part.getPartsOfSentence().size();
                if(size > 0){
                    ArrayList<String> firstPartWords = part.getPartsOfSentence().get(0).getWords();
                    ArrayList<String> lastPartWords = part.getPartsOfSentence().get(size - 1).getWords();
                    String temp = firstPartWords.get(0);
                    firstPartWords.set(0, lastPartWords.get(lastPartWords.size()- 1));
                    part.getPartsOfSentence().get(0).setWords(firstPartWords);
                    lastPartWords.set(lastPartWords.size() - 1, temp);
                    part.getPartsOfSentence().get(size - 1).setWords(lastPartWords);
                }
            }
        }
        return text;
    }

    public Text applyFunctionality(Text text) {
        return null;
    }
}
