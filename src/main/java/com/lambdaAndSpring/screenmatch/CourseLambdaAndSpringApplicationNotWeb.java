package com.lambdaAndSpring.screenmatch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import com.lambdaAndSpring.screenmatch.model.EpisodeR;
import com.lambdaAndSpring.screenmatch.model.Season;
import com.lambdaAndSpring.screenmatch.model.SeriesR;
import com.lambdaAndSpring.screenmatch.repository.SeriesRepository;
import com.lambdaAndSpring.screenmatch.resources.Seriesresouces;
import com.lambdaAndSpring.screenmatch.service.ApiCall;
import com.lambdaAndSpring.screenmatch.service.ConsultationGPT;
import com.lambdaAndSpring.screenmatch.service.Datas;

//@SpringBootApplication
//public class CourseLambdaAndSpringApplicationNotWeb implements CommandLineRunner  {
//	@Autowired
//	Seriesresouces series;
//	public static void main(String[] args) {
//		SpringApplication.run(CourseLambdaAndSpringApplicationNotWeb.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		
//		series.showMenu();
//		
//	}
//
//}
