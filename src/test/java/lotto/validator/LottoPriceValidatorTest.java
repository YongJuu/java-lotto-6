package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 가격 validation")
class LottoPriceValidatorTest {

    @DisplayName("8000은 Validator 정상 통과")
    @Test
    void testValidate_정상_동작() {
        //given
        String input = "8000";

        //when & then
        assertThatNoException().isThrownBy(
                () -> LottoPriceValidator.validate(input)
        );
    }

    @Test
    void 숫자_아닌_입력이면_예외() {
        //given
        String input = " a 13";

        //when & then
        assertThatThrownBy(() -> LottoPriceValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }

    @DisplayName("1000원으로 나누어 떨어지지 않는 입력 ")
    @Test
    void NotDividedBy1000() {
        //given
        String input = "1007";

        //when & then
        assertThatThrownBy(() -> LottoPriceValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR} 구매 금액은 1000원 단위로 작성되어야 합니다.");
    }
}