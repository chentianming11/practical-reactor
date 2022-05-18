import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;

/**
 * @author 陈添明
 * @since 2022/5/11 8:27 下午
 */
public class FluxTest {

    @Test
    public void test() {
        Flux.range(1, 1000)
                .publishOn(Schedulers.parallel())
                .doOnNext(i -> {
                    try {
                        Thread.sleep(100);
                        System.out.println(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                })
                .blockLast();
//                .subscribeOn(Schedulers.boundedElastic())

        System.out.println("消费结束");
    }
}
