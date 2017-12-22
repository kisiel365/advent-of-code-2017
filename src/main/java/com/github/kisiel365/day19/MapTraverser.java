package com.github.kisiel365.day19;

public class MapTraverser {

	private final char[][] map;
	private boolean pathAvailable = true;
	private Position position;
	private Direction direction;

	public MapTraverser(char[][] map, Position startingPosition, Direction startingDirection) {
		this.map = map;
		this.position = startingPosition;
		this.direction = startingDirection;
	}

	public Position getPosition() {
		return position;
	}

	public void moveNextStep() {
		if (!hasPathAhead()) {
			if (hasPathToLeft())
				direction = direction.directionToLeft();
			else if (hasPathToRight())
				direction = direction.directionToRight();
			else
				pathAvailable = false;
		}
		position = position.makeStep(direction);
	}

	public boolean hasPathAvailable() {
		return pathAvailable;
	}

	private boolean hasPathToRight() {
		Direction directionToRight = direction.directionToRight();
		Position positionToRight = position.makeStep(directionToRight);
		return isTileAPath(positionToRight);
	}

	private boolean hasPathToLeft() {
		Direction directionToLeft = direction.directionToLeft();
		Position positionToLeft = position.makeStep(directionToLeft);
		return isTileAPath(positionToLeft);
	}

	private boolean hasPathAhead() {
		Position positionAhead = position.makeStep(direction);
		return isTileAPath(positionAhead);
	}

	private boolean isTileAPath(Position position) {
		if (position.getX() < 0 || position.getY() < 0 || position.getX() > map[0].length - 1
				|| position.getY() > map.length - 1)
			return false;
		if (map[position.getY()][position.getX()] != ' ')
			return true;
		return false;
	}

}
