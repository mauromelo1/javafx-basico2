package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	private int contador = 0;

	private void atualizarLabelNumero(Label label) {
		label.setText(Integer.toString(contador));
		label.getStyleClass().remove("verde");
		label.getStyleClass().remove("vermelho");

		if (contador >= 0) {
			label.getStyleClass().add("verde");
		}
		else {
			label.getStyleClass().add("vermelho");
		}

	}

	@Override
	public void start(Stage primaryStage) {
		try {

			Label labelTitulo = new Label("Contador");
			labelTitulo.getStyleClass().add("titulo");

			Label labelNumero = new Label("0");
			labelNumero.getStyleClass().add("numero");

			Button botaoDecremento = new Button("-");
			botaoDecremento.getStyleClass().add("botoes");
			botaoDecremento.setOnAction(e -> {
				contador--;
				atualizarLabelNumero(labelNumero);
			});

			Button botaoIncremento = new Button("+");
			botaoIncremento.getStyleClass().add("botoes");
			botaoIncremento.setOnAction(e -> {
				contador++;
				atualizarLabelNumero(labelNumero);
			});

			HBox boxBotoes = new HBox();
			boxBotoes.setAlignment(Pos.CENTER);
			boxBotoes.setSpacing(10);
			boxBotoes.getChildren().add(botaoDecremento);
			boxBotoes.getChildren().add(botaoIncremento);

			VBox boxPrincipal = new VBox();
			boxPrincipal.getStyleClass().add("conteudo");
			boxPrincipal.setAlignment(Pos.CENTER);
			boxPrincipal.setSpacing(10);
			boxPrincipal.getChildren().add(labelTitulo);
			boxPrincipal.getChildren().add(labelNumero);
			boxPrincipal.getChildren().add(boxBotoes);

			String caminhoDoCss = getClass().getResource("/application/application.css").toExternalForm();

			Scene cenaPrincipal = new Scene(boxPrincipal, 200, 230);
			cenaPrincipal.getStylesheets().add(caminhoDoCss);
			cenaPrincipal.getStylesheets().add("https://fonts.googleapis.com/css?family=Oswald");

			primaryStage.setScene(cenaPrincipal);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
