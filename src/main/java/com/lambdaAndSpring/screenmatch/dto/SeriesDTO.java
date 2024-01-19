package com.lambdaAndSpring.screenmatch.dto;

import com.lambdaAndSpring.screenmatch.enums.Categorys;


public record SeriesDTO (
		 Long id,
		 String title,
		 Double avaliation,
		 Integer sesons,
		 Categorys genre,
		 String actors,
		 String poster, 
		 String plot) {

}
