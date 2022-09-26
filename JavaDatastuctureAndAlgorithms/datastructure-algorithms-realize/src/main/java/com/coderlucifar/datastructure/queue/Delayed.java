package com.coderlucifar.datastructure.queue;

import java.util.concurrent.TimeUnit;

/**
 * @author sunyuan
 * @version 1.0
 * @description: 延迟
 * @date 2022/8/8 13:19
 */
public interface Delayed extends Comparable<Delayed>{

    long getDelay(TimeUnit unit);


}
