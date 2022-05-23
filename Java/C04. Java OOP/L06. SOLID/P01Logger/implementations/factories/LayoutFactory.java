package L06SOLID.Exercise.P01Logger.implementations.factories;

import L06SOLID.Exercise.P01Logger.implementations.layouts.SimpleLayout;
import L06SOLID.Exercise.P01Logger.implementations.layouts.XmlLayout;
import L06SOLID.Exercise.P01Logger.interfaces.Factory;
import L06SOLID.Exercise.P01Logger.interfaces.Layout;

public class LayoutFactory implements Factory<Layout> {


    @Override
    public Layout produce(String input) {
        Layout layout = null;

        if (input.equals("SimpleLayout")) {
            layout = new SimpleLayout();
        } else if (input.equals("XmlLayout")) {
            layout = new XmlLayout();
        }

        return layout;
    }
}
