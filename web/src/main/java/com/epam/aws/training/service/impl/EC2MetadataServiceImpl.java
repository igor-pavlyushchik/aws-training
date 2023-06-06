package com.epam.aws.training.service.impl;

import com.amazonaws.util.EC2MetadataUtils;
import com.epam.aws.training.dto.EC2Metadata;
import com.epam.aws.training.service.EC2MetadataService;
import org.springframework.stereotype.Service;

@Service
public class EC2MetadataServiceImpl implements EC2MetadataService {

  @Override
  public EC2Metadata retrieveMetadata() {
    var region = EC2MetadataUtils.getEC2InstanceRegion();
    var availabilityZone = EC2MetadataUtils.getAvailabilityZone();
    return EC2Metadata.builder()
        .region(region)
        .availabilityZone(availabilityZone)
        .build();
  }
}
