package th.ac.ku.tutor.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    private String firstName;

    private String lastName;

    private String nickname;

    private String studentId;

    private String campus;

    private String faculty;

    private String department;

    private String aboutMe;

    private String pictureUrl;
}
