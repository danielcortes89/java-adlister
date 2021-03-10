import models.Author;

public class Quote {
    private int id;
    private String content;
    private Author author;

    Quote(){

    }

    Quote(int id, String content, Author author){
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId(){
        return this.id;
    }



    public String getContent(){
        return this.content;
    }

    public Author getAuthor(){
        return this.author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
