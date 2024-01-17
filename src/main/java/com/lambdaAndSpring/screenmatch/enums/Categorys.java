package com.lambdaAndSpring.screenmatch.enums;

public enum Categorys {
	ACAO ("Action", "Ação"),
	COMEDIA ("Comedy", "Comédia"),
	ROMANCE ("Romance", "Romance"),
	DRAMA ("Drama", "Drama"),
	CRIME ("Crime", "Crime"),
	CURTO ("Short", "Curto"),
	ANIMACAO ("Animation", "Animação");
	private String categoryOmdb;
	private String categoyInPortuges;
	private Categorys(String categoryOmdb, String categoryInPortugues) {
		this.categoryOmdb = categoryOmdb;
		this.categoyInPortuges = categoryInPortugues;
	}
	public static Categorys fromString(String text) {
	    for (Categorys categoria : Categorys.values()) {
	        if (categoria.categoryOmdb.equalsIgnoreCase(text)) {
	            return categoria;
	        }
	    }
	    throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
	}
	
	public static Categorys fromCategoryInPortugues(String text) {
	    for (Categorys categoria : Categorys.values()) {
	        if (categoria.categoyInPortuges.equalsIgnoreCase(text)) {
	            return categoria;
	        }
	    }
	    throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
	}
}
