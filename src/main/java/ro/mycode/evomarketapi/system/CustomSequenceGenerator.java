package ro.mycode.evomarketapi.system;

import jakarta.transaction.Transactional;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CustomSequenceGenerator {

    private static final String PREFIX = "source-";
    private static final int PADDING_LENGTH = 4;

    @Autowired
    private CustomSequenceRepo sequenceRepository;


    @Transactional
    public String generateSequence(String sequenceName) {
        CustomSequence sequence = sequenceRepository.findByName(sequenceName);
        if (sequence == null) {
            sequence = new CustomSequence();
            sequence.setName(sequenceName);
        }

        int nextValue = sequence.getNextValue();
        String sequenceValue = String.format("%s%0" + PADDING_LENGTH + "d", PREFIX, nextValue);

        sequence.setNextValue(nextValue + 1);
        sequenceRepository.save(sequence);

        return sequenceValue;
    }
}