
package com.mycompany.batarang.solutions;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author Cristian Sigel
 */
public class BatsiController {
    private BatsiModel model;
    private BatsiView view;

    public BatsiController(BatsiModel model, BatsiView view) {
        this.model = model;
        this.view = view;
    }

    public void fetchAuthorData(String apiKey) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String url = "https://serpapi.com/search?engine=google_scholar&q=ciencia&api_key=" + apiKey;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            if (statusCode == 200) {
                model.setAuthorData(response.body());
            } else {
                System.out.println("Error en la conexión. Código de estado: " + statusCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updateView() {
        view.displayAuthorData(model.getAuthorData());
    }

}
