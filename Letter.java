import java.util.Objects;

public class Letter {
    private String sign;
    private String binary_code;

    public Letter(String sign, String binary_code){
        this.sign = sign;
        this.binary_code = binary_code;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBinary_code() {
        return binary_code;
    }

    public void setBinary_code(String binary_code) {
        this.binary_code = binary_code;
    }

    @Override
    public String toString() {
        return  sign + " " + binary_code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter = (Letter) o;
        return Objects.equals(sign, letter.sign) && Objects.equals(binary_code, letter.binary_code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sign, binary_code);
    }
}
