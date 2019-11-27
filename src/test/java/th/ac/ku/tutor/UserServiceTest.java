package th.ac.ku.tutor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import th.ac.ku.tutor.model.User;
import th.ac.ku.tutor.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class UserServiceTest {

    @InjectMocks
    User user;

    @Mock
    UserService userService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        ArrayList<User> list = new ArrayList<User>();
        User user1 = new User();
        user1.setId("1234");
        user1.setEmail("sukitta.a@ku.th");
        user1.setFirstName("Sukibong");
        user1.setLastName("Akkarathaneht");
        user1.setNickname("JingJing");
        user1.setStudentId("6010405530");
        user1.setCampus("BKN");
        user1.setFaculty("SC");
        user1.setDepartment("CS");
        user1.setAboutMe("Hi");
        user1.setPictureUrl("https://lh3.googleusercontent.com/a-/AAuE7mAj5i8HgJMrgjUhAfKc6p7TqvCqTl_NeeGBw0cy=s500");
        list.add(user1);

        User user2 = new User();
        user2.setId("1235");
        user2.setEmail("wachirawit.o@ku.th");
        user2.setFirstName("Wachirawit");
        user2.setLastName("Onchet");
        user2.setNickname("Ing");
        user2.setStudentId("6010405432");
        user2.setCampus("BKN");
        user2.setFaculty("SC");
        user2.setDepartment("CS");
        user2.setAboutMe("Hi");
        user2.setPictureUrl("https://lh3.googleusercontent.com/a-/AAuE7mAj5i8HgJMrgjUhAfKc6p7TqvCqTl_NeeGBw0cy=s500");
        list.add(user2);

        when(userService.getAllUser()).thenReturn(list);
        when(userService.getUserFromEmail("wachirawit.o@ku.th")).thenReturn(user2);
    }

    @Test
    public void getAllUserTest() {
        List<User> userList = userService.getAllUser();
        assertEquals(2, userList.size());
    }

    @Test
    public void getUserByEmailTest() {
        User user = userService.getUserFromEmail("wachirawit.o@ku.th");

        assertEquals("Wachirawit", user.getFirstName());
        assertEquals("Onchet", user.getLastName());
        assertEquals("Ing", user.getNickname());
        assertEquals("6010405432", user.getStudentId());
        assertEquals("BKN", user.getCampus());
        assertEquals("SC", user.getFaculty());
        assertEquals("CS", user.getDepartment());
        assertEquals("Hi", user.getAboutMe());
        assertEquals("https://lh3.googleusercontent.com/a-/AAuE7mAj5i8HgJMrgjUhAfKc6p7TqvCqTl_NeeGBw0cy=s500",user.getPictureUrl());
    }

    @Test
    public void createUserTest() {
        User user = new User();
        user.setId("1236");
        user.setEmail("pasinee.w@ku.th");
        user.setFirstName("Pasinee");
        user.setLastName("Wasupan");
        user.setNickname("Kapop");
        user.setStudentId("6010405378");
        user.setCampus("BKN");
        user.setFaculty("SC");
        user.setDepartment("CS");
        user.setAboutMe("Hi");
        user.setPictureUrl("https://lh3.googleusercontent.com/a-/AAuE7mAj5i8HgJMrgjUhAfKc6p7TqvCqTl_NeeGBw0cy=s500");
        userService.createUser(user);
        verify(userService, times(1)).createUser(user);
    }

}
