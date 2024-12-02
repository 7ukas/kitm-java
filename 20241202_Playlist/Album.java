import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album (String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) != null) return false;

        Song song = new Song(title, duration);
        songs.add(song);

        return songs.contains(song);
    }

    private Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }

        return null;
    }

    public boolean addToPlayList(int songNumber, LinkedList<Song> playlist) {
        if (songNumber > songs.size()) return false;

        Song song = songs.get(songNumber-1);
        playlist.push(song);

        return playlist.peek() == song;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song song = findSong(title);
        if (song == null) return false;

        playlist.push(song);

        return playlist.peek() == song;
    }

    @Override
    public String toString() {
        return String.join(", ", songs.toString());
    }
}
