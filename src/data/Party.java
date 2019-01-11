package data;

final public class Party {
	private final String name;

	public Party(String name) throws NullPointerException {
		if (name == null) {
			throw new NullPointerException("Party constructor received null object");
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Party that = (Party) o;
		return name.equals(that.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return "Party{" + "name='" + name + '\'' + '}';
	}
}