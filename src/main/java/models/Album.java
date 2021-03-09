package models;

public class Album {
    private int id;
    private String artist;
    private String name;
    private int release_date;
    private float sales;
    private String genre;

    public Album(){

    }

    public void Album(int id, String artist, String name, int release_date, float sales, String genre){
        this.id = id;
        this.artist = artist;
        this.name = name;
        this.release_date = release_date;
        this.sales = sales;
        this.genre = genre;
    }

    public int getId(){
        return this.id;
    }

    public String getArtist(){
        return this.artist;
    }

    public String getName(){
        return this.name;
    }

    public int getRelease_date(){
        return this.release_date;
    }

    public float getSales(){
        return this.sales;
    }

    public String getGenre(){
        return this.genre;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setRelease_date(int release_date){
        this.release_date = release_date;
    }

    public void setSales(float sales){
        this.sales = sales;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }


}
