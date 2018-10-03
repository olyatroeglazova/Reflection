import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ReflectionDemoTest {
    @Test
    public void getCountOfHumanTest() {
        List<Object> list = new ArrayList<Object>() {{
            add(new Object());
            add(new Human("Surname1", "Name1", "Patronymic1", 1));
            add(new String("Human"));
            add(13);
            add(new Human("Surname2", "Name2", "Patronymic2", 2));
            add(new Student("Surname", "Name", "Patronymic", 3, "IMIT"));
        }};
        Assert.assertEquals(3, ReflectionDemo.getCountOfHuman(list));
    }

    @Test
    public void getNamesOfPublicMethodsTest() {
        Object o = new Object();
        List<String> expected = new ArrayList<String>() {{
            add("getClass");
            add("equals");
            add("hashCode");
            add("toString");
            add("notify");
            add("notifyAll");
            add("wait");
            add("wait");
            add("wait");
        }};
        Assert.assertTrue(ReflectionDemo.getNamesOfPublicMethods(o).containsAll(expected));
        Assert.assertEquals(ReflectionDemo.getNamesOfPublicMethods(o).size(), expected.size());
    }

    @Test
    public void getAllSuperclassesTest() {
        Human student = new Student("", "", "", 0, "");
        List<String> expected = new ArrayList<String>() {{
            add("Human");
            add("java.lang.Object");
        }};
        Assert.assertEquals(expected, ReflectionDemo.getAllSuperclasses(student));
    }

    @Test
    public void getAllSuperclassesTest2() {
        Object student = new Object();
        List<String> expected = new ArrayList<String>() {};
        Assert.assertEquals(expected, ReflectionDemo.getAllSuperclasses(student));
    }
}
