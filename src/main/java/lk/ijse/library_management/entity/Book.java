package lk.ijse.library_management.entity;

import lk.ijse.library_management.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "book_title", nullable = false)
    private String title;

    @Column(name = "book_author", nullable = false)
    private String author;

    @Column(name = "book_genre", nullable = false)
    private String genre;

    @Column(name = "book_availability", nullable = false)
    private String availability;

    @CreationTimestamp
    @Column(name = "book_added")
    private Timestamp addedDate;

    @UpdateTimestamp
    @Column(name = "book_updated")
    private Timestamp updatedDate;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "book"
    )
    private List<TransactionDetails> transactionDetails = new ArrayList<>();

    public BookDto toDto() {
        return new BookDto(
                id,
                title,
                author,
                genre,
                availability,
                addedDate,
                updatedDate,
                admin.toDto()
        );
    }
}
