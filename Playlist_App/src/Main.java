import java.util.*;

public class Main {
    public static void main(String[] args) {
        Album album1 = new Album("Rockstar","Mohit Chauhan");
        album1.addSongToAlbum("Sadda Haq",5.2);
        album1.addSongToAlbum("Kun Faya Kun",6.0);
        album1.addSongToAlbum("Hawa Hawa",3.1);

        Album album2 = new Album("Ashique 2","Arijit Singh");
        album2.addSongToAlbum("Sun Raha Hai ", 5.0);
        album2.addSongToAlbum("Tere Bina",4.1);
        album2.addSongToAlbum("Chahun main ya na",3.5);

        List<Song> myPlaylist = new LinkedList<>();
        System.out.println(album1.addSongToPlaylistFromAlbum("Sadda Haq",myPlaylist));
        System.out.println(album2.addSongToPlaylistFromAlbum("Sun Raha Hai",myPlaylist));
        System.out.println(album2.addSongToPlaylistFromAlbum(2,myPlaylist));
        System.out.println(album2.addSongToPlaylistFromAlbum("Chahun main ya na",myPlaylist));

        play(myPlaylist);

    }
    public static void play(List<Song> playlist){
        ListIterator<Song> itr  = playlist.listIterator();
        if(playlist.size() == 0){
            System.out.println("Playlist is empty");
            return;
        }

        boolean isNext;
        System.out.println("Currently Playing : ");
        System.out.println(itr.next());
        isNext = true;

        Scanner sc  = new Scanner(System.in);
        printMenu();
        while (true){
            System.out.println("Enter Your Choice :");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    if(!isNext){
                        itr.next();
                        isNext = true;
                    }
                    if(itr.hasNext()){
                        System.out.println("Now Playing");
                        System.out.println(itr.next());
                        isNext= true;
                    }
                    else System.out.println("You have reach the end of playlist");
                    break; 
                case 2:
                    if(isNext){
                        itr.previous();
                        isNext = false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println("Now Playing");
                        System.out.println(itr.previous());
                        isNext = false;
                    }
                    else System.out.println("You are on the first song of playlist");
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    printAllSong(playlist);
                    break;
                case 6:
                    printMenu();
                    break;
                case 7: // Exit
                    return;
            }
        }
    }
    static void printAllSong(List<Song> playlist){
        for(Song songs:playlist)
            System.out.println(songs);
        return;
    }
    static void printMenu(){
        System.out.println("1. Play next song ");
        System.out.println("2. Play previous song");
        System.out.println("3. Play current Song");
        System.out.println("4. Delete Current Song");
        System.out.println("5. Show All Songs");
        System.out.println("6.Show menu again");
        System.out.println("7.Exit");
    }
}