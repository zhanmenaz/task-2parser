package com.epam.zhanassyl.textparser;

/**
 * Created by zhanassyl on 29.07.2016.
 */
public class Parser {
    public static void main(String[] args) throws Exception {
        FileParserRead fpr = new FileParserRead("C:\\Users\\Мечта\\IdeaProjects\\textParser-task2\\1.txt");
        Text text = fpr.read();
        SearchUniqueWord suw = new SearchUniqueWord();
        System.out.println(suw.applyFunctianality(text));
        SwapingFirstLast sfl = new SwapingFirstLast();
        text = sfl.applyFunctianality(text);
        FileParserWrite fpw = new FileParserWrite("C:\\Users\\Мечта\\IdeaProjects\\textParser-task2\\2.txt");
        fpw.write(text);
    }
}
