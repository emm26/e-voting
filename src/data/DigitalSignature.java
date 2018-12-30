package data;

import java.util.Arrays;
import java.util.Objects;

final public class DigitalSignature {
    private final byte[] digitalsignature;

    public DigitalSignature(byte[] digitalsignature) {
        this.digitalsignature = digitalsignature;
    }

    public byte[] getDigitalSignature() {
        return digitalsignature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalSignature that = (DigitalSignature) o;
        return Arrays.equals(digitalsignature, that.digitalsignature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(digitalsignature);
    }

    @Override
    public String toString() {
        return "DigitalSignature{" +
                "digitalsignature=" + Arrays.toString(digitalsignature) +
                '}';
    }
}
