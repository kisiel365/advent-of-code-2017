package com.github.kisiel365.day25;

public interface CommandParser {

	boolean parse(String line, State state);

}
