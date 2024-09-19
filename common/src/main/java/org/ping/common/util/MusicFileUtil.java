package org.ping.common.util;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.ping.common.entity.MusicMetadata;

import java.io.File;
import java.io.IOException;

/**
 * @author Ping
 */
public class MusicFileUtil {

    public static void changeMetadata(File file, MusicMetadata metadata) {

        try {
            // Step 2: Load the audio file
            AudioFile audioFile = AudioFileIO.read(file);

            // Step 3: Get the tag from the audio file (ID3 tag)
            Tag tag = audioFile.getTag();

            tag.setField(FieldKey.ARTIST, metadata.getArtistName());
            tag.setField(FieldKey.TITLE, metadata.getTrackTitle());
            tag.setField(FieldKey.ALBUM, metadata.getAlbumTitle());
            tag.setField(FieldKey.YEAR, metadata.getDate());
            tag.setField(FieldKey.GENRE, metadata.getGenre());
            tag.setField(FieldKey.COMPOSER, metadata.getComposer());
//            tag.setField(FieldKey.PERFORMER, metadata.getPerformer());
            tag.setField(FieldKey.ALBUM_ARTIST, metadata.getAlbumArtist());
            tag.setField(FieldKey.TRACK, metadata.getTrackNumber());
            tag.setField(FieldKey.TRACK_TOTAL, metadata.getTotalTracks());
            tag.setField(FieldKey.DISC_NO, metadata.getDiscNumber());
            tag.setField(FieldKey.DISC_TOTAL, metadata.getTotalDiscs());
            tag.setField(FieldKey.COMMENT, metadata.getComment());


            // Step 5: Save the updated tag back to the file
            audioFile.commit();

        } catch (CannotReadException | IOException | TagException | ReadOnlyFileException | InvalidAudioFrameException |
                 CannotWriteException e) {
            // Step 6: Handle exceptions
            System.err.println("Error updating title: " + e.getMessage());
        }
    }
}
