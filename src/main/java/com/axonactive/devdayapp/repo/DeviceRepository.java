package com.axonactive.devdayapp.repo;

import com.axonactive.devdayapp.domain.Device;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {}

