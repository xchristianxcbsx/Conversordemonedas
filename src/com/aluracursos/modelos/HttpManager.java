package com.aluracursos.modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HttpManager {
	private String apiKey;
	private HttpClient client;
	private Gson gson;

	public HttpManager() {
		this.apiKey = "2d58917211206ec5318c56a8";
		this.client = HttpClient.newHttpClient();
		this.gson = new GsonBuilder().setPrettyPrinting().create();
	}

	public Moneda realizarSolicitud(String fromCurreny, String toCurrency) throws IOException, InterruptedException {
		String direccion = "https://v6.exchangerate-api.com/v6/" + this.apiKey + "/pair/" + fromCurreny + "/"
				+ toCurrency;
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		return fromJsonToMoneda(response);
	}

	private Moneda fromJsonToMoneda(HttpResponse<String> response) {
		String json = response.body();
		Moneda moneda = gson.fromJson(json, Moneda.class);
		return moneda;
	}

}
