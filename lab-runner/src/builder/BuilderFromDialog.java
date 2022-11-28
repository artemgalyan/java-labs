package builder;

import java.awt.*;
import java.util.List;

public abstract class BuilderFromDialog<T> {
    public abstract T buildFrom(List<Object> params) throws IllegalParameterException;
    public abstract T inputFromDialog(Frame owner, String title);
}
