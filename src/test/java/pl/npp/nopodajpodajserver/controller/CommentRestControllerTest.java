package pl.npp.nopodajpodajserver.controller;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.npp.nopodajpodajserver.NoPodajPodajServerApplication;
import pl.npp.nopodajpodajserver.model.place.Place;
import pl.npp.nopodajpodajserver.model.rateSystem.Comment;
import pl.npp.nopodajpodajserver.model.user.Customer;
import pl.npp.nopodajpodajserver.repository.ICommentRepository;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import pl.npp.nopodajpodajserver.repository.ICustomerRepository;
import pl.npp.nopodajpodajserver.repository.IPlaceRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.junit.Assert.assertNotNull;

/**
 * @author Paweł Lelental
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = NoPodajPodajServerApplication.class)
@WebAppConfiguration
public class CommentRestControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private ICommentRepository commentRepository;
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private IPlaceRepository placeRepository;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

        Customer customer = new Customer();
        customer.setLevel(2);
        customer.setName("TestName");
        customer.setEmail("Test@mail.pl");
        this.customerRepository.save(customer);

        Place place = new Place();
        place.setCity("Gdynia");
        place.setCost(new BigDecimal(25));
        place.setName("SoccerField");
        this.placeRepository.save(place);

        Comment comment = new Comment();
        comment.setCustomer(customer);
        comment.setPlace(place);
        comment.setText("TestTestTest");

        Comment comment2 = new Comment();
        comment.setCustomer(customer);
        comment.setPlace(place);
        comment.setText("TestTest2");

        this.commentRepository.save(comment);
        this.commentRepository.save(comment2);
    }

    @Test
    public void getComments() throws Exception {
    mockMvc.perform(get("/comments")).andExpect(status().isOk())
            .andExpect(content().contentType(contentType));
    }

    @Test
    public void getComment() throws Exception {
        mockMvc.perform(get("/comments/1")).andExpect(status().isOk())
                .andExpect(content().contentType(contentType));
    }

    @Test
    public void deleteComment() throws Exception {
        mockMvc.perform(delete("/comments/2")).andExpect(status().isOk());
    }

    @Test
    public void findByCustomerId() throws Exception {
        mockMvc.perform(get("/comments/byCustomer/1")).andExpect(status().isOk())
                .andExpect(content().contentType(contentType));
    }

    @Test
    public void findByPlacerId() throws Exception {
        mockMvc.perform(get("/comments/byPlace/1")).andExpect(status().isOk())
                .andExpect(content().contentType(contentType));
    }

    @Test
    public void addComment() throws Exception{
        String commentJson = json(new Comment(),mappingJackson2HttpMessageConverter);
        this.mockMvc.perform(post("/comments")
        .contentType(contentType)
        .content(commentJson)).andExpect(status().isCreated());

    }

    protected String json(Object o, HttpMessageConverter messageConverter) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        messageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

}