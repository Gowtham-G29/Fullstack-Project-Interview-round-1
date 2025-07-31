package org.gowtham.fullstackecommercebackend.Repository;

import org.gowtham.fullstackecommercebackend.Model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemRepo extends JpaRepository<InventoryItem, Long> {

}
