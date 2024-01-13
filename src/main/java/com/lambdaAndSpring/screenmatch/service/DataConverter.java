package com.lambdaAndSpring.screenmatch.service;

public interface DataConverter {
	<T> T getDatas(String json, Class<T> clas);
}
