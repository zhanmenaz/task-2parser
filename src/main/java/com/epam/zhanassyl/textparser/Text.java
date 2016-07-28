package com.epam.zhanassyl.textparser;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by zhanassyl on 27.07.2016.
 */

public class Text {
    private ArrayList<PartOfText> parts;

    public Text(ArrayList<PartOfText> parts){
        this.parts = parts;
    }

    public Iterator<PartOfText> getParts(){
        return parts.iterator();
    }

    public void setParts(ArrayList<PartOfText> parts){
        this.parts = parts;
    }
}
