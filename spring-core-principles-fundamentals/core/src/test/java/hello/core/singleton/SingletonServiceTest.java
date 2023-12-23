package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonServiceTest {

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest() {

        SingletonService instance = SingletonService.getInstance();
        SingletonService instance1 = SingletonService.getInstance();

        Assertions.assertThat(instance1).isSameAs(instance);
    }
}
