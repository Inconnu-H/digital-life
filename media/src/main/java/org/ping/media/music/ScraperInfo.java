package org.ping.media.music;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbTvEpisodes;
import info.movito.themoviedbapi.TmdbTvSeasons;
import info.movito.themoviedbapi.TmdbTvSeries;
import info.movito.themoviedbapi.model.core.Genre;
import info.movito.themoviedbapi.model.tv.core.TvSeason;
import info.movito.themoviedbapi.model.tv.core.credits.Cast;
import info.movito.themoviedbapi.model.tv.episode.EpisodeCredits;
import info.movito.themoviedbapi.model.tv.episode.GuestStar;
import info.movito.themoviedbapi.model.tv.season.TvSeasonDb;
import info.movito.themoviedbapi.model.tv.season.TvSeasonEpisode;
import info.movito.themoviedbapi.model.tv.series.TvSeriesDb;
import info.movito.themoviedbapi.tools.TmdbException;
import org.ping.common.entity.MusicMetadata;
import org.ping.common.util.FileUtil;
import org.ping.common.util.MusicFileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 刮削音乐信息
 *
 * @author Ping
 */
public class ScraperInfo {

    public static void main(String[] args) throws TmdbException {
        File[] files = FileUtil.getFiles("D:\\FFOutput");
        List<MusicMetadata> musicMetadataList = getMusicMetadata(95903);
        changeMetadata(files, musicMetadataList);
    }

    /**
     * 修改音频元属性
     */
    public static void changeMetadata(File[] files, List<MusicMetadata> musicMetadataList) {
        for (File file : files) {
            String name = file.getName();
            System.out.println("正在修改文件属性：" + name);

            String[] split = name.split(" - ");
            String no = split[1];
            String season = no.substring(1, 3);
            String episode = no.substring(4);

            Optional<MusicMetadata> first = musicMetadataList.stream().filter(musicMetadata -> musicMetadata.getDiscNumber().equals(season)).filter(musicMetadata -> musicMetadata.getTrackNumber().equals(episode)).findFirst();
            if (first.isEmpty()) {
                System.out.println("未找到匹配项：" + name);
            } else {
                MusicFileUtil.changeMetadata(file, first.get());
            }

        }
    }

    /**
     * 调用 tmdb api 获取剧集信息
     * TODO 当前用于圆桌派，未来可进行适配调整
     */
    public static List<MusicMetadata> getMusicMetadata(int seriesId) throws TmdbException {
        List<MusicMetadata> result = new ArrayList<>();
        TmdbApi tmdbApi = new TmdbApi("eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1OWNmMjY5ZTUyYzNiYjcwYWZhOGViNjMwNGExZThlYiIsIm5iZiI6MTcyNjQ2Mjg2Ny4xOTMyMSwic3ViIjoiNjRjZDFlYzhlMDRkOGEzYWFhMDdjYjE0Iiwic2NvcGVzIjpbImFwaV9yZWFkIl0sInZlcnNpb24iOjF9.twg_mJ-iPh-o2tzobKoBNnzbQCOY8uGK9vXPfYn77Ow");

        TmdbTvSeries tvSeries = tmdbApi.getTvSeries();
        TmdbTvSeasons tvSeasons = tmdbApi.getTvSeasons();
        TmdbTvEpisodes tvEpisodes = tmdbApi.getTvEpisodes();

        TvSeriesDb tv = tvSeries.getDetails(seriesId, "zh-CN");
        List<TvSeason> seasons = tv.getSeasons();
        for (TvSeason season : seasons) {
            Integer seasonNumber = season.getSeasonNumber();
            Integer episodeCount = season.getEpisodeCount();

            TvSeasonDb seasonsDetails = tvSeasons.getDetails(seriesId, seasonNumber, "zh-CN");
            List<TvSeasonEpisode> episodes = seasonsDetails.getEpisodes();
            for (TvSeasonEpisode episode : episodes) {

                EpisodeCredits credits = tvEpisodes.getCredits(seriesId, seasonNumber, episode.getEpisodeNumber(), "zh-CN");

                MusicMetadata musicMetadata = new MusicMetadata();
                String artistName = credits.getCast().stream().map(Cast::getName).collect(Collectors.joining(", "));
                String guestName = credits.getGuestStars().stream().map(GuestStar::getName).collect(Collectors.joining(", "));
                musicMetadata.setArtistName(artistName);
                musicMetadata.setTrackTitle(episode.getName());
                musicMetadata.setAlbumTitle(season.getName());
                musicMetadata.setDate(episode.getAirDate());
                musicMetadata.setGenre(tv.getGenres().stream().map(Genre::getName).collect(Collectors.joining(", ")));
                musicMetadata.setComposer("张亚东");
                musicMetadata.setPerformer(artistName + ", " + guestName);
                musicMetadata.setAlbumArtist(artistName);
                musicMetadata.setTrackNumber(String.format("%02d", episode.getEpisodeNumber()));
                musicMetadata.setTotalTracks(String.format("%02d", episodeCount));
                musicMetadata.setDiscNumber(String.format("%02d", seasonNumber));
                musicMetadata.setTotalDiscs(String.format("%02d", tv.getNumberOfSeasons()));
                musicMetadata.setComment(episode.getOverview());
                result.add(musicMetadata);
                System.out.println("S" + musicMetadata.getDiscNumber() + "E" + musicMetadata.getTrackNumber() + "\t" + episode.getName() + "\t" + musicMetadata.getPerformer());
            }
            break;
        }
        return result;
    }
}
