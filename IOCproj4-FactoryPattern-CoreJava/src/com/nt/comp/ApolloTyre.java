package com.nt.comp;

public class ApolloTyre implements Tyre {

	public ApolloTyre() {
  	  System.out.println("ApolloTyre::0-param constructor");
    }
	@Override
	public String roadGrip() {
		return "Apollo Type::Standard Road Grip---> suitable for any transportation";

	}

}
