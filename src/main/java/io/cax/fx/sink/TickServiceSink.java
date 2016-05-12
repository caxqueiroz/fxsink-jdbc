package io.cax.fx.sink;

import io.cax.fx.sink.domain.Tick;
import io.cax.fx.sink.repository.TickRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;

import static io.cax.fx.sink.Utils.convertToTick;
import static io.cax.fx.sink.Utils.mean;

/**
 * Created by cq on 12/5/16.
 */
@EnableBinding(Sink.class)
public class TickServiceSink {

    private static Logger logger = LoggerFactory.getLogger(TickServiceSink.class);


    private CounterService counterService;

    @Autowired
    public void setCounterService(CounterService counterService) {
        this.counterService = counterService;
    }


    private GaugeService gaugeService;

    @Autowired
    public void setGaugeService(GaugeService service) {
        this.gaugeService = service;
    }

    private TickRepository repository;

    @Autowired
    public void setRepository(TickRepository repository) {
        this.repository = repository;
    }

    @ServiceActivator(inputChannel=Sink.INPUT)
    public void sink(String payload) {

        logger.debug("Received: " + payload);
        Tick tick = repository.save(convertToTick(payload));

        counterService.increment("tick");
        gaugeService.submit(tick.getInstrument(),mean(tick.getAsk(),tick.getBid()));

    }
}
