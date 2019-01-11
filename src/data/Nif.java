package data;

import java.util.Objects;

final public class Nif {
	private final String nif;

	public Nif(String nif) throws NullPointerException{
		if (nif == null){
			throw new NullPointerException("Nif constructor received null object");
		}
		this.nif = nif;
	}

	public String getNif() {
		return nif;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Nif that = (Nif) o;
		return Objects.equals(nif, that.nif);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nif);
	}

	@Override
	public String toString() {
		return "Nif{" +
			   "nif='" + nif + '\'' +
			   '}';
	}
}
