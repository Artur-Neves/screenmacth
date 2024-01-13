package com.lambdaAndSpring.screenmatch.service;


import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
public class ConsultationGPT {
	    public static String obterTraducao(String texto) {
	        OpenAiService service = new OpenAiService("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");


	        CompletionRequest requisicao = CompletionRequest.builder()
	                .model("gpt-3.5-turbo-instruct")
	                .prompt("Traduza este texto do inglês para o portugês: " + texto)
	                .maxTokens(1000)
	                .temperature(0.7)
	                .build();


	        var resposta = service.createCompletion(requisicao);
	        return resposta.getChoices().get(0).getText();
	    }
	

}
