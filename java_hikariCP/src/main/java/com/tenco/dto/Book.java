package com.tenco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {


        private int id;
        private String title;
        private String author;
        private String publisher;
        private int publicationYear;
        private String isbn;
        private boolean available;



}
