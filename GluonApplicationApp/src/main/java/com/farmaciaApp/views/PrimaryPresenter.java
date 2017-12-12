package com.farmaciaApp.views;

import com.farmaciaApp.api.RestStockProduct;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.farmaciaApp.main;
import com.gluonhq.charm.glisten.layout.layer.FloatingActionButton;
import com.gluonhq.connect.GluonObservableList;
import com.gluonhq.connect.provider.DataProvider;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.json.JSONArray;
import org.json.JSONObject;

public class PrimaryPresenter {

    @FXML
    private View primary;

    @FXML
    private Label label;
    
    @FXML
    private ListView itemList;

    public void initialize() {
        primary.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().showLayer(main.MENU_LAYER)));
                appBar.setTitleText("Primary");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> 
                        System.out.println("Search")));
            }
        });
        
        primary.getLayers().add(new FloatingActionButton(MaterialDesignIcon.ADD.text, 
            e -> System.out.println("Info")).getLayer());
        
        this.popularList();
    }
    
    private void popularList(){
        GluonObservableList<String> lst = new GluonObservableList<String>();
        JSONArray itemArray = RestStockProduct.listStockProduct();
        
        for(int i = 0; i < itemArray.length(); i++){
            JSONObject obj = itemArray.getJSONObject(i);
            lst.add(obj.get("id") + " - " + obj.get("name"));
        }
        
        itemList.setItems(lst);
    }
    
    @FXML
    void buttonClick() {
        label.setText("Hello JavaFX Universe!");
    }
    
}
