package com.epam.aws.training.repository;

import com.epam.aws.training.repository.model.ImageMetadata;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageMetadataRepository extends JpaRepository<ImageMetadata, Long> {

  Optional<ImageMetadata> findByName(String name);

  void deleteByName(String name);

  @Query(value = "SELECT * FROM image_metadata im ORDER BY RAND() LIMIT 1", nativeQuery = true)
  ImageMetadata findRandom();
}
