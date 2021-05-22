package tomorrowcook.mp.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tomorrowcook.mp.domain.Posting;
import tomorrowcook.mp.repository.PostingRepository;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class PostingServiceTest {

    @Autowired
    PostingService postingService;
    @Autowired
    PostingRepository postingRepository;

    @Test
    public void posting() throws Exception {
        //Given
        Posting posting =  new Posting();
        posting.setInformation("123123");
        posting.setTitle("title");
        //When
        Long saveId = postingService.join(posting);
        //Then
        assertEquals(posting, postingRepository.findOne(saveId));
    }

}