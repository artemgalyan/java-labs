package builder;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectInputDialogBuilder<T> {
    private final Frame owner;
    private final String title;
    private final List<ObjectDialogInput.Field> fields = new ArrayList<>();
    private final BuilderFromDialog<T> builder;

    public ObjectInputDialogBuilder(Frame owner, String title, BuilderFromDialog<T> builder) {
        this.owner = owner;
        this.title = title;
        this.builder = builder;
    }

    public ObjectInputDialogBuilder<T> addField(String name, Class<?> clazz) {
        if (!ObjectDialogInput.allowedClasses.contains(clazz)) {
            throw new IllegalArgumentException(clazz.getName() + " is not supported by builder");
        }

        fields.add(new ObjectDialogInput.Field(name, clazz));
        return this;
    }

    public ObjectDialogInput<T> build() {
        return new ObjectDialogInput<>(owner, title, fields, builder);
    }
}
