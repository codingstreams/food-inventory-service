package io.github.codingstreams.foodinventoryservice.controller;

import io.github.codingstreams.foodinventoryservice.model.FoodItem;
import io.github.codingstreams.foodinventoryservice.repository.FoodItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/food-inventory")
@RequiredArgsConstructor
public class MainController {
  private final FoodItemRepo foodItemRepo;

  @PostMapping("/")
  public ResponseEntity<FoodItem> saveFoodItem(@RequestBody FoodItem foodItem) {
    return ResponseEntity.ok()
        .body(foodItemRepo.save(foodItem));
  }

  @GetMapping("/{id}")
  public ResponseEntity<FoodItem> getFoodItemById(@PathVariable String id) {
    var optionalFoodItem = foodItemRepo.findById(id);

    if (optionalFoodItem.isEmpty()) {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body(null);
    }

    return ResponseEntity.ok()
        .body(optionalFoodItem.get());
  }
}
