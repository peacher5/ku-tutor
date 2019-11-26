package th.ac.ku.tutor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import th.ac.ku.tutor.model.User;
import th.ac.ku.tutor.service.UserService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(testUserRestController.class)
public class testUserRestController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void createUserAPI() throws Exception{
        User user = new User();
        user.setEmail("wachirawit.o@ku.th");
        user.setFirstName("Wachirawit");
        user.setLastName("Onchet");
        user.setNickname("Ing");
        user.setStudentId("6010405432");
        user.setCampus("Kasetsart University");
        user.setFaculty("Science");
        user.setDepartment("Computer Science");
        user.setAboutMe("I'm a good student");
        user.setPictureUrl("www.eiei.com");
        mockMvc.perform(MockMvcRequestBuilders
                .post("/user")
                .content(asJsonString(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}