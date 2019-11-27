package th.ac.ku.tutor.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Post {
    @Id
    private String id;

    private String title;

    private String description;

    private String content;

    private String coverPictureUrl;

    private String ownerId;
}
