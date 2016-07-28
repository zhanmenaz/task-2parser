package com.epam.zhanassyl.textparser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhanassyl on 27.07.2016.
 */
public class FileParserRead {
    private String fileName;
    private StringBuffer text;
    public FileParserRead(String name){
        fileName = name;
    }

    private void readFromFile() throws Exception{
        FileReader fr = null;
        try{

            fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String s;
            text = new StringBuffer();
            while((s = br.readLine()) != null){
                if(text.length() != 0)
                    text.append("\n");
                text.append(s);
            }

        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            if(fr != null){
                fr.close();
            }
        }
    }

    public Text read() throws Exception{
        readFromFile();
        ArrayList<PartOfText> partsOfText = new ArrayList<PartOfText>();
        if(null != text){
            Pattern p = Pattern.compile("([^.?!]+[.?!])|(\\n.*\\{(\\n.*\\n)*\\}\\n)|(.+)");
            Matcher m = p.matcher(text);
            String str;
            while(m.find()){
                if(null != (str = m.group(1))){
                    partsOfText.add(new Sentence(str));
                }
                if(null != (str = m.group(2))){
                    partsOfText.add(new Code(str));
                }
                if(null != (str = m.group(4))){
                    partsOfText.add(new Unidentified(str));
                }
            }
        }
        return (partsOfText.isEmpty()) ? null : new Text(partsOfText);
    }

}
