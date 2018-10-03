import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Arrays.stream;

public class ReflectionDemo {

    //Найдите количество элементов списка, которые являются объектами типа Human или его подтипами
    public static long getCountOfHuman(List<Object> list) {
        return list.stream().filter(Human.class::isInstance).count();
    }

    //Для объекта получить список имен его открытых методов
    public static List<String> getNamesOfPublicMethods(Object o) {
        return stream(o.getClass().getMethods()).map(Method::getName).collect(Collectors.toList());
    }

    //Для объекта получить список (в виде списка строк) имен всех его суперклассов до класса Object включительно
    public static List<String> getAllSuperclasses(Object obj) {
        List<String> result = new ArrayList<>();
        Class tmp = obj.getClass().getSuperclass();
        while (tmp != null) {
            result.add(tmp.getName());
            tmp = tmp.getSuperclass();
        }
        return result;
    }

}
