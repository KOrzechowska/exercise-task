package pl.opi.pib.interview.firsttask;


import org.junit.*;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class FirstTaskTest {

    protected final Logger log = Logger.getLogger(getClass().getName());

    @Rule
    public TestName name = new TestName();

    @Test
    public void testEmptyArray(){
        ArrayList<Integer> emptyList = new ArrayList<Integer>();
        ArrayList<Integer> result = FirstTask.filterEvenNumbers(emptyList);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testEvenFilter(){
        ArrayList<Integer> inputList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> result = FirstTask.filterEvenNumbers(inputList);
        Assert.assertEquals(new ArrayList<>(Arrays.asList(2, 4)), result);
    }

    @Before
    public void before(){
        log.info("Starting test " + name.getMethodName());
    }

    @After
    public void after(){
        log.info("Finishing test " + name.getMethodName());
    }
}
