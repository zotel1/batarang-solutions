package com.mycompany.batarang.solutions;

/* api-key = 0a7f9bd044bb822ed6f3ae5a254d75e457cdc399e66257ca84eff292af3f1a0e*/

public class BatarangSolutions {

    public static void main(String[] args) {
         
        String apiKey = "0a7f9bd044bb822ed6f3ae5a254d75e457cdc399e66257ca84eff292af3f1a0e";

        BatsiModel model = new BatsiModel();
        BatsiView view = new BatsiView();
        BatsiController controller = new BatsiController(model, view);

        controller.fetchAuthorData(apiKey);
        controller.updateView();
    

        }
}
  
