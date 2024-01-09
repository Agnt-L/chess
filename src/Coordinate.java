import java.util.Objects;

public class Coordinate {
    private int rank;
    private int file;

    public Coordinate(int rank, int file) {
        this.rank = rank;
        this.file = file;
    }

    // Getters and setters for row and col
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return rank == that.rank && file == that.file;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, file);
    }
}
