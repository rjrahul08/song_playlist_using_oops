import java.util.*;
public class Album {

    private List<Song> songs;

    public List<Song> getSong() {
        return songs;
    }

    public void setSong(List<Song> song) {
        this.songs = song;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    private String title;
    private  String artist;

    public Album(String title, String artist) {
        this.songs = new ArrayList<>();
        this.title = title;
        this.artist = artist;
    }
    // find song
    boolean findSong(String title){
        for(Song song : songs){
            if(song.getTitle().equals(title)) return true;

        }
        return false;
    }

    //add song to album
    String addSongToAlbum(String title,double duration){
        if(findSong(title) == false){
            Song s = new Song(title,duration);
            songs.add(s);
            return "Song added to the album";
        }
        return "Song is already exits";
    }
      String addSongToPlaylistFromAlbum(String title,List<Song> playlist){
        if(findSong(title) == true){
            for(Song s : songs){
                if(s.getTitle().equals(title)){
                    playlist.add(s);
                    return "Song added to your playlist";
                }
            }
        }
        return "Song not preset in the album";
    }
     String addSongToPlaylistFromAlbum(int trackNo, List<Song> playlist){
        int index = trackNo - 1;
        if(index > 0 && index<this.songs.size()){
            playlist.add(this.songs.get(index));
            return "Song added";
        }
        else
            return "Invald position of song";
    }
}
