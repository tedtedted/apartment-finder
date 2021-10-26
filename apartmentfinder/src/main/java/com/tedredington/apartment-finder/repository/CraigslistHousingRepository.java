package com.tedredington.apartment-finder.repository;

import com.tedredington.apartment-finder.model.CraigslistHousing;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CraigslistHousingRepository extends MongoRepository<CraigslistHousing, String> {
}
