package com.tedredington.apartment-finder;

import com.tedredington.apartment-finder.model.CraigslistAreas;
import com.tedredington.apartment-finder.model.CraigslistHousing;
import com.tedredington.apartment-finder.repository.CraigslistHousingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;
import java.util.Date;

@SpringBootApplication
public class ApartmentfinderApplication implements CommandLineRunner {

	@Autowired
	CraigslistHousingRepository craigslistHousingRepository;

	public static void main(String[] args) {

		SpringApplication.run(ApartmentfinderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CraigslistHousing clh = new CraigslistHousing();
		clh.setCraigslistId("6447330032");
		clh.setName("");
		URL url = new URL("https://google.com/test");
		clh.setUrl(url);
		clh.setDate(new Date());
		clh.setPrice(1232100);
		clh.setWhere("sunset / parkside");
		clh.setHasMap(false);
		clh.setHasImage(false);
		clh.setBedrooms(2);

		craigslistHousingRepository.save(clh);

		System.out.println(clh);
	}
}
