package uk.co.softwarepulse.server.api.motivateme.data;

public class Quote {
    private String id;
    private String author;
    private String category;
    private String quotation;

    public Quote() {
        this("", "", "", "");
    }

    public Quote(String id, String author, String category, String quotation) {
        this.id = id ;
        this.author = author;
        this.category = category;
        this.quotation = quotation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuotation() {
        return this.quotation;
    }

    public void setQuotation(String quotation) {
        this.quotation = quotation;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Author: " + author + ", Category: " + category + ", Quote: " + quotation;
    }
}
