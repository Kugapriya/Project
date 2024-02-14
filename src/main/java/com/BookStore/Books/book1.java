package com.BookStore.Books;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class book1 {
    private int id;
    private String title ;
    private String author;
    private int year;
    private double price;
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
    public void Database()
    {

        Connection connection = null;
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kugapriya","root", "");
            if (connection != null) {


                String insertQuery = "INSERT INTO book1 (id, title, author, year,price) VALUES (?, ?, ?, ?,?)";


                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, title);
                preparedStatement.setString(3, author);
                preparedStatement.setInt(4, year);
                preparedStatement.setDouble(5, price);

                int rowsAffected = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database!");
            e.printStackTrace();

        }
    }
    public  static void Database(List<book1> booksList)
    {
        for(book1 abc: booksList)
        {
            System.out.println(abc.getTitle());
            abc.Database();
        }
    }
}

