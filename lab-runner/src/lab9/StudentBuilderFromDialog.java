package lab9;

import builder.*;
import java.awt.*;
import java.util.List;

public class StudentBuilderFromDialog extends BuilderFromDialog<Student> {
    @Override
    public Student buildFrom(List<Object> params) throws IllegalParameterException {
        if (!ClassValidator.validate(params, Integer.class, Object.class, Integer.class, Integer.class)) {
            throw new IllegalParameterException();
        }
        return new Student((int)params.get(0), params.get(1).toString(), (int)params.get(2), (int)params.get(3));
    }

    @Override
    public Student inputFromDialog(Frame owner, String title) {
        ObjectInputDialogBuilder<Student> builder = new ObjectInputDialogBuilder<>(owner, title, this);
        builder.addField("Id", Integer.class)
                .addField("Surname", String.class)
                .addField("Course", Integer.class)
                .addField("Group", Integer.class);
        ObjectDialogInput<Student> dialog = builder.build();
        return dialog.get();
    }
}
