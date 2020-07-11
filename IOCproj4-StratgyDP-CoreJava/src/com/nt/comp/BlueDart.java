package com.nt.comp;

public final class BlueDart implements Courier {
  
	public BlueDart()
	{
		System.out.println("BlueDart::0-param constructor");
	}
	@Override
	public String deliver(int oid) {
		return "BlueDart courier will deliver  order id::"+oid+"order products";
	}

}
