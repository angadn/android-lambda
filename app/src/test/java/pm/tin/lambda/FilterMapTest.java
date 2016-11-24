package pm.tin.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class FilterMapTest {
    @Test
    public void filter() throws Exception {
        LambdaCollection<String> collection = new LambdaCollection<>(Arrays.asList(
                "Pen", "Pineapple", "Apple", "Pen"
        ));

        assertEquals(3, collection.filter(new FilterLambda<String>() {
            @Override
            public boolean filter(String value) {
                return value.startsWith("P");
            }
        }).size());
    }

    @Test
    public void map() throws Exception {
        final String apple = "apple", pen = "pen", pineapple = "pineapple";
        LambdaCollection<String> collection = new LambdaCollection<>(Arrays.asList(
                pen, pineapple, apple, pen
        ));
        assertArrayEquals(new Integer[]{
                Integer.valueOf(apple.length()) // 5
        }, collection.map(new MapLambda<String, Integer>() {
            @Override
            public Integer map(String value) {
                return value.length();
            }
        }).filter(new FilterLambda<Integer>() {
            @Override
            public boolean filter(Integer value) {
                return value.equals(5);
            }
        }).toArray());
    }
}