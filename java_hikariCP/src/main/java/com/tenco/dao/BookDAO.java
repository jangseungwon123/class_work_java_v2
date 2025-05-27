package com.tenco.dao;

import com.tenco.dto.Book;
import com.tenco.util.DBConnectionManager;
import com.tenco.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BookDAO {

    public List<Book> getAllBooks() throws SQLException {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * FROM books ";
        try(Connection conn = DBConnectionManager.getConnection2();
            Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int publicationYear = rs.getInt("publication_year");
                String isbn = rs.getString("isbn");
                boolean available = rs.getBoolean("available");

                Book book = new Book(id, title, author, publisher, publicationYear, isbn, available);
                bookList.add(book);
            }
        }
        return bookList;
    }

    // 테스코드 작성
    public static void main(String[] args) {
        BookDAO bookDAO =new BookDAO();
        try {
            System.out.println("북 조회");
            bookDAO.getAllBooks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
