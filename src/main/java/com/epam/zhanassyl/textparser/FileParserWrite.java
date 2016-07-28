package com.epam.zhanassyl.textparser;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;

/**
 * Created by zhanassyl on 29.07.2016.
 */
public class FileParserWrite {
    private String fileName;
    public FileParserWrite(String fileName){
        this.fileName = fileName;
    }

    public void write(Text text) throws Exception{
        if(null != text){
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),"UTF8"));
            StringBuffer sb = new StringBuffer();
            Iterator<PartOfText> parts = text.getParts();
            while(parts.hasNext()){
                PartOfText part = parts.next();
                if(part instanceof Sentence){
                    ((Sentence)part).addSentence(sb);
                }
                else{
                    if(null != part.getContent()){
                        sb.append(part.getContent());
                    }
                }
            }
            System.out.println(sb.toString());
            out.write(sb.toString());
            out.close();
        }
    }
}
