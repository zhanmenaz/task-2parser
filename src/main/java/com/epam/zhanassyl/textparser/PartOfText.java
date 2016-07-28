package com.epam.zhanassyl.textparser;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by zhanassyl on 27.07.2016.
 */

    public abstract class PartOfText {
        protected ArrayList<PartOfSentence> partsOfSentence = null;
        protected ArrayList<String> punctuatianMarks;
        protected String content = null;

        public ArrayList<PartOfSentence> getPartsOfSentence(){
            return partsOfSentence;
        }

        public Iterator<String> getPunctuatianMarks(){
            return punctuatianMarks.iterator();
        }

        public String getContent(){
            return content;
        }
    }

