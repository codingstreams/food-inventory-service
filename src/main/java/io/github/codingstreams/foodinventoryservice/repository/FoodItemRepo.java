package io.github.codingstreams.foodinventoryservice.repository;

import io.github.codingstreams.foodinventoryservice.model.FoodItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodItemRepo extends MongoRepository<FoodItem, String> {
}
