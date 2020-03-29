package Generics;

import model.Apple;
import model.Food;
import org.junit.Assert;
import org.junit.Test;

public class GenericsTest {

    @Test
    public void  test(){
        Assert.assertEquals(Apple.class,Generics.getTypeParameter(ServiceApplication.class));
        Assert.assertEquals(Apple.class,Generics.getTypeParameter(ServiceIocApplication.class, Food.class));

    }

}