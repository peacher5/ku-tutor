package th.ac.ku.tutor.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Document(collection = "User")
public class User {

    @Id
    private String id;

    @NonNull
    @Indexed(unique = true)
    private String email;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String nickName;

    @NotNull
    private String studentID;

    @NotNull
    private String campus;

    @NotNull
    private String faculty;

    @NotNull
    private String department;

    @NotNull
    private String kuGen;

}
