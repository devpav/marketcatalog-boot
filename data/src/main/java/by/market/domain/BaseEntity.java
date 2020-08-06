package by.market.domain;

import by.market.domain.generator.DeserializeUUID;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

    @Id
    @GenericGenerator(name = "useIdOrGenerate", strategy = "by.market.domain.generator.Generator")
    @GeneratedValue(generator = "useIdOrGenerate")
    @Column(name = "id", nullable = false, unique = true)
    @JsonDeserialize(using = DeserializeUUID.class)
    protected UUID id;

}
