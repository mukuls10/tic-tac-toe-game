package Model;

public class Player {
    public String name;
    public PlayingPiece playingPiece;

    public Player(String name, PlayingPiece piece) {
        this.name = name;
        this.playingPiece = piece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }
}
