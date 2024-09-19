package org.ping.common.entity;

import lombok.Data;

/**
 * 音乐文件元数据
 *
 * @author Ping
 */
@Data
public class MusicMetadata {
    /**
     * 歌手
     */
    private String artistName;
    /**
     * 音乐标题
     */
    private String trackTitle;
    /**
     * 专辑标题
     */
    private String albumTitle;
    /**
     * 专辑日期
     */
    private String date;
    /**
     * 音乐类型
     */
    private String genre;
    /**
     * 作曲者
     */
    private String composer;
    /**
     * 表演者
     */
    private String performer;
    /**
     * 专辑作者
     */
    private String albumArtist;
    /**
     * 音乐序号
     */
    private String trackNumber;
    /**
     * 音乐总数
     */
    private String totalTracks;
    /**
     * 专辑序号
     */
    private String discNumber;
    /**
     * 专辑总数
     */
    private String totalDiscs;
    /**
     * 音乐备注
     */
    private String comment;
}
