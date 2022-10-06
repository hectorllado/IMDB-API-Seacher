package br.com.hector.modelo;

public class Movies implements Content{
    private String fullTitle;
    private String image;
    private String imDbRating;
    private String year;

    public Movies(String fullTitle, String image, String imDbRating, String year) {
        this.fullTitle = fullTitle;
        this.image = image;
        this.imDbRating = imDbRating;
        this.year = year;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public void setImDbRating(String imDbRating) {
        this.imDbRating = imDbRating;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "fullTitle='" + fullTitle + '\'' +
                ", image='" + image + '\'' +
                ", imDbRating='" + imDbRating + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
