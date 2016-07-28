package com.epam.zhanassyl.textparser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Мечта on 27.07.2016.
 */
public class PartOfSentence {
    private ArrayList<String> words = null;

    public PartOfSentence(String text){
        words = new ArrayList<String>();
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(text);
        while(m.find()){
            words.add(m.group());
        }
    }

    public ArrayList<String> getWords(){
        return words;
    }

    public void setWords(ArrayList<String> words){
        this.words = words;
    }

    public void addPartOfSentence(StringBuffer sb){
        for(int i = 0; i < words.size();++i){
            if(i != 0){
                sb.append(" ");
            }
            sb.append(words.get(i));
        }
    }
}
