import models.Author;

import java.util.ArrayList;

public class TestBeans {
    public static void main(String[] args) {
        Author daniel = new Author(1, "Daniel", "Cortes");
        Quote goldRule = new Quote(1, "Empathy puts you at the mercy of the last sob story you heard", daniel);
        Quote gol = new Quote(2,  "Empathy is important not esential", daniel);

        ArrayList<Quote> quoteList = new ArrayList<>();

        quoteList.add(goldRule);
        quoteList.add(gol);

        for(int i = 0; i < quoteList.size(); i++){
//            Quote cycle = quoteList.get(i);
            System.out.println(quoteList.get(i).getContent());
        }
    }
}
