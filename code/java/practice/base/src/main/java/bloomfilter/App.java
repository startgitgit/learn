package bloomfilter;

import cn.hutool.core.lang.Assert;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/6/27 11:40
 */
public class App {
    public static void main(String[] args) {
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 500, 0.01);
        filter.put(1);
        filter.put(2);
        filter.put(3);
        Assert.isTrue(filter.mightContain(1));
        Assert.isTrue(filter.mightContain(10));
    }
}
