package uk.co.softwarepulse.server.api.motivateme.data;

public class Quote {

    private String author ;
    private String category ;
    private String quotation ;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuotation() {
        return quotation;
    }

    public void setQuotation(String quotation) {
        this.quotation = quotation;
    }

    @Override
    public String toString() {
        return "Author: " + this.author + ", Category: " + this.category + ", Quote: " + this.quotation ;
    }
}