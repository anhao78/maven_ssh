package com.properties.hashset;

public class Bean {
	private int id;
	private String name;

	public Bean() {
		super();
	}

	public Bean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Bean)) {
			return false;
		}
		Bean b = (Bean) obj;
		if (this.id == b.id) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return id;
	}
	public static void main(String[] args) {
		Bean b=null;
		b.setId(1024);
		b.setName("asdf");
		System.out.println(b.getId());
	}
}
