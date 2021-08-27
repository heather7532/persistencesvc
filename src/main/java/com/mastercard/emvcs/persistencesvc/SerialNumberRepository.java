package com.mastercard.emvcs.persistencesvc;

import org.springframework.data.repository.CrudRepository;
import com.mastercard.emvcs.persistencesvc.UnallocatedSn;

public interface SerialNumberRepository extends CrudRepository<UnallocatedSn, String> {
}
