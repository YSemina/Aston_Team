package org.example;

class Book {
    private final String title;
    private final String author;
    private final String publishing_house;
    private final int year;

    public Book(BookBuilder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.year = builder.year;
        this.publishing_house = builder.publishing_house;
    }
    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ",author=" + author + ",year=" + year + ",publishing_house=" + publishing_house + "]";
    }

    public static class BookBuilder {
        private final String title;
        private final String author;
        private final String publishing_house;
        private final int year;


        public BookBuilder(String title,String author,String publishing_house, int year) {
            this.title = title;
            this.author = author;
            this.year = year;
            this.publishing_house = publishing_house;
        }
        public Book build() {
            return new Book(this);
        }
    }
}

class main {
    public static void main(String[] args) {
        Book book = new Book.BookBuilder("Sacred and Terrible Air", "Robert Kurvitz", "--", 2013)
                .build();
        System.out.println(book);
    }
}