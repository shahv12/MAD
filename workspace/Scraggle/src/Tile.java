
public class Tile {
	String character = "";
	Integer position = 0;
	Boolean isTileEmpty = true;
	
	public Boolean getIsTileEmpty() {
		return isTileEmpty;
	}

	public void setIsTileEmpty(Boolean isTileEmpty) {
		this.isTileEmpty = isTileEmpty;
	}

	public Tile(Integer position,Boolean isEmpty){
		this.position = position;
		this.isTileEmpty = isEmpty;
	}
	
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
}
