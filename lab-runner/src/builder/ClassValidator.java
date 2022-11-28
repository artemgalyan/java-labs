package builder;

import java.util.List;

public class ClassValidator {
    public static boolean validate(List<?> objects, Class<?>... classes) {
        if (objects.size() != classes.length) {
            return false;
        }

        for (int i = 0; i < objects.size(); ++i) {
            Class<?> toCheck = classes[i];
            Class<?> given = objects.get(i).getClass();
            if (!toCheck.isAssignableFrom(given)) {
                return false;
            }
        }
        return true;
    }
}
