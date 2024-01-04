package hello.typeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class IntegerToStringConverter implements Converter {
    @Override
    public Object convert(Object source) {
        log.info("convert source={}", source);
        return String.valueOf(source);
    }
}
