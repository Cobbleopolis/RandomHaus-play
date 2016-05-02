package reference

import anorm.SqlParser._
import anorm._
import models.{Channel, ChannelContent, ChannelSeries}

object DBReferences {

    val getChannel = SQL("CALL getChannel({channelID});")
    val getChannelParser = for {
        channelID <- str("channelID")
        name <- str("name")
    } yield new Channel(channelID, name)

    val getAllChannels = SQL("SELECT * FROM channels;")

    val getAllSeriess = SQL("SELECT * FROM channelSeriess;")
    val getSeries = SQL("CALL getSeries({SeriesID});")
    val getChannelSeriess = SQL("CALL getChannelSeries({channelID});")
    val insertChannelSeries = SQL("CALL insertChannelSeries({id}, {channelID}, {name});")

    val channelSeriesParser = for {
        id <- str("id")
        channelID <- str("channelID")
        name <- str("name")
    } yield new ChannelSeries(id, channelID, name)

    val insertChannelContent = SQL("CALL insertChannelContent({id}, {channelID}, {isPlaylist}, {seriesID});")

    val getAllContent = SQL("SELECT * FROM channelContent;")
    val getContent = SQL("CALL getContent({contentID});")
    val channelContentParser = for {
        id <- str("id")
        channelID <- str("channelID")
        isPlaylist <- bool("isPlaylist")
        seriesID <- str("seriesID")
    } yield new ChannelContent(id, channelID, isPlaylist, seriesID)
}
