package com.mastercard.emvcs.persistencesvc;

import net.bytebuddy.jar.asm.commons.Remapper;
import org.apache.catalina.mapper.Mapper;
import org.springframework.data.repository.CrudRepository;
import com.mastercard.emvcs.persistencesvc.UnallocatedSn;

import java.util.List;
import java.util.UUID;

public interface SerialNumberRepository extends CrudRepository<UnallocatedSn, UUID> {
    UnallocatedSn findByRidAndCaPKIdx(String rid, String caPKIdx);
//    List<UnallocatedSn> findByRidAndCaPKIdx(String rid, String capkidx);
}
