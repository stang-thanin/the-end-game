package controller;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;

public class AvengersDragController implements EventHandler<MouseEvent> {

	private StackPane stackPane;
	private Image image;

	public AvengersDragController(StackPane stackPane, Image image) {
		this.stackPane = stackPane;
		this.image = image;
	}

	public void handle(MouseEvent event) {
		Dragboard drag = this.stackPane.startDragAndDrop(TransferMode.MOVE);
		ClipboardContent content = new ClipboardContent();
		String id = this.stackPane.getId();
		content.putImage(this.image);
		if (id == "Ironman") {
			content.putString("Ironman");
		} else if (id == "BlackWidow") {
			content.putString("BlackWidow");
		} else if (id == "CaptainAmerica") {
			content.putString("CaptainAmerica");
		} else if (id == "Hawkeye") {
			content.putString("Hawkeye");
		} else if (id == "Hulk") {
			content.putString("Hulk");
		} else if (id == "Thor") {
			content.putString("Thor");
		}
		drag.setContent(content);
	}

}