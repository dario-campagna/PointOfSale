package it.esteco.pos.adapters.display;

import javafx.scene.control.Label;

public class LabelDisplayArea implements DisplayArea {

    private Label label;

    public LabelDisplayArea(Label label) {
        this.label = label;
    }

    @Override
    public void show(String text) {
        label.setText(text);
    }
}
