package io.cax.fx.sink;

import io.cax.fx.sink.domain.Tick;
import io.cax.fx.sink.repository.TickRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by cq on 12/5/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
public class TickRepositoryTests {

    @Autowired
    TickRepository repository;

    @After
    public void tearDown(){
        repository.deleteAll();
    }

    @Test
    public void testSaveTick() throws Exception{

        saveTick();
        assertThat(repository.count(),equalTo(1L));

    }

    @Test
    public void testRetrieveTick() throws Exception{

        Tick returnedTick = saveTick();
        repository.findAll().forEach(tick -> assertThat(tick.getTime(),equalTo(returnedTick.getTime())));


    }

    private Tick saveTick() {
        Tick tick = new Tick();
        tick.setAsk(2.222);
        tick.setBid(2.333);
        tick.setTime(1461396366924145L);
        tick.setInstrument("AUD/USD");

        return repository.save(tick);
    }


}
