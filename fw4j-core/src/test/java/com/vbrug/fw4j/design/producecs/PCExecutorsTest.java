package com.vbrug.fw4j.design.producecs;

import com.vbrug.fw4j.core.design.producecs.PCPool;

import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author vbrug
 * @since 1.0.0
 */
public class PCExecutorsTest {

    public static void main(String[] args) throws Exception {
        TreeSet<Long> consumerTreeSet = new TreeSet<>();
        TreeSet<Long> producerTreeSet = new TreeSet<>();
        new PCPool<Long>("110").setDequeMaxSize(2)
                .push(new AConsumer(new AtomicLong(0L), consumerTreeSet).split(10))
                .push(new AProducer(1L, 100L, new AtomicLong(0L), producerTreeSet).split(10))
                .run();
        System.out.println(consumerTreeSet.toString());
        System.out.println(producerTreeSet.toString());
    }
}
