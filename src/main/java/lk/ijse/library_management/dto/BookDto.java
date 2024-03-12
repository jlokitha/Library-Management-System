package lk.ijse.library_management.dto;

import lk.ijse.library_management.entity.Admin;
import lk.ijse.library_management.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDto {
    private int id;

    private String title;

    private String author;

    private String genre;

    private String availability;

    private Timestamp addedDate;

    private Timestamp updatedDate;

    private Admin admin;

    public Book toEntity() {
        return new Book(
                id,
                title,
                author,
                genre,
                availability,
                addedDate,
                updatedDate,
                admin,
                new ArrayList<>()
        );
    }
}
