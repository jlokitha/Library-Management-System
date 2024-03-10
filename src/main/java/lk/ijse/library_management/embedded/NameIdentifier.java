package lk.ijse.library_management.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Embeddable
public class NameIdentifier {

    @Column(name = "first_name")
    private String fName;

    @Column(name = "last_name")
    private String lName;
}
