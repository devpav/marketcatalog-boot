package by.market.domain.generator;

import by.market.domain.BaseEntity;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDGenerator;

import java.io.Serializable;

import static java.util.Objects.isNull;

public class Generator extends UUIDGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        if (isNull(object)) throw new HibernateException(new NullPointerException());

        final BaseEntity baseEntity = (BaseEntity) object;

        return isNull( baseEntity.getId() ) ? super.generate(session, object) : baseEntity.getId();
    }

}
