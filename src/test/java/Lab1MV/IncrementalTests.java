package Lab1MV;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IncrementalTests.class)
public class IncrementalTests {

    private IntegrationTests it;

    @Before
    public void setData() {
        it = new IntegrationTests();
    }

    @Test(expected = NullPointerException.class)
    public void addStudentTest() {
        it.addStudentTest();
    }

    @Test(expected = NullPointerException.class)
    public void addHomeworkTest() {
        it.addStudentTest();
        it.addHomeworkTest();
    }

    @Test(expected = NullPointerException.class)
    public void addGradeTest() {
        it.addStudentTest();
        it.addHomeworkTest();
        it.addGradeTest();
    }
}
