package lk.ijse.library_management.entity;

import lk.ijse.library_management.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_title")
    private String title;

    @Column(name = "book_author")
    private String author;

    @Column(name = "book_genre")
    private String genre;

    @Column(name = "book_availability")
    private String availability;

    @Column(name = "book_added")
    private Timestamp addedDate;

    @Column(name = "book_updated")
    private Timestamp updatedDate;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public BookDto toDto() {
        return new BookDto(
                id,
                title,
                author,
                genre,
                availability,
                addedDate,
                updatedDate,
                admin
        );
    }
}
