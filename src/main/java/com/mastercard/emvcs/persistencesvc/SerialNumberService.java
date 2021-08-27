package com.mastercard.emvcs.persistencesvc;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metamodel.spi.MetamodelImplementor;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mastercard.emvcs.persistencesvc.UnallocatedSn;

import javax.persistence.EntityManagerFactory;

@Service
public class SerialNumberService {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

//    SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
//    MetamodelImplementor metamodel = (MetamodelImplementor) sessionFactory.getMetamodel();
//    ClassMetadata classMetadata = (ClassMetadata) metamodel.entityPersister(entityName);

    @Autowired
    private SerialNumberRepository serialNumberRepository;

    public List<UnallocatedSn> getAllUnallocatedSn()
    {
        List<UnallocatedSn>unallocatedSnList = new ArrayList<>();
        serialNumberRepository.findAll().forEach(unallocatedSnList::add);
        return unallocatedSnList;
    }


    public void setUnallocatedSerialNumberInfo(UnallocatedSn unallocatedSn)
    {
        serialNumberRepository.save(unallocatedSn);
    }
}
