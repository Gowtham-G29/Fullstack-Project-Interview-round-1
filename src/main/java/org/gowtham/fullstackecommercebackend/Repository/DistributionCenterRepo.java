package org.gowtham.fullstackecommercebackend.Repository;

import org.gowtham.fullstackecommercebackend.Model.DistributionCenters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DistributionCenterRepo extends JpaRepository<DistributionCenters, Long> {
}
