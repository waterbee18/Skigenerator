package guesski.view;

public enum View {

    MENU("/guesski/view/Menu.fxml"),
    GAME("/guesski/view/interjeu.fxml"),
    HELP("/guesski/view/Help.fxml"),
    POPUP("/guesski/view/Popup.fxml");

    private String path;

    View(String p){
        path = p;
    }

    public String getPath(){
        return path;
    }
}
