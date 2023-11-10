package com.example.demo3;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;

public class MenuController implements Initializable {

    private final ObservableList<String> listOfValutes = FXCollections.observableArrayList("USD", "EUR", "RUB", "FOU");


    @FXML
    private ComboBox<String> valuteComboBox;

    @FXML
    private TextField enterDataField;

    @FXML
    private Label resultTextField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        valuteComboBox.setItems(listOfValutes);
    }

    @FXML
    public void onCountButtonClick(ActionEvent actionEvent) {
        switch (valuteComboBox.getValue()) {
            case "EUR" -> convertToEuro(enterDataField.getText());
            case "USD" -> convertToDollar(enterDataField.getText());
            case "RUB" -> convertToRuble(enterDataField.getText());
            case "FOU" -> convertToFount(enterDataField.getText());
            default -> showWarning();
        }
    }

    private void showWarning() {
        resultTextField.setText("Выберите валюту");
    }

    private void convertToFount(String text) {
        try {
            double founts = Double.parseDouble(text);
            founts /= 150;
            resultTextField.setText(String.valueOf(founts));
        }
        catch (Exception e) {
            resultTextField.setText("Неверные данные.");
            System.out.println(e);
        }
    }

    private void convertToRuble(String text) {
        try {
            double founts = Double.parseDouble(text);
            resultTextField.setText(String.valueOf(founts));
        }
        catch (Exception e) {
            resultTextField.setText("Неверные данные.");
            System.out.println(e);
        }
    }

    private void convertToDollar(String text) {
        try {
            double dollars = Double.parseDouble(text);
            dollars /= 100;
            resultTextField.setText(String.valueOf(dollars));
        }
        catch (Exception e) {
            resultTextField.setText("Неверные данные.");
            System.out.println(e);
        }
    }

    private void convertToEuro(String text) {
        try {
            double euros = Double.parseDouble(text);
            euros /= 110;
            resultTextField.setText(String.valueOf(euros));
        }
        catch (Exception e) {
            resultTextField.setText("Неверные данные.");
            System.out.println(e);
        }
    }
}
