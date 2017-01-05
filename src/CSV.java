
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mouhammad
 */
public class CSV extends javax.swing.JFrame{
    File authFile = new File("authors.csv");
    File bookFile = new File("books.csv");
    final String COMMA_DELIMITER = ",";
    final String NEW_LINE_SEPARATOR = "\n";
    ArrayList<Author> authors = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();
    String[] temp = new String[100];
    String line = "";
    FileWriter fileWriter;
    
    public String appendDQ(String str) {
        return "\"" + str + "\"";
    }
    public void sync(){
        authors.clear();
        books.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(bookFile))) {
            while ((line = br.readLine()) != null) {
                //book names might have spaces in them, we'll wrap them in a quote to identify them
                temp = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                //remote the quotes to add them to the book name,author name;
                books.add(new Book(temp[0].replaceAll("\"", ""), temp[1].replaceAll("\"", ""),Integer.parseInt(temp[2]), temp[3]));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(authFile))) {
            while ((line = br.readLine()) != null) {
                //Author name might have spaces in them, we'll wrap them in a quote to identify them
                temp = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                //remote the quotes to add them to the author ArrayList;
                authors.add(new Author(temp[0].replaceAll("\"", ""), temp[1].replaceAll("\"", "")));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }  
    }
    public void saveAuthor(Author a)
    {
        try{
                fileWriter = new FileWriter(authFile, true);    
                fileWriter.append("\"" + a.getName()+ "\"");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(a.getNationality());
                fileWriter.append(NEW_LINE_SEPARATOR);
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error while flushing/closing fileWriter");
                    e.printStackTrace();
		}
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        sync();
    }
    public void saveBook(Book b)
    {
        try{
                fileWriter = new FileWriter(bookFile, true);    
                fileWriter.append("\"" + b.getName()+ "\"");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("\"" +b.getAuthorname()+ "\"");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(b.getYear()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(b.getIsbn());
                fileWriter.append(NEW_LINE_SEPARATOR);
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error while flushing/closing fileWriter");
                    e.printStackTrace();
		}
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        sync();
    }
}
