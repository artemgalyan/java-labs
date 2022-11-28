package builder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectDialogInput<T> {
    public ObjectDialogInput(Frame owner, String title, List<Field> inputDataTypeList, BuilderFromDialog<T> builder) {
        this.builder = builder;
        this.inputDataTypeList = inputDataTypeList;
        this.owner = owner;
        this.title = title;
    }

    private final Frame owner;
    private final String title;
    private final List<ObjectDialogInput.Field> inputDataTypeList;
    private final BuilderFromDialog<T> builder;
    static final List<Class<?>> allowedClasses = Arrays.asList(Integer.class, Double.class, Float.class, String.class);

    public static class Field {
        private final String message;
        private final Class<?> dataType;

        public Field(String message, Class<?> dataType) {
            this.message = message;
            this.dataType = dataType;
        }
    }

    public T get() {
        List<Object> params = new ArrayList<>();
        for (Field f : inputDataTypeList) {
            Object value = inputField(f);
            if (value == null) {
                return null;
            }
            params.add(value);
        }
        try {
            return builder.buildFrom(params);
        } catch (IllegalParameterException e) {
            int value = JOptionPane.showConfirmDialog(owner, "The data is wrong. Would you like to input data again?", "Error", JOptionPane.OK_CANCEL_OPTION);
            if (value == JOptionPane.OK_OPTION) {
                return get();
            }
            return null;
        }
    }

    private Object inputField(Field f) {
        while (true) {
            String text = JOptionPane.showInputDialog(owner, "Input field " + f.message);
            Object value = match(text, f.dataType);
            if (value != null) {
                return value;
            }
            int result = JOptionPane.showConfirmDialog(owner, "Wrong input. The field is of type " + f.dataType.getName() + ". Would you like to continue?",
                    "Error", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.NO_OPTION) {
                return null;
            }
        }
    }

    private Object match(String text, Class<?> type) {
        if (type == Integer.class) {
            try {
                return Integer.parseInt(text);
            } catch (Exception e) {
                return null;
            }
        }
        if (type == Double.class) {
            try {
                return Double.parseDouble(text);
            } catch (Exception e) {
                return null;
            }
        }
        if (type == Float.class) {
            try {
                return Float.parseFloat(text);
            } catch (Exception e) {
                return null;
            }
        }
        return text;
    }
}
