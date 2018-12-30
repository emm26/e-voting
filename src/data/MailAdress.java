package data;

import java.util.Objects;

final public class MailAdress {
    private final String mailAdress;

    public MailAdress(String mailAdress) {
        this.mailAdress = mailAdress;
    }

    public String getMailAdress() {
        return mailAdress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailAdress that = (MailAdress) o;
        return Objects.equals(mailAdress, that.mailAdress);
    }

    @Override
    public String toString() {
        return "MailAdress{" +
                "mailAdress='" + mailAdress + '\'' +
                '}';
    }
}
