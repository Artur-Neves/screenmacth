package com.lambdaAndSpring.screenmatch.enums;

public enum Categorys {
	ACAO ("Action"),
	COMEDIA ("Comedy"),
	ROMANCE ("Romance"),
	DRAMA ("Drama"),
	CRIME ("Crime"),
	CURTO ("Short"),
	ANIMACAO ("Animation");
	private String categoryOmdb;

	private Categorys(String categoryOmdb) {
		this.categoryOmdb = categoryOmdb;
	}
	public static Categorys fromString(String text) {
	    for (Categorys categoria : Categorys.values()) {
	        if (categoria.categoryOmdb.equalsIgnoreCase(text)) {
	            return categoria;
	        }
	    }
	    throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
	}
}
