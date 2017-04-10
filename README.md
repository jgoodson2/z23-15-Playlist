# z23-15-Playlist

    Students:
    This content is controlled by your instructor, and is not zyBooks content. Direct questions or concerns about this content to your instructor. If you have any technical issues with the zyLab submission system, use the "Trouble with lab?" button at the bottom of the lab.
    You will be building a linked list. Make sure to keep track of both the head and tail nodes.
 
##(1) Create two files to submit.

* SongEntry.java - Class declaration
* Playlist.java - Contains main() method

Build the `SongEntry` class per the following specifications. Note: Some methods can initially be method stubs (empty methods), to be completed in later steps.

###Private fields

* String uniqueID - Initialized to "none" in default constructor
* string songName - Initialized to "none" in default constructor
* string artistName - Initialized to "none" in default constructor
* int songLength - Initialized to 0 in default constructor
* SongEntry nextNode - Initialized to null in default constructor
* Default constructor (1 pt)
* Parameterized constructor (1 pt)

###Public member methods

* void insertAfter(SongEntry currNode) (1 pt)
* void setNext(SongEntry nextNode) - Mutator (1 pt)
* String getID()- Accessor
* String getSongName() - Accessor
* String getArtistName() - Accessor
* int getSongLength() - Accessor
* SongEntry getNext() - Accessor
* void printPlaylistSongs()

###Ex. of printPlaylistSongs output:

Unique ID: S123
Song Name: Peg
Artist Name: Steely Dan
Song Length (in seconds): 237

##(2) In main(), prompt the user for the title of the playlist. (1 pt) 

Ex:

Enter playlist's title:
JAMZ 

##(3) Implement the printMenu() method. printMenu() takes the playlist title as a parameter and a Scanner object, outputs a menu of options to manipulate the playlist, and reads the user menu selection. Each option is represented by a single character. Build and output the menu within the method.

If an invalid character is entered, continue to prompt for a valid choice. Hint: Implement Quit before implementing other options. Call printMenu() in the main() method. Continue to execute the menu until the user enters q to Quit. (3 pts) 

Ex:

JAMZ PLAYLIST MENU
a - Add song
d - Remove song
c - Change position of song
s - Output songs by specific artist
t - Output total time of playlist (in seconds)
o - Output full playlist
q - Quit

Choose an option:

##(4) Implement "Output full playlist" menu option. If the list is empty, output: Playlist is empty (3 pts) 

Ex:

JAMZ - OUTPUT FULL PLAYLIST
1.
Unique ID: SD123
Song Name: Peg
Artist Name: Steely Dan
Song Length (in seconds): 237

2.
Unique ID: JJ234
Song Name: All For You
Artist Name: Janet Jackson
Song Length (in seconds): 391

3.
Unique ID: J345
Song Name: Canned Heat
Artist Name: Jamiroquai
Song Length (in seconds): 330

4.
Unique ID: JJ456
Song Name: Black Eagle
Artist Name: Janet Jackson
Song Length (in seconds): 197

5. 
Unique ID: SD567
Song Name: I Got The News
Artist Name: Steely Dan
Song Length (in seconds): 306

Ex (empty playlist):

JAMZ - OUTPUT FULL PLAYLIST
Playlist is empty

##(5) Implement the "Add song" menu item. New additions are added to the end of the list. (2 pts) 

Ex:

ADD SONG
Enter song's unique ID:
SD123
Enter song's name:
Peg
Enter artist's name:
Steely Dan
Enter song's length (in seconds):
237

##(6) Implement the "Remove song" method. Prompt the user for the unique ID of the song to be removed.(4 pts) 

Ex:

REMOVE SONG
Enter song's unique ID:
JJ234
"All For You" removed

##(7) Implement the "Change position of song" menu option. Prompt the user for the current position of the song and the desired new position. Valid new positions are 1 - n (the number of nodes). If the user enters a new position that is less than 1, move the node to the position 1 (the head). If the user enters a new position greater than n, move the node to position n (the tail). 6 cases will be tested:

Moving the head node (1 pt)
Moving the tail node (1 pt)
Moving a node to the head (1 pt)
Moving a node to the tail (1 pt)
Moving a node up the list (1 pt)
Moving a node down the list (1 pt) 
Ex:

CHANGE POSITION OF SONG
Enter song's current position:
3
Enter new position for song:
2
"Canned Heat" moved to position 2

##(8) Implement the "Output songs by specific artist" menu option. Prompt the user for the artist's name, and output the node's information, starting with the node's current position. (2 pt) 

Ex:

OUTPUT SONGS BY SPECIFIC ARTIST
Enter artist's name:
Janet Jackson

2.
Unique ID: JJ234
Song Name: All For You
Artist Name: Janet Jackson
Song Length (in seconds): 391

4.
Unique ID: JJ456
Song Name: Black Eagle
Artist Name: Janet Jackson
Song Length (in seconds): 197

##(9) Implement the "Output total time of playlist" menu option. Output the sum of the time of the playlist's songs (in seconds). (2 pts) 

Ex:

OUTPUT TOTAL TIME OF PLAYLIST (IN SECONDS)
Total time: 1461 seconds